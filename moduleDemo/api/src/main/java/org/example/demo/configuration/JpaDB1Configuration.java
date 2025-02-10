package org.example.demo.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories( 
        basePackages = {"org.example.trouble.demo.Repository.db1"},
        entityManagerFactoryRef = "db1EntityManagerFactory",
        transactionManagerRef = "db1SourceTransactionManager")
public class JpaDB1Configuration {
    @Bean("db1Connection")
    @Primary
    @ConfigurationProperties("db1.datasource")
    public ConnectionInfo getIBConnectionInfo() {
        return new ConnectionInfo();
    }

    @Bean("db1DataSource")
    @Primary
    public DataSource db1DataSource() {
        ConnectionInfo connectionInfo = getIBConnectionInfo();
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(connectionInfo.getDriverClassName());
        dataSource.setJdbcUrl(connectionInfo.getJdbcUrl());
        dataSource.setUsername(connectionInfo.getUsername());
        dataSource.setPassword(connectionInfo.getPazzword());

        return dataSource;
    }

    @Bean(name = "db1EntityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean db1EntityManagerFactory() {
        final LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
        emfb.setDataSource(db1DataSource());
        emfb.setPackagesToScan("org.example.trouble.demo.Entities.db1");
        // emfb.setPackagesToScan("com.systex.backstage.digitalbank.foreignDollarAccounts.entities.ib");
        emfb.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        emfb.setJpaProperties(jpaDB1Properties());
        emfb.setPersistenceUnitName("db1");
        emfb.afterPropertiesSet();
        return emfb;
    }

    @Bean(name = "db1SourceTransactionManager")
    public PlatformTransactionManager ibSourceTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(db1EntityManagerFactory().getObject());
        return transactionManager;
    }

    private Properties jpaDB1Properties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "none");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MariaDBDialect");

        return properties;
    }
}
