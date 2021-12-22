package com.latextoword.dictionary;

import com.latextoword.atom.Atom;
import com.latextoword.atom.AtomBE;

import java.util.Arrays;
import java.util.List;

public enum AtomRuleSeries {
    SUPSUB(1,"^",Arrays.asList(new AtomBE("{",new Atom(),"}",1),new AtomBE("{",new Atom(),"}",1),new AtomBE(new Atom("_"),1,2),new AtomBE("{",new Atom(),"}",1)),-1,OMathRule.SUPSUB),
    SUBSUP(2,"_",Arrays.asList(new AtomBE("{",new Atom(),"}",1),new AtomBE("{",new Atom(),"}",1),new AtomBE(new Atom("^"),1,2),new AtomBE("{",new Atom(),"}",1)),-1,OMathRule.SUBSUP),

    LIM_TO(3,"\\lim",Arrays.asList(new AtomBE(new Atom("_"),1,2),new AtomBE("{",new Atom(),"}",1)),1,OMathRule.LIM_TO),
    UNDER_BRACE(4,"\\underbrace",Arrays.asList(new AtomBE("{",new Atom(),"}",1),new AtomBE(new Atom("_"),1,2),new AtomBE("{",new Atom(),"}",1)),1,OMathRule.UNDER_BRACE),
    OVER_BRACE(5,"\\overbrace",Arrays.asList(new AtomBE("{",new Atom(),"}",1),new AtomBE(new Atom("^"),1,2),new AtomBE("{",new Atom(),"}",1)),1,OMathRule.OVER_BRACE),

    NO_LIMITS(6,"\\nolimits",Arrays.asList(new AtomBE("{",new Atom(),"}",1),new AtomBE(new Atom("_"),1,2),new AtomBE("{",new Atom(),"}",1),new AtomBE(new Atom("^"),1,2),new AtomBE("{",new Atom(),"}",1)),-1,OMathRule.NO_LIMITS),
    L_IMITS(7,"\\limits",Arrays.asList(new AtomBE("{",new Atom(),"}",1),new AtomBE(new Atom("_"),1,2),new AtomBE("{",new Atom(),"}",1),new AtomBE(new Atom("^"),1,2),new AtomBE("{",new Atom(),"}",1)),-1,OMathRule.L_IMITS),
    NO_LIMITS_1(8,"\\nolimits",Arrays.asList(new AtomBE("{",new Atom(),"}",1),new AtomBE(new Atom("^"),1,2),new AtomBE("{",new Atom(),"}",1),new AtomBE(new Atom("_"),1,2),new AtomBE("{",new Atom(),"}",1)),-1,OMathRule.NO_LIMITS_1),
    L_IMITS_1(9,"\\limits",Arrays.asList(new AtomBE("{",new Atom(),"}",1),new AtomBE(new Atom("^"),1,2),new AtomBE("{",new Atom(),"}",1),new AtomBE(new Atom("_"),1,2),new AtomBE("{",new Atom(),"}",1)),-1,OMathRule.L_IMITS_1),
    VERB(10,"\\verb",Arrays.asList(new AtomBE(new Atom("+"),1,2),new AtomBE("{",new Atom(),"}",1),new AtomBE(new Atom("+"),1,2)),1,OMathRule.V_ERB),


    ;
    private Integer seriesId;
    private String atomName;
    private List<AtomBE> atomBEList;
    private Integer type;//起始位置
    private OMathRule oMathRule;

    private AtomRuleSeries(Integer seriesId, String atomName, List<AtomBE> atomBEList, Integer type, OMathRule oMathRule){
        this.seriesId=seriesId;
        this.atomName=atomName;
        this.atomBEList=atomBEList;
        this.type=type;
        this.oMathRule=oMathRule;
    }

    public Integer getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(Integer seriesId) {
        this.seriesId = seriesId;
    }

    public String getAtomName() {
        return atomName;
    }

    public void setAtomName(String atomName) {
        this.atomName = atomName;
    }

    public List<AtomBE> getAtomBEList() {
        return atomBEList;
    }

    public void setAtomBEList(List<AtomBE> atomBEList) {
        this.atomBEList = atomBEList;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public OMathRule getoMathRule() {
        return oMathRule;
    }

    public void setoMathRule(OMathRule oMathRule) {
        this.oMathRule = oMathRule;
    }
}
