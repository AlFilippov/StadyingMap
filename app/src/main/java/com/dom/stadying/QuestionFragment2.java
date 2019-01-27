package com.dom.stadying;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import android.widget.Button;
import android.widget.TextView;

public class QuestionFragment2 extends Fragment {
private TextView textview ;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View q2View = inflater.inflate(R.layout.question_fragment2,container,false);
        textview = q2View.findViewById(R.id.decided);
       //Создать более точную информацию
//Bundle bundle = new Bundle();
//        int seekBar_HA = bundle.getInt("SeekBar");

        return q2View;
    }


}
