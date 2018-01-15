package com.ch.autotest.analysis.next.next.next.next.next.next.next;

import com.ch.autotest.analysis.inter.Analysis;
import com.ch.autotest.body.Inter.iBody;
import com.ch.autotest.body.next.next.next.next.next.next.next.iList;
import org.dom4j.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CH on 2018/1/8/008.
 */
public class AnalysisList implements Analysis {
    final String VALUE = "value";
    @Override
    public iBody analysis(Element element) {
        iList iList = new iList();
        List<Element> elementList = element.elements();
        List<String> list = new ArrayList<>();
        if(elementList != null && elementList.size()>0){
            for(Element element1 : elementList){
                if(element1.getName().equals(VALUE)){
                    list.add(String.valueOf(element1.getData()));
                }
            }
        }
        iList.setiList(list);
        return iList;
    }
}
