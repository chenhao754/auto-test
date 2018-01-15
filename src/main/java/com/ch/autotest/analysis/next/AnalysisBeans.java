package com.ch.autotest.analysis.next;

import com.ch.autotest.analysis.inter.Analysis;
import com.ch.autotest.analysis.next.next.AnalysisBean;
import com.ch.autotest.body.Inter.iBody;
import com.ch.autotest.body.next.Beans;
import org.dom4j.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CH on 2017/12/18/018.
 * @description 解析测试XML文件中的beans节点类
 */
public class AnalysisBeans implements Analysis {
    /**
     * mail是beans的属性：测试出错后需要通知到的邮件地址，如果放在beans节点下，则任意一个bean出错后就需要通知，如果放在bean中，则只有该bean出现错误才通知，如果放在API中，则只有该API出现错误才通知
     * */
    public static final String BEANS_ATTR_MAIL = "mail";

    /**
     * 用于描述一个controller的bean，一个bean有一个name属性和mail属性，name属性对应Spring上下文中的名称一个bean可以有多个API节点，可以测试多个API，mail属性用于bean测试出错通知
     * */
    public static final String BEAN = "bean";

    /**
     * @description 解析测试XML文件中的beans节点函数
     * @param element dom4j中的代表beans的节点元素
     * @return body 返回值为Beans类型
     * */
    @Override
    public iBody analysis(Element element) {
        Beans beans = new Beans();
        List<iBody> beanlist = new ArrayList<>();
        //首先遍历beans中的属性
        List<Element> elementList1 = element.attributes();
        if(elementList1 != null && elementList1.size() > 0){
            for(Element element1 :elementList1){
                if(element1.getName().equals(BEANS_ATTR_MAIL)){
                    beans.setMail(String.valueOf(element1.getData()));
                }
            }
        }
        //然后遍历beans中的子节点
        List<Element> elementList = element.elements();
        if(elementList != null && elementList.size() > 0) {
            for (Element element1 : elementList) {
                if (element1.getName().equals(BEAN)) {
                    beanlist.add(new AnalysisBean().analysis(element1));
                } else if (element1.getName().equals(BEANS_ATTR_MAIL)) {
                    beans.setMail(String.valueOf(element1.getData()));
                }
            }
        }

        beans.setBeanList(beanlist);
        return beans;
    }
}
