package com.alphilippov.studyingmap.network;

import com.alphilippov.studyingmap.network.dto.UserModelDto;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestService {
@GET("courses")
    Call<UserModelDto>getInfo(@Query("page") int page );
}
