package com.dom.stadying;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import java.util.HashMap;
import java.util.Map;

public class QuestionActivity extends MainActivity implements ChoiceOfProfession.OnFragmentInteractionListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ChoiceOfProfession choiceOfProfession = new ChoiceOfProfession();
        ft.add(R.id.container, choiceOfProfession);
        ft.commit();
        //Обратиться к переменной фрагмента , чтобы получить даннные по нажатию кнопок
    }

    Map<Integer, String> dataquestions = new HashMap<Integer, String>();

    @Override
    public void OnFragmentInteraction(int value_seekbar, String keys) {
        dataquestions.put(value_seekbar, keys);
        if (!dataquestions.containsKey("default")) {
//        if (value_seekbar != 0 && key.equals("human_art")) {
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.addToBackStack(null);
            ProfessionDefinition qf2 = new ProfessionDefinition();
            ft.replace(R.id.container, qf2);
            fm.popBackStack();
            ft.commit();


        }
    }

}