package com.alphilippov.studyingmap.fragments;

import android.content.Context;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alphilippov.studyingmap.R;
import com.alphilippov.studyingmap.network.NetworkService;
import com.alphilippov.studyingmap.network.dto.UserModelDto;
import com.alphilippov.studyingmap.network.dto.UserModelDtoList;
import com.alphilippov.studyingmap.ui.DataAdapter;
import com.alphilippov.studyingmap.ui.courseModelDto;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchResultOfCourses extends Fragment {
    List<UserModelDto> mCourseModelDto = new ArrayList<>();
    private RecyclerView mRecyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View qView = inflater.inflate(R.layout.search_result_of_courses, container, false);
        mRecyclerView = qView.findViewById(R.id.list);
        DataAdapter mDataAdapter = new DataAdapter(getContext(), mCourseModelDto);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mDataAdapter);
        return qView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        callRetrofit();


    }

    private void callRetrofit() {
        NetworkService.getInstance().getJSONApi().getResultList(1, 12, "java", "price-free", true, "en", "beginner", "highest-rated", 4).enqueue(new Callback<UserModelDtoList>() {
            @Override
            public void onResponse(Call<UserModelDtoList> call, Response<UserModelDtoList> response) {
                mCourseModelDto = response.body().getUserModelDtoList();
            }

            @Override
            public void onFailure(Call<UserModelDtoList> call, Throwable t) {

            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }
}
