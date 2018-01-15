package com.ch.autotest.analysis.next.next.next.next.next;

import com.ch.autotest.analysis.inter.Analysis;
import com.ch.autotest.analysis.next.next.next.next.next.next.AnalysisResult;
import com.ch.autotest.body.Inter.iBody;
import com.ch.autotest.body.next.next.next.next.next.Results;
import org.dom4j.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CH on 2017/12/18/018.
 */
public class AnalysisResults implements Analysis {
    /**
     * results下的唯一属性：需要匹配的最小结果单元
     * */
    public static final String RESULT = "result";
    @Override
    public iBody analysis(Element element) {
        Results results = new Results();
        List<Element> elementList = element.elements();
        List<iBody> resultList = new ArrayList<>();
        for(Element element1 : elementList){
            if(element1.getName().equals(RESULT)){
                resultList.add(new AnalysisResult().analysis(element1));
            }
        }
        results.setResultList(resultList);
        return results;
    }
}
