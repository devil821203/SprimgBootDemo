package org.example.trouble.demo.gateways;


import com.github.lianjiatech.retrofit.spring.boot.core.RetrofitClient;
import org.example.trouble.demo.dtos.TW8310803Request;
import org.example.trouble.demo.dtos.TW8310803Response;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


@Component
@RetrofitClient(baseUrl = "${taiwanDollar.baseUrl}", sourceOkHttpClient = "ignoreSSLOkHttpClient")
public interface TaiwanDollarGateway {
    @POST("TW8310803?client_id=c7a8aa6a-c53d-48e3-ba8e-18a107169b88")
    Call<TW8310803Response> TW8310803(@Body TW8310803Request body);
}
