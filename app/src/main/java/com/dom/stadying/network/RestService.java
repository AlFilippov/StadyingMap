package com.dom.stadying.network;

import com.dom.stadying.network.res.UserModelRes;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface RestService {
@GET("courses")
    Call<UserModelRes>getInfo(@Query("page") int page );
}
