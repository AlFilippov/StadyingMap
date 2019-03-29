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
import com.alphilippov.studyingmap.ui.DataAdapter;
import com.alphilippov.studyingmap.ui.courseModelDto;

import java.util.ArrayList;
import java.util.List;

public class SearchResultOfCourses extends Fragment {
    List<courseModelDto> mCourseModelDto = new ArrayList<>();
private RecyclerView mRecyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View qView = inflater.inflate(R.layout.search_result_of_courses, container, false);
       mRecyclerView=qView.findViewById(R.id.list);
        DataAdapter mDataAdapter = new DataAdapter(getContext(),mCourseModelDto);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mDataAdapter);
return qView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCourseModelDto = new ArrayList<>();
        mCourseModelDto.add(new courseModelDto("Java","Jonh","4.5","4","50","30$","15$"));
        mCourseModelDto.add(new courseModelDto("Java","Jonh","4.5","4","50","30$","15$"));
        mCourseModelDto.add(new courseModelDto("Java","Jonh","4.5","4","50","30$","15$"));
        mCourseModelDto.add(new courseModelDto("Java","Jonh","4.5","4","50","30$","15$"));
        mCourseModelDto.add(new courseModelDto("Java","Jonh","4.5","4","50","30$","15$"));
        mCourseModelDto.add(new courseModelDto("Java","Jonh","4.5","4","50","30$","15$"));
        mCourseModelDto.add(new courseModelDto("Java","Jonh","4.5","4","50","30$","15$"));
        mCourseModelDto.add(new courseModelDto("Java","Jonh","4.5","4","50","30$","15$"));
        mCourseModelDto.add(new courseModelDto("Java","Jonh","4.5","4","50","30$","15$"));
        mCourseModelDto.add(new courseModelDto("Java","Jonh","4.5","4","50","30$","15$"));
        mCourseModelDto.add(new courseModelDto("Java","Jonh","4.5","4","50","30$","15$"));
        mCourseModelDto.add(new courseModelDto("Java","Jonh","4.5","4","50","30$","15$"));

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }
}
