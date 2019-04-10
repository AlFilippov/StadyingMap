package com.alphilippov.studyingmap.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.alphilippov.studyingmap.R;
import com.alphilippov.studyingmap.network.NetworkService;
import com.alphilippov.studyingmap.network.RestService;
import com.alphilippov.studyingmap.network.dto.UserModelDto;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChoiceOfProfession extends Fragment {
    private static final String HUMANITIES_AND_ART = "human_art";
    private static final String COMPUTER_SCIENCE = "computer_science";
    private static final String DEFAULT_KEY = "default";
    private TextView mTitle;
    private TextView mPrice;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View qView = inflater.inflate(R.layout.choice_profession, container, false);

        mTitle = qView.findViewById(R.id.titleCourse);
        mPrice = qView.findViewById(R.id.coursePrice);


        return qView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
    }
}

