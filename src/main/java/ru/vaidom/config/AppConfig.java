package ru.vaidom.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan("ru.vaidom")
@PropertySource("classpath:db.properties")
@RequiredArgsConstructor
public class AppConfig {

    private final Environment env;

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("db.driver"));
        dataSource.setUrl(env.getProperty("db.url"));
        dataSource.setUsername(env.getProperty("db.username"));
        dataSource.setPassword(env.getProperty("db.password"));
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(getDataSource());

        Properties hibernateProperties = new Properties();
        hibernateProperties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl"));
        hibernateProperties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        hibernateProperties.put("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
        hibernateProperties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
        sessionFactoryBean.setHibernateProperties(hibernateProperties);

        sessionFactoryBean.setPackagesToScan("ru.vaidom.model");
        return sessionFactoryBean;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(getSessionFactory().getObject());
        return transactionManager;
    }
}
