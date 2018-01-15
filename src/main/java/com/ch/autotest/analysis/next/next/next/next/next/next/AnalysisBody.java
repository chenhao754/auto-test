package com.ch.autotest.analysis.next.next.next.next.next.next;

import com.ch.autotest.analysis.inter.Analysis;
import com.ch.autotest.body.Inter.iBody;
import com.ch.autotest.body.next.next.next.next.next.next.Body;
import org.dom4j.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CH on 2017/12/19/019.
 */
public class AnalysisBody implements Analysis {
    /**
     * body下的唯一属性：param，表示实体对象中的某个属性
     * */
    public static final String PARAM = "param";
    @Override
    public iBody analysis(Element element) {
        Body body = new Body();
        List<iBody> params = new ArrayList<>();
        List<Element> elementList = element.elements();
        if(elementList != null && elementList.size() > 0) {
            for (Element element1 : elementList) {
                if (element1.getName().equals(PARAM)) {
                    params.add(new AnalysisParam().analysis(element1));
                }
            }
        }
        body.setParamList(params);
        return body;
    }
}
