package com.dom.stadying;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class QuestionFragment1 extends Fragment implements SeekBar.OnSeekBarChangeListener {


    protected int seekbar_changed1;
    protected int seekbar_changed2;
    private int seekbar_changed3;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View qView = inflater.inflate(R.layout.question_fragment1, container, false);
         SeekBar seekBar_HA = qView.findViewById(R.id.seekbar_ha);
         SeekBar seekBar_CS = qView.findViewById(R.id.seekbar_cs);
        seekBar_HA.setOnSeekBarChangeListener(this);
        seekBar_CS.setOnSeekBarChangeListener(this);
        return qView;
    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

    }
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

@Override
    public void onStopTrackingTouch(SeekBar seekBar) {

        switch (seekBar.getId()){

            case R.id.seekbar_ha:

                seekbar_changed1 = seekBar.getProgress();
                break;
            case R.id.seekbar_cs:
                seekbar_changed2 = seekBar.getProgress();
                break;
        }

    }






}
