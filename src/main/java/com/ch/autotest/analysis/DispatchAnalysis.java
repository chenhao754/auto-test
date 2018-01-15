package com.ch.autotest.analysis;

import com.ch.autotest.analysis.next.AnalysisBeans;
import com.ch.autotest.body.Auto;
import com.ch.autotest.body.Inter.iBody;
import com.ch.autotest.utils.FileUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by CH on 2017/12/18/018.
 * @descirption 解析自动部署的XML文件的调度类
 */
public class DispatchAnalysis {
    //所有被测试bean的根节点，子节点为bean，可以有多个子节点
    public static final String BEANS = "beans";
    /**
     * @description 解析自动部署的XML文件的调度方法
     * @param file 被解析的XML文件
     * @return 返回值为自动部署的总体body
     * */
    public iBody analysis(File file){
        List<iBody> importList = new ArrayList<>();
        List<iBody> beansList = new ArrayList<>();
        Auto auto = new Auto();
        try {
            Document document = new SAXReader().read(file);
            for (Iterator i = document.getRootElement().elementIterator(); i.hasNext(); ) {
                Element element = (Element) i.next();
                if(element.getName().equals(BEANS)) {
                    beansList.add(new AnalysisBeans().analysis(element));
                }
            }
            auto.setBeansList(beansList);
            auto.setImportList(importList);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return auto;
    }
    public static void main(String []args){
        new DispatchAnalysis().analysis(new File(FileUtils.getAbsolutePath("/src/main/resources/autotest.xml")));
    }
}
