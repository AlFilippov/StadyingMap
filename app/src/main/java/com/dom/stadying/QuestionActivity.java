package com.dom.stadying;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class QuestionActivity extends MainActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       FragmentManager fragmentManager = getFragmentManager();
       Fragment questionFragment1 = fragmentManager.findFragmentById(R.id.question_fragment1);
       FragmentTransaction ft = fragmentManager.beginTransaction();
       ft.add(R.id.container,questionFragment1,"questionFragment");
       ft.commit();
    }
}

