package com.ch.autotest.analysis.next.next.next.next.next.next;

import com.ch.autotest.analysis.inter.Analysis;
import com.ch.autotest.body.Inter.iBody;
import com.ch.autotest.body.next.next.next.next.next.next.Result;
import org.dom4j.Element;

import java.util.List;

/**
 * Created by CH on 2018/1/2/002.
 */
public class AnalysisResult implements Analysis {
    /**
     * 需要匹配的结果键值对
     * */
    public static final String RESULT_ATTR_KEY = "key";
    public static final String RESULT_ATTR_VALUE = "value";
    @Override
    public iBody analysis(Element element) {
        Result result = new Result();
        List<Element> elementList = element.elements();
        for(Element element1 : elementList){
            if(element1.getName().equals(RESULT_ATTR_KEY)){
                result.setKey(String.valueOf(element1.getData()));
            }else if(element1.getName().equals(RESULT_ATTR_VALUE)){
                result.setValue(String.valueOf(element1.getData()));
            }
        }
        return result;
    }
}
