package com.ch.autotest.analysis.next.next.next.next.next.next;

import com.ch.autotest.analysis.inter.Analysis;
import com.ch.autotest.body.Inter.iBody;
import com.ch.autotest.body.next.next.next.next.next.next.Header;
import org.dom4j.Element;

import java.util.List;

/**
 * Created by CH on 2018/1/2/002.
 */
public class AnalysisHeader implements Analysis {
    /**
     * Header中的两个属性，表示头信息中的键值对
     * */
    public static final String HEADER_ATTR_KEY = "key";
    public static final String HEADER_ATTR_VALUE = "value";

    @Override
    public iBody analysis(Element element) {
        Header header = new Header();
        List<Element> elementList = element.elements();
        if(elementList != null && elementList.size()>0) {
            for (Element element1 : elementList) {
                if (element1.getName().equals(HEADER_ATTR_KEY)) {
                    header.setKey(String.valueOf(element1.getData()));
                } else if (element1.getName().equals(HEADER_ATTR_VALUE)) {
                    header.setValue(String.valueOf(element1.getData()));
                }
            }
        }
        return header;
    }
}
