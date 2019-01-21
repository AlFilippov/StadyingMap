package com.dom.stadying;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class QuestionActivity extends MainActivity {
private int seekbar1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        QuestionFragment1 questionFragment1 = new QuestionFragment1();
        ft.add(R.id.container,questionFragment1);
        ft.commit();
        //Обратиться к переменной фрагмента , чтобы получить даннные по нажатию кнопок
    }

}

