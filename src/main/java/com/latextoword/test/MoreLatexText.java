package com.latextoword.test;

import com.latextoword.Latex_Word;
import com.latextoword.dictionary.AtomChar;
import com.latextoword.dictionary.OMathRule;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @Author: maoyuwei
 * @Date: 2020/1/13 16:54
 * @Desc:
 **/
public class MoreLatexText {

    public static void main1(String[] args) {
        File file = new File("C:\\Users\\maoyuwei\\Desktop\\新建文件夹\\新建文件夹\\latex-error.log");
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            String s = null;
            int i=0;
            while((s = br.readLine())!=null){
                 String result=Latex_Word.latexToWordAlreadyClean(s);
                 if(result.equals("ERROR")) System.out.println(">>>------------ "+s);
                i++;
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        for(OMathRule atom: OMathRule.values()) {
            if(atom.getoMathId()>34&&atom.getoMathId()<253){
                String or = atom.getoMathName()+" ";
                String ta = atom.getAtom().getAtomName();
                ta = ta .replaceAll("<m:r.*?m:t>","");
                ta = ta .replaceAll("</m:t.*?/m:r>","");
                System.out.println("latex = latex.replace(\""+ta+"\",\""+or+"\")");
            }

        }
    }

}
