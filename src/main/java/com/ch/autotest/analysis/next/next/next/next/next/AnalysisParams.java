package com.ch.autotest.analysis.next.next.next.next.next;

import com.ch.autotest.analysis.inter.Analysis;
import com.ch.autotest.analysis.next.next.next.next.next.next.AnalysisBody;
import com.ch.autotest.analysis.next.next.next.next.next.next.AnalysisHeader;
import com.ch.autotest.analysis.next.next.next.next.next.next.AnalysisParam;
import com.ch.autotest.body.Inter.iBody;
import com.ch.autotest.body.next.next.next.next.next.Params;
import org.dom4j.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CH on 2017/12/18/018.
 */
public class AnalysisParams implements Analysis {
    /**
     * body：API中用@requestBody描述的参数，子节点有多个param，每个param代表参数中的一个属性
     */
    public static final String BODY = "body";
    /**
     * param：API中用@requestParam描述的参数，属性有两个：key和value，key表示参数的属性名，value表示参数的属性名对应的属性值
     */
    public static final String PARAM = "param";
    /**
     * header:API中存储在header中的参数，属性有两个：key和value，key表示参数的属性名，value表示参数的属性名对应的属性值
     */
    public static final String HEADER = "header";

    @Override
    public iBody analysis(Element element) {
        Params params = new Params();
        List<iBody> iBodyList = new ArrayList<>();
        List<iBody> paramsList = new ArrayList<>();
        List<iBody> headerList = new ArrayList<>();
        List<Element> elementList = element.elements();
        if(elementList != null && elementList.size() > 0) {
            for (Element element1 : elementList) {
                if (element1.getName().equals(BODY)) {
                    iBodyList.add(new AnalysisBody().analysis(element1));
                }else if (element1.getName().equals(PARAM)) {
                    paramsList.add(new AnalysisParam().analysis(element1));
                }else if(element1.getName().equals(HEADER)){
                    headerList.add(new AnalysisHeader().analysis(element1));
                }
            }
        }
        params.setBodyList(iBodyList);
        params.setHeaderList(headerList);
        params.setParamList(paramsList);
        return params;
    }
}
