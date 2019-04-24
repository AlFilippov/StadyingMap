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
        ProfessionOnePart.add(new ProfessionalDefinition(1, 0, "Автомеханик"));
        ProfessionOnePart.add(new ProfessionalDefinition(2, 1, "Специалист по информационной безопасности"));
        ProfessionOnePart.add(new ProfessionalDefinition(4, 2, "Оператор связи"));
        ProfessionOnePart.add(new ProfessionalDefinition(1, 3, "Водитель"));
        ProfessionOnePart.add(new ProfessionalDefinition(2, 4, "Инженер-конструктор"));
        ProfessionOnePart.add(new ProfessionalDefinition(4, 5, "Авиадиспетчер"));
        ProfessionOnePart.add(new ProfessionalDefinition(1, 6, "Ветеринар"));
        ProfessionOnePart.add(new ProfessionalDefinition(2, 7, "Разработчик-игр "));
        ProfessionOnePart.add(new ProfessionalDefinition(4, 8, "Лаборант"));
        ProfessionOnePart.add(new ProfessionalDefinition(1, 9, "Агроном"));
        ProfessionOnePart.add(new ProfessionalDefinition(2, 10, "Селекционер"));
        ProfessionOnePart.add(new ProfessionalDefinition(4, 11, "Маркетолог"));
        ProfessionOnePart.add(new ProfessionalDefinition(1, 12, "Массажист"));
        ProfessionOnePart.add(new ProfessionalDefinition(2, 13, "Преподаватель"));
        ProfessionOnePart.add(new ProfessionalDefinition(4, 14, "Администратор заведений"));
        ProfessionOnePart.add(new ProfessionalDefinition(1, 15, "Официант"));
        ProfessionOnePart.add(new ProfessionalDefinition(2, 16, "Психолог"));
        ProfessionOnePart.add(new ProfessionalDefinition(4, 17, "Страховой агент"));
        ProfessionOnePart.add(new ProfessionalDefinition(1, 18, "Ювелир-гравер"));
        ProfessionOnePart.add(new ProfessionalDefinition(2, 19, "Искусствовед"));
        ProfessionOnePart.add(new ProfessionalDefinition(4, 20, "Редактор"));
        ProfessionOnePart.add(new ProfessionalDefinition(1, 21, "Дизайнер интерьера"));
        ProfessionOnePart.add(new ProfessionalDefinition(2, 23, "Тестировщик ПО"));
        ProfessionOnePart.add(new ProfessionalDefinition(4, 24, "Копирайтер"));
        ProfessionOnePart.add(new ProfessionalDefinition(2, 25, "Системный администратор"));
        ProfessionOnePart.add(new ProfessionalDefinition(1, 26, "Плотник"));
        ProfessionOnePart.add(new ProfessionalDefinition(4, 27, "Корректор"));
        ProfessionOnePart.add(new ProfessionalDefinition(1, 28, "Наборщик текстов"));
        ProfessionOnePart.add(new ProfessionalDefinition(2, 29, "Программист"));
        ProfessionOnePart.add(new ProfessionalDefinition(4, 30, "Бухгалтер"));
        ProfessionOnePart.add(new ProfessionalDefinition(7, 30, "Бухгалтер"));

        ProfessionTwoPart.add(new ProfessionalDefinition(3, 0, "Физиотерапевт"));
        ProfessionTwoPart.add(new ProfessionalDefinition(5, 1, "Специалист по логистике"));
        ProfessionTwoPart.add(new ProfessionalDefinition(6, 2, "Кинооператор"));
        ProfessionTwoPart.add(new ProfessionalDefinition(3, 3, "Кассир"));
        ProfessionTwoPart.add(new ProfessionalDefinition(5, 4, "Менеджер по автопродажам"));
        ProfessionTwoPart.add(new ProfessionalDefinition(6, 5, "Web-дизайнер"));
        ProfessionTwoPart.add(new ProfessionalDefinition(3, 6, "Эколог"));
        ProfessionTwoPart.add(new ProfessionalDefinition(5, 7, "Фермер"));
        ProfessionTwoPart.add(new ProfessionalDefinition(6, 8, "SEO-специалист "));
        ProfessionTwoPart.add(new ProfessionalDefinition(3, 9, "Санитарный врач"));
        ProfessionTwoPart.add(new ProfessionalDefinition(5, 10, "Заготовитель сельхозпродуктов"));
        ProfessionTwoPart.add(new ProfessionalDefinition(6, 11, "Ландшафтный дизайнер"));
        ProfessionTwoPart.add(new ProfessionalDefinition(3, 12, "Воспитатель"));
        ProfessionTwoPart.add(new ProfessionalDefinition(5, 13, "Предприниматель"));
        ProfessionTwoPart.add(new ProfessionalDefinition(6, 14, "Художник-мультипликатор"));
        ProfessionTwoPart.add(new ProfessionalDefinition(3, 15, "Врач"));
        ProfessionTwoPart.add(new ProfessionalDefinition(5, 16, "Торговый агент"));
        ProfessionTwoPart.add(new ProfessionalDefinition(6, 17, "Хореограф"));
        ProfessionTwoPart.add(new ProfessionalDefinition(3, 18, "Журналист"));
        ProfessionTwoPart.add(new ProfessionalDefinition(5, 19, "Продюссер"));
        ProfessionTwoPart.add(new ProfessionalDefinition(6, 21, "Музыкант"));
        ProfessionTwoPart.add(new ProfessionalDefinition(3, 22, "Экскурсовод"));
        ProfessionTwoPart.add(new ProfessionalDefinition(5, 23, "Арт-директор"));
        ProfessionTwoPart.add(new ProfessionalDefinition(6, 24, "Актер театра и кино"));
        ProfessionTwoPart.add(new ProfessionalDefinition(3, 25, "Гид-переводчик"));
        ProfessionTwoPart.add(new ProfessionalDefinition(5, 26, "Антикризисный управляющий"));
        ProfessionTwoPart.add(new ProfessionalDefinition(6, 27, "Художественный редактор"));
        ProfessionTwoPart.add(new ProfessionalDefinition(3, 28, "Юрисконсультр"));
        ProfessionTwoPart.add(new ProfessionalDefinition(5, 29, "Брокер"));
        ProfessionTwoPart.add(new ProfessionalDefinition(6, 30, "Литературный переводчик"));
        ProfessionTwoPart.add(new ProfessionalDefinition(7, 30, "Бухгалтер"));
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


