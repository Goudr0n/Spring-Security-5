package by.example.security.configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "by.example.security")
@EnableWebMvc
public class MyConfig {

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INF/view/");
        internalResourceViewResolver.setSuffix(".jsp");

        return internalResourceViewResolver;
    }

    @Bean
    public DataSource dataSource() {
        ComboPooledDataSource dataSource;
        try {
            dataSource = new ComboPooledDataSource();
            dataSource.setDriverClass("com.mysql.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/spring_course_db2?useSSL=false&amp;serverTimezone=UTC");
            dataSource.setUser("root");
            dataSource.setPassword("root");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return dataSource;
    }
}
