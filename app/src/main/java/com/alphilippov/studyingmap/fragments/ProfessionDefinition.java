package com.alphilippov.studyingmap.fragments;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.alphilippov.studyingmap.R;
import com.alphilippov.studyingmap.databind.ProfessionBinding;
import com.alphilippov.studyingmap.databinding.ProfessionDefinitionBinding;
import com.alphilippov.studyingmap.helperclasses.HumanInterest;
import com.alphilippov.studyingmap.helperclasses.ProfessionalDefinition;
import com.alphilippov.studyingmap.utils.AppConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class ProfessionDefinition extends Fragment {
    public List<ProfessionalDefinition> ProfessionOnePart = new ArrayList<>();
    public List<ProfessionalDefinition> ProfessionTwoPart = new ArrayList<>();
    public List<ProfessionalDefinition> ProfessionThreePart = new ArrayList<>();
    public List<String> HighInterest = new ArrayList<>();
    public List<String> MiddleInterest = new ArrayList<>();
    public List<String> LowInterest = new ArrayList<>();
    public List<String> HighInterestBefore = new ArrayList<>();
    public List<String> MiddleInterestBefore = new ArrayList<>();
    public List<String> LowInterestBefore = new ArrayList<>();
    public int QuestionCount = 1;
    private TextView mCountQue;
    private static final String TAG = ProfessionDefinition.class.getName();



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ProfessionDefinitionBinding binding = DataBindingUtil.inflate(inflater, R.layout.profession_definition, container, false);
        binding.setProfessionalDefinitionDB(new ProfessionBinding("Выберете одно из двух",
                "Вопрос",
                "Автомеханик",
                "Физиотерапевт",
                " 1 ",
                " из ",
                " 30 "));
        mCountQue = binding.countQuestionTwoPart;
        Button mOnePartButton = binding.OnePartButton;
        Button mTwoPartButton = binding.TwoPartButton;

        initializeObjectProfession();


        mOnePartButton.setOnClickListener(view -> {

            collectList(ProfessionOnePart, QuestionCount);
            if (QuestionCount == 1) {
                collectList(ProfessionOnePart, 0);
            }
            mOnePartButton.setText(setItemListOnePart(ProfessionOnePart, QuestionCount));
            mTwoPartButton.setText(setItemListTwoPart(ProfessionTwoPart, QuestionCount));
            QuestionCount++;
            countView(QuestionCount);

        });


        mTwoPartButton.setOnClickListener(view -> {
            collectList(ProfessionTwoPart, QuestionCount);
            if (QuestionCount == 1) {
                collectList(ProfessionTwoPart, 0);
            }
            mOnePartButton.setText(setItemListOnePart(ProfessionOnePart, QuestionCount));
            mTwoPartButton.setText(setItemListTwoPart(ProfessionTwoPart, QuestionCount));

            QuestionCount++;

            countView(QuestionCount);
        });

        return binding.getRoot();
    }

    public List<ProfessionalDefinition> getProfessionThreePart() {
        return ProfessionThreePart;
    }

    public void collectList(List<ProfessionalDefinition> onePart, int i) {
        ProfessionThreePart.add(onePart.get(i));
       // Log.i(TAG, String.valueOf(ProfessionThreePart.size()));
//        for (ProfessionalDefinition professionalDefinition : ProfessionThreePart) {
//            System.out.println(professionalDefinition.getProfession());
//        }
        if (getProfessionThreePart().size() >= ProfessionOnePart.size()) {
            replaceFragment();
            collectInteresGroups();
        }

    }

    private void replaceFragment() {
        mSentDataFragment.onSentData("YES");
    }


    private void initializeObjectProfession() {
        ProfessionOnePart.add(new ProfessionalDefinition(1, 0, "Mechanic"));
        ProfessionOnePart.add(new ProfessionalDefinition(2, 1, "Information security specialist"));
        ProfessionOnePart.add(new ProfessionalDefinition(4, 2, "Call center operator"));
        ProfessionOnePart.add(new ProfessionalDefinition(1, 3, "Driver"));
        ProfessionOnePart.add(new ProfessionalDefinition(2, 4, "Design Engineer"));
        ProfessionOnePart.add(new ProfessionalDefinition(4, 5, "Air traffic controller"));
        ProfessionOnePart.add(new ProfessionalDefinition(1, 6, "Veterinarian"));
        ProfessionOnePart.add(new ProfessionalDefinition(2, 7, "Game developer "));
        ProfessionOnePart.add(new ProfessionalDefinition(4, 8, "Laboratory assistant"));
        ProfessionOnePart.add(new ProfessionalDefinition(1, 9, "Agronomist"));
        ProfessionOnePart.add(new ProfessionalDefinition(2, 10, "Breeder"));
        ProfessionOnePart.add(new ProfessionalDefinition(4, 11, "Marketer"));
        ProfessionOnePart.add(new ProfessionalDefinition(1, 12, "Masseur"));
        ProfessionOnePart.add(new ProfessionalDefinition(2, 13, "Teacher"));
        ProfessionOnePart.add(new ProfessionalDefinition(4, 14, "Facility manager"));
        ProfessionOnePart.add(new ProfessionalDefinition(1, 15, "Waiter"));
        ProfessionOnePart.add(new ProfessionalDefinition(2, 16, "Psychologist"));
        ProfessionOnePart.add(new ProfessionalDefinition(4, 17, "Insurance agent"));
        ProfessionOnePart.add(new ProfessionalDefinition(1, 18, "Jeweler"));
        ProfessionOnePart.add(new ProfessionalDefinition(2, 19, "Art Critic"));
        ProfessionOnePart.add(new ProfessionalDefinition(4, 20, "Editor"));
        ProfessionOnePart.add(new ProfessionalDefinition(1, 21, "Interior designer"));
        ProfessionOnePart.add(new ProfessionalDefinition(2, 23, "Software tester"));
        ProfessionOnePart.add(new ProfessionalDefinition(4, 24, "Copywriter"));
        ProfessionOnePart.add(new ProfessionalDefinition(2, 25, "System Administrator"));
        ProfessionOnePart.add(new ProfessionalDefinition(1, 26, "Carpenter"));
        ProfessionOnePart.add(new ProfessionalDefinition(4, 27, "Corrector"));
        ProfessionOnePart.add(new ProfessionalDefinition(1, 28, "Typewriter"));
        ProfessionOnePart.add(new ProfessionalDefinition(2, 29, "Programmer"));
        ProfessionOnePart.add(new ProfessionalDefinition(4, 30, "Accountant"));
        ProfessionOnePart.add(new ProfessionalDefinition(7, 30, "Бухгалтер"));

        ProfessionTwoPart.add(new ProfessionalDefinition(3, 0, "Physiotherapist"));
        ProfessionTwoPart.add(new ProfessionalDefinition(5, 1, "Logistics specialist"));
        ProfessionTwoPart.add(new ProfessionalDefinition(6, 2, "Cameraman"));
        ProfessionTwoPart.add(new ProfessionalDefinition(3, 3, "Cashier"));
        ProfessionTwoPart.add(new ProfessionalDefinition(5, 4, "Auto Sales Manager"));
        ProfessionTwoPart.add(new ProfessionalDefinition(6, 5, "Web designer"));
        ProfessionTwoPart.add(new ProfessionalDefinition(3, 6, "Ecologist"));
        ProfessionTwoPart.add(new ProfessionalDefinition(5, 7, "Farmer"));
        ProfessionTwoPart.add(new ProfessionalDefinition(6, 8, "SEO specialist "));
        ProfessionTwoPart.add(new ProfessionalDefinition(3, 9, "Sanitary doctor"));
        ProfessionTwoPart.add(new ProfessionalDefinition(5, 10, "Agricultural Product Provider"));
        ProfessionTwoPart.add(new ProfessionalDefinition(6, 11, "Landscape designer"));
        ProfessionTwoPart.add(new ProfessionalDefinition(3, 12, "Tutor"));
        ProfessionTwoPart.add(new ProfessionalDefinition(5, 13, "Entrepreneur"));
        ProfessionTwoPart.add(new ProfessionalDefinition(6, 14, "Artist-animator"));
        ProfessionTwoPart.add(new ProfessionalDefinition(3, 15, "Doctor"));
        ProfessionTwoPart.add(new ProfessionalDefinition(5, 16, "Trading agent"));
        ProfessionTwoPart.add(new ProfessionalDefinition(6, 17, "Choreographer"));
        ProfessionTwoPart.add(new ProfessionalDefinition(3, 18, "Journalist"));
        ProfessionTwoPart.add(new ProfessionalDefinition(5, 19, "Producer"));
        ProfessionTwoPart.add(new ProfessionalDefinition(6, 21, "Musician"));
        ProfessionTwoPart.add(new ProfessionalDefinition(3, 22, "Guide"));
        ProfessionTwoPart.add(new ProfessionalDefinition(5, 23, "Art Director"));
        ProfessionTwoPart.add(new ProfessionalDefinition(6, 24, "Theater and film actor"));
        ProfessionTwoPart.add(new ProfessionalDefinition(3, 25, "Guide-translator"));
        ProfessionTwoPart.add(new ProfessionalDefinition(5, 26, "Crisis Manager"));
        ProfessionTwoPart.add(new ProfessionalDefinition(6, 27, "Art editor"));
        ProfessionTwoPart.add(new ProfessionalDefinition(3, 28, "Legal Counsel"));
        ProfessionTwoPart.add(new ProfessionalDefinition(5, 29, "Broker"));
        ProfessionTwoPart.add(new ProfessionalDefinition(6, 30, "Literary translator"));
        ProfessionTwoPart.add(new ProfessionalDefinition(7, 30, "Accountant"));
    }

    private String setItemListOnePart(List<ProfessionalDefinition> professionOnePart, int questionCount) {

        return professionOnePart.get(questionCount).getProfession();

    }

    private String setItemListTwoPart(List<ProfessionalDefinition> professionTwoPart, int questionCount) {
        return professionTwoPart.get(questionCount).getProfession();

    }

    private void countView(int name) {
        String s = String.valueOf(name);
        mCountQue.setText(s);
    }

    private void collectInteresGroups() {
        int realist = (int) ProfessionThreePart.stream().filter((p) -> p.getIdDefiniton() == AppConfig.Group.REALIST).count();
        int intellectual = (int) ProfessionThreePart.stream().filter((p) -> p.getIdDefiniton() == AppConfig.Group.INTELLECTUAL).count();
        int social = (int) ProfessionThreePart.stream().filter((p) -> p.getIdDefiniton() == AppConfig.Group.SOCIAL).count();
        int office = (int) ProfessionThreePart.stream().filter((p) -> p.getIdDefiniton() == AppConfig.Group.OFFICE).count();
        int entrepreneurial = (int) ProfessionThreePart.stream().filter((p) -> p.getIdDefiniton() == AppConfig.Group.ENTREPRENEURIAL).count();
        int artistic = (int) ProfessionThreePart.stream().filter((p) -> p.getIdDefiniton() == AppConfig.Group.ARTISTIC).count();
        HumanInterest mHigh = new HumanInterest(8, 10, "High");
        HumanInterest mMiddle = new HumanInterest(5, 7, "Middle");
        HumanInterest mLow = new HumanInterest(0, 4, "Low");
        int[] arr = {realist, intellectual, social, office, entrepreneurial, artistic};
        int[] arr1 = {1, 2, 3, 4, 5, 6};
        for (int i = 0; i <= arr.length-1; i++) {
            if (inGroup(mHigh.getLowInterest(), mHigh.getHighInterest(), arr[i]))
                collectInterestHigh(arr1[i], HighInterestBefore);
            else if (inGroup(mMiddle.getLowInterest(), mMiddle.getHighInterest(), arr[i]))
                collectInterestMiddle(arr1[i], MiddleInterestBefore);
            else if (inGroup(mLow.getLowInterest(), mLow.getHighInterest(), arr[i]))
                collectInterestLow(arr1[i], LowInterestBefore);

        }

    }

    public void collectInterestHigh(int group, List<String> name) {
        HighInterestBefore = ProfessionThreePart.stream().filter((p) -> p.getIdDefiniton() == group).
                map(ProfessionalDefinition::getProfession).collect(Collectors.toList());
        if (HighInterestBefore.size() != 0)
            HighInterest.addAll(HighInterestBefore);

    }

    public void collectInterestMiddle(int group, List<String> name) {
        MiddleInterestBefore = ProfessionThreePart.stream().filter((p) -> p.getIdDefiniton() == group).
                map(ProfessionalDefinition::getProfession).collect(Collectors.toList());
        if (MiddleInterestBefore.size() != 0)
            MiddleInterest.addAll(MiddleInterestBefore);

    }

    public void collectInterestLow(int group, List<String> name) {
        LowInterestBefore = ProfessionThreePart.stream().filter((p) -> p.getIdDefiniton() == group).
                map(ProfessionalDefinition::getProfession).collect(Collectors.toList());
        if (LowInterestBefore.size() != 0)
            LowInterest.addAll(LowInterestBefore);

    }


    boolean inGroup(int low, int hi, int value) {
        return (low <= value && value <= hi);
    }

    public interface sentDataFragment {

        void onSentData(String d);

    }

    sentDataFragment mSentDataFragment;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mSentDataFragment = (sentDataFragment) context;
    }


}


