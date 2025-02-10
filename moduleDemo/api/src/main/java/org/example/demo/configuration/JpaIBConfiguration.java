package org.example.demo.configuration;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories( 
        basePackages = {"org.example.trouble.demo.Repository.ib"},
        entityManagerFactoryRef = "ibEntityManagerFactory",
        transactionManagerRef = "ibSourceTransactionManager")
public class JpaIBConfiguration {
    @Bean("ibConnection")
    @ConfigurationProperties("ib.datasource")
    public ConnectionInfo getIBConnectionInfo() {
        return new ConnectionInfo();
    }

    @Bean("ibDataSource")
    public DataSource ibDataSource() {
        ConnectionInfo connectionInfo = getIBConnectionInfo();
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(connectionInfo.getDriverClassName());
        dataSource.setJdbcUrl(connectionInfo.getJdbcUrl());
        dataSource.setUsername(connectionInfo.getUsername());
        dataSource.setPassword(connectionInfo.getPazzword());
        dataSource.setMaximumPoolSize(connectionInfo.getMaximumPoolSize());
        return dataSource;
    }

    @Bean(name = "ibEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean ibEntityManagerFactory() {
        final LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
        emfb.setDataSource(ibDataSource());
        emfb.setPackagesToScan("org.example.trouble.demo.Entities.ib");
        // emfb.setPackagesToScan("com.systex.backstage.digitalbank.foreignDollarAccounts.entities.ib");
        emfb.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        emfb.setJpaProperties(jpaIBProperties());
        emfb.setPersistenceUnitName("IB");
        emfb.afterPropertiesSet();
        return emfb;
    }

    @Bean(name = "ibSourceTransactionManager")
    public PlatformTransactionManager ibSourceTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(ibEntityManagerFactory().getObject());
        return transactionManager;
    }

    private Properties jpaIBProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "none");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
        return properties;
    }
}
