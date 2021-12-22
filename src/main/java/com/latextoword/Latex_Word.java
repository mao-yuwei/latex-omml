package com.latextoword;

import com.latextoword.anal.AtomAnalysis;
import com.latextoword.anal.AtomToOMath;
import com.latextoword.anal.InitAtom;
import com.latextoword.atom.Atom;

import java.util.*;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: maoyuwei
 * @Date: 2019/4/16 19:53
 * @Desc: latex 公式转换为word样式的公式
 * 版权所有者：毛玉伟
 * 电话：15764220809
 * QQ：2277630164
 * 有无法转化的样式望告知
 **/
public class Latex_Word {
    private static Logger logger=Logger.getLogger("Latex_Word");
    /**
     *@Author: maoyuwei
     *@Date: 2019/5/12 10:32
     *@Desc: latex公式转化为word公式（omml），（latex公式带边界）
     */
    public static String  latexToWord(String latexStr){
        String latex= latexClean(latexStr);
        return latexToWordAlreadyClean(latex);
    }
    /**
     *@Author: maoyuwei
     *@Date: 2019/5/12 10:32
     *@Desc: latex公式转化为word公式（omml），（latex公式不带边界）
     */
    public static String  latexToWordAlreadyClean(String latex){
        List<Atom> atoms= InitAtom.latexIntoAtomAll(latex);
        AtomAnalysis atomAnalysis=new AtomAnalysis();
        String message= atomAnalysis.atomListToOMathAtomList(atoms);
        if(message.indexOf("ERROR")>=0){
            logger.info("[latexToWord:ERROR]:"+message);
            return "ERROR";
        }
        AtomToOMath atomToOMath = new AtomToOMath();
        String oMathStr= atomToOMath.atomToOMathStrMain(atoms);
        if(oMathStr.indexOf("ERROR")>=0){
            logger.info("[latexToWord:ERROR]:"+oMathStr);
            return "ERROR";
        }
        if(!checkOmmlFormat(oMathStr)) return "ERROR";
        return oMathStr;
    }
    public static String  latexToWordResult(String latexStr){
        String latex= latexClean(latexStr);
        List<Atom> atoms= InitAtom.latexIntoAtomAll(latex);
        AtomAnalysis atomAnalysis=new AtomAnalysis();
        String message= atomAnalysis.atomListToOMathAtomList(atoms);
        if(message.indexOf("ERROR")>=0){
            return message;
        }
        AtomToOMath atomToOMath = new AtomToOMath();
        String oMathStr= atomToOMath.atomToOMathStrMain(atoms);
        if(!checkOmmlFormat(oMathStr)) return "ERROR";
        return oMathStr;
    }
    public static String latexClean(String latexStr){
        String latex=latexStr.trim();
        List<Map<String,String>> borderList= new ArrayList<Map<String, String>>();
        Map<String,String> map1=new HashMap<String, String>();
        map1.put("leftBorder","\\(");
        map1.put("rightBorder","\\)");
        borderList.add(map1);

        Map<String,String> map2=new HashMap<String, String>();
        map2.put("leftBorder","$$");
        map2.put("rightBorder","$$");
        borderList.add(map2);

        Map<String,String> map3=new HashMap<String, String>();
        map3.put("leftBorder","\\[");
        map3.put("rightBorder","\\]");
        borderList.add(map3);

        Map<String,String> map11=new HashMap<String, String>();
        map11.put("leftBorder","$");
        map11.put("rightBorder","$");
        borderList.add(map11);

        int latexLength=latex.length();
        if(latexLength<2)  return "ERROR";
        for(Map<String,String> map:borderList){
            String leftBorder=map.get("leftBorder");
            String rightBorder=map.get("rightBorder");
            int cutLength=leftBorder.length();
            if(latex.substring(0,cutLength).equals(leftBorder)&&latex.substring(latexLength-cutLength).equals(rightBorder)){
                latex=latex.substring(cutLength,latexLength-cutLength);
                break;
            }
        }
        return  latex;
    }

    public static boolean checkOmmlFormat(String omml){
        String ommlStr=omml.replaceAll("<[^>]+/>","");
        Map<String,Integer> labelCount=new HashMap<String, Integer>();
        String regexStart="(?<=<)m:\\w+";
        Pattern patternStart=Pattern.compile(regexStart);
        Matcher matcherStart=patternStart.matcher(ommlStr);
        while (matcherStart.find()){
            String label=matcherStart.group();
            labelCount.put(label,labelCount.get(label)==null?1:labelCount.get(label)+1);
        }
        String regexEnd="(?<=</)m:\\w+";
        Pattern patternEnd=Pattern.compile(regexEnd);
        Matcher matcherEnd=patternEnd.matcher(ommlStr);
        while (matcherEnd.find()){
            String label=matcherEnd.group();
            labelCount.put(label,labelCount.get(label)==null?-1:labelCount.get(label)-1);
        }
        for(String key:labelCount.keySet()){
            if(!labelCount.get(key).equals(0)){
                logger.info("----------------不闭合标签：["+key+"]----------------------------------------------");
                logger.info("----------------公式转换标签不闭合！--------------->>>["+omml+"]");
                return false;
            }
        }
        return  true;
    }

    public static void main(String[] args) {
        String latex = "2^q+⇔";
        System.out.println(latexToWord(latex));
    }



}
