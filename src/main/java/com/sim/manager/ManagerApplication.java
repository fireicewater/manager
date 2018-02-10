package com.sim.manager;

import com.sim.manager.config.RewriteFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan(basePackages = "com.sim.manager.mapper")
public class ManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManagerApplication.class, args);
    }

    //    @Bean
//    public EmbeddedServletContainerCustomizer containerCustomizer() {
//        return (container -> {
//            ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/errors/401.html");
//            ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/errors/404.html");
//            ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/errors/500.html");
//            container.addErrorPages(error401Page, error404Page, error500Page);
//        });
//    }
    @Bean
    public FilterRegistrationBean testFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new RewriteFilter());//注册rewrite过滤器
        registration.addUrlPatterns("/*");
        registration.addInitParameter(RewriteFilter.REWRITE_TO, "/index.html");
        registration.addInitParameter(RewriteFilter.REWRITE_PATTERNS, "/manager/*");
        registration.setName("rewriteFilter");
        registration.setOrder(1);
        return registration;
    }
}
