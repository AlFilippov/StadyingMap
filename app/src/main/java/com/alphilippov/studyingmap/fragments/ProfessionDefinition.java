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
import com.alphilippov.studyingmap.helperclasses.ReplaceFragment;
import com.alphilippov.studyingmap.network.dto.ProfessionDataListDTO;
import com.alphilippov.studyingmap.utils.AppConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


public class ProfessionDefinition extends Fragment implements ReplaceFragment {
    public List<String> HighInterest = new ArrayList<>();
    public List<String> MiddleInterest = new ArrayList<>();
    public List<String> LowInterest = new ArrayList<>();
    public List<String> HighIntGroup = new ArrayList<>();
    public List<String> MiddleIntGroup = new ArrayList<>();
    public List<String> LowIntGroup = new ArrayList<>();
    public int QuestionCount = 1;
    public HashMap<String, List<String>> mHashInterest = new HashMap<>();
    private static final String HIGH_INT_KEY = "high";
    private static final String MIDDLE_INT_KEY = "middle";
    private static final String LOW_INT_KEY = "low";
    private static final String WANT_DEFENITION = "wdecided";
    private List<ProfessionalDefinition> ProfessionOnePart = new ArrayList<>();
    private List<ProfessionalDefinition> ProfessionTwoPart = new ArrayList<>();
    private List<ProfessionalDefinition> ProfessionThreePart = new ArrayList<>();
    private HashMap<String, List<ProfessionDataListDTO>> mHashMapCollectionProfession;
    private List<String> HighInterestBefore = new ArrayList<>();
    private List<String> MiddleInterestBefore = new ArrayList<>();
    private List<String> LowInterestBefore = new ArrayList<>();
    private List<ProfessionDataListDTO> professionDataLists = new ArrayList<>();
    private TextView mCountQue;
    private  String restoreCount;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = new Bundle(getArguments());
        bundle.getSerializable(WANT_DEFENITION);
        mHashMapCollectionProfession = (HashMap<String, List<ProfessionDataListDTO>>) bundle.getSerializable(WANT_DEFENITION);
        professionDataLists = mHashMapCollectionProfession.get(WANT_DEFENITION);
    }

    @Override
    public void onResume() {
        //Восстановление не работает
        mCountQue.setText(String.valueOf(restoreCount));
        super.onResume();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        ProfessionDefinitionBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.profession_definition, container, false);
        binding.setProfessionalDefinitionDB(new ProfessionBinding(
                "Choose one of the two",
                "Question",
                "Mechanic",
                "Physiotherapist",
                " 1 ",
                " of ",
                " 31 "));
        mCountQue = binding.countQuestionTwoPart;
        Button mOnePartButton = binding.OnePartButton;
        Button mTwoPartButton = binding.TwoPartButton;
        castTypesProfessionalDefinition();

        mOnePartButton.setOnClickListener(view -> {

            if (QuestionCount == 1) {
                collectList(ProfessionOnePart, 0);
            }
            collectList(ProfessionOnePart, QuestionCount);
            mOnePartButton.setText(setItemListOnePart(ProfessionOnePart, QuestionCount));
            mTwoPartButton.setText(setItemListTwoPart(ProfessionTwoPart, QuestionCount));
            QuestionCount++;
            countView(QuestionCount);

        });


        mTwoPartButton.setOnClickListener(view -> {
            if (QuestionCount == 1) {
                collectList(ProfessionTwoPart, 0);
            }

            collectList(ProfessionTwoPart, QuestionCount);
            mOnePartButton.setText(setItemListOnePart(ProfessionOnePart, QuestionCount));
            mTwoPartButton.setText(setItemListTwoPart(ProfessionTwoPart, QuestionCount));
            QuestionCount++;

            countView(QuestionCount);
        });

        return binding.getRoot();
    }

    public void castTypesProfessionalDefinition() {
        ProfessionOnePart.add(new ProfessionalDefinition(getIdDefenitionOnePart(0), getIndexDefenitionOnePart(0), getProfessionOnePart(0)));
        ProfessionOnePart.add(new ProfessionalDefinition(getIdDefenitionOnePart(1), getIndexDefenitionOnePart(1), getProfessionOnePart(1)));
        ProfessionOnePart.add(new ProfessionalDefinition(getIdDefenitionOnePart(2), getIndexDefenitionOnePart(2), getProfessionOnePart(2)));
        ProfessionOnePart.add(new ProfessionalDefinition(getIdDefenitionOnePart(3), getIndexDefenitionOnePart(3), getProfessionOnePart(3)));
        ProfessionOnePart.add(new ProfessionalDefinition(getIdDefenitionOnePart(4), getIndexDefenitionOnePart(4), getProfessionOnePart(4)));
        ProfessionOnePart.add(new ProfessionalDefinition(getIdDefenitionOnePart(5), getIndexDefenitionOnePart(5), getProfessionOnePart(5)));
        ProfessionOnePart.add(new ProfessionalDefinition(getIdDefenitionOnePart(6), getIndexDefenitionOnePart(6), getProfessionOnePart(6)));
        ProfessionOnePart.add(new ProfessionalDefinition(getIdDefenitionOnePart(7), getIndexDefenitionOnePart(7), getProfessionOnePart(7)));
        ProfessionOnePart.add(new ProfessionalDefinition(getIdDefenitionOnePart(8), getIndexDefenitionOnePart(8), getProfessionOnePart(8)));
        ProfessionOnePart.add(new ProfessionalDefinition(getIdDefenitionOnePart(9), getIndexDefenitionOnePart(9), getProfessionOnePart(9)));
        ProfessionOnePart.add(new ProfessionalDefinition(getIdDefenitionOnePart(10), getIndexDefenitionOnePart(10), getProfessionOnePart(10)));
        ProfessionOnePart.add(new ProfessionalDefinition(getIdDefenitionOnePart(11), getIndexDefenitionOnePart(11), getProfessionOnePart(11)));
        ProfessionOnePart.add(new ProfessionalDefinition(getIdDefenitionOnePart(12), getIndexDefenitionOnePart(12), getProfessionOnePart(12)));
        ProfessionOnePart.add(new ProfessionalDefinition(getIdDefenitionOnePart(13), getIndexDefenitionOnePart(13), getProfessionOnePart(13)));
        ProfessionOnePart.add(new ProfessionalDefinition(getIdDefenitionOnePart(14), getIndexDefenitionOnePart(14), getProfessionOnePart(14)));
        ProfessionOnePart.add(new ProfessionalDefinition(getIdDefenitionOnePart(15), getIndexDefenitionOnePart(15), getProfessionOnePart(15)));
        ProfessionOnePart.add(new ProfessionalDefinition(getIdDefenitionOnePart(16), getIndexDefenitionOnePart(16), getProfessionOnePart(16)));
        ProfessionOnePart.add(new ProfessionalDefinition(getIdDefenitionOnePart(17), getIndexDefenitionOnePart(17), getProfessionOnePart(17)));
        ProfessionOnePart.add(new ProfessionalDefinition(getIdDefenitionOnePart(18), getIndexDefenitionOnePart(18), getProfessionOnePart(18)));
        ProfessionOnePart.add(new ProfessionalDefinition(getIdDefenitionOnePart(19), getIndexDefenitionOnePart(19), getProfessionOnePart(19)));
        ProfessionOnePart.add(new ProfessionalDefinition(getIdDefenitionOnePart(20), getIndexDefenitionOnePart(20), getProfessionOnePart(20)));
        ProfessionOnePart.add(new ProfessionalDefinition(getIdDefenitionOnePart(21), getIndexDefenitionOnePart(21), getProfessionOnePart(21)));
        ProfessionOnePart.add(new ProfessionalDefinition(getIdDefenitionOnePart(22), getIndexDefenitionOnePart(22), getProfessionOnePart(22)));
        ProfessionOnePart.add(new ProfessionalDefinition(getIdDefenitionOnePart(23), getIndexDefenitionOnePart(23), getProfessionOnePart(23)));
        ProfessionOnePart.add(new ProfessionalDefinition(getIdDefenitionOnePart(24), getIndexDefenitionOnePart(24), getProfessionOnePart(24)));
        ProfessionOnePart.add(new ProfessionalDefinition(getIdDefenitionOnePart(25), getIndexDefenitionOnePart(25), getProfessionOnePart(25)));
        ProfessionOnePart.add(new ProfessionalDefinition(getIdDefenitionOnePart(26), getIndexDefenitionOnePart(26), getProfessionOnePart(26)));
        ProfessionOnePart.add(new ProfessionalDefinition(getIdDefenitionOnePart(27), getIndexDefenitionOnePart(27), getProfessionOnePart(27)));
        ProfessionOnePart.add(new ProfessionalDefinition(getIdDefenitionOnePart(28), getIndexDefenitionOnePart(28), getProfessionOnePart(28)));
        ProfessionOnePart.add(new ProfessionalDefinition(getIdDefenitionOnePart(29), getIndexDefenitionOnePart(29), getProfessionOnePart(29)));
        ProfessionOnePart.add(new ProfessionalDefinition(getIdDefenitionOnePart(29), getIndexDefenitionOnePart(29), getProfessionOnePart(29)));

        ProfessionTwoPart.add(new ProfessionalDefinition(getIdDefenitionTwoPart(0), getIndexDefenitionTwoPart(0), getProfessionTwoPart(0)));
        ProfessionTwoPart.add(new ProfessionalDefinition(getIdDefenitionTwoPart(1), getIndexDefenitionTwoPart(1), getProfessionTwoPart(1)));
        ProfessionTwoPart.add(new ProfessionalDefinition(getIdDefenitionTwoPart(2), getIndexDefenitionTwoPart(2), getProfessionTwoPart(2)));
        ProfessionTwoPart.add(new ProfessionalDefinition(getIdDefenitionTwoPart(3), getIndexDefenitionTwoPart(3), getProfessionTwoPart(3)));
        ProfessionTwoPart.add(new ProfessionalDefinition(getIdDefenitionTwoPart(4), getIndexDefenitionTwoPart(4), getProfessionTwoPart(4)));
        ProfessionTwoPart.add(new ProfessionalDefinition(getIdDefenitionTwoPart(5), getIndexDefenitionTwoPart(5), getProfessionTwoPart(5)));
        ProfessionTwoPart.add(new ProfessionalDefinition(getIdDefenitionTwoPart(6), getIndexDefenitionTwoPart(6), getProfessionTwoPart(6)));
        ProfessionTwoPart.add(new ProfessionalDefinition(getIdDefenitionTwoPart(7), getIndexDefenitionTwoPart(7), getProfessionTwoPart(7)));
        ProfessionTwoPart.add(new ProfessionalDefinition(getIdDefenitionTwoPart(8), getIndexDefenitionTwoPart(8), getProfessionTwoPart(8)));
        ProfessionTwoPart.add(new ProfessionalDefinition(getIdDefenitionTwoPart(9), getIndexDefenitionTwoPart(9), getProfessionTwoPart(9)));
        ProfessionTwoPart.add(new ProfessionalDefinition(getIdDefenitionTwoPart(10), getIndexDefenitionTwoPart(10), getProfessionTwoPart(10)));
        ProfessionTwoPart.add(new ProfessionalDefinition(getIdDefenitionTwoPart(11), getIndexDefenitionTwoPart(11), getProfessionTwoPart(11)));
        ProfessionTwoPart.add(new ProfessionalDefinition(getIdDefenitionTwoPart(12), getIndexDefenitionTwoPart(12), getProfessionTwoPart(12)));
        ProfessionTwoPart.add(new ProfessionalDefinition(getIdDefenitionTwoPart(13), getIndexDefenitionTwoPart(13), getProfessionTwoPart(13)));
        ProfessionTwoPart.add(new ProfessionalDefinition(getIdDefenitionTwoPart(14), getIndexDefenitionTwoPart(14), getProfessionTwoPart(14)));
        ProfessionTwoPart.add(new ProfessionalDefinition(getIdDefenitionTwoPart(15), getIndexDefenitionTwoPart(15), getProfessionTwoPart(15)));
        ProfessionTwoPart.add(new ProfessionalDefinition(getIdDefenitionTwoPart(16), getIndexDefenitionTwoPart(16), getProfessionTwoPart(16)));
        ProfessionTwoPart.add(new ProfessionalDefinition(getIdDefenitionTwoPart(17), getIndexDefenitionTwoPart(17), getProfessionTwoPart(17)));
        ProfessionTwoPart.add(new ProfessionalDefinition(getIdDefenitionTwoPart(18), getIndexDefenitionTwoPart(18), getProfessionTwoPart(18)));
        ProfessionTwoPart.add(new ProfessionalDefinition(getIdDefenitionTwoPart(19), getIndexDefenitionTwoPart(19), getProfessionTwoPart(19)));
        ProfessionTwoPart.add(new ProfessionalDefinition(getIdDefenitionTwoPart(20), getIndexDefenitionTwoPart(20), getProfessionTwoPart(20)));
        ProfessionTwoPart.add(new ProfessionalDefinition(getIdDefenitionTwoPart(21), getIndexDefenitionTwoPart(21), getProfessionTwoPart(21)));
        ProfessionTwoPart.add(new ProfessionalDefinition(getIdDefenitionTwoPart(22), getIndexDefenitionTwoPart(22), getProfessionTwoPart(22)));
        ProfessionTwoPart.add(new ProfessionalDefinition(getIdDefenitionTwoPart(23), getIndexDefenitionTwoPart(23), getProfessionTwoPart(23)));
        ProfessionTwoPart.add(new ProfessionalDefinition(getIdDefenitionTwoPart(24), getIndexDefenitionTwoPart(24), getProfessionTwoPart(24)));
        ProfessionTwoPart.add(new ProfessionalDefinition(getIdDefenitionTwoPart(25), getIndexDefenitionTwoPart(25), getProfessionTwoPart(25)));
        ProfessionTwoPart.add(new ProfessionalDefinition(getIdDefenitionTwoPart(26), getIndexDefenitionTwoPart(26), getProfessionTwoPart(26)));
        ProfessionTwoPart.add(new ProfessionalDefinition(getIdDefenitionTwoPart(27), getIndexDefenitionTwoPart(27), getProfessionTwoPart(27)));
        ProfessionTwoPart.add(new ProfessionalDefinition(getIdDefenitionTwoPart(28), getIndexDefenitionTwoPart(28), getProfessionTwoPart(28)));
        ProfessionTwoPart.add(new ProfessionalDefinition(getIdDefenitionTwoPart(29), getIndexDefenitionTwoPart(29), getProfessionTwoPart(29)));
        ProfessionTwoPart.add(new ProfessionalDefinition(getIdDefenitionTwoPart(29), getIndexDefenitionTwoPart(29), getProfessionTwoPart(29)));

    }

    public int getIdDefenitionOnePart(int i) {
        return professionDataLists.get(i).getProfessionOnePart().get(0).getIdDefinition();
    }

    public int getIndexDefenitionOnePart(int i) {
        return professionDataLists.get(i).getProfessionOnePart().get(0).getIndexDefenition();
    }

    public String getProfessionOnePart(int i) {
        return professionDataLists.get(i).getProfessionOnePart().get(0).getProfession();
    }

    public int getIdDefenitionTwoPart(int i) {
        return professionDataLists.get(i).getProfessionTwoPart().get(0).getIdDefinition();
    }

    public int getIndexDefenitionTwoPart(int i) {
        return professionDataLists.get(i).getProfessionTwoPart().get(0).getIndexDefenition();
    }

    public String getProfessionTwoPart(int i) {
        return professionDataLists.get(i).getProfessionTwoPart().get(0).getProfession();
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
        if (getProfessionThreePart().size() > professionDataLists.size()) {
            collectInteresGroups();
            replaceFragment("YES", mHashInterest);
            restoreCount=String.valueOf(QuestionCount);
        }

    }

    @Override
    public void replaceFragment(String key, HashMap hashMap) {
        mSentDataFragment.onSendDataProfessionDefinition(key, hashMap);

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

        String[] mNameGroupInteres = {"realist", "intellectual", "social", "office", "entrepreneurial", "artistic"};
        int[] arrays = {1, 2, 3, 4, 5, 6};

        for (int i = 0; i <= arr.length - 1; i++) {
            if (inGroup(mHigh.getLowInterest(), mHigh.getHighInterest(), arr[i])) {
                collectInterestHigh(arrays[i], HighInterestBefore);
                HighIntGroup.add(mNameGroupInteres[i]);
            } else if (inGroup(mMiddle.getLowInterest(), mMiddle.getHighInterest(), arr[i])) {
                collectInterestMiddle(arrays[i], MiddleInterestBefore);
                MiddleIntGroup.add(mNameGroupInteres[i]);
            } else if (inGroup(mLow.getLowInterest(), mLow.getHighInterest(), arr[i])) {
                collectInterestLow(arrays[i], LowInterestBefore);
                LowIntGroup.add(mNameGroupInteres[i]);
            }
        }
        createHashMapIntGroup(HIGH_INT_KEY, HighIntGroup);
        createHashMapIntGroup(MIDDLE_INT_KEY, MiddleIntGroup);
        createHashMapIntGroup(LOW_INT_KEY, LowIntGroup);
    }

    public void collectInterestHigh(int group, List<String> name) {
        HighInterestBefore = ProfessionThreePart.stream().filter((p) -> p.getIdDefiniton() == group).
                map(ProfessionalDefinition::getProfession).collect(Collectors.toList());
        if (HighInterestBefore.size() != 0)
            HighInterest.addAll(HighInterestBefore);

    }

    private void createHashMapIntGroup(String key, List<String> name) {
        mHashInterest.put(key, name);
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

    public interface sentDataFragmentProfessionDefenition {

        void onSendDataProfessionDefinition(String d, HashMap hashMap);


    }

    sentDataFragmentProfessionDefenition mSentDataFragment;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mSentDataFragment = (sentDataFragmentProfessionDefenition) context;
    }


}