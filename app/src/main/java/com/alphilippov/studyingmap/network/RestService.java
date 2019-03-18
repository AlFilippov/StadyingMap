package com.alphilippov.studyingmap.network;

import com.alphilippov.studyingmap.network.dto.UserModelDto;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestService {
@GET("courses")
    Call<UserModelDto>getInfo(@Query("page") int page ,@Query("page_size")int page_size,@Query("search")String search,@Query("sub_category") String subcategory_courses);
}
