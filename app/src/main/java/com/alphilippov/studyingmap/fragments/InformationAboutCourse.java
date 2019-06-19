package com.alphilippov.studyingmap.fragments;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.alphilippov.studyingmap.R;
import com.alphilippov.studyingmap.databind.InformationAbCourseBinding;
import com.alphilippov.studyingmap.databinding.InformationAboutCourseBinding;
import com.alphilippov.studyingmap.network.dto.UserModelDto;
import com.alphilippov.studyingmap.utils.AppConfig;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InformationAboutCourse extends Fragment {
    private List<UserModelDto.Result> userModeltoInformationAboutCourse = new ArrayList<>();
    private HashMap<String, List<UserModelDto.Result>> mUserModelResultInfo = new HashMap<>();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = new Bundle(getArguments());
        mUserModelResultInfo = (HashMap<String, List<UserModelDto.Result>>) bundle.getSerializable("info");
        userModeltoInformationAboutCourse = mUserModelResultInfo.get("info");
        bundle.remove("info");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        InformationAboutCourseBinding binding = DataBindingUtil.inflate(inflater, R.layout.information_about_course, container, false);
        binding.setInformationAbCourseDB(new InformationAbCourseBinding(
                userModeltoInformationAboutCourse.get(0).getTitle(),
                userModeltoInformationAboutCourse.get(0).getVisibleInstructors().get(0).getTitle(),
                "Rating",
                4,
                "Website"));
        Glide.with(getContext())
                .applyDefaultRequestOptions(new RequestOptions().fitCenter())
                .load(userModeltoInformationAboutCourse.get(0).getImage480x270())
                .into(binding.mImageAboutCourse);
        Button mWebsite = binding.mBuyAboutCourse;
        mWebsite.setOnClickListener(view -> {
            getCourseView(getConcatUrl(userModeltoInformationAboutCourse));
        });
        return binding.getRoot();
    }

    private String getConcatUrl(List<UserModelDto.Result> results) {
        return AppConfig.BASE_URL_UDEMY + results.get(0).getUrl();
    }

    private void getCourseView(String url) {
        Intent getWeb = new Intent();
        getWeb.setPackage("com.android.chrome");
        getWeb.setAction(Intent.ACTION_VIEW);
        getWeb.setData(Uri.parse(url));
        startActivity(getWeb);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }
}
