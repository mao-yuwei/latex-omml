package com.latextoword.dictionary.dicList;

import com.latextoword.dictionary.AtomRule;

import java.util.Hashtable;

public class AtomList {
	
	private AtomList() {};

	private static Hashtable<String, AtomRule> atomDic;
	
	private static volatile AtomList atomList;
	
	public static Hashtable<String, AtomRule> getAtomDicList() {
		if(atomList!=null)  return AtomList.atomDic;
		synchronized (AtomList.class) {
			if(atomList==null) {
				initAtomList();
				return AtomList.atomDic;
			}
		}
		return AtomList.atomDic;
	}
	private static AtomList initAtomList() {
		atomList=new AtomList();
		atomDic=new Hashtable<String, AtomRule>();
		for(AtomRule atomRule:AtomRule.values()) {
			atomDic.put(atomRule.getAtomName(), atomRule);
		}
		return atomList;
	}

}
