package com.latextoword.anal;

import java.util.*;

import com.latextoword.atom.Atom;
import com.latextoword.atom.AtomBE;
import com.latextoword.common.MyJsonUtil;
import com.latextoword.dictionary.AtomRuleSeries;
import com.latextoword.dictionary.MatrixStyle;
import com.latextoword.dictionary.dicList.AtomList;
import com.latextoword.dictionary.AtomRule;
import com.latextoword.dictionary.dicList.AtomRuleSeriesList;
import com.latextoword.dictionary.dicList.MatrixList;

//atom复制到相应父结构之下，原atom失效
public class AtomAnalysis {
    private static Hashtable<String, AtomRule> atomDic;

	private static Hashtable<String, MatrixStyle> matrixDic;

	private static Hashtable<String, List<AtomRuleSeries>> atomRuleSeriesDic;

    private  Map<Integer,Integer> groupMap = new HashMap<Integer,Integer>();

    private  Map<Integer,List<String>> groupEndStrList = new HashMap<Integer,List<String>>();//right 的结束样式

	private static void init() {
		atomDic=AtomList.getAtomDicList();
		matrixDic= MatrixList.getMatrixDicList();
		atomRuleSeriesDic= AtomRuleSeriesList.getAtomRuleSeriesDicList();
	}

	public String atomListToOMathAtomList(List<Atom> atoms) {
		init();
		return   atomToOMathAtomALL(atoms);
	}

	public  String atomToOMathAtomALL(List<Atom> atoms) {
		for(int i=0;i<atoms.size();i++) {
			Atom atom=atoms.get(i);
			if(atom==null||atom.getAnalType().equals(2)) continue;
			if(atom.getMoveType()!=null&&atom.getMoveType().equals(1)) continue;
			String message=atomToOMathAtom(atom);
			if(!message.equals("SUCCESS")) return message;
			if(atom.getAnalType().equals(1)){
				if(atomToOMathSeriesAtom(atoms,i)) continue;
				message=atomAnalysis(atoms,i);
				if(!message.equals("SUCCESS")) return message;
			}
		}
			return "SUCCESS";
   }

   public  String atomAnalysis(List<Atom> atoms,Integer i){
	   Atom atom=atoms.get(i);
	   List<AtomBE> atomBEs=atom.getAtomBEs();
	   if(atomBEs==null) atomBEs=new ArrayList<AtomBE>();
	   AtomRule atomRule=atom.getAtomRule();
	   Integer groupBeginEnd=0;
	   Integer group =0;
	   if(atomRule==null){
		   atomRule=atomDic.get(atom.getAtomName());
		   if(atomRule==null) return "ERROR:解析标记:["+atom.getAtomName()+"]没有对应的解析规则";
		   atom.setAtomRule(atomRule);
	   }
	   groupBeginEnd = atomRule.getGroupBeginEnd();
	   group = atomRule.getGroup();
	   if(group!=null&&groupBeginEnd!=null&&groupBeginEnd.equals(1)) groupMap.put(group,groupMap.get(group)==null?1:groupMap.get(group)+1);
	   if(group!=null&&groupBeginEnd!=null&&groupBeginEnd.equals(2)) groupMap.put(group,groupMap.get(group)==null?0:groupMap.get(group)-1);
	   Atom ruleAtom=atomRule.getAtom();
	   List<AtomBE> atomRuleBEsTmp=ruleAtom.getAtomBEs();
	   int step=atomRule.getType();
	   String message = "SUCCESS";
	   if(atomRuleBEsTmp!=null&&atomRuleBEsTmp.size()>0&&step>-99) {
		   for(AtomBE atomRuleBETmp:atomRuleBEsTmp) {
			   Atom atomNext=i+step>=atoms.size()||i+step<0?null:atoms.get(i+step);
			   //取到不失效的atom
			   if(atomNext!=null&&((atomNext.getAnalType()!=null&&atomNext.getAnalType().equals(2))||(atomNext.getAtomName()!=null&&atomNext.getAtomName().equals("\u200B")))){
			   	  int invalidStep=1;
			   	  int trend=step<0?-1:1;
                  while (i+step+invalidStep*trend<atoms.size()&&i+step+invalidStep*trend>=0){
					  atomNext=i+step+invalidStep*trend>=atoms.size()||i+step+invalidStep*trend<0?null:atoms.get(i+step+invalidStep*trend);
					  if(atomNext!=null&&atomNext.getAtomName()!=null&&atomNext.getAtomName().equals("\u200B")){
                          atomNext.setAnalType(2);
                      }
					  if(atomNext!=null&&atomNext.getAnalType()!=null&&!atomNext.getAnalType().equals(2)){
					  	if(trend>0){step=step+invalidStep*trend;}
					  	break;
					  }
					  invalidStep++;
                  }
			   }
			   if(i+step>i&&atomNext!=null) {
			       if(atomRuleBETmp.getMappingType()!=null&&atomRuleBETmp.getMappingType().equals(3)&&atomNext.getAtomBEs()!=null&&atomNext.getAtomBEs().size()>0&&atomNext.getAtomBEs().get(0).getEnd()!=null){
                       //将right的结束标志存储
                       List<String> endStrList=groupEndStrList.get(group)==null?new ArrayList<String>():groupEndStrList.get(group);
                       endStrList.add(atomNext.getAtomBEs().get(0).getEnd());
                       groupEndStrList.put(group,endStrList);
                   }
			       if(atomNext.getMoveType()==null){
					   message=atomToOMathAtom(atomNext);
					   if(!message.equals("SUCCESS")) return message;
					   if(atomNext.getAnalType()!=null&&atomNext.getAnalType().equals(1)&&atomNext.getAtomName()!=null){
						   if(atomToOMathSeriesAtom(atoms,i+step)) continue;
						   message=atomAnalysis(atoms,i+step);
						   if(!message.equals("SUCCESS")) return message;
					   }
				   }
			   }
			   if(atomRuleBETmp.getMatchType().equals(0)) {
				   List<AtomBE> atomNextBEsTmp=atomNext==null?null:atomNext.getAtomBEs();
				   if(atomNextBEsTmp==null||atomNextBEsTmp.get(0).getBegin()==null||!atomNextBEsTmp.get(0).getBegin().equals(atomRuleBETmp.getBegin())) continue;
				   Integer mappingType = atomRuleBETmp.getMappingType();
				   Integer styleLength=0;
				   if(groupBeginEnd!=null&&groupBeginEnd.equals(1)&&group!=null&&groupMap.get(group)!=null&&groupMap.get(group)>0&&mappingType!=null&&mappingType.equals(1)&&atomNextBEsTmp.get(0).getAtom()!=null&&atomNextBEsTmp.get(0).getAtom().getAtomName()!=null){
					   MatrixStyle matrixStyle = matrixDic.get(atomNext.getAtomBEs().get(0).getAtom().getAtomName());
					   if(matrixStyle!=null){
						   atomNextBEsTmp.get(0).getAtom().setMatrixStyle(matrixStyle);
						   styleLength=matrixStyle.getStyleLength()==null?0:matrixStyle.getStyleLength();
					   }
				   }
				   AtomBE atomBENew= MyJsonUtil.fromJson(MyJsonUtil.toJson(atomNextBEsTmp.get(0)), AtomBE.class);
				   atomBENew.setType(0);
				   atomBEs.add(atomBENew);
				   atom.setAtomBEs(atomBEs);
				   atomNext.setAnalType(2);
				   step=step==-1?1:step+1;
				   if(styleLength>0){
					   atomNext=i+step>=atoms.size()||i+step<0?null:atoms.get(i+step);
					  // AtomBE atomBENewTmp=MyJsonUtil.fromJson(MyJsonUtil.toJson(atomNext.getAtomBEs().get(0)), AtomBE.class);
						 /*  atomBEs.add(atomBENewTmp);
						   atom.setAtomBEs(atomBEs);*/ //暂不解析
					   atomNext.setAnalType(2);
					   step=step==-1?1:step+1;
				   }
			   }else {
			   	   if(atomRuleBETmp.getMappingType()!=null&&atomRuleBETmp.getMappingType().equals(3)){//先处理匹配下一个块级元素，如 /left,/right
                       if(atomNext!=null&&atomNext.getAtomBEs()!=null&&atomNext.getAtomBEs().size()>0&&atomNext.getAtomBEs().get(0).getBegin()!=null){
                           Atom atomNew=new Atom(atomNext.getAtomBEs().get(0).getBegin());
                           atomNew.setAnalType(0);
                           atomNew.setType(0);
                           AtomBE atomBENew=new AtomBE(null, atomNew, null);
                           atomBENew.setType(0);
                           atomBEs.add(atomBENew);
                           atom.setAtomBEs(atomBEs);
                           atomNext.getAtomBEs().get(0).setType(0);
                       }
                       if(atomNext==null){
                           //获取right的结束符
                           List<String> endStrList=groupEndStrList.get(group);
                           String endStr=")";
                           if(endStrList!=null&&endStrList.size()>0){
                               endStr=endStrList.get(endStrList.size()-1);
                               endStr=endStr.equals("")?")":endStr;
                               endStrList.remove(endStrList.size()-1);
                               groupEndStrList.put(group,endStrList);
                           }
                           Atom atomNew=new Atom(endStr);
                           atomNew.setAnalType(0);
                           atomNew.setType(0);
                           AtomBE atomBENew=new AtomBE(null, atomNew, null);
                           atomBENew.setType(0);
                           atomBEs.add(atomBENew);
                           atom.setAtomBEs(atomBEs);
                       }
                       if(atomNext!=null&&atomNext.getAtomName()!=null&&atomBEs.size()<1){
                           Atom atomNew= MyJsonUtil.fromJson(MyJsonUtil.toJson(atomNext), Atom.class);
                           atomNext.setAnalType(2);
                           AtomBE atomBENew=new AtomBE(null, atomNew, null);
                           atomBENew.setType(0);
                           atomBEs.add(atomBENew);
                           atom.setAtomBEs(atomBEs);
                       }
                    if(groupBeginEnd!=null&&groupBeginEnd.equals(1)&&(atom.getBlockType()==null||!atom.getBlockType().equals(1))){//块级下沉
			   	   	 	atom.setBlockType(1);
			   	   	 	Atom atomNew=new Atom();
			   	   	 	atomNew.setType(0);
			   	   	 	atomNew.setAnalType(0);
			   	   	 	List<AtomBE> atomNewBEs=new ArrayList<AtomBE>();
			   	   	 	Atom atomChildNew= MyJsonUtil.fromJson(MyJsonUtil.toJson(atom), Atom.class);
			   	   	 	AtomBE atomChildBENew=new AtomBE(null, atomChildNew,null);
			   	   	 	atomChildBENew.setType(0);
			   	   	 	atomNewBEs.add(atomChildBENew);
			   	   	 	if(atomNext!=null&&atomNext.getAtomBEs()!=null&&atomNext.getAtomBEs().size()>0) {
							 List<AtomBE> atomBENextNew= MyJsonUtil.jsontoListClazz(MyJsonUtil.toJson(atomNext.getAtomBEs()), AtomBE.class);
                             atomNewBEs.addAll(atomBENextNew);
							 atomNew.setAtomBEs(atomNewBEs);
                             atomNext.setType(0);
                             atomNext.setAnalType(0);
                             atomNext.setAtomBEs(atomNewBEs);
							 atom.setAnalType(2);
							 break;
						 }
			   	   	 	 List<Atom> innnerBlockAtomList=new ArrayList<Atom>();
						Map<Integer,Integer> groupTmpMap = new HashMap<Integer,Integer>();
						if(group!=null&&groupBeginEnd!=null&&groupBeginEnd.equals(1)) groupTmpMap.put(group,groupTmpMap.get(group)==null?1:groupTmpMap.get(group)+1);
						for(int blockStep=i+step+1;blockStep<atoms.size();blockStep++){
						 	 Atom atomNextTmp= blockStep>=atoms.size()||blockStep<0?null:atoms.get(blockStep);
						 	 if(atomNextTmp!=null&&atomNextTmp.getAnalType()!=null&&atomNextTmp.getAnalType().equals(2)) continue;
                            /* message=atomToOMathAtom(atomNextTmp);
                             if(atomNextTmp.getAnalType()!=null&&atomNextTmp.getAnalType().equals(1)&&atomNextTmp.getAtomName()!=null){
                                 AtomRule atomRuleNext=atomDic.get(atomNextTmp.getAtomName());
                                 if(atomRuleNext==null) return "ERROR:解析标记:["+atomNextTmp.getAtomName()+"]没有对应的解析规则";
                                 atomNextTmp.setAtomRule(atomRuleNext);
                             }
                             if(!message.equals("SUCCESS")) return message;
                             */
						 	 if(atomNextTmp!=null&&atomNextTmp.getAnalType().equals(1)&&atomNextTmp.getAtomName()!=null){
								 AtomRule atomNextTmpRule=atomDic.get(atomNextTmp.getAtomName());
								 if(atomNextTmpRule==null) return "ERROR:解析标记:["+atom.getAtomName()+"]没有对应的解析规则";
                                 atomNextTmp.setAtomRule(atomNextTmpRule);
								 Integer groupNexBeginEnd = atomNextTmpRule.getGroupBeginEnd();
								 Integer groupNext = atomNextTmpRule.getGroup();
                                 if(groupNext!=null&&groupNexBeginEnd!=null&&groupNexBeginEnd.equals(1)) groupMap.put(groupNext,groupMap.get(groupNext)==null?1:groupMap.get(groupNext)+1);
                                 if(groupNext!=null&&groupNexBeginEnd!=null&&groupNexBeginEnd.equals(2)) groupMap.put(groupNext,groupMap.get(groupNext)==null?0:groupMap.get(groupNext)-1);
								 if(groupNext!=null&&groupNexBeginEnd!=null&&groupNexBeginEnd.equals(1)) groupTmpMap.put(groupNext,groupTmpMap.get(groupNext)==null?1:groupTmpMap.get(groupNext)+1);
								 if(groupNext!=null&&groupNexBeginEnd!=null&&groupNexBeginEnd.equals(2)) groupTmpMap.put(groupNext,groupTmpMap.get(groupNext)==null?0:groupTmpMap.get(groupNext)-1);
                                 if(groupNexBeginEnd!=null&&groupNext!=null&&groupNexBeginEnd.equals(2)&&groupNext.equals(group)&&groupTmpMap.get(groupNext)!=null&&groupTmpMap.get(groupNext)<1){
                                    Atom atomEndBlock=blockStep+1>=atoms.size()||blockStep+1<0?null:atoms.get(blockStep+1);
                                    if(atomEndBlock==null) {
										atomEndBlock=new Atom("(");
										atomEndBlock.setType(0);
										atomEndBlock.setAnalType(0);
									}
									 Atom atomEndBlockNextNew= MyJsonUtil.fromJson(MyJsonUtil.toJson(atomEndBlock), Atom.class);
									 AtomBE atomEndBlockNextBENew=new AtomBE(null, atomEndBlockNextNew,null);
                                     atomEndBlockNextBENew.setType(0);
                                     List<AtomBE> atomEndBlockNextBEListNew=new ArrayList<AtomBE>();
                                     atomEndBlockNextBEListNew.add(atomEndBlockNextBENew);
                                     atomNextTmp.setAtomBEs(atomEndBlockNextBEListNew);
									 atomEndBlock.setAnalType(2);
                                     blockStep=atoms.size();
								 }
							 }
							 //统计下一个atomBE里面的left，right（主要是right）
							 if(atomNextTmp.getAtomBEs()!=null&&atomNextTmp.getAtomBEs().size()>0){
								 for(AtomBE atomBEChild:atomNextTmp.getAtomBEs()){
									 Atom atomChild=atomBEChild.getAtom();
									 if(atomChild==null){continue;}
									 if(atomChild.getAtomName()!=null&&!atomChild.getAtomName().equals("")&&atomChild.getAnalType().equals(1)&&atomChild.getAtomRule()==null){
										 AtomRule atomNextTmpRuleChild=atomDic.get(atomChild.getAtomName());
										 if(atomNextTmpRuleChild==null) return "ERROR:解析标记:["+atomChild.getAtomName()+"]没有对应的解析规则";
										 atomChild.setAtomRule(atomNextTmpRuleChild);
										 Integer groupNexBeginEndChild = atomNextTmpRuleChild.getGroupBeginEnd();
										 Integer groupNextChild = atomNextTmpRuleChild.getGroup();
										 if(groupNextChild!=null&&groupNexBeginEndChild!=null&&groupNexBeginEndChild.equals(1)) groupMap.put(groupNextChild,groupMap.get(groupNextChild)==null?1:groupMap.get(groupNextChild)+1);
										 if(groupNextChild!=null&&groupNexBeginEndChild!=null&&groupNexBeginEndChild.equals(2)) groupMap.put(groupNextChild,groupMap.get(groupNextChild)==null?0:groupMap.get(groupNextChild)-1);
										 if(groupNextChild!=null&&groupNexBeginEndChild!=null&&groupNexBeginEndChild.equals(1)) groupTmpMap.put(groupNextChild,groupTmpMap.get(groupNextChild)==null?1:groupTmpMap.get(groupNextChild)+1);
										 if(groupNextChild!=null&&groupNexBeginEndChild!=null&&groupNexBeginEndChild.equals(2)) groupTmpMap.put(groupNextChild,groupTmpMap.get(groupNextChild)==null?0:groupTmpMap.get(groupNextChild)-1);
									 }
									 if(atomChild.getAtomBEs()!=null&&atomChild.getAtomBEs().size()>0){
									 	for(AtomBE atomBEGrandSon:atomChild.getAtomBEs()){
											Atom atomGrandSon=atomBEGrandSon.getAtom();
											if(atomGrandSon==null){continue;}
											if(atomGrandSon.getAtomName()!=null&&!atomGrandSon.getAtomName().equals("")&&atomGrandSon.getAnalType().equals(1)&&atomGrandSon.getAtomRule()==null){
												AtomRule atomNextTmpRuleGrandSon=atomDic.get(atomGrandSon.getAtomName());
												if(atomNextTmpRuleGrandSon==null) return "ERROR:解析标记:["+atomGrandSon.getAtomName()+"]没有对应的解析规则";
												atomGrandSon.setAtomRule(atomNextTmpRuleGrandSon);
												Integer groupNexBeginEndGrandSon = atomNextTmpRuleGrandSon.getGroupBeginEnd();
												Integer groupNextGrandson = atomNextTmpRuleGrandSon.getGroup();
												if(groupNextGrandson!=null&&groupNexBeginEndGrandSon!=null&&groupNexBeginEndGrandSon.equals(1)) groupMap.put(groupNextGrandson,groupMap.get(groupNextGrandson)==null?1:groupMap.get(groupNextGrandson)+1);
												if(groupNextGrandson!=null&&groupNexBeginEndGrandSon!=null&&groupNexBeginEndGrandSon.equals(2)) groupMap.put(groupNextGrandson,groupMap.get(groupNextGrandson)==null?0:groupMap.get(groupNextGrandson)-1);
												if(groupNextGrandson!=null&&groupNexBeginEndGrandSon!=null&&groupNexBeginEndGrandSon.equals(1)) groupTmpMap.put(groupNextGrandson,groupTmpMap.get(groupNextGrandson)==null?1:groupTmpMap.get(groupNextGrandson)+1);
												if(groupNextGrandson!=null&&groupNexBeginEndGrandSon!=null&&groupNexBeginEndGrandSon.equals(2)) groupTmpMap.put(groupNextGrandson,groupTmpMap.get(groupNextGrandson)==null?0:groupTmpMap.get(groupNextGrandson)-1);
											}
										}
									 }
								 }
							 }
                             Atom atomNextNew= MyJsonUtil.fromJson(MyJsonUtil.toJson(atomNextTmp), Atom.class);
						 	 if(blockStep==atoms.size()){
                                 message=atomToOMathAtomALL(innnerBlockAtomList);
								 System.out.println(MyJsonUtil.toJson(innnerBlockAtomList));
                                 if(!message.equals("SUCCESS")) return message;
                                 for(Atom blockAtom:innnerBlockAtomList){
                                     AtomBE atomNextBENew=new AtomBE(null, blockAtom,null);
                                     atomNextBENew.setType(0);
                                     atomNewBEs.add(atomNextBENew);
                                 }
                                 AtomBE atomNextBENew=new AtomBE(null, atomNextNew,null);
                                 atomNextBENew.setType(0);
                                 atomNewBEs.add(atomNextBENew);
                             }
                             innnerBlockAtomList.add(atomNextNew);
                             atomNextTmp.setAnalType(2);
						}
                       atomNew.setAtomBEs(atomNewBEs);
					   atom.setType(0);
					   atom.setAnalType(0);
					   atom.setAtomBEs(atomNewBEs);
					   break;
					 }
                       step=step==-1?1:step+1;
                       continue;
				   }
				   if(atomNext!=null&&atomNext.getAtomName()!=null) {
				   	   if(atomNext.getAnalType()!=null&&!atomNext.getAnalType().equals(2)){
						   Atom atomNew= MyJsonUtil.fromJson(MyJsonUtil.toJson(atomNext), Atom.class);
						   AtomBE atomBENew=new AtomBE(atomRuleBETmp.getBegin(), atomNew, atomRuleBETmp.getEnd());
						   atomBENew.setType(0);
						   atomBEs.add(atomBENew);
						   atom.setAtomBEs(atomBEs);
					   }
					   atomNext.setAnalType(2);
					   step=step==-1?1:step+1;
					   continue;
				   }
				   if(atomNext!=null&&atomNext.getAtomBEs()!=null&&atomNext.getAtomBEs().size()>0) {
				   	 if(atomNext.getAnalType()!=null&&!atomNext.getAnalType().equals(2)){
						 AtomBE atomBENew=null;
				   	 	 if(atomNext.getAtomBEs().size()==1){
							 atomBENew= MyJsonUtil.fromJson(MyJsonUtil.toJson(atomNext.getAtomBEs().get(0)), AtomBE.class);
						 }else {
				   	 	 	Atom atomTmp= MyJsonUtil.fromJson(MyJsonUtil.toJson(atomNext), Atom.class);
				   	 	 	atomBENew=new AtomBE(null,atomTmp,null);
				   	 	 	atomBENew.setType(0);
						 }
						 atomBEs.add(atomBENew);
						 atom.setAtomBEs(atomBEs);
					 }
					   atomNext.setAnalType(2);
					   step=step==-1?1:step+1;
				   }
				   if(atomNext==null){
                       Atom atomPlaceholder=new Atom("\u200B");
                       atomPlaceholder.setAnalType(0);
					   AtomBE atomBENew=new AtomBE(null, atomPlaceholder, null);
					   atomBENew.setType(0);
					   atomBEs.add(atomBENew);
					   atom.setAtomBEs(atomBEs);
					   step=step==-1?1:step+1;
				   }
			   }
		   }
	   }
       if(atomRuleBEsTmp!=null&&atomRuleBEsTmp.size()>0&&step==-99) {//解析类似\over将整个块从中间分隔的样式
            Atom atomBefore = new Atom();
            atomBefore.setType(0);
            atomBefore.setAnalType(0);
            List<AtomBE> atomBeforeNewBEs=new ArrayList<AtomBE>();
            for(int index=0;index<i;index++){
                Atom atomBeforeTmp = atoms.get(index);
                if(atomBeforeTmp.getAnalType()!=null&&atomBeforeTmp.getAnalType().equals(2)) continue;
                Atom atomBeforeNew = MyJsonUtil.fromJson(MyJsonUtil.toJson(atomBeforeTmp), Atom.class);
                AtomBE atomBENew=new AtomBE(null, atomBeforeNew, null);
                atomBENew.setType(0);
                atomBeforeNewBEs.add(atomBENew);
                atomBeforeTmp.setAnalType(2);
            }
            atomBefore.setAtomBEs(atomBeforeNewBEs);

            Atom atomAfter = new Atom();
            atomAfter.setAnalType(0);
            atomAfter.setType(0);
            List<AtomBE> atomAfterNewBEs=new ArrayList<AtomBE>();
            for(int index=i+1;index<atoms.size();index++){
               Atom atomAfterTmp = atoms.get(index);
               if(atomAfterTmp.getAnalType()!=null&&atomAfterTmp.getAnalType().equals(2)) continue;
               Atom atomAfterNew = MyJsonUtil.fromJson(MyJsonUtil.toJson(atomAfterTmp), Atom.class);
               AtomBE atomBENew=new AtomBE(null, atomAfterNew, null);
               atomBENew.setType(0);
               atomAfterNewBEs.add(atomBENew);
               atomAfterTmp.setAnalType(2);
            }
            atomAfter.setAtomBEs(atomAfterNewBEs);
            String resultMessage= atomToOMathAtom(atomAfter);
            if(!resultMessage.equals("SUCCESS")) return resultMessage;
            List<AtomBE> atomNewBEs=new ArrayList<AtomBE>();
            AtomBE atomBEBeforeNew=new AtomBE(null, atomBefore, null);
            atomBEBeforeNew.setType(0);
            AtomBE atomBEAfterNew=new AtomBE(null, atomAfter, null);
            atomBEAfterNew.setType(0);
            atomNewBEs.add(atomBEBeforeNew);
            atomNewBEs.add(atomBEAfterNew);
            atom.setAtomBEs(atomNewBEs);
       }
	  return "SUCCESS";
   }

   public  boolean atomToOMathSeriesAtom(List<Atom> atoms,Integer i){
	   Atom atom=atoms.get(i);
	   List<AtomRuleSeries> atomRuleSeriesDicList=atomRuleSeriesDic.get(atom.getAtomName());
	   if(atomRuleSeriesDicList==null||atomRuleSeriesDicList.size()<1) return false;
	   List<AtomBE> atomBEs=atom.getAtomBEs();
	   if(atomBEs==null) atomBEs=new ArrayList<AtomBE>();
	   AtomRuleSeries atomRuleSeriesMatched=null;
	   for(AtomRuleSeries atomRuleSeries:atomRuleSeriesDicList){
		   int step=atomRuleSeries.getType();
		   List<AtomBE> atomRuleSeriesList=atomRuleSeries.getAtomBEList();
		   if(atomToOMathSeriesAtomIsMatched(atomRuleSeriesList,atoms,i,step)){
			   atomRuleSeriesMatched=atomRuleSeries;
			   break;
		   }
	   }
	   if(atomRuleSeriesMatched==null) return false;
	   int step=atomRuleSeriesMatched.getType();
	   List<AtomBE> atomRuleSeriesList=atomRuleSeriesMatched.getAtomBEList();
	   for(AtomBE atomRuleSeriesAtomBE : atomRuleSeriesList){
		   Atom atomNext=i+step>=atoms.size()||i+step<0?null:atoms.get(i+step);
		   //取到不失效的atom
		   if(atomNext!=null&&((atomNext.getAnalType()!=null&&atomNext.getAnalType().equals(2))||(atomNext.getAtomName()!=null&&atomNext.getAtomName().equals("\u200B")))){
			   int invalidStep=1;
			   int trend=step<0?-1:1;
			   while (i+step+invalidStep*trend<atoms.size()&&i+step+invalidStep*trend>=0){
				   atomNext=i+step+invalidStep*trend>=atoms.size()||i+step+invalidStep*trend<0?null:atoms.get(i+step+invalidStep*trend);
                   if(atomNext!=null&&atomNext.getAtomName()!=null&&atomNext.getAtomName().equals("\u200B")){
                       atomNext.setAnalType(2);
                   }
				   if(atomNext!=null&&atomNext.getAnalType()!=null&&!atomNext.getAnalType().equals(2)) break;
				   invalidStep++;
			   }
		   }
		   if(i+step>i&&atomNext!=null&&(atomRuleSeriesAtomBE.getMappingType()==null||!atomRuleSeriesAtomBE.getMappingType().equals(2))) {
			   String message=atomToOMathAtom(atomNext);
               if(atomNext.getAnalType()!=null&&atomNext.getAnalType().equals(1)&&atomNext.getAtomName()!=null){
                   AtomRule atomRuleNext=atomDic.get(atomNext.getAtomName());
                   if(atomRuleNext==null) return false;
                   atomNext.setAtomRule(atomRuleNext);
               }
			   if(!message.equals("SUCCESS")) return false;
		   }
		   if(atomRuleSeriesAtomBE.getMatchType()!=null&&atomRuleSeriesAtomBE.getMatchType().equals(0)){//可以不匹配时处理
			   if(atomRuleSeriesAtomBE.getAtom()==null||atomRuleSeriesAtomBE.getAtom().getAtomName()==null){
				   if(atomNext.getAtomBEs()!=null&&atomNext.getAtomBEs().get(0).getBegin()!=null&&atomNext.getAtomBEs().get(0).getBegin().equals(atomRuleSeriesAtomBE.getBegin())){
					   if(atomNext.getAnalType()!=null&&!atomNext.getAnalType().equals(2)) {
						   AtomBE atomBENew = MyJsonUtil.fromJson(MyJsonUtil.toJson(atomNext.getAtomBEs().get(0)), AtomBE.class);
						   atomBEs.add(atomBENew);
						   atom.setAtomBEs(atomBEs);
					   }
					   atomNext.setAnalType(2);
				   	   step=step==-1?1:step+1;
					   continue;
				   }
			   }else {
				   if(atomNext.getAtomName()!=null&&atomRuleSeriesAtomBE.getAtom()!=null&&atomNext.getAtomName().equals(atomRuleSeriesAtomBE.getAtom().getAtomName())){
					   if(atomNext.getAnalType()!=null&&!atomNext.getAnalType().equals(2)) {
						   Atom atomNew = MyJsonUtil.fromJson(MyJsonUtil.toJson(atomNext), Atom.class);
						   AtomBE atomBENew = new AtomBE(atomRuleSeriesAtomBE.getBegin(), atomNew, atomRuleSeriesAtomBE.getEnd());
						   atomBENew.setType(0);
						   atomBENew.setMappingType(atomRuleSeriesAtomBE.getMappingType());
						   atomBEs.add(atomBENew);
						   atom.setAtomBEs(atomBEs);
					   }
					   atomNext.setAnalType(2);
				   	   step=step==-1?1:step+1;
					   continue;
				   }
			   }
		   }else {//必须匹配至少一个
		   	    if(atomNext.getAtomName()==null&&atomNext.getAtomBEs()!=null&&atomNext.getAtomBEs().size()>0){
					if(atomNext.getAnalType()!=null&&!atomNext.getAnalType().equals(2)) {
						Atom firAtomInAtomBE=atomNext.getAtomBEs().get(0).getAtom();
						AtomRule firAtomRule=firAtomInAtomBE==null?null:firAtomInAtomBE.getAtomRule();
						if(firAtomRule!=null&&firAtomRule.getGroup()!=null&&firAtomRule.getGroup()>0){
							Atom nextAtomNew = MyJsonUtil.fromJson(MyJsonUtil.toJson(atomNext), Atom.class);
							AtomBE atomBENew = new AtomBE(null, nextAtomNew, null);
							atomBENew.setType(0);
							atomBENew.setMappingType(atomRuleSeriesAtomBE.getMappingType());
							atomBEs.add(atomBENew);
							atom.setAtomBEs(atomBEs);
						}else {
							List<AtomBE> atomBENews = MyJsonUtil.jsontoListClazz(MyJsonUtil.toJson(atomNext.getAtomBEs()), AtomBE.class);
							atomBEs.addAll(atomBENews);
							atom.setAtomBEs(atomBEs);
						}
					}
					atomNext.setAnalType(2);
					step=step==-1?1:step+1;
					continue;
				}else {
					if(atomNext.getAnalType()!=null&&!atomNext.getAnalType().equals(2)) {
						Atom nextAtomNew = MyJsonUtil.fromJson(MyJsonUtil.toJson(atomNext), Atom.class);
						AtomBE atomBENew = new AtomBE(null, nextAtomNew, null);
						atomBENew.setType(0);
						atomBENew.setMappingType(atomRuleSeriesAtomBE.getMappingType());
						atomBEs.add(atomBENew);
						atom.setAtomBEs(atomBEs);
					}
					atomNext.setAnalType(2);
					step=step==-1?1:step+1;
					continue;
				}
		   }
	   }
       atom.setFormType(1);
	   atom.setMoveType(1);
	   atom.setAtomRuleSeries(atomRuleSeriesMatched);
       return  true;
   }

	public static boolean atomToOMathSeriesAtomIsMatched(List<AtomBE> atomRuleSeriesList,List<Atom> atoms,Integer i,int step) {
		for(AtomBE atomRuleSeriesAtomBE : atomRuleSeriesList){
			if(i+step>=atoms.size()||i+step<0) return false;
			Atom currentAtom=atoms.get(i+step);
			if(atomRuleSeriesAtomBE.getMatchType()!=null&&atomRuleSeriesAtomBE.getMatchType().equals(0)){//可以不匹配时处理
				if(atomRuleSeriesAtomBE.getAtom()==null||atomRuleSeriesAtomBE.getAtom().getAtomName()==null){
					if(currentAtom.getAtomBEs()!=null&&currentAtom.getAtomBEs().get(0).getBegin().equals(atomRuleSeriesAtomBE.getBegin())){
						step=step==-1?1:step+1;
						continue;
					}
				}else {
					if(currentAtom.getAtomName()!=null&&atomRuleSeriesAtomBE.getAtom()!=null&&currentAtom.getAtomName().equals(atomRuleSeriesAtomBE.getAtom().getAtomName())){
						step=step==-1?1:step+1;
						continue;
					}
				}
			}else {//必须匹配至少一个
				if(atomRuleSeriesAtomBE.getAtom()==null||atomRuleSeriesAtomBE.getAtom().getAtomName()==null){
					step=step==-1?1:step+1;
					continue;
				}else {
					if(currentAtom.getAtomName()==null||!currentAtom.getAtomName().equals(atomRuleSeriesAtomBE.getAtom().getAtomName())) return false;
					step=step==-1?1:step+1;
					continue;
				}
			}
		}
		return true;
	}

	public  String atomToOMathAtom(Atom atom) {
		String message="SUCCESS";
		List<AtomBE> atomBEs=atom.getAtomBEs();
		if(atom.getAtomName()==null&&atom.getType().equals(0) &&atom.getAnalType().equals(0) &&atomBEs!=null &&atomBEs.size()==1 &&atomBEs.get(0).getBegin()==null &&atomBEs.get(0).getEnd()==null){
			if(atomBEs.get(0).getAtom().getAtomName()!=null){
				atom.setAtomName(atomBEs.get(0).getAtom().getAtomName());
				atom.setAnalType(atomBEs.get(0).getAtom().getAnalType());
				if(atomBEs.get(0).getAtom().getAtomBEs()==null||atomBEs.get(0).getAtom().getAtomBEs().size()<1) {atom.setAtomBEs(null);}
				return message;
			}
			if(atomBEs.get(0).getAtom().getAtomBEs()!=null&&atomBEs.get(0).getAtom().getAtomBEs().size()>0) atom.setAtomBEs(atomBEs.get(0).getAtom().getAtomBEs());
			//return message;
		}
		if(atom.getAtomBEs()!=null&&atom.getAtomBEs().size()>0){
			List<Atom> atomChildren=atom.atomListFromAtomBEs();
			if(atomChildren!=null&&atomChildren.size()>0) message=atomToOMathAtomALL(atomChildren);
			if(!message.equals("SUCCESS")) return message;
		}
		atom.setMoveType(1);
		return message;
	}

}
