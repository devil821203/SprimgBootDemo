package org.example.demo.configuration;

import com.github.lianjiatech.retrofit.spring.boot.core.SourceOkHttpClientRegistrar;
import com.github.lianjiatech.retrofit.spring.boot.core.SourceOkHttpClientRegistry;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import org.springframework.stereotype.Component;

import javax.net.ssl.X509TrustManager;
import java.time.Duration;

@Component
public class RetrofitCustomOkHttpClientRegister implements SourceOkHttpClientRegistrar {

    @Override
    public void register(SourceOkHttpClientRegistry registry) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(Level.BODY);

        registry.register("ignoreSSLOkHttpClient", new OkHttpClient.Builder()
            .connectTimeout(Duration.ofSeconds(60))
            .writeTimeout(Duration.ofSeconds(60))
            .readTimeout(Duration.ofSeconds(60))
            .sslSocketFactory(SSLSocketConfig.getSSLSocketFactory(),(X509TrustManager)SSLSocketConfig.getTrustManagers()[0])
            .hostnameVerifier(SSLSocketConfig.getHostnameVerifier())
            .addInterceptor(logging)
            .build());
    }
    
}
