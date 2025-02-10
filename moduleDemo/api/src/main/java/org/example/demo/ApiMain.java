package org.example.demo;


import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component(value = "org.example.trouble.demo")
//scanBasePackages = "org.example.trouble.demo",
@SpringBootApplication (exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class, JdbcTemplateAutoConfiguration.class})
//@Import(value= RetrofitCustomOkHttpClientRegister.class)
public class ApiMain {
    @Autowired
    private ApplicationContext applicationContext;
    public static void main(String[] args) {
        SpringApplication.run(ApiMain.class,args);
    }
    @PostConstruct
    public void checkBeans() {
        System.out.println("All beans: ");

        for (String bean: applicationContext.getBeanDefinitionNames()
        ) {
            System.out.println(bean);
        }
    }
}
