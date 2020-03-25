package com.sunny.config;

// 对应applicationContext.xml的配置类

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.sunny")
@PropertySource("classpath:db.properties")
@EnableTransactionManagement // 事务处理的注解
public class AppConfig {

    @Value("${jdbc.driverClassName}")
    private String driverClassName;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;
    @Value("${jdbc.initialSize}")
    private int initialSize;

    // 连接池对象
    @Bean // bean的id就是dataSource,也可以起一个
    public DataSource dataSource(){
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName(driverClassName);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        ds.setInitialSize(initialSize);
        return ds;
    }

    // 事务管理器对象;这里传的ds对象,就是上面的连接池对象,它会自动找ds对象
    @Bean
    public DataSourceTransactionManager txManager(DataSource ds){
        return new DataSourceTransactionManager(ds);
    }

}
