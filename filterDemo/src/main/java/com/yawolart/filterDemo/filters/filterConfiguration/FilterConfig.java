package com.yawolart.filterDemo.filters.filterConfiguration;

import com.yawolart.filterDemo.filters.ManualBeanFilterDemo;
import jakarta.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("/com/yawolart/filters")
public class FilterConfig {
    @Bean
    public FilterRegistrationBean<ManualBeanFilterDemo> getManualRegisterBean()
    {
        FilterRegistrationBean<ManualBeanFilterDemo> registrationBean =
                new FilterRegistrationBean<>();
        registrationBean.setFilter(new ManualBeanFilterDemo());
        //registrationBean.addUrlPatterns("/api/student, /api/admin");
        registrationBean.setOrder(4);
        return registrationBean;
    }

}
