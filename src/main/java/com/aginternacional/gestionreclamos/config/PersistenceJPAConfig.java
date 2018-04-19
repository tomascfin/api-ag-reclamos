package com.aginternacional.gestionreclamos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories
public class PersistenceJPAConfig {

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(new String[]{"com.aginternacional.gestionreclamos.domain"});
        em.setPersistenceUnitName("reclamos");
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(additionalProperties());

        return em;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5433/reclamos");
        dataSource.setUsername("postgres");
        dataSource.setPassword("axiom61");
        dataSource.setSchema("public");

        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);

        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("spring.jpa.database-platform", "org.hibernate.dialect.PostgreSQLDialect");
       // properties.setProperty("spring.jpa.properties.hibernate.temp.use_jdbc_metadata_defaults", "false");
        properties.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
       // properties.setProperty("spring.jpa.properties.hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        properties.setProperty("spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation", "true");
        properties.setProperty("hibernate.jdbc.lob.non_contextual_creation", "true");
        properties.setProperty("spring.datasource.url", "jdbc:postgresql://localhost:5433/reclamos");
        properties.setProperty("spring.jpa.hibernate.ddl-auto", "create");
        properties.setProperty("spring.jpa.generate-ddl", "true");
        //spring.jpa.database-platform=org.hibernate.dialect.PostgreSQL9Dialect
        //properties.setProperty("spring.freemarker.check-template-location")
        return properties;
    }
}
