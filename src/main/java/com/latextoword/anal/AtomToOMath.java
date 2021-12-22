package com.latextoword.anal;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.latextoword.atom.Atom;
import com.latextoword.atom.AtomBE;
import com.latextoword.dictionary.*;
import com.latextoword.dictionary.dicList.AtomList;
import com.latextoword.dictionary.dicList.AtomRuleSeriesList;
import com.latextoword.dictionary.dicList.MatrixList;

public class AtomToOMath {

	private static Hashtable<String, MatrixStyle> matrixDic;

	private  Map<Integer,Integer> groupMap = new HashMap<Integer,Integer>();

	private static String beginOMath="<m:oMath>";
	
	private static String endOMath="</m:oMath>";
	
	private static String mrmt="<m:r><m:t>";
	
	private static String mtmr="</m:t></m:r>";

	private static String mtmrmrmt="</m:t></m:r><m:r><m:t>";

	private static String pStyle="<m:rPr><m:sty m:val=\"p\"/></m:rPr>";//正体

	private static void init() {
		matrixDic=MatrixList.getMatrixDicList();
	}
	
	public  String atomToOMathStrMain(List<Atom> atoms){
		init();
		return atomToOMathStrALL(atoms);
	}
	
	public  String atomToOMathStrALL(List<Atom> atoms) {
		String oMathStr="";
		for(int i=0;i<atoms.size();i++) {
			Atom atom=atoms.get(i);
			oMathStr=atomToOMathStr(atom,oMathStr);
		}
		oMathStr=oMathStr.replace(mtmrmrmt,"");
		if(!groupMap.isEmpty()) oMathStr=oMathStr.replace("<m:mr><m:e></m:e></m:mr>","");
        oMathStr=beginOMath+oMathStr+endOMath;
		oMathStr=oMathStrAddFracFontStyle(oMathStr);//分数增加字体大小控制
		return oMathStr;
   }
    public  String atomToOMathStr(Atom atom,String oMathStr) {
    	if(atom==null||atom.getAnalType().equals(2)) return oMathStr;
    	if(atom.getAnalType().equals(0)&&(atom.getAtomBEs()==null||atom.getAtomBEs().size()<1)){
    		//if(oMathStr.length()>mtmr.length()&&oMathStr.substring(oMathStr.length()-mtmr.length()).equals(mtmr)) oMathStr=oMathStr.substring(0, oMathStr.length()-mtmr.length())+atomNameStandardized(atom.getAtomName())+mtmr;
    		//else oMathStr=oMathStr+mrmt+atomNameStandardized(atom.getAtomName())+mtmr;
			oMathStr=oMathStr+mrmt+atomNameStandardized(atom.getAtomName())+mtmr;
    		return oMathStr;
    	}
        List<AtomBE> atomBEs=atom.getAtomBEs();
    	if(atom.getAnalType().equals(0)&&atomBEs!=null&&atomBEs.size()>0){
    	    for(AtomBE atomBE:atomBEs){
                if(atomBE.getType().equals(1)) oMathStr=oMathStr+mrmt+atomBeginEndChineseStrFont(atomBE.getBegin())+mtmr;
                oMathStr=atomToOMathStr(atomBE.getAtom(),oMathStr);
                if(atomBE.getType().equals(1)) oMathStr=oMathStr+mrmt+atomBeginEndChineseStrFont(atomBE.getEnd())+mtmr;
            }
    	}
		if(atom.getAnalType().equals(1)){
			oMathStr=atom.getFormType()!=null&&atom.getFormType().equals(1)?atomOMathSeriesAnalysis(atom,oMathStr):atomOMathAnalysis(atom,oMathStr);
		}
    	return oMathStr;
	}

	public  String atomOMathAnalysis(Atom atom,String oMathStr){
		AtomRule atomRule=atom.getAtomRule();
		if(atomRule==null) return "ERROR:解析标记:["+atom.getAtomName()+"]没有对应的OMath解析规则";
		Atom ruleAtom=atomRule.getAtom();
		OMathRule oMathRule=atomRule.getoMathRule();
		Integer groupBeginEnd = atomRule.getGroupBeginEnd();
		Integer group = atomRule.getGroup();
		if(group!=null&&groupBeginEnd!=null&&groupBeginEnd.equals(1)) groupMap.put(group,groupMap.get(group)==null?1:groupMap.get(group)+1);
		if(group!=null&&groupBeginEnd!=null&&groupBeginEnd.equals(2)) groupMap.put(group,groupMap.get(group)==null?0:groupMap.get(group)-1);
		if(group!=null&&groupBeginEnd!=null&&groupBeginEnd.equals(3)&&(groupMap.get(group)==null||groupMap.get(group)<1)){
			//组不存在时出现只在此组内有效的元素让其使用备用解析方案
			if(atomRule.getoMathSecRule()!=null) oMathRule=atomRule.getoMathSecRule();
		}
		Atom oMathAtom=oMathRule.getAtom();
		oMathStr=oMathStr+oMathAtom.getAtomName();
		List<AtomBE> oMathBEs=oMathAtom.getAtomBEs();
		List<AtomBE> ruleBEs=ruleAtom.getAtomBEs();
		List<AtomBE> atomBEs=atom.getAtomBEs();
		if(atomBEs==null||atomBEs.size()<1) return oMathStr;
		int j=0;
		for(int i=0;i<atomBEs.size();i++) {
			AtomBE atomBE=atomBEs.get(i);
			if(atomBE.getAtom()!=null&&atomBE.getAtom().getAnalType().equals(2)) continue;
			AtomBE ruleBE=ruleBEs.get(j);
			AtomBE oMathBE=oMathBEs.get(j);
			if(ruleBE.getMatchType().equals(0)) {
				if((atomBE.getBegin()==null||!atomBE.getBegin().equals(ruleBE.getBegin()))&&oMathBE.getAtom().getoMathType().equals(1)) {
					if(oMathBE.getAtom()!=null&&oMathBE.getAtom().getAtomName()!=null) oMathStr=oMathStr+oMathBE.getAtom().getAtomName();
                    j++;
                    ruleBE=ruleBEs.get(j);
                    oMathBE=oMathBEs.get(j);
				}
			}
			oMathStr=oMathStr+oMathBE.getBegin();
			String oMathEndStr=oMathBE.getEnd();
			if(atomBE.getType().equals(1)) oMathStr=oMathStr+mrmt+atomBeginEndChineseStrFont(atomBE.getBegin())+mtmr;
            Integer oMathStyle=oMathBE.getoMathStyle();
            if(oMathStyle!=null&&oMathStyle.equals(2)){//类似text要展示空格
                if(atomBE.getAtom()!=null&&atomBE.getAtom().getAtomName()!=null){
                    atomBE.getAtom().setAtomName(atomBE.getAtom().getAtomName().replace("\u200B"," "));
                }
            }
			Integer mappingType = ruleBE.getMappingType();
			if(groupMap.get(group)!=null&&mappingType!=null&&mappingType.equals(1)&&atomBE.getAtom()!=null&&atomBE.getAtom().getAtomName()!=null){
				if(groupBeginEnd!=null&&groupBeginEnd.equals(1)){
                    MatrixStyle matrixStyle=atomBE.getAtom().getMatrixStyle();
                    matrixStyle =matrixStyle!=null?matrixStyle:matrixDic.get(atomBE.getAtom().getAtomName());
                    if(matrixStyle!=null){
                        if(groupMap.get(group)>0){
                            oMathStr = oMathStr+ matrixStyle.getMappingBegin()+matrixStyle.getMappingEnd();
                            //begin块的样式替换(如{split})
                            if(matrixStyle.getMcJcStyle()!=null) oMathEndStr=oMathEndStr.replace("<m:mcs><m:mc><m:mcPr><m:count m:val=\"3\"/><m:mcJc m:val=\"left\"/></m:mcPr></m:mc></m:mcs>",matrixStyle.getMcJcStyle());
                        }
                        //atomBE.getAtom().setAtomName("");
                        atomBE.getAtom().setAnalType(2);
                    }
                }
				if(groupBeginEnd!=null&&groupBeginEnd.equals(2)){
                    //atomBE.getAtom().setAtomName("");
                    atomBE.getAtom().setAnalType(2);
                }
			}
			if(mappingType!=null&&mappingType.equals(3)&&i==0){
				if(groupMap.get(group)!=null&&groupMap.get(group)>0&&groupBeginEnd!=null&&groupBeginEnd.equals(1)&&atomBE.getBegin()!=null&&!atomBE.getBegin().equals("")){
					MatrixStyle matrixStyle = matrixDic.get(atomBE.getBegin());
					if(matrixStyle!=null){
						String mappingStrBegin = matrixStyle.getMappingBegin()+matrixStyle.getMappingEnd();
						oMathStr = oMathStr+mappingStrBegin+oMathEndStr;
						oMathEndStr="";
					}
				}
				if(groupMap.get(group)!=null&&groupMap.get(group)>0&&groupBeginEnd!=null&&groupBeginEnd.equals(1)&&atomBE.getBegin()==null&&atomBE.getAtom()!=null&&atomBE.getAtom().getAtomName()!=null){
                   String beginStr=atomBE.getAtom().getAtomName().trim();
                   String matchString="";
					MatrixStyle matrixStyle=null;
					if(beginStr.indexOf("\\")==0){
						Pattern pattern = Pattern.compile("^\\\\([a-zA-Z]+|\\{|\\[|\\()");
						Matcher matcher=pattern.matcher(beginStr);
						if(matcher.find()){
							String matchStr = matcher.group();
							matchString=matchStr;
							if(matchStr.equals(beginStr.substring(0,matchStr.length()))) matrixStyle=matrixDic.get(matchStr);
						}
					}
                    else{
                    	matchString=beginStr.substring(0,1);
                    	matrixStyle = matrixDic.get(matchString);
                    }
					if(matrixStyle!=null){
						String mappingStrBegin = matrixStyle.getMappingBegin()+"#"+group+"#"+matrixStyle.getMappingEnd()+"##";
						oMathStr = oMathStr+mappingStrBegin+oMathEndStr;
						oMathEndStr="";
						atomBE.getAtom().setAtomName(beginStr.replace(matchString,""));
						atomBE.getAtom().setAnalType(0);
					}
				}
				if(groupMap.get(group)!=null&&groupBeginEnd!=null&&groupBeginEnd.equals(2)&&atomBE.getAtom()!=null&&atomBE.getAtom().getAtomName()!=null){
					String beginStr=atomBE.getAtom().getAtomName().trim();
					String matchString="";
					MatrixStyle matrixStyle=null;
					if(beginStr.indexOf("\\")==0){
						Pattern pattern = Pattern.compile("^\\\\([a-zA-Z]+|\\}|\\]|\\))");
						Matcher matcher=pattern.matcher(beginStr);
						if(matcher.find()){
							String matchStr = matcher.group();
							matchString=matchStr;
							if(matchStr.equals(beginStr.substring(0,matchStr.length()))) matrixStyle=matrixDic.get(matchStr);
						}
					}
					else {
						matchString=beginStr.substring(0,1);
						matrixStyle = matrixDic.get(matchString);
					}
					if(matrixStyle!=null){
						String mappingStrEnd = matrixStyle.getMappingEnd();
						int lastIndex=oMathStr.lastIndexOf("#"+group+"#");
						if(lastIndex>=0){
							String lastOMathStr=oMathStr.substring(lastIndex);
							lastOMathStr=lastOMathStr.replaceFirst("#"+group+"#.*?##",mappingStrEnd);
							oMathStr = oMathStr.substring(0,lastIndex)+lastOMathStr;
							atomBE.getAtom().setAtomName(beginStr.replace(matchString,""));
							atomBE.getAtom().setAnalType(0);
						}
					}else {
						int lastIndex=oMathStr.lastIndexOf("#"+group+"#");
						if(lastIndex>=0){
							String lastOMathStr=oMathStr.substring(lastIndex);
							lastOMathStr=lastOMathStr.replace("#"+group+"#","").replace("##","");
							oMathStr = oMathStr.substring(0,lastIndex)+lastOMathStr;
							atomBE.getAtom().setAtomName(beginStr.replace(matchString,""));
							atomBE.getAtom().setAnalType(0);
						}
					}
				}
			}
			if((mappingType==null||mappingType.equals(0))&&oMathBE.getAtom()!=null&&oMathBE.getAtom().getAtomName()!=null&&(oMathBE.getAtom().getoMathType()==null||!oMathBE.getAtom().getoMathType().equals(1))){
				oMathStr=oMathStr+mrmt+oMathBE.getAtom().getAtomName()+mtmr;
			}
			oMathStr=atomToOMathStr(atomBE.getAtom(),oMathStr);
			if(atomBE.getType().equals(1))  oMathStr=oMathStr+mrmt+atomBeginEndChineseStrFont(atomBE.getEnd())+mtmr;
			oMathStr=oMathStr+oMathEndStr;
			j++;
		}
		return oMathStr;
	}
	public  String atomOMathSeriesAnalysis(Atom atom,String oMathStr){
		AtomRuleSeries atomRuleSeries=atom.getAtomRuleSeries();
		if(atomRuleSeries==null) return atomOMathAnalysis(atom,oMathStr);
		List<AtomBE> atomRuleSeriesList=atomRuleSeries.getAtomBEList();
		OMathRule oMathRule=atomRuleSeries.getoMathRule();
		Atom oMathAtom=oMathRule.getAtom();
		oMathStr=oMathStr+oMathAtom.getAtomName();
		List<AtomBE> oMathBEs=oMathAtom.getAtomBEs();
		List<AtomBE> atomBEs=atom.getAtomBEs();
		if(atomBEs==null||atomBEs.size()<1) return oMathStr;
		int atomBEIndex = 0;
		int step=0;//有无效OMath对应字符时增加步长
        for (AtomBE atomRuleSeriesAtomBE:atomRuleSeriesList){
        	    if(atomBEIndex+step>=atomBEs.size()) break;
				AtomBE atomBE=atomBEs.get(atomBEIndex+step);
				if(atomBE.getMappingType()!=null&&atomBE.getMappingType().equals(2)) {
					step++;
					if(atomBEIndex+step>=atomBEs.size()) break;
					atomBE=atomBEs.get(atomBEIndex+step);
				}
			    if(atomRuleSeriesAtomBE.getMappingType()!=null&&atomRuleSeriesAtomBE.getMappingType().equals(2)) continue;
				AtomBE oMathBE=oMathBEs.get(atomBEIndex);
				if(atomRuleSeriesAtomBE.getMatchType()!=null&&atomRuleSeriesAtomBE.getMatchType().equals(0)) {
					if(atomBE.getBegin()==null||!atomBE.getBegin().equals(atomRuleSeriesAtomBE.getBegin())) {
						atomBEIndex++;
						continue;
					}
				}
				oMathStr=oMathStr+oMathBE.getBegin();
				if(atomBE.getType().equals(1)) oMathStr=oMathStr+mrmt+atomBeginEndChineseStrFont(atomBE.getBegin())+mtmr;
				Integer mappingType = atomRuleSeriesAtomBE.getMappingType();
				if((mappingType==null||mappingType.equals(0))&&oMathBE.getAtom()!=null&&oMathBE.getAtom().getAtomName()!=null){
					oMathStr=oMathStr+mrmt+oMathBE.getAtom().getAtomName()+mtmr;
				}
				oMathStr=atomToOMathStr(atomBE.getAtom(),oMathStr);
				if(atomBE.getType().equals(1)) oMathStr=oMathStr+mrmt+atomBeginEndChineseStrFont(atomBE.getEnd())+mtmr;
				oMathStr=oMathStr+oMathBE.getEnd();
				atomBEIndex++;
		}
		return oMathStr;
	}
	//分数增加字体为小三字体
	public static String oMathStrAddFracFontStyle(String oMathStr){
        //String regex="<m:f>.*?</m:f>";
        String style="<w:rPr><w:sz w:val=\"30\"/></w:rPr>";
        return oMathStrAddStyle(oMathStr,"<m:f>","</m:f>",style);
    }

    //不同结构增加样式
   /* public static String oMathStrAddStyle(String oMathStr,String regex,String style){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher=pattern.matcher(oMathStr);
        while (matcher.find()){
            String matchStr = matcher.group();
            String newMatchStr=matchStr.replace("<m:r><m:t>","<m:r>"+style+"<m:t>");
            oMathStr=oMathStr.replace(matchStr,newMatchStr);
        }
        return oMathStr;
    }*/
	//不同结构增加样式
	public static String oMathStrAddStyle(String oMathStr,String beginStr,String endStr,String style){
		List<Map<String,Integer>> beginEndIndex=new ArrayList<Map<String, Integer>>();
		int flag=0;
		int index=0;
		Integer beginIndex;
		Integer endIndex;
		while (index>=0){
			index=oMathStr.indexOf(beginStr,index+5);
			if(index<0) break;
			flag++;
			endIndex=index;
			while (endIndex>=0){
				int nextBeginIndex=oMathStr.indexOf(beginStr,endIndex+5);
				int nextEndIndex=oMathStr.indexOf(endStr,endIndex+5);
				if(nextEndIndex<0) break;
				if(nextBeginIndex>0&&nextBeginIndex<nextEndIndex) flag++;
				if(nextBeginIndex<0||nextBeginIndex>nextEndIndex) flag--;
				if(flag==0){
					Map<String,Integer> beginEndIndexMap=new HashMap<String, Integer>();
					beginEndIndexMap.put("beginIndex",index);
					beginEndIndexMap.put("endIndex",nextEndIndex);
					beginEndIndex.add(beginEndIndexMap);
					index=nextEndIndex;
					break;
				}
				endIndex=nextBeginIndex<nextEndIndex?nextBeginIndex>0?nextBeginIndex:nextEndIndex:nextEndIndex>0?nextEndIndex:nextBeginIndex;
			}
		}
        if(beginEndIndex.size()<1) return oMathStr;
        List<String> matchStrList=new ArrayList<String>();
        for(Map<String,Integer> beginEndIndexMap:beginEndIndex){
        	if(beginEndIndexMap.get("beginIndex")>0&&beginEndIndexMap.get("endIndex")>0&&beginEndIndexMap.get("beginIndex")<beginEndIndexMap.get("endIndex")){
				matchStrList.add(oMathStr.substring(beginEndIndexMap.get("beginIndex"),beginEndIndexMap.get("endIndex")));
			}
		}
        if(matchStrList.size()<1) return oMathStr;
        for(String matchStr:matchStrList){
        	String newMatchStr=matchStr.replace("<m:r><m:t>","<m:r>"+style+"<m:t>");
			oMathStr=oMathStr.replace(matchStr,newMatchStr);
		}
		return oMathStr;
	}
	//非样式字符标准化
	public static String atomNameStandardized(String atomName){
		atomName=atomName.replace("{","");
		atomName=atomName.replace("}","");
		atomName=atomNameChineseStrFont(atomName);
		return atomName;
	}
    //中文正体
	public static String atomNameChineseStrFont(String atomName){
		String chinesRegex="[\\u4e00-\\u9fa5（）]+";
		Pattern pattern=Pattern.compile(chinesRegex);
		Matcher matcher=pattern.matcher(atomName);
		String resultStr=atomName;
		while (matcher.find()){
			String matchStr=matcher.group();
			resultStr=resultStr.replace(matchStr,mtmr+"<m:r>"+pStyle+"<m:t>"+matchStr+mtmr+" "+mrmt);
		}
	    return resultStr;
    }
	//开始结束中文括号中文正体
	public static String atomBeginEndChineseStrFont(String atomBeginEndStr){
		if(atomBeginEndStr!=null&&(atomBeginEndStr.contains("（")||atomBeginEndStr.contains("）"))){
			atomBeginEndStr=mtmr+"<m:r>"+pStyle+"<m:t>"+atomBeginEndStr+mtmr+" "+mrmt;
		}
		return atomBeginEndStr;
	}

	/*public static void main(String[] args) {
		String ll="<m:oMath><m:r><m:rPr><m:sty m:val=\"p\"/></m:rPr><w:rPr><w:rFonts w:ascii=\"Times New Roman\" w:hAnsi=\"Times New Roman\" w:cs=\"Times New Roman\"/></w:rPr><m:t>a</m:t></m:r><m:r><m:rPr><m:sty m:val=\"p\"/></m:rPr><m:t> </m:t> </m:r><m:r><m:t>\u200B毛\u200Bmol</m:t></m:r><m:r><m:rPr><m:sty m:val=\"p\"/></m:rPr><m:t> </m:t> </m:r><m:r><m:t>瑞瑞P</m:t></m:r><m:sSub><m:e><m:r><m:t>\u200BH</m:t></m:r></m:e><m:sub><m:r><m:t>4</m:t></m:r></m:sub></m:sSub><m:r><m:t>I</m:t> </m:r></m:oMath>";
		System.out.println(atomNameStandardized(ll));
	}*/


}
