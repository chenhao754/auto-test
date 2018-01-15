package com.ch.autotest.constant;

/**
 * Created by CH on 2017/12/21/021.
 * @description 该类中所有属性都对应于XML文件中的节点名或属性名
 * @description 命名规则：第一个单词是英文：one,two,three；代表节点中的1,2,3级
 *                          第二个单词是节点名称：如果该属性是代表一个节点名称，则有两个单词组成
 *                          第三个单词是ATTR：代表属性的意思
 *                          第四个单词是第二个单词为节点的属性：如果该属性是一个节点中的属性名称，则有四个单词组成
 */
public class Constant {

    /**
     * 第一级节点 ：auto
     * auto：XML文件的根节点
     */
    public static final String ONE_AUTO = "auto";


    /**
     * 第二级节点：beans，import
     * beans：所有被测试bean的根节点，子节点为bean，可以有多个子节点。beans有一个属性是mail：测试出错后需要通知到的邮件地址，如果放在第二级则如果beans节点下的任意一个bean出错后就需要通知，如果放在bean中，则只有该bean出现错误才通知，如果放在API中，则只有该API出现错误才通知
     * import：
     */
    public static final String TWO_BEANS = "beans";
    public static final String TWO_BEANS_ATTR_MAIL = "mail";

    public static final String TWO_IMPORT = "import";


    /**
     * 第三级节点：bean，mail
     * bean：用于描述一个controller的bean，一个bean有一个name属性和mail属性，name属性对应Spring上下文中的名称一个bean可以有多个API节点，可以测试多个API，mail属性用于bean测试出错通知
     */
    public static final String THREE_BEAN = "bean";
    public static final String THREE_BEAN_ATTR_MAIL = "mail";
    public static final String THREE_BEAN_ATTR_NAME = "name";


    /**
     * 第四级节点：name，API
     * name：对应第三级节点bean的属性name，作用相同。只是一个属性标志，一个节点标志。
     * API：描述controller中的需要测试的一个API，属性有三个：URL，TYPE，MAIL。URL为API访问的URL结尾，type为API访问方式，mail用于API访问失败报错
     */
    public static final String FOUR_API = "api";
    public static final String FOUR_API_ATTR_MAIL = "mail";
    public static final String FOUR_API_ATTR_URL = "url";
    public static final String FOUR_API_ATTR_TYPE = "type";

    /***
     * 第五级节点：select
     * select：里面包含有参数与结果，表示一种测试选择，一个API中可以包含多个select，即可以选择多种参数与结果
     */
    public static final String FINE_SELECT = "select";

    /**
     * 第六级节点：params，result
     * params：API的所有参数描述，一个params可以有多个param，一个param描述一个参数
     * result：API节点的返回值匹配
     */
    public static final String SIX_PARAMS = "params";
    public static final String SIX_RESULTS = "results";

    /**
     * 第七级节点：body，param，header
     * body：API中用@requestBody描述的参数，子节点有多个param，每个param代表参数中的一个属性
     * param：API中用@requestParam描述的参数，属性有两个：key和value，key表示参数的属性名，value表示参数的属性名对应的属性值
     * header:API中存储在header中的参数，属性有两个：key和value，key表示参数的属性名，value表示参数的属性名对应的属性值
     */
    public static final String SEVEN_BODY = "body";

    public static final String SEVEN_PARAM = "param";
    public static final String SEVEN_PARAM_ATTR_KEY = "key";
    public static final String SEVEN_PARAM_ATTR_VALUE = "value";

    public static final String SEVEN_HEADER = "header";
    public static final String SEVEN_HEADER_ATTR_KEY = "key";
    public static final String SEVEN_HEADER_ATTR_VALUE = "value";

    public static final String SEVEN_RESULT = "result";
    public static final String SEVEN_RESULT_ATTR_KEY = "key";
    public static final String SEVEN_RESULT_ATTR_VALUE = "value";
    /**
     * 第八级节点：param,list
     * Param：是body下的子节点，表示body中的一般属性
     * list：是body下的子节点，表示body中的List属性
     * */
    public static final String ENGHT_PARAM = "param";
    public static final String ENGTH_PARAM_ATTR_KEY = "key";
    public static final String ENGTH_PARAM_ATTR_VALUE = "value";


    public static final String ENGHT_LIST = "list";
    public static final String ENGTH_VALUE = "value";

}
