package com.latextoword.dictionary.dicList;

import com.latextoword.dictionary.AtomRuleSeries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

/**
 * @Author: maoyuwei
 * @Date: 2019/3/8 14:54
 * @Desc:
 **/
public class AtomRuleSeriesList {

    private AtomRuleSeriesList(){};

    private static Hashtable<String, List<AtomRuleSeries>> atomRuleSeriesDic;

    private static volatile AtomRuleSeriesList atomRuleSeriesList;

    public static Hashtable<String, List<AtomRuleSeries>> getAtomRuleSeriesDicList() {
        if(atomRuleSeriesList!=null)  return AtomRuleSeriesList.atomRuleSeriesDic;
        synchronized (AtomList.class) {
            if(atomRuleSeriesList==null) {
                initAtomSerierList();
                return AtomRuleSeriesList.atomRuleSeriesDic;
            }
        }
        return AtomRuleSeriesList.atomRuleSeriesDic;
    }
    private static AtomRuleSeriesList initAtomSerierList() {
        atomRuleSeriesList=new AtomRuleSeriesList();
        atomRuleSeriesDic=new Hashtable<String, List<AtomRuleSeries>>();
        for(AtomRuleSeries atomRuleSeries:AtomRuleSeries.values()) {
            List<AtomRuleSeries> atomRuleSeriesListCurrent=atomRuleSeriesDic.get(atomRuleSeries.getAtomName())==null?new ArrayList<AtomRuleSeries>():atomRuleSeriesDic.get(atomRuleSeries.getAtomName());
            atomRuleSeriesListCurrent.add(atomRuleSeries);
            atomRuleSeriesDic.put(atomRuleSeries.getAtomName(), atomRuleSeriesListCurrent);
        }
        return atomRuleSeriesList;
    }

}
