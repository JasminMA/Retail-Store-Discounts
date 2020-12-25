package com.retail.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:database.properties")
public class HibernateConfiguration {
    private static final Logger logger = LogManager.getLogger(HibernateConfiguration.class);

    @Autowired
    private Environment env;

    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        logger.trace("getSessionFactory");
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(
                new String[]{"com.retail.trx"});
        sessionFactory.setHibernateProperties(hibernateProperties());

        return sessionFactory;
    }

    @Bean
    public DataSource dataSource() {
        logger.trace("dataSource");
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl(env.getProperty("jdbc.url"));
        dataSource.setUsername(env.getProperty("jdbc.username"));
        dataSource.setPassword(env.getProperty("jdbc.password"));

        return dataSource;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        logger.trace("transactionManager");
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(getSessionFactory().getObject());
        return txManager;
    }

    private Properties hibernateProperties() {
        logger.trace("hibernateProperties");
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty(
                "hibernate.hbm2ddl.auto", env.getProperty("jdbc.hibernate.hbm2ddl.auto"));
        hibernateProperties.setProperty(
                "hibernate.dialect", env.getProperty("jdbc.hibernate.dialect"));

        return hibernateProperties;
    }
}
