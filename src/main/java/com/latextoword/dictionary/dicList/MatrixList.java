package com.latextoword.dictionary.dicList;

import com.latextoword.dictionary.MatrixStyle;

import java.util.Hashtable;

/**
 * @Author: maoyuwei
 * @Date: 2019/3/5 20:44
 * @Desc:
 **/
public class MatrixList {

       private MatrixList(){};

       private static Hashtable<String, MatrixStyle> matrixDic;

       private static volatile MatrixList matrixList;

    public static Hashtable<String, MatrixStyle> getMatrixDicList() {
        if(matrixList!=null)  return MatrixList.matrixDic;
        synchronized (MatrixList.class) {
            if(matrixList==null) {
                initMatrixList();
                return MatrixList.matrixDic;
            }
        }
        return  MatrixList.matrixDic;
    }
    private static MatrixList initMatrixList() {
        matrixList=new MatrixList();
        matrixDic=new Hashtable<String, MatrixStyle>();
        for(MatrixStyle matrixStyle:MatrixStyle.values()) {
            matrixDic.put(matrixStyle.getStyleStr(), matrixStyle);
        }
        return matrixList;
    }

}
