package org.example.trouble.demo.configuration;

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
        basePackages = {"org.example.trouble.demo.Repository.db2"},
        entityManagerFactoryRef = "db2EntityManagerFactory",
        transactionManagerRef = "db2SourceTransactionManager")
public class JpaDB2Configuration {
    @Bean("db2Connection")
    @ConfigurationProperties("db2.datasource")
    public ConnectionInfo getIBConnectionInfo() {
        return new ConnectionInfo();
    }

    @Bean("db2DataSource")
    public DataSource db1DataSource() {
        ConnectionInfo connectionInfo = getIBConnectionInfo();
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(connectionInfo.getDriverClassName());
        dataSource.setJdbcUrl(connectionInfo.getJdbcUrl());
        dataSource.setUsername(connectionInfo.getUsername());
        dataSource.setPassword(connectionInfo.getPazzword());

        return dataSource;
    }

    @Bean(name = "db2EntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean db2EntityManagerFactory() {
        final LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
        emfb.setDataSource(db1DataSource());
        emfb.setPackagesToScan("org.example.trouble.demo.Entities.db2");
        // emfb.setPackagesToScan("com.systex.backstage.digitalbank.foreignDollarAccounts.entities.ib");
        emfb.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        emfb.setJpaProperties(jpaDB2Properties());
        emfb.setPersistenceUnitName("db2");
        emfb.afterPropertiesSet();
        return emfb;
    }

    @Bean(name = "db2SourceTransactionManager")
    public PlatformTransactionManager ibSourceTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(db2EntityManagerFactory().getObject());
        return transactionManager;
    }

    private Properties jpaDB2Properties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "none");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MariaDBDialect");
        return properties;
    }
}
