package app.messages;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;
import java.util.Arrays;

@Configuration
@Component("app.messages")
public class AppConfig {
    private DataSource dataSource;


    public AppConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public FilterRegistrationBean<AuditingFilter> auditingFilterFilterRegistrationBean () {
        FilterRegistrationBean<AuditingFilter> registrationBean = new FilterRegistrationBean<>();
        AuditingFilter filter = new AuditingFilter();
        registrationBean.setFilter(filter);
        registrationBean.setOrder(Integer.MAX_VALUE);
        registrationBean.setUrlPatterns(Arrays.asList("/messages/*"));
        return registrationBean;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setPackagesToScan("app.messages");
        return sessionFactoryBean;
    }
}
