package com.latextoword.atom;

//开始标志+元素+结束标志
public class AtomBE {
    private String begin;
    private Atom atom;
    private String end;
    private Integer type;//0:不显示起止符；1：显示起止符;
    private Integer matchType;//0:可以不匹配；1：必须至少匹配一项;
    private Integer mappingType;//0:atomName为普通字符；1：atomName需要单独映射;2：无效OMath对应符，3：匹配下一个块级开始符;
    private Integer oMathStyle;//0:一般样式；1：mr样式；2:mr允许空格样式

    public AtomBE() {

    }

    public AtomBE(String begin, Atom atom, String end) {
        this.begin = begin;
        this.atom = atom;
        this.end = end;
    }

    public AtomBE(Atom atom, Integer matchType, Integer mappingType) {
        this.atom = atom;
        this.matchType = matchType;
        this.mappingType = mappingType;
    }

    public AtomBE(String begin, Atom atom, String end, Integer matchType) {
        this.begin = begin;
        this.atom = atom;
        this.end = end;
        this.matchType = matchType;
    }

    public AtomBE(String begin, Integer oMathStyle, Atom atom, String end) {
        this.begin = begin;
        this.atom = atom;
        this.end = end;
        this.oMathStyle = oMathStyle;
    }

    public AtomBE(String begin, Atom atom, String end, Integer matchType, Integer mappingType) {
        this.begin = begin;
        this.atom = atom;
        this.end = end;
        this.matchType = matchType;
        this.mappingType = mappingType;
    }

    public AtomBE(Integer matchType, Integer mappingType) {
        this.matchType = matchType;
        this.mappingType = mappingType;
    }

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public Atom getAtom() {
        return atom;
    }

    public void setAtom(Atom atom) {
        this.atom = atom;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getMatchType() {
        return matchType;
    }

    public void setMatchType(Integer matchType) {
        this.matchType = matchType;
    }

    public Integer getMappingType() {
        return mappingType;
    }

    public void setMappingType(Integer mappingType) {
        this.mappingType = mappingType;
    }

    public Integer getoMathStyle() {
        return oMathStyle;
    }

    public void setoMathStyle(Integer oMathStyle) {
        this.oMathStyle = oMathStyle;
    }

}
