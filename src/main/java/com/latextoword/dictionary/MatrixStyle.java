package com.latextoword.dictionary;

public enum MatrixStyle {
    MATRIX(1,"matrix","<m:begChr m:val=\"\"/>","<m:endChr m:val=\"\"/>"),
    VMATRIX(2,"vmatrix","<m:begChr m:val=\"|\"/>","<m:endChr m:val=\"|\"/>"),
    V_MATRIX(3,"Vmatrix","<m:begChr m:val=\"|\"/>","<m:endChr m:val=\"|\"/>"),
    BMATRIX(4,"bmatrix","<m:begChr m:val=\"[\"/>","<m:endChr m:val=\"]\"/>"),
    B_MATRIX(5,"Bmatrix","<m:begChr m:val=\"{\"/>","<m:endChr m:val=\"}\"/>"),
    P_MATRIX(6,"pmatrix","<m:begChr m:val=\"(\"/>","<m:endChr m:val=\")\"/>"),
    CASES(7,"cases","<m:begChr m:val=\"{\"/>","<m:endChr m:val=\"\"/>"),
    BRACES_BEGIN(8,"{","<m:begChr m:val=\"{\"/>","<m:endChr m:val=\"}\"/>"),
    BRACKET_BEGIN(10,"(","<m:begChr m:val=\"(\"/>","<m:endChr m:val=\")\"/>"),
    BRACKETZH_BEGIN(12,"（","<m:begChr m:val=\"(\"/>","<m:endChr m:val=\")\"/>"),
    SQARE_BRACKET_BEGIN(13,"[","<m:begChr m:val=\"[\"/>","<m:endChr m:val=\"]\"/>"),
    VMATRIX_BEGIN_BEGIN(14,"|","<m:begChr m:val=\"|\"/>","<m:endChr m:val=\"|\"/>"),
    DOT_BEGIN_BEGIN(15,".","<m:begChr m:val=\"\"/>","<m:endChr m:val=\"\"/>"),
    TR_BRACES_BEGIN(16,"\\{","<m:begChr m:val=\"{\"/>","<m:endChr m:val=\"}\"/>"),
    TR_BRACKET_BEGIN(17,"\\(","<m:begChr m:val=\"(\"/>","<m:endChr m:val=\")\"/>"),
    TR_SQARE_BRACKET_BEGIN(18,"\\[","<m:begChr m:val=\"[\"/>","<m:endChr m:val=\"]\"/>"),
    TR_VMATRIX_BEGIN_BEGIN(19,"\\|","<m:begChr m:val=\"‖\"/>","<m:endChr m:val=\"‖\"/>"),
    BRACES_END(20,"}","<m:begChr m:val=\"{\"/>","<m:endChr m:val=\"}\"/>"),
    BRACKET_END(21,")","<m:begChr m:val=\"(\"/>","<m:endChr m:val=\")\"/>"),
    BRACKETZH_END(22,"）","<m:begChr m:val=\"(\"/>","<m:endChr m:val=\")\"/>"),
    SQARE_BRACKET_END(23,"]","<m:begChr m:val=\"[\"/>","<m:endChr m:val=\"]\"/>"),
    TR_BRACES_END(24,"\\}","<m:begChr m:val=\"{\"/>","<m:endChr m:val=\"}\"/>"),
    TR_BRACKET_END(25,"\\)","<m:begChr m:val=\"(\"/>","<m:endChr m:val=\")\"/>"),
    TR_SQARE_BRACKET_END(26,"\\]","<m:begChr m:val=\"[\"/>","<m:endChr m:val=\"]\"/>"),
    LANGLE(27,"\\langle","<m:begChr m:val=\"⟨\"/>","<m:endChr m:val=\"⟩\"/>"),
    RANGLE(28,"\\rangle","<m:begChr m:val=\"⟨\"/>","<m:endChr m:val=\"⟩\"/>"),
    ALIGN(29,"align","<m:begChr m:val=\"\"/>","<m:endChr m:val=\"\"/>","<m:cGpRule m:val=\"3\"/><m:mcs><m:mc><m:mcPr><m:count m:val=\"1\"/><m:mcJc m:val=\"right\"/></m:mcPr></m:mc><m:mc><m:mcPr><m:count m:val=\"2\"/><m:mcJc m:val=\"left\"/></m:mcPr></m:mc></m:mcs>"),
    ALIGNAT(30,"alignat","<m:begChr m:val=\"\"/>","<m:endChr m:val=\"\"/>",1),
    ARRAY(31,"array","<m:begChr m:val=\"\"/>","<m:endChr m:val=\"\"/>",1),
    SPLIT(32,"split","<m:begChr m:val=\"\"/>","<m:endChr m:val=\"\"/>","<m:cGpRule m:val=\"3\"/><m:mcs><m:mc><m:mcPr><m:count m:val=\"1\"/><m:mcJc m:val=\"right\"/></m:mcPr></m:mc><m:mc><m:mcPr><m:count m:val=\"2\"/><m:mcJc m:val=\"left\"/></m:mcPr></m:mc></m:mcs>"),
    GATHERED(33,"gathered","<m:begChr m:val=\"\"/>","<m:endChr m:val=\"\"/>","<m:mcs><m:mc><m:mcPr><m:count m:val=\"1\"/><m:mcJc m:val=\"center\"/></m:mcPr></m:mc></m:mcs>"),
    LT(34,"<","<m:begChr m:val=\"⟨\"/>","<m:endChr m:val=\"⟩\"/>"),
    GT(35,">","<m:begChr m:val=\"⟨\"/>","<m:endChr m:val=\"⟩\"/>"),
    VERT(36,"\\vert","<m:begChr m:val=\"|\"/>","<m:endChr m:val=\"|\"/>"),
    ;


    private Integer styleId;
    private String styleStr;
    private String mappingBegin;
    private String mappingEnd;
    private String mcJcStyle;
    private Integer styleLength;//额外样式数

    private  MatrixStyle(Integer styleId, String styleStr, String mappingBegin, String mappingEnd){
        this.styleId=styleId;
        this.styleStr=styleStr;
        this.mappingEnd=mappingEnd;
        this.mappingBegin=mappingBegin;
    }
    private  MatrixStyle(Integer styleId,String styleStr,String mappingBegin,String mappingEnd,Integer styleLength){
        this.styleId=styleId;
        this.styleStr=styleStr;
        this.mappingEnd=mappingEnd;
        this.mappingBegin=mappingBegin;
        this.styleLength=styleLength;
    }
    private  MatrixStyle(Integer styleId,String styleStr,String mappingBegin,String mappingEnd,String mcJcStyle){
        this.styleId=styleId;
        this.styleStr=styleStr;
        this.mappingEnd=mappingEnd;
        this.mappingBegin=mappingBegin;
        this.mcJcStyle=mcJcStyle;
    }
    public Integer getStyleId() {
        return styleId;
    }

    public void setStyleId(Integer styleId) {
        this.styleId = styleId;
    }

    public String getStyleStr() {
        return styleStr;
    }

    public void setStyleStr(String styleStr) {
        this.styleStr = styleStr;
    }

    public String getMappingBegin() {
        return mappingBegin;
    }

    public void setMappingBegin(String mappingBegin) {
        this.mappingBegin = mappingBegin;
    }

    public String getMappingEnd() {
        return mappingEnd;
    }

    public void setMappingEnd(String mappingEnd) {
        this.mappingEnd = mappingEnd;
    }

    public Integer getStyleLength() {
        return styleLength;
    }

    public void setStyleLength(Integer styleLength) {
        this.styleLength = styleLength;
    }

    public String getMcJcStyle() {
        return mcJcStyle;
    }

    public void setMcJcStyle(String mcJcStyle) {
        this.mcJcStyle = mcJcStyle;
    }
}
