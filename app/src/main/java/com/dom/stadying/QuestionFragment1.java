package com.dom.stadying;

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

public class QuestionFragment1 extends Fragment implements SeekBar.OnSeekBarChangeListener {
private static final String  HUMANITIES_AND_ART = "human_art";
private static final String  COMPUTER_SCIENCE = "computer_science";
    private Button mFragmentButton;
    private OnFragmentInteractionListener mListener;
    private int mTextView;
    private String mKey;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View qView = inflater.inflate(R.layout.question_fragment1, container, false);
        SeekBar seekBarHumanandArt = qView.findViewById(R.id.seekbar_ha);
        SeekBar seekBarComputerScience = qView.findViewById(R.id.seekbar_cs);
        TextView ExampleTextView = qView.findViewById(R.id.textview);
        seekBarComputerScience.setOnSeekBarChangeListener(this);
        seekBarHumanandArt.setOnSeekBarChangeListener(this);
        ExampleTextView.setText(String.valueOf(getTextView()));

        Button mFragmentButton = qView.findViewById(R.id.fragment1_finish);
        mFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Задача метода передать данные в активити
                replacefragment();
            }
        });
        return qView;
    }

    public String getKey() {
        return mKey;
    }

    public void setKey(String key) {
        mKey = key;
    }

    public void setTextView(int textView) {
        this.mTextView = textView;
    }

    public int getTextView() {
        return mTextView;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()) {
            case R.id.seekbar_ha:
                setTextView(progress);
               setKey(HUMANITIES_AND_ART);
                break;
            case R.id.seekbar_cs:
                setKey(COMPUTER_SCIENCE);
                setTextView(progress);
                break;

        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    //Вложенный интерфейс для взаимодействия с активити
    interface OnFragmentInteractionListener {
        void OnFragmentInteraction(int value_seekbar,String key);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//Обращаемся к активити
        mListener = (OnFragmentInteractionListener) context;


    }

    public void replacefragment() {
        int b = getTextView();
        String c = getKey();
        //Передаем некоторое значение , по которому будем судить
        mListener.OnFragmentInteraction(b,c);
    }

    public void saveBar(int b) {

    }
}

