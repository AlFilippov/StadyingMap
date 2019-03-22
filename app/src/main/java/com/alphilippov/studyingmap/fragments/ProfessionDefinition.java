package com.alphilippov.studyingmap.fragments;

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
import com.alphilippov.studyingmap.utils.AppConfig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class ProfessionDefinition extends Fragment {
    private static List<ProfessionalDefinition> ProfessionOnePart = new ArrayList<>();
    private static List<ProfessionalDefinition> ProfessionTwoPart = new ArrayList<>();
    private static List<ProfessionalDefinition> ProfessionThreePart = new ArrayList<>();
    public List<String> mHighInterest = new ArrayList<>();
    public List<String> mMiddleInterest = new ArrayList<>();
    public List<String> mLowInterest = new ArrayList<>();
    private int mQuestionCount;
    private TextView mCountQue;

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

        initializeObjectProfession();
        int questionList = ProfessionOnePart.size() + ProfessionTwoPart.size();
        mCountQue=binding.countQuestionTwoPart;
        TextView quantityQuestion = binding.countQuestionFourPart;
        Button mOnePartButton = binding.OnePartButton;
        Button mTwoPartButton = binding.TwoPartButton;
        mOnePartButton.setText(ProfessionOnePart.get(0).getProfession());
        mTwoPartButton.setText(ProfessionTwoPart.get(0).getProfession());
        if (mQuestionCount <= AppConfig.QUANTITY_QUESTIONS) {
            mOnePartButton.setOnClickListener(view -> {
                if (mQuestionCount == 0) {
                    ProfessionThreePart.add(ProfessionOnePart.get(mQuestionCount));
                    mOnePartButton.setText(ProfessionOnePart.get(1).getProfession());
                    mTwoPartButton.setText(ProfessionTwoPart.get(1).getProfession());
                    mQuestionCount++;
                } else {
                    mOnePartButton.setText(ProfessionOnePart.get(mQuestionCount).getProfession());
                    mTwoPartButton.setText(ProfessionTwoPart.get(mQuestionCount).getProfession());
                    ProfessionThreePart.add(ProfessionOnePart.get(mQuestionCount));
                }
                mQuestionCount++;
                String s = String.valueOf(mQuestionCount);
                mCountQue.setText(s);
//                String form = getString(R.string.quest_profdef).concat(" ") + mQuestionCount + " " + getString(R.string.quest_profdef_continue).concat(getString(R.string.quest_profdef_continue_two));
//                mCountQue.setText(form);
                //   mCountQue.setText(form);
            });
            mTwoPartButton.findViewById(R.id.TwoPartButton);
            mTwoPartButton.setOnClickListener(view -> {
                if (mQuestionCount == 0) {
                    ProfessionThreePart.add(ProfessionTwoPart.get(mQuestionCount));
                    mOnePartButton.setText(ProfessionOnePart.get(1).getProfession());
                    mTwoPartButton.setText(ProfessionTwoPart.get(1).getProfession());
                    mQuestionCount++;
                } else {
                    mOnePartButton.setText(ProfessionOnePart.get(mQuestionCount).getProfession());
                    mTwoPartButton.setText(ProfessionTwoPart.get(mQuestionCount).getProfession());
                    ProfessionThreePart.add(ProfessionTwoPart.get(mQuestionCount));
                }
                mQuestionCount++;
                String s = String.valueOf(mQuestionCount);
                mCountQue.setText(s);
//                String form = getString(R.string.quest_profdef).concat(" ") + mQuestionCount + " " + getString(R.string.quest_profdef_continue).concat(getString(R.string.quest_profdef_continue_two));
//                mCountQue.setText(form);
            });
            determineInteres();

        } else {
            // TODO: Переходим на следующий экран с выбором

        }
        return binding.getRoot();
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
        ProfessionOnePart.add(new ProfessionalDefinition(2, 26, "Лингвист"));
        ProfessionOnePart.add(new ProfessionalDefinition(4, 27, "Корректор"));
        ProfessionOnePart.add(new ProfessionalDefinition(1, 28, "Наборщик текстов"));
        ProfessionOnePart.add(new ProfessionalDefinition(2, 29, "Программист"));
        ProfessionOnePart.add(new ProfessionalDefinition(4, 30, "Бухгалтер"));

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
    }

    private void determineInteres() {
        int realist = (int) ProfessionThreePart.stream().filter((p) -> p.getIdDefiniton() == AppConfig.REALIST_GROUP).count();
        int intellectual = (int) ProfessionThreePart.stream().filter((p) -> p.getIdDefiniton() == AppConfig.INTELLECTUAL_GROUP).count();
        int social = (int) ProfessionThreePart.stream().filter((p) -> p.getIdDefiniton() == AppConfig.SOCIAL_GROUP).count();
        int office = (int) ProfessionThreePart.stream().filter((p) -> p.getIdDefiniton() == AppConfig.OFFICE_GROUP).count();
        int entrepreneurial = (int) ProfessionThreePart.stream().filter((p) -> p.getIdDefiniton() == AppConfig.ENTREPRENEURIAL_GROUP).count();
        int artistic = (int) ProfessionThreePart.stream().filter((p) -> p.getIdDefiniton() == AppConfig.ARTISTIC_GROUP).count();

        if (7 <= realist && realist <= 9)
            mHighInterest = ProfessionThreePart.stream().filter((p) -> p.getIdDefiniton() == AppConfig.REALIST_GROUP).
                    map(ProfessionalDefinition::getProfession).collect(Collectors.toList());
        else if (8 <= intellectual && intellectual <= 11)
            mHighInterest = ProfessionThreePart.stream().filter((p) -> p.getIdDefiniton() == AppConfig.INTELLECTUAL_GROUP).
                    map(ProfessionalDefinition::getProfession).collect(Collectors.toList());
        else if (8 <= social && social <= 10)
            mHighInterest = ProfessionThreePart.stream().filter((p) -> p.getIdDefiniton() == AppConfig.SOCIAL_GROUP).
                    map(ProfessionalDefinition::getProfession).collect(Collectors.toList());
        else if (8 <= office && office <= 10)
            mHighInterest = ProfessionThreePart.stream().filter((p) -> p.getIdDefiniton() == AppConfig.OFFICE_GROUP).
                    map(ProfessionalDefinition::getProfession).collect(Collectors.toList());
        else if (8 <= entrepreneurial && entrepreneurial <= 10)
            mHighInterest = ProfessionThreePart.stream().filter((p) -> p.getIdDefiniton() == AppConfig.ENTREPRENEURIAL_GROUP).
                    map(ProfessionalDefinition::getProfession).collect(Collectors.toList());
        else if (8 <= artistic && artistic <= 10)
            mHighInterest = ProfessionThreePart.stream().filter((p) -> p.getIdDefiniton() == AppConfig.ARTISTIC_GROUP).
                    map(ProfessionalDefinition::getProfession).collect(Collectors.toList());

        if (5 <= realist && realist <= 7)
            mMiddleInterest = ProfessionThreePart.stream().filter((p) -> p.getIdDefiniton() == AppConfig.REALIST_GROUP).
                    map(ProfessionalDefinition::getProfession).collect(Collectors.toList());
        else if (5 <= intellectual && intellectual <= 7)
            mMiddleInterest = ProfessionThreePart.stream().filter((p) -> p.getIdDefiniton() == AppConfig.INTELLECTUAL_GROUP).
                    map(ProfessionalDefinition::getProfession).collect(Collectors.toList());
        else if (5 <= social && social <= 7)
            mMiddleInterest = ProfessionThreePart.stream().filter((p) -> p.getIdDefiniton() == AppConfig.SOCIAL_GROUP).
                    map(ProfessionalDefinition::getProfession).collect(Collectors.toList());
        else if (5 <= office && office <= 7)
            mMiddleInterest = ProfessionThreePart.stream().filter((p) -> p.getIdDefiniton() == AppConfig.OFFICE_GROUP).
                    map(ProfessionalDefinition::getProfession).collect(Collectors.toList());
        else if (5 <= entrepreneurial && entrepreneurial <= 7)
            mMiddleInterest = ProfessionThreePart.stream().filter((p) -> p.getIdDefiniton() == AppConfig.ENTREPRENEURIAL_GROUP).
                    map(ProfessionalDefinition::getProfession).collect(Collectors.toList());
        else if (5 <= artistic && artistic <= 7)
            mMiddleInterest = ProfessionThreePart.stream().filter((p) -> p.getIdDefiniton() == AppConfig.ARTISTIC_GROUP).
                    map(ProfessionalDefinition::getProfession).collect(Collectors.toList());
        if (0 <= realist && realist <= 5)
            mLowInterest = ProfessionThreePart.stream().filter((p) -> p.getIdDefiniton() == AppConfig.REALIST_GROUP).
                    map(ProfessionalDefinition::getProfession).collect(Collectors.toList());
        else if (0 <= intellectual && intellectual <= 5)
            mLowInterest = ProfessionThreePart.stream().filter((p) -> p.getIdDefiniton() == AppConfig.INTELLECTUAL_GROUP).
                    map(ProfessionalDefinition::getProfession).collect(Collectors.toList());
        else if (0 <= social && social <= 5)
            mLowInterest = ProfessionThreePart.stream().filter((p) -> p.getIdDefiniton() == AppConfig.SOCIAL_GROUP).
                    map(ProfessionalDefinition::getProfession).collect(Collectors.toList());
        else if (0 <= office && office <= 5)
            mLowInterest = ProfessionThreePart.stream().filter((p) -> p.getIdDefiniton() == AppConfig.OFFICE_GROUP).
                    map(ProfessionalDefinition::getProfession).collect(Collectors.toList());
        else if (0 <= entrepreneurial && entrepreneurial <= 5)
            mLowInterest = ProfessionThreePart.stream().filter((p) -> p.getIdDefiniton() == AppConfig.ENTREPRENEURIAL_GROUP).
                    map(ProfessionalDefinition::getProfession).collect(Collectors.toList());
        else if (0 <= artistic && artistic <= 5)
            mLowInterest = ProfessionThreePart.stream().filter((p) -> p.getIdDefiniton() == AppConfig.ARTISTIC_GROUP).
                    map(ProfessionalDefinition::getProfession).collect(Collectors.toList());


    }

}


