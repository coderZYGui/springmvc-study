# SpringMVC-Study
Record springmvc learned

## <span id="j0">目录</span>

这里是部分笔记,全部笔记请点击[链接](https://blog.csdn.net/m0_37989980/article/details/103987924)

- [一、什么是MVC](#j1)
- [二、前端控制器(中心控制器)](#j2)
	- [1、什么是前端控制器](#j3)
	- [2、前端控制器原理](#j4)
- [三、什么是SpringMVC](#j5)
	- [1、SpringMVC简介](#j6)
	- [2、SpringMVC和Struts2](#j7)
- [四、SpringMVC第一个程序(配置版)](#j8)
- [五、第一个SpringMVC程序小结](#j9)

![在这里插入图片描述](https://img-blog.csdnimg.cn/2020030414232473.png)

---

# 一、什么是MVC<span id="j1"></span>
[<font size = 1>跳转到目录</font>](#j0)
这里作简单介绍 具体看我之前的一篇博客: [三层架构和MVC思想](https://blog.csdn.net/m0_37989980/article/details/104128295)

- MVC是模型(Model)、视图(View)、控制器(Controller)的简写，是一种软件设计规范。
是将业务逻辑、数据、显示分离的方法来组织代码。
- MVC主要作用是降低了视图与业务逻辑间的双向偶合。
- MVC不是一种设计模式，MVC是一种架构模式。当然不同的MVC存在差异。

<font color=blue>**Model（模型）**</font>：数据模型，提供要展示的数据，因此包含数据和行为，可以认为是领域模型或JavaBean组件（包含数据和行为），不过现在一般都分离开来：Value Object（数据Dao） 和 服务层（行为Service）。也就是模型提供了模型数据查询和模型数据的状态更新等功能，包括数据和业务。

<font color=blue>**View（视图）</font>**：负责进行模型的展示，一般就是我们见到的用户界面，客户想看到的东西。

<font color=blue>**Controller（控制器）</font>**：接收用户请求，委托给模型进行处理（状态改变），处理完毕后把返回的模型数据返回给视图，由视图负责展示。 也就是说控制器做了个调度员的工作。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200304144901487.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L20wXzM3OTg5OTgw,size_16,color_FFFFFF,t_70)

最典型的MVC就是**JSP + servlet + javabean**的模式。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200304143726286.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L20wXzM3OTg5OTgw,size_16,color_FFFFFF,t_70)
# 二、前端控制器(中心控制器)<span id="j2"></span>
[<font size = 1>跳转到目录</font>](#j0)
### 1、什么是前端控制器<span id="j3"></span>
[<font size = 1>跳转到目录</font>](#j0)

**Front Controller模式**要求在WEB应用系统的前端( Front )设置一个入口控制器( Controller ) ,是用来提供一个集中的请求处理机制,所有的请求都被发往该控制器统统一处理 ,然后把请求分发给各自相应的处理程序。

一般用来做一个`共同的处理`,如权限检查,授权,日志记录等。因为前端控制的集中处理请求的能力,因此提高了可重用性和可拓展性。


没有前端控制器前:
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200304144336254.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L20wXzM3OTg5OTgw,size_16,color_FFFFFF,t_70)
问题: 如果每次请求需要做相同的处理操作,此时每一个Servlet都要做重复的处理;

### 2、前端控制器原理<span id="j4"></span>
[<font size = 1>跳转到目录</font>](#j0)
有了前端控制器
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200304144458909.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L20wXzM3OTg5OTgw,size_16,color_FFFFFF,t_70)
我们发现这个前端控制器,很像web里面的Filter过滤器;

一般的, 我们把处理请求的对象称之为`处理器`。

- Apache习惯称之为Action ,如EmployeeAction.
- Spring习惯称之为Controller ,如EmployeeController.

从这里能看出使用MVC框架必须在`web.xml中配置前端控制器`, -般的要么是要Filter , 要么是Servlet.

- Struts2基于Filter.
- SpringMVC 基于Servlet.
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200304155244610.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L20wXzM3OTg5OTgw,size_16,color_FFFFFF,t_70)

# 三、什么是SpringMVC<span id="j5"></span>
[<font size = 1>跳转到目录</font>](#j0)
### 1、SpringMVC简介<span id="j6"></span>
[<font size = 1>跳转到目录</font>](#j0)
Spring MVC是Spring Framework的一部分，是基于Java实现MVC的轻量级Web框架。

官方文档：[https://docs.spring.io/spring/docs/5.2.0.RELEASE/spring-framework-reference/web.html#spring-web](https://docs.spring.io/spring/docs/5.2.0.RELEASE/spring-framework-reference/web.html#spring-web)

Spring MVC的特点：

- 轻量级，简单易学
- 高效 , 基于请求响应的MVC框架
- 与Spring兼容性好，无缝结合
- 约定优于配置
- 功能强大：RESTful、数据验证、格式化、本地化、主题等
- 简洁灵活

### 2、SpringMVC和Struts2<span id="j7"></span>
[<font size = 1>跳转到目录</font>](#j0)
SpringMVC和Struts2对比

- Spring MVC的前端控制器是Servlet， 而Struts2是Fiter.
- Spring MVC会稍微比Struts2 快些，Spring MVC是基于方法设计， `处理器是单例`,而Sturts2 是基于类,每次发一次请求都会实例一个新的Action对象, `Action是多例`的。
- Spring MVC更加简洁,开发效率Spring MVC比Struts2高,如支持JSR303校验,且处理AJAX请求更方便。
- Struts2 的OGNL表达式使页面的开发效率相比Spring MVC更高些,但是Spring MVC也不差。

总之SpringMVC目前的使用率已经远远超过了Struts2, Struts的漏洞比较多;

# 四、SpringMVC第一个程序(配置版)<span id="j8"></span>
[<font size = 1>跳转到目录</font>](#j0)
##### 1、导入Maven依赖
```xml
    <dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>5.1.9.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>servlet-api</artifactId>
            <version>2.5</version>
        </dependency>
        <dependency>
            <groupId>javax.servlet.jsp</groupId>
            <artifactId>jsp-api</artifactId>
            <version>2.2</version>
        </dependency>
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>jstl</artifactId>
            <version>1.2</version>
        </dependency>
    </dependencies>
```
##### 2、在 **web.xml** 中配置 前端控制器 <font color=red>DispatcherServlet</font>(初始化Spring容器)
```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0">

        <!--配置前端控制器-->
        <!--1.注册DispatcherServlet-->
        <servlet>
            <servlet-name>springMVC</servlet-name>
            <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
            <!--关联一个springMVC的配置文件:【servlet-name】-servlet.xml-->
            <!--默认去WEB-INF目录中去寻找-->
            <!-- 默认寻找<servlet-name>元素文本内容-servlet.xml文件-->
            <init-param>
                <param-name>contextConfigLocation</param-name>
                <param-value>classpath:springmvc-servlet.xml</param-value>
            </init-param>
            <!--启动级别-1,在Tomcat启动时就初始化Spring容器-->
            <load-on-startup>1</load-on-startup>
        </servlet>

        <!--/ 匹配所有的请求；（不包括.jsp）-->
        <!--/* 匹配所有的请求；（包括.jsp）-->
        <servlet-mapping>
            <servlet-name>springMVC</servlet-name>
            <url-pattern>/</url-pattern>
        </servlet-mapping>

</web-app>
```
注意: `<url-pattern>元素`
>配置成 /，可支持 RESTfull风格，但会导致静态资源文件（jsp,css图片等）被拦截不能正常显示，但是可以通过配置来处理。推荐使用
配置成 /*，可以请求到 controller中，但是跳转到jsp时会被拦截，不能渲染jsp视图，不使用，一般用于filter

##### 3、配置SpringMVC核心配置文件 <font color=red>springmvc-servlet.xml</font>
###### 所以springmvc-servlet.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!--配置1:处理器映射器-->
    <bean class="org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping"/>

    <!--配置2:处理器适配器-->
    <bean class="org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter"/>

    <!--配置3:视图解析器-->
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver" id="InternalResourceViewResolver">
        <!--前缀-->
        <property name="prefix" value="/WEB-INF/jsp/"/>
        <!--后缀-->
        <property name="suffix" value=".jsp"/>
    </bean>

    <!--配置4:处理器-->
    <!--通过处理器映射器在url中寻找id为hello的jsp-->
    <bean id="/hello" class="com.sunny.hello.HelloController"/>
    <bean id="/hello2" class="com.sunny.hello.HelloController2"/>
</beans>
```

#### 对上面xml文件中处理器的解释
###### 3.1、在springmvc-servlet.xml文件中配置<font color=red>处理器映射器</font>
目的: 选择哪一个处理器(Controller)来处理当前请求
        BeanNameUrlHandlerMapping:
        根据请求的URL去寻找对应的bean, 根据bean的id/name
> eg:  /hello   去匹配id或name为/hell的bean
```xml
<bean class="org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping"/>
```

###### 3.2、在springmvc-servlet.xml文件中配置<font color=red>处理器适配器</font>
目的: 调用处理器(Controller)的处理请求的方法
- 所有的适配器都实现了HandlerAdapter接口
- 处理器(Controller)类必须实现org.springframework.web.servlet.mvc.Controller接口
```xml
<bean class="org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter"/>
```

###### 3.3、在springmvc-servlet.xml文件中配置<font color=red>视图解析器</font>
目的: 处理dispatcherServlet(前端控制器)给它的**ModelAndView**
```xml
<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver" id="InternalResourceViewResolver">
    <!--前缀-->
    <property name="prefix" value="/WEB-INF/jsp/"/>
    <!--后缀-->
    <property name="suffix" value=".jsp"/>
</bean>
```
###### 3.4、编写我们要操作业务Controller ，要么<font color=red>实现Controller接口，要么增加注解</font>；需要返回一个ModelAndView，装数据，封视图；
```java
public class HelloController implements Controller {

    /**
     * 模型视图类
     * 包含了要跳转的页面和共享的数据
     */
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //ModelAndView 模型和视图
        ModelAndView mv = new ModelAndView();
        //封装要跳转的视图，放在ModelAndView中
        mv.setViewName("welcome"); //: /WEB-INF/jsp/welcome.jsp
        //封装对象，放在ModelAndView中。Model
        mv.addObject("msg","HelloSpringMVC!");
        return mv;
    }
}
```
###### 3.5、在springmvc-servlet.xml文件中配置<font color=red>处理器</font>
将自己写的类交给SpringIOC容器，注册bean (springmvc-servlet.xml文件中)
<font color=red>**注意:**</font> `在SpringMVC中Handler(框架)和Controller(自己)是同一个东西`

目的: 通过处理器映射器在url中寻找id为hello的jsp
```xml
<!--通过处理器映射器在url中寻找id为hello的jsp-->
<bean id="/hello" class="com.sunny.hello.HelloController"/>
```

### 4、编写HelloController类
```java
public class HelloController implements Controller {

    /**
     * 模型视图类
     * 包含了要跳转的页面和共享的数据
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //ModelAndView 模型和视图
        ModelAndView mv = new ModelAndView();
        //封装要跳转的视图，放在ModelAndView中
        mv.setViewName("welcome"); //: /WEB-INF/jsp/welcome.jsp
        //封装对象，放在ModelAndView中。Model
        mv.addObject("msg","HelloSpringMVC!");
        return mv;
    }
}
```

### 5、在WEB-INF下创建jsp目录下welcome.jsp

```html
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    ${msg}
</body>
</html>
```
### 6、测试运行
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200304153209662.png)

如此, 第一个SpringMVC程序完成了

<font color=red>可能遇到的问题：访问出现404，排查步骤：</font>

- 查看控制台输出，看一下是不是缺少了什么jar包。
- 如果jar包存在，显示无法输出，就在IDEA的项目发布中，添加lib依赖！
- 重启Tomcat 即可解决！

这个错误很恶心,当项目发布,lib没有被添加,导致404,具体操作如下
1、
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200304155629764.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L20wXzM3OTg5OTgw,size_16,color_FFFFFF,t_70)
2、
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200304155827978.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L20wXzM3OTg5OTgw,size_16,color_FFFFFF,t_70)
3、
![在这里插入图片描述](https://img-blog.csdnimg.cn/2020030415592510.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L20wXzM3OTg5OTgw,size_16,color_FFFFFF,t_70)
4、这样就将jar包添加到Lib中了,此时重启tomcat即可!

**完整步骤:**
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200304155219837.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L20wXzM3OTg5OTgw,size_16,color_FFFFFF,t_70)

# 五、第一个SpringMVC程序小结<span id="j9"></span>
[<font size = 1>跳转到目录</font>](#j0)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200304153923957.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L20wXzM3OTg5OTgw,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200304154036776.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L20wXzM3OTg5OTgw,size_16,color_FFFFFF,t_70)