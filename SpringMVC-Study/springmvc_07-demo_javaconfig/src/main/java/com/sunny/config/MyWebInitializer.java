package com.sunny.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

// Web容器启动; 相当于web.xml
public class MyWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    // 根容器: 相当于_关联Spring的核心配置文件
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{AppConfig.class};
    }

    // SpringMVC容器:相当于在web.xml中配置mvc.xml
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    // 映射路径
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /*    // 配置全局过滤器(字符编码问题)
        protected void registerContextLoaderListener(ServletContext servletContext) {
            super.registerContextLoaderListener(servletContext);
            //编码过滤器
            Dynamic filter = servletContext.addFilter("CharacterEncodingFilter", CharacterEncodingFilter.class);
            filter.setInitParameter("encoding", "UTF-8");
            filter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
        }*/
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return new Filter[]{characterEncodingFilter};
    }
}
