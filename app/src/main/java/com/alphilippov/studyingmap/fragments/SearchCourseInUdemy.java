package com.alphilippov.studyingmap.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.alphilippov.studyingmap.R;

public class SearchCourseInUdemy extends Fragment {
    public String keyWords;
    public EditText searchWords;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View searchView = inflater.inflate(R.layout.content_info_course_for_request, container, false);
        searchWords = searchView.findViewById(R.id.content_edit_text_request);
        searchWords.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                keyWords = s.toString();
            }
        });

        Button buttonSearch = searchView.findViewById(R.id.content_button_request);
        buttonSearch.setOnClickListener(v -> {
            if (keyWords != null) {
                mReplaceFragment.sentDataInSearchInUdemy("ok", keyWords);
            } else {
                Toast.makeText(getContext(), "Enter value", Toast.LENGTH_SHORT).show();
            }
        });
        return searchView;
    }


    public interface replaceFragment {

        void sentDataInSearchInUdemy(String keyChangeFragment, String keyWords);
    }

    replaceFragment mReplaceFragment;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mReplaceFragment = (replaceFragment) context;
    }
}
