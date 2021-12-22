package com.latextoword.dictionary.dicList;

import com.latextoword.dictionary.AtomChar;

import java.util.Hashtable;

public class AtomCharList {
	
	    private AtomCharList() {};
		
		private static Hashtable<String, AtomChar> atomCharDic;
		
		private static volatile AtomCharList atomCharList;
		
		public static Hashtable<String, AtomChar> getAtomCharDicList() {
			if(atomCharList!=null)  return AtomCharList.atomCharDic;
			synchronized (AtomList.class) {
				if(atomCharList==null) {
					initAtomCharList();
					return AtomCharList.atomCharDic;
				}
			}
			return AtomCharList.atomCharDic;
		}
		private static AtomCharList initAtomCharList() {
			atomCharList=new AtomCharList();
			atomCharDic=new Hashtable<String, AtomChar>();
			for(AtomChar atomChar:AtomChar.values()) {
				atomCharDic.put(atomChar.getAtomChar(), atomChar);
			}
			return atomCharList;
		}
}
