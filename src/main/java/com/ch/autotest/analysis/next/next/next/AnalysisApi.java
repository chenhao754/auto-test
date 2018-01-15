package com.ch.autotest.analysis.next.next.next;

import com.ch.autotest.analysis.inter.Analysis;
import com.ch.autotest.analysis.next.next.next.next.AnalysisSelect;
import com.ch.autotest.body.Inter.iBody;
import com.ch.autotest.body.next.next.next.Api;
import org.dom4j.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CH on 2017/12/18/018.
 * @description 解析测试XML文件中的api节点类
 */
public class AnalysisApi implements Analysis {
    /**
     * api属性有三个：URL，TYPE，MAIL。URL为API访问的URL结尾，type为API访问方式，mail用于API访问失败报错
     */
    public static final String API_ATTR_MAIL = "mail";
    public static final String API_ATTR_URL = "url";
    public static final String API_ATTR_TYPE = "type";
    /***
     * select：里面包含有参数与结果，表示一种测试选择，一个API中可以包含多个select，即可以选择多种参数与结果
     */
    public static final String SELECT = "select";

    /**
     * @description 解析测试XML文件中的api节点函数
     * @param element dom4j中的代表api的节点元素
     * @return body 返回值为api类型
     * */
    @Override
    public iBody analysis(Element element) {
        Api api = new Api();
        //首先遍历API的属性
        List<Element> elementList1 = element.attributes();
        if(elementList1 != null && elementList1.size() > 0){
            for(Element element1 : elementList1){
                if(element1.getName().equals(API_ATTR_MAIL)){
                    api.setMail(String.valueOf(element1.getData()));
                }else if(element1.getName().equals(API_ATTR_URL)){
                    api.setUrl(String.valueOf(element1.getData()));
                }else if(element1.getName().equals(API_ATTR_TYPE)){
                    api.setType(String.valueOf(element1.getData()));
                }
            }
        }
        //然后遍历API的子节点
        List<Element> elementList = element.elements();
        List<iBody> selectList = new ArrayList<>();
        for(Element element1 : elementList){
            if(element1.getName().equals(SELECT)){
                selectList.add(new AnalysisSelect().analysis(element1));
            }else if(element1.getName().equals(API_ATTR_TYPE)){
                api.setType(String.valueOf(element1.getData()));
            }else if(element1.getName().equals(API_ATTR_URL)){
                api.setUrl(String.valueOf(element1.getData()));
            }else if(element1.getName().equals(API_ATTR_MAIL)){
                api.setType(String.valueOf(element1.getData()));
            }
        }
        api.setSelectList(selectList);
        return api;
    }
}
