package com.ch.autotest.analysis.next.next.next.next.next.next.next;

import com.ch.autotest.analysis.inter.Analysis;
import com.ch.autotest.analysis.next.next.next.next.next.next.AnalysisParam;
import com.ch.autotest.body.Inter.iBody;
import com.ch.autotest.body.next.next.next.next.next.next.next.iMap;
import org.dom4j.Element;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by CH on 2018/1/8/008.
 */
public class AnalysisMap implements Analysis{
    final String PARAM = "param";
    @Override
    public iBody analysis(Element element) {
        iMap iMap = new iMap();
        List<Element> elementList = element.elements();
        List<iBody> map = new ArrayList<>();
        if(elementList != null && elementList.size()>0){
            for(Element element1 : elementList){
                if(element1.getName().equals(PARAM)){
                    map.add(new AnalysisParam().analysis(element1));
                }
            }
        }
        iMap.setParamList(map);
        return iMap;
    }
}
