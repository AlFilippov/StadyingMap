package com.dom.stadying.network;

import com.dom.stadying.utils.AppConfig;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class ServiceGenerator {
    //TODO Реализация Retrofit и http клиента
    private static OkHttpClient.Builder httpClient= new OkHttpClient.Builder();
    private static Retrofit.Builder sBuilder =  new Retrofit.Builder()
            .baseUrl(AppConfig.BASE_URL)
            .addConverterFactory(JacksonConverterFactory.create());
    public  static <S>S createService(Class<S> serviceClass){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient.addInterceptor(logging);
        Retrofit retrofit = sBuilder
                .client(httpClient.build())
                .build();
        return retrofit.create(serviceClass);

    }


}
