package com.latextoword.dictionary;

import com.latextoword.atom.AtomRegex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum AtomChar {
	
	 BACKSLASH("\\",Arrays.asList(new AtomRegex(1,"","^\\\\([a-zA-Z]+|\\\\| |;|,|!|%|#|\\$|\\^|_|~|:)","",0,0,1),new AtomRegex("{","^\\\\\\{.*?\\\\\\}","}",1,1,1),new AtomRegex("[","^\\\\\\[.*?\\\\\\]","]",1,1,1),new AtomRegex("","\\\\(\\{|\\}|\\[|\\]|\\(|\\))","",0,0,1)),0),
	 AMP("&",Arrays.asList(new AtomRegex("","^&[a-zA-z]{1,10}[1-5]?;","",0,0,1),new AtomRegex("","^&#[0-9]{1,5};","",0,0,2),new AtomRegex("","^&","",0,0,1)),0),
	 SUP("^",new ArrayList<AtomRegex>(),0),
	 SUB("_",new ArrayList<AtomRegex>(),0),
	 BRACE("{",Arrays.asList(new AtomRegex("{","^\\{.*?\\}","}",0,0,1)),1),
	 BRACKET("(",Arrays.asList(new AtomRegex("(","^\\(.*?\\)",")",1,0,1)),1),
	 BRACKETZH("（",Arrays.asList(new AtomRegex("（","^\\（.*?\\）","）",1,0,1)),1),
	 SQARE_BRACKET("[",Arrays.asList(new AtomRegex("[","^\\[.*?\\]","]",1,0,1)),1),
	 GT(">",new ArrayList<AtomRegex>(),0),
	 LT("<",new ArrayList<AtomRegex>(),0),
	 LONGEQUAL("═",new ArrayList<AtomRegex>(),0),
	 WAVE("~",new ArrayList<AtomRegex>(),0),
	 ;
		
	 private String atomChar;
	 private List<AtomRegex> regex;
	 private Integer type;//0:atomName;1:atomBEs
	 
	 private AtomChar(String atomChar,List<AtomRegex> regex,Integer type) {
		 this.atomChar=atomChar;
		 this.regex=regex;
		 this.type=type;
	 }

	public String getAtomChar() {
		return atomChar;
	}

	public void setAtomChar(String atomChar) {
		this.atomChar = atomChar;
	}

	public List<AtomRegex> getRegex() {
		return regex;
	}

	public void setRegex(List<AtomRegex> regex) {
		this.regex = regex;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	
}
