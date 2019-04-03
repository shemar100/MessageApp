package app.messages;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Configuration
@Component("app.messages")
public class AppConfig {
    @Bean
    public FilterRegistrationBean<AuditingFilter> auditingFilterFilterRegistrationBean () {
        FilterRegistrationBean<AuditingFilter> registrationBean = new FilterRegistrationBean<>();
        AuditingFilter filter = new AuditingFilter();
        registrationBean.setFilter(filter);
        registrationBean.setOrder(Integer.MAX_VALUE);
        registrationBean.setUrlPatterns(Arrays.asList("/messages/*"));
        return registrationBean;
    }
}
