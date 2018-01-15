package com.ch.autotest.analysis.next.next.next.next;

import com.ch.autotest.analysis.inter.Analysis;
import com.ch.autotest.analysis.next.next.next.next.next.AnalysisParams;
import com.ch.autotest.analysis.next.next.next.next.next.AnalysisResults;
import com.ch.autotest.body.Inter.iBody;
import com.ch.autotest.body.next.next.next.next.Select;
import org.dom4j.Element;

import java.util.List;

/**
 * Created by CH on 2018/1/2/002.
 */
public class AnalysisSelect implements Analysis {
    /**
     * params：API的所有参数描述，一个params可以有多个param，一个param描述一个参数
     * result：API节点的返回值匹配
     */
    public static final String PARAMS = "params";
    public static final String RESULTS = "results";
    @Override
    public iBody analysis(Element element) {
        Select select = new Select();
        //遍历select的子节点
        List<Element> elementList = element.elements();
        for(Element element1 : elementList){
            if(element1.getName().equals(PARAMS)){
                select.setParams(new AnalysisParams().analysis(element1));
            }else if(element1.getName().equals(RESULTS)){
                select.setResults(new AnalysisResults().analysis(element1));
            }
        }
        return select;
    }
}
