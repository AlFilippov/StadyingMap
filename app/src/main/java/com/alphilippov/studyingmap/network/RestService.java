package com.alphilippov.studyingmap.network;

import com.alphilippov.studyingmap.network.dto.UserModelDto;
import com.alphilippov.studyingmap.network.dto.UserModelDtoList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestService {
    @GET("/courses")
    Call<UserModelDto> getInfo(@Query("page") int page, @Query("page_size") int page_size, @Query("search") String search, @Query("sub_category") String subcategory_courses);

    @GET("courses")
    Call<UserModelDto.Result> getResult(@Query("page") int page, @Query("page_size") int page_size, @Query("search") String search,
                                              @Query("price") String price,
                                              @Query("is_affiliate_agreed") boolean aff,
                                              @Query("language") String lang,
                                              @Query("instructional_level")String level,
                                              @Query("ordering") String order,
                                              @Query("ratings")int nubmer);
    @GET("courses")
    Call<UserModelDtoList>getResultList(@Query("page") int page, @Query("page_size") int page_size, @Query("search") String search,
                                    @Query("price") String price,
                                    @Query("is_affiliate_agreed") boolean aff,
                                    @Query("language") String lang,
                                    @Query("instructional_level")String level,
                                    @Query("ordering") String order,
                                    @Query("ratings")int nubmer);
}
