package com.latextoword.atom;
//元素结构

import java.util.ArrayList;
import java.util.List;

import com.latextoword.dictionary.AtomRule;
import com.latextoword.dictionary.AtomRuleSeries;
import com.latextoword.dictionary.MatrixStyle;

public class Atom {
    private Integer atomId;
    private String atomName;
    private List<AtomBE> atomBEs;
    private Integer type;//0：分解完全；1：需分解；
    private Integer analType;//0：解析完成；1：未解析；2:失效
    private Integer formType;//0：AtomRule映射；1：AtomSeries映射
    private Integer oMathType;//0：和atomName拼接；1：非必须匹配项的替换方式;
    private Integer moveType;//0:未完成移位解析；1：已完成移位解析
    private Integer blockType;//0:未完成块级关联下沉；1：已完成块级关联下沉
    private AtomRule atomRule;
    private AtomRuleSeries atomRuleSeries;
    private MatrixStyle matrixStyle;

    public Atom() {
    }

    public Atom(String atomName) {
        this.atomName = atomName;
    }

    public Atom(String atomName, Integer oMathType) {
        this.atomName = atomName;
        this.oMathType = oMathType;
    }

    public Atom(Integer atomId, String atomName) {
        this.atomName = atomName;
        this.atomId = atomId;
    }

    public Atom(Integer atomId, String atomName, List<AtomBE> atomBEs) {
        this.atomId = atomId;
        this.atomName = atomName;
        this.atomBEs = atomBEs;
    }

    public Atom(Integer atomId, String atomName, String begin, Atom atom, String end) {
        this.atomId = atomId;
        this.atomName = atomName;
        AtomBE atomBE = new AtomBE(begin, atom, end);
        List<AtomBE> atomBEs = new ArrayList<AtomBE>();
        atomBEs.add(atomBE);
        this.atomBEs = atomBEs;
    }

    public Atom(Integer atomId, String atomName, String begin, Integer oMathStyle, Atom atom, String end) {
        this.atomId = atomId;
        this.atomName = atomName;
        AtomBE atomBE = new AtomBE(begin, oMathStyle, atom, end);
        List<AtomBE> atomBEs = new ArrayList<AtomBE>();
        atomBEs.add(atomBE);
        this.atomBEs = atomBEs;
    }

    public Atom(Integer atomId, String atomName, String begin, Atom atom, String end, String begin1, Atom atom1, String end1) {
        this.atomId = atomId;
        this.atomName = atomName;
        AtomBE atomBE = new AtomBE(begin, atom, end);
        AtomBE atomBE1 = new AtomBE(begin1, atom1, end1);
        List<AtomBE> atomBEs = new ArrayList<AtomBE>();
        atomBEs.add(atomBE);
        atomBEs.add(atomBE1);
        this.atomBEs = atomBEs;
    }

    public Atom(Integer atomId, String atomName, String begin, Atom atom, String end, Integer matchType) {
        this.atomId = atomId;
        this.atomName = atomName;
        AtomBE atomBE = new AtomBE(begin, atom, end, matchType);
        List<AtomBE> atomBEs = new ArrayList<AtomBE>();
        atomBEs.add(atomBE);
        this.atomBEs = atomBEs;
    }

    public Atom(Integer atomId, String atomName, String begin, Atom atom, String end, Integer matchType, Integer mappingType) {
        this.atomId = atomId;
        this.atomName = atomName;
        AtomBE atomBE = new AtomBE(begin, atom, end, matchType, mappingType);
        List<AtomBE> atomBEs = new ArrayList<AtomBE>();
        atomBEs.add(atomBE);
        this.atomBEs = atomBEs;
    }

    public Atom(Integer atomId, String atomName, String begin, Atom atom, String end, Integer matchType, String begin1, Atom atom1, String end1, Integer matchType1) {
        this.atomId = atomId;
        this.atomName = atomName;
        AtomBE atomBE = new AtomBE(begin, atom, end, matchType);
        AtomBE atomBE1 = new AtomBE(begin1, atom1, end1, matchType1);
        List<AtomBE> atomBEs = new ArrayList<AtomBE>();
        atomBEs.add(atomBE);
        atomBEs.add(atomBE1);
        this.atomBEs = atomBEs;
    }

    public Integer getAtomId() {
        return atomId;
    }

    public void setAtomId(Integer atomId) {
        this.atomId = atomId;
    }

    public String getAtomName() {
        return atomName;
    }

    public void setAtomName(String atomName) {
        this.atomName = atomName;
    }

    public List<AtomBE> getAtomBEs() {
        return atomBEs;
    }

    public void setAtomBEs(List<AtomBE> atomBEs) {
        this.atomBEs = atomBEs;
    }

    public void setAtomBEsFromAtomList(List<Atom> atoms) {
        List<AtomBE> atomBETmp = new ArrayList<AtomBE>();
        for (Atom atom : atoms) {
            AtomBE atomBE = new AtomBE();
            atomBE.setAtom(atom);
            atomBE.setType(0);
            atomBETmp.add(atomBE);
        }
        this.atomBEs = atomBETmp;
    }

    public List<Atom> atomListFromAtomBEs() {
        List<Atom> atomList = new ArrayList<Atom>();
        if (atomBEs == null || atomBEs.size() < 1) return null;
        for (AtomBE atomBE : atomBEs) {
            atomList.add(atomBE.getAtom());
        }
        return atomList;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getAnalType() {
        return analType;
    }

    public void setAnalType(Integer analType) {
        this.analType = analType;
    }

    public Integer getFormType() {
        return formType;
    }

    public void setFormType(Integer formType) {
        this.formType = formType;
    }

    public Integer getoMathType() {
        return oMathType;
    }

    public void setoMathType(Integer oMathType) {
        this.oMathType = oMathType;
    }

    public Integer getMoveType() {
        return moveType;
    }

    public void setMoveType(Integer moveType) {
        this.moveType = moveType;
    }

    public AtomRule getAtomRule() {
        return atomRule;
    }

    public void setAtomRule(AtomRule atomRule) {
        this.atomRule = atomRule;
    }

    public AtomRuleSeries getAtomRuleSeries() {
        return atomRuleSeries;
    }

    public void setAtomRuleSeries(AtomRuleSeries atomRuleSeries) {
        this.atomRuleSeries = atomRuleSeries;
    }
    public MatrixStyle getMatrixStyle() {
        return matrixStyle;
    }

    public void setMatrixStyle(MatrixStyle matrixStyle) {
        this.matrixStyle = matrixStyle;
    }

    public Integer getBlockType() {
        return blockType;
    }

    public void setBlockType(Integer blockType) {
        this.blockType = blockType;
    }

}

