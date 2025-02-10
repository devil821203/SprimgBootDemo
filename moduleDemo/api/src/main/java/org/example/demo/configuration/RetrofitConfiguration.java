package org.example.demo.configuration;

import com.github.lianjiatech.retrofit.spring.boot.core.RetrofitScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@RetrofitScan("org.example.demo.gateways")
public class RetrofitConfiguration {
    
}
