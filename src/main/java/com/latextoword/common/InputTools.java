package com.latextoword.common;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: maoyuwei
 * @Date: 2019/3/28 17:59
 * @Desc:
 **/
public class InputTools {
    public static void main(String[] args) {
        LinkedHashMap<String,String> map=new LinkedHashMap<String, String>();

        /*map.put("vartheta","ϑ");
        map.put("blacktriangle","▲");
        map.put("surd","√");
        map.put("subseteq","⊆");
        map.put("supseteq","⊇");
        map.put("subset","⊂");
        map.put("supset","⊃");*/

       // map.put("emptyset","∅");
        map.put("succ","≻");










        // map.put("&aacute;","á");
       // map.put("═","=");








        //ruleHtmlMappingFormat(2155,map);
       ruleMappingFormat(252,map);
        //ruleAccMappingFormat(402,map);

    }

    public static void ruleMappingFormat(Integer startId, LinkedHashMap<String,String> map){
        Integer rIndex=startId;
        for(String key:map.keySet()){
            System.out.println(key.toUpperCase()+"("+rIndex+",\"\\\\"+key+"\",new Atom("+rIndex+",\"\\\\"+key+"\"),0,0,0,0,OMathRule."+key.toUpperCase()+"),");
            rIndex++;
        }
        System.out.println("-----------------------------------------------------------");
        for(String key:map.keySet()){
            System.out.println(key.toUpperCase()+"("+startId+",\"\\\\"+key+"\",new Atom("+startId+",\"<m:r><m:t>"+map.get(key)+"</m:t></m:r>\"),0),");
            startId++;
        }
    }
    public static void ruleAccMappingFormat(Integer startId, LinkedHashMap<String,String> map){
        Integer rIndex=startId;
        for(String key:map.keySet()){
            System.out.println(key.toUpperCase()+"("+rIndex+",\"\\\\"+key+"\",new Atom("+rIndex+",\"\\\\"+key+"\",\"{\",new Atom(),\"}\",1),1,0,0,0,OMathRule."+key.toUpperCase()+"),");
            rIndex++;
        }
        System.out.println("-----------------------------------------------------------");
        for(String key:map.keySet()){
            System.out.println(key.toUpperCase()+"("+startId+",\"\\\\"+key+"\",new Atom("+startId+",\"<m:acc><m:accPr><m:chr m:val=\\\""+map.get(key)+"\\\"/></m:accPr>\",\"<m:e>\",new Atom(),\"</m:e></m:acc>\"),1),");
            startId++;
        }
    }

    public static void ruleHtmlMappingFormat(Integer startId, LinkedHashMap<String,String> map){
        Integer rIndex=startId;
        for(String key:map.keySet()){
            String tKey=key.trim();
            String enumKey=tKey.substring(1,tKey.length()-1);
            System.out.println("_"+enumKey.toUpperCase()+"("+rIndex+",\""+tKey+"\",new Atom("+rIndex+",\""+key+"\"),0,0,0,0,OMathRule._"+enumKey.toUpperCase()+"),");
            rIndex++;
        }
        System.out.println("-----------------------------------------------------------");
        for(String key:map.keySet()){
            String tKey=key.trim();
            String enumKey=tKey.substring(1,tKey.length()-1);
            System.out.println("_"+enumKey.toUpperCase()+"("+startId+",\""+tKey+"\",new Atom("+startId+",\"<m:r><m:t>"+map.get(key).trim()+"</m:t></m:r>\"),0),");
            startId++;
        }
    }






}
