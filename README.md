# auto-test
#### 封装Spring和Junit，自动测试
#### 本项目是利用Spring和Junit的MOCK测试Controller，通过XML配置文件配置信息。
#### 首先分析本项目的规定的XML结构：
#### 针对Spring的Controller，本文通过XML文件描述。
#### 以下是一个配置例子：


```
<auto>                                  <!-- auto节点是本文规定的根节点 -->
    <beans>                             <!-- beans节点是所有需要测试的controller节点的父节点 -->
        <mail>chenhao754@qq.com</mail>  <!-- mail表示beans中任意一个bean中api测试错误就会发邮件通知 -->
        <bean>                          <!-- bean对应一个Spring中的Controller类，暂时本项目只能测试Controller -->
            <mail>chenhao754@qq.com</mail>        <!-- mail表示bean中任意一个api测试错误就会通知邮件 -->
            <name>adminController</name>          <!-- Controller类在Spring中的名字，默认为类名，首字母小写 -->
            <api>                                 <!-- bean节点下可以有多个api节点，表示可以测试controller下多个api节点 -->
                <mail>chenhao754@qq.com</mail>    <!-- mail表示api测试出错后，通知
                <url>/admin/init</url>            <!-- api的url -->
                <type>get</type>                  <!-- api的访问方式 -->
                <select>                          <!-- select节点下主要有params和results两个节点，一个api节点下可以有多个select节点，表示配置不同的参数有不同的返回值，都会测试到 -->
                    <params>                      <!-- params节点封装访问api的参数，参数主要有三种：@requestBody，@requestParam,@Header三种，分别用<body>,<param>,<header>三种节点封装，不同参数选择不同节点 -->
                        <body>                    <!-- body用来配置@requestBody封装的自定义类参数，子节点为<param>，用来表示自定义类中的某个属性 -->
                            <param>               <!-- param用来表示自定义类中的某个属性，key表示属性名称，value表示该属性初始化值，可以用list和map节点封装，用于属性类型是list和map的属性 -->
                                <key>name</key>   
                                <list>
                                    <value></value>
                                </list>
                                <map>
                                    <param>
                                       <key></key>
                                       <value></value>
                                    </param>
                                </map>
                                <value>username</value>
                            </param>
                            <param>
                                <key>age</key>
                                <value>10</value>
                            </param>
                        </body>
                        <param>                   <!-- param用法与上面的param一样，只是用于描述@requestParam的参数，key描述参数名，value描述参数值 -->
                            <key>id</key>
                            <value>10</value>
                        </param>
                        <header>                  <!-- header用法与param类似，只是用于描述@Header的参数，key描述参数名，value描述参数值 -->
                            <key>name</key>
                            <value>user</value>
                        </header>
                    </params>
                    <results>                     <!-- results用于配置匹配的结果 -->
                        <result>                  <!-- result用于封装多个匹配结果，必须全部匹配才算正确 -->
                            <key>name</key>       <!-- key表示结果中的属性，用法：如果结果是{"name":"user"}，则如配置中。如果结果是{"name":{"age":1}},则<key>name.age</key>，非常方便 -->
                            <value>user</value>   <!-- 匹配结果 -->
                        </result>
                    </results>
                </select>
            </api>
        </bean>
    </beans>
</auto>
```


项目中一共有四个包：
1.analysis：用于分析XML节点，入口是DispatchAnalysis
2.body：用于描述XML节点中内容
3.test：主要测试类，用户使用时也是继承该包下的BasicTest类，该类是自动测试的入口。
4.utils：帮助类
