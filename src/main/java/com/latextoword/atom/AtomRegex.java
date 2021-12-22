package com.latextoword.atom;

public class AtomRegex {
	private Integer regexId;
	private String begin;
	private String regex;
	private String end;
	private Integer type;//0:不显示起止符；1：显示起止符
	private Integer matchtype;//普通连续匹配；1：显示起止符的转义块级匹配匹配长度为2
	private Integer analysisType;//解析类型 1：解析 2：不解析

	public  AtomRegex() {
		
	}
    public  AtomRegex(String begin,String regex,String end,Integer type,Integer matchtype,Integer analysisType) {
		this.begin=begin;
		this.regex=regex;
		this.type=type;
		this.matchtype=matchtype;
		this.end=end;
		this.analysisType=analysisType;
	}
	public  AtomRegex(Integer regexId,String begin,String regex,String end,Integer type,Integer matchtype,Integer analysisType) {
		this.begin=begin;
		this.regex=regex;
		this.type=type;
		this.matchtype=matchtype;
		this.end=end;
		this.regexId=regexId;
		this.analysisType=analysisType;
	}
	public Integer getRegexId() {
		return regexId;
	}
	public void setRegexId(Integer regexId) {
		this.regexId = regexId;
	}
	public String getBegin() {
		return begin;
	}
	public void setBegin(String begin) {
		this.begin = begin;
	}
	public String getRegex() {
		return regex;
	}
	public void setRegex(String regex) {
		this.regex = regex;
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
	public Integer getMatchtype() {
		return matchtype;
	}
	public void setMatchtype(Integer matchtype) {
		this.matchtype = matchtype;
	}

	public Integer getAnalysisType() {
		return analysisType;
	}

	public void setAnalysisType(Integer analysisType) {
		this.analysisType = analysisType;
	}
}
