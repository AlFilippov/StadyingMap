package com.dom.stadying;

import android.content.Context;
import android.content.Intent;
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

public class QuestionFragment1 extends Fragment implements SeekBar.OnSeekBarChangeListener {
    private int seekbar_changed1;
    private int seekbar_changed2;
private Button fq1Button;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View qView = inflater.inflate(R.layout.question_fragment1, container, false);
        SeekBar seekBar_HA = qView.findViewById(R.id.seekbar_ha);
        SeekBar seekBar_CS = qView.findViewById(R.id.seekbar_cs);
        seekBar_HA.setOnSeekBarChangeListener(this);
        seekBar_CS.setOnSeekBarChangeListener(this);
        Button fq1Button = qView.findViewById(R.id.fragment1_finish);
        fq1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Переход на 2 фрагмент с данными
            }
        });
        //Вопрос по реализации все кнопок в одном onCreateView
        return qView;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        switch (seekBar.getId()) {
            case R.id.seekbar_ha:
                seekbar_changed1 = seekBar.getProgress();
                break;
            case R.id.seekbar_cs:
                seekbar_changed2 = seekBar.getProgress();
                break;
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }


    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onAttach(Context context) {

        super.onAttach(context);
    }
}
