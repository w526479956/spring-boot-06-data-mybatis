package net.cnway.springboot06.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {
    @ConfigurationProperties(prefix = "spring.dataSource")
    @Bean
    public DataSource druid(){
        return new DruidDataSource();
    }
    //配置statViewServlet
    @Bean
    public ServletRegistrationBean statViewServlet(){

        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String,String> initParamater =new HashMap<>();
        initParamater.put("loginUsername","admin");
        initParamater.put("loginPassword","123456");
        bean.setInitParameters(initParamater);
        return bean;
    }
    //配置filter
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        Map<String,String> map =new HashMap<>();
        map.put("exclusions","*.css,*.js");
        bean.setInitParameters(map);
        bean.setUrlPatterns(Arrays.asList("/*"));
        return  bean;
    }
}
