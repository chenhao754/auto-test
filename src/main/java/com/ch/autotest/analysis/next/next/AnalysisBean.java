package com.ch.autotest.analysis.next.next;

import com.ch.autotest.analysis.inter.Analysis;
import com.ch.autotest.analysis.next.next.next.AnalysisApi;
import com.ch.autotest.body.Inter.iBody;
import com.ch.autotest.body.next.next.Bean;
import org.dom4j.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CH on 2017/12/18/018.
 * @description 解析测试XML文件中的bean节点类
 */
public class AnalysisBean implements Analysis {
    public static final String BEAN_ATTR_MAIL = "mail";
    public static final String BEAN_ATTR_NAME = "name";
    /**
     * api：描述controller中的需要测试的一个api
     * */
    public static final String API = "api";
    /**
     * @description 解析测试XML文件中的bean节点函数
     * @param element dom4j中的代表bean的节点元素
     * @return body 返回值为bean类型
     * */
    @Override
    public iBody analysis(Element element) {
        Bean bean = new Bean();
        List<iBody> apiList = new ArrayList<>();
        //首先遍历bean的属性
        List<Element> elementList1 = element.attributes();
        if(elementList1 != null && elementList1.size() > 0){
            for(Element element1 : elementList1){
                if(element1.getName().equals(BEAN_ATTR_NAME)){
                    bean.setName(String.valueOf(element1.getData()));
                }else if(element1.getName().equals(BEAN_ATTR_MAIL)){
                    bean.setMail(String.valueOf(element1.getData()));
                }
            }
        }
        //然后遍历bean的子节点
        List<Element> elementList = element.elements();
        if(elementList != null && elementList.size() > 0) {
            for (Element element1 : elementList) {
                if (element1.getName().equals(API)) {
                    apiList.add(new AnalysisApi().analysis(element1));
                } else if (element1.getName().equals(BEAN_ATTR_NAME)) {
                    bean.setName(String.valueOf(element1.getData()));
                }else if(element1.getName().equals(BEAN_ATTR_MAIL)){
                    bean.setMail(String.valueOf(element1.getData()));
                }
            }
        }
        bean.setApiList(apiList);
        return bean;
    }
}
