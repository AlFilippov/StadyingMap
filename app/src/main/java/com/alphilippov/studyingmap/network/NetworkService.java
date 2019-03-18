package com.alphilippov.studyingmap.network;

import com.alphilippov.studyingmap.utils.AppConfig;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class NetworkService {

private static NetworkService mInstance;
private Retrofit mRetrofit;
private NetworkService(){
    HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
    httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    OkHttpClient.Builder client = new OkHttpClient.Builder();
    client.addInterceptor(httpLoggingInterceptor);
    mRetrofit= new Retrofit.Builder()
            .baseUrl(AppConfig.BASE_URL)
            .addConverterFactory(JacksonConverterFactory.create())
            .build();
}
public static NetworkService getInstance(){
    if(mInstance==null){
        mInstance = new NetworkService();

    }
    return  mInstance;
}
public RestService getJSONApi(){
    return mRetrofit.create(RestService.class);
}
}
