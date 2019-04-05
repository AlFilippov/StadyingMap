package com.alphilippov.studyingmap.network;

import com.alphilippov.studyingmap.BuildConfig;
import com.alphilippov.studyingmap.utils.AppConfig;

import java.util.Base64;

import okhttp3.OkHttpClient;
import okhttp3.Request;

import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class NetworkService {

    private static NetworkService mInstance;
    private Retrofit mRetrofit;

    private NetworkService() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(chain -> {
            Request original = chain.request();
            Request.Builder requestBuilder = original.newBuilder()
                    .header("Authorization", "Basic " + getBasicAuthenticator());
            Request request = requestBuilder.build();
            return chain.proceed(request);
        }).addInterceptor(httpLoggingInterceptor).build();


        mRetrofit = new Retrofit.Builder()
                .baseUrl(AppConfig.BASE_URL)
                .client(client)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    private static String getBasicAuthenticator() {
        String authStr = AppConfig.Authorization.CLIENT_ID + ":" + AppConfig.Authorization.CLIENT_SECRET;
        return Base64.getEncoder().encodeToString(authStr.getBytes());
    }

    public synchronized static NetworkService getInstance() {
        if (mInstance == null) {
            mInstance = new NetworkService();

        }
        return mInstance;
    }

    public RestService getJSONApi() {
        return mRetrofit.create(RestService.class);
    }

}
