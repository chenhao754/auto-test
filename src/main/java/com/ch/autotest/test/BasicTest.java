package com.ch.autotest.test;

import com.ch.autotest.analysis.DispatchAnalysis;
import com.ch.autotest.body.Auto;
import com.ch.autotest.body.Inter.iBody;
import com.ch.autotest.body.next.Beans;
import com.ch.autotest.body.next.next.Bean;
import com.ch.autotest.body.next.next.next.Api;
import com.ch.autotest.body.next.next.next.next.Select;
import com.ch.autotest.body.next.next.next.next.next.Params;
import com.ch.autotest.body.next.next.next.next.next.Results;
import com.ch.autotest.body.next.next.next.next.next.next.Body;
import com.ch.autotest.body.next.next.next.next.next.next.Header;
import com.ch.autotest.body.next.next.next.next.next.next.Param;
import com.ch.autotest.body.next.next.next.next.next.next.Result;
import com.ch.autotest.utils.FileUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;


/**
 * Created by CH on 2018/1/5/005.
 */
public class BasicTest {
    //Spring中上下文对象
    private ApplicationContext context =  null;
    //Spring中拦截转换器对象
    private HandlerMethodArgumentResolver[] handlerMethodArgumentResolvers = null;
    //自动测试配置文件
    private String xmls[] = null;


    //当前自动测试根对象
    private Auto auto;
    //当前自动测试beans对象
    private Beans beans;
    //当前自动测试bean对象
    private Bean bean;
    //当前自动测试api对象
    private Api api;

    /**
     * @decription 初始化Spring上下文对象，用于获取bean对象
     * @param xmls Spring配置文件路径
     * */
    public void initContext(String... xmls){
        context = new ClassPathXmlApplicationContext(xmls);
    }
    /**
     * @decription 初始化自动测试配置文件
     * @param xmls 自动测试配置文件路径
     * */
    public void initAutoTestXML(String... xmls){
        //根据XML文件解析出自动测试实体对象
        this.xmls = xmls;
    }
    /**
     * @description 初始化拦截转换器对象
     * @param argumentResolvers 拦截转换器对象
     * */
    public void initHandlerMethodArgumentResolver(HandlerMethodArgumentResolver... argumentResolvers){
        handlerMethodArgumentResolvers = argumentResolvers;
    }
    /**
     * 测试入口函数
     * */
    public void test() throws Exception{
        if(context == null){
            throw new Exception("Spring配置文件错误");
        }
        if(xmls == null || xmls.length <1){
            throw new Exception("自动测试配置文件错误："+xmls);
        }
        for(String xml : xmls){
            File file = new File(FileUtils.getAbsolutePath(xml));
            if(file != null && file.exists()){
                dealXml(file);
            }else{
                throw new Exception("自动测试配置文件错误："+xml);
            }
        }
    }
    /**
     * @description 以文件为单位进行处理
     * @param Xmlfile 自动测试配置文件
     * */
    private void dealXml(File Xmlfile) throws Exception{
        //如果文件存在
        if(Xmlfile != null && Xmlfile.exists()){
            //如果文件是文件，并且后缀名为.xml文件，则处理
            if(Xmlfile.isFile() && Xmlfile.getName().endsWith(".xml")){
                //根据XML文件解析出自动测试实体对象
                auto = (Auto)new DispatchAnalysis().analysis(Xmlfile);
                dealAuto(auto);
            }else if(Xmlfile.isDirectory()){
                //如果文件是文件夹，则递归遍历
                for(File file : Xmlfile.listFiles()){
                    dealXml(file);
                }
            }
        }else{
            throw new Exception("配置文件存在错误："+Xmlfile.getName());
        }
    }

    private void dealAuto(Auto auto){
        List<iBody> beansList = auto.getBeansList();
        if(beansList != null && beansList.size()>0) {
            for (iBody ibody : beansList) {
                beans = (Beans)ibody;
                dealBeans(beans);
            }
        }
    }
    private void dealBeans(Beans beans){
        List<iBody> beanList = beans.getBeanList();
        if(beanList != null && beanList.size()>0){
            for(iBody ibody : beanList){
                bean = (Bean)ibody;
                dealBean(bean);
            }
        }
    }
    private void dealBean(Bean bean){
        List<iBody> apiList = bean.getApiList();
        if(apiList != null && apiList.size()>0){
            for(iBody ibody : apiList){
                api = (Api)ibody;
                dealApi(api);
            }
        }
    }
    private void dealApi(Api api){
        Object object = null;
        if(bean.getName() != null && !bean.getName().isEmpty()){
            object = context.getBean(bean.getName());
            if(object == null){
                return ;
            }
        }
        //项目中使用到的类型转换器，该转换器是用于api访问中，自动将header中的参数组装成BasicUserInfo对象返回给api参数使用
        //BeanArgumentResolver beanArgumentResolver = new BeanArgumentResolver();
        //注入controller的bean对象和转换器对象到Mock测试中
        MockMvc mockMvc = standaloneSetup(object).setCustomArgumentResolvers(handlerMethodArgumentResolvers).build();

        //测试建造类
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder  = null;
        //判断测试方法类型，根据不同类型调用不同的测试方法和api的url
        switch (api.getType()){
            case "get":
                mockHttpServletRequestBuilder = MockMvcRequestBuilders.get(api.getUrl());
                break;
            case "post":
                mockHttpServletRequestBuilder = MockMvcRequestBuilders.post(api.getUrl());
                break;
            case "delete":
                mockHttpServletRequestBuilder = MockMvcRequestBuilders.delete(api.getUrl());
                break;
            case "put":
                mockHttpServletRequestBuilder = MockMvcRequestBuilders.put(api.getUrl());
                break;
        }
        //http访问的contentType
        mockHttpServletRequestBuilder.contentType(MediaType.APPLICATION_JSON);
        //解析api所使用的参数
        List<iBody> selectList = api.getSelectList();
        if(selectList != null && selectList.size()>0){
            for(iBody select : selectList){
                Params params = (Params) ((Select)select).getParams();
                //解析api中使用的body，也就是用@requestBody描述的实体参数
                List<iBody> bodyList = params.getBodyList();
                if(bodyList != null && bodyList.size()>0) {
                    for (iBody ibody : bodyList) {
                        //否则注入到content中
                        List<iBody> paramList = ((Body)ibody).getParamList();

                        HashMap<String, Object> map = new HashMap<>();
                        if(paramList != null && paramList.size()>0) {
                            for (iBody ibody1 : paramList) {
                                Param param = (Param) ibody1;
                                map.put(param.getKey(), param.getValue());
                            }
                        }
                        List<String> ids = new ArrayList<>();
                        ids.add("1");
                        ids.add("2");
                        map.put("ids",ids);
                        mockHttpServletRequestBuilder.content(map.toString());
                    }
                }
                List<iBody> paramList = params.getParamList();
                //如果有@requestParam描述的参数，则将参数注入到param中
                if(paramList != null && paramList.size()>0) {
                    for (iBody ibody : paramList) {
                        Param param = (Param) ibody;
                        mockHttpServletRequestBuilder.param(param.getKey(), param.getValue());
                    }
                }
                List<iBody> headerList = params.getHeaderList();
                //如果有header中的内容，则将参数注入到header中
                if(headerList != null && headerList.size()>0){
                    for(iBody ibody1 : headerList) {
                        Header header = (Header) ibody1;
                        mockHttpServletRequestBuilder.header(header.getKey(),header.getValue());
                    }
                }
                try {
                    //启动测试
                    Results results = (Results) ((Select)select).getResults();

                    ResultActions resultActions = mockMvc.perform(mockHttpServletRequestBuilder);
                    System.out.println("--------------------------");
                    //resultActions.andDo(MockMvcResultHandlers.print()).andReturn().getResponse().getContentAsString();

                    if(results != null){
                        List<iBody> resultList = results.getResultList();
                        if(resultList != null && resultList.size()>0){
                            for(iBody ibody : resultList){
                                Result result = (Result)ibody;
                                ResultMatcher resultMatcher = jsonPath("$."+result.getKey()).value(result.getValue());
                                resultActions.andExpect(resultMatcher);
                            }
                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
