package com.ch.autotest.analysis.next.next.next.next.next.next;

import com.ch.autotest.analysis.inter.Analysis;
import com.ch.autotest.analysis.next.next.next.next.next.next.next.AnalysisList;
import com.ch.autotest.analysis.next.next.next.next.next.next.next.AnalysisMap;
import com.ch.autotest.body.Inter.iBody;
import com.ch.autotest.body.next.next.next.next.next.next.Param;
import org.dom4j.Element;

import java.util.List;

/**
 * Created by CH on 2017/12/18/018.
 */
public class AnalysisParam implements Analysis {
    /**
     * 参数中的键值对
     * */
    public static final String PARAM_ATTR_KEY = "key";
    public static final String PARAM_ATTR_VALUE = "value";
    /**
     * 参数中的特殊值
     * */
    public static final String PARAM_ATTR_LIST = "list";
    public static final String PARAM_ATTR_MAP = "map";
    @Override
    public iBody analysis(Element element) {
        Param param = new Param();
        List<Element> elementList = element.elements();
        if(elementList != null && elementList.size()>0) {
            for (Element element1 : elementList) {
                if (element1.getName().equals(PARAM_ATTR_KEY)) {
                    param.setKey(String.valueOf(element1.getData()));
                } else if (element1.getName().equals(PARAM_ATTR_VALUE)) {
                    param.setValue(String.valueOf(element1.getData()));
                }else if(element1.getName().equals(PARAM_ATTR_LIST)){
                    param.setList(new AnalysisList().analysis(element1));
                }else if(element1.getName().equals(PARAM_ATTR_MAP)){
                    param.setMap(new AnalysisMap().analysis(element1));
                }
            }
        }
        return param;
    }
}
