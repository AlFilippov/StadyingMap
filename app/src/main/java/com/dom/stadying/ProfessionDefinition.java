package com.dom.stadying;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProfessionDefinition extends Fragment {
    private TextView textview;
    private static List<ProfessionalDefinition> ProfessionOnePart = new ArrayList<>();
    private static List<ProfessionalDefinition> ProfessionTwoPart = new ArrayList<>();
    private static List<ProfessionalDefinition> ProfessionThreePart = new ArrayList<>();
    public List<String> listRealist = new ArrayList<>();
    public List<String> listIntellectual = new ArrayList<>();
    public List<String> listSocial = new ArrayList<>();
    public List<String> listOffice = new ArrayList<>();
    public List<String> listEntrepreneurial = new ArrayList<>();
    public List<String> listArtistic = new ArrayList<>();

    private int mQuestionCount;
    private Button mOnePartButton;
    private Button mTwoPartButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View ProfDef = inflater.inflate(R.layout.profession_definition, container, false);
        textview = ProfDef.findViewById(R.id.askMe1);
        initializeObjectProfession();
        mOnePartButton.findViewById(R.id.OnePartButton);
        mOnePartButton.setText(ProfessionOnePart.get(0).getProfession());
        mTwoPartButton.setText(ProfessionTwoPart.get(0).getProfession());
        if (mQuestionCount <= 30) {
            mOnePartButton.setOnClickListener(view -> {
                if (mQuestionCount == 0) {
                    ProfessionThreePart.add(ProfessionOnePart.get(mQuestionCount));
                } else {
                    mOnePartButton.setText(ProfessionOnePart.get(mQuestionCount).getProfession());
                    mTwoPartButton.setText(ProfessionTwoPart.get(mQuestionCount).getProfession());
                    ProfessionThreePart.add(ProfessionOnePart.get(mQuestionCount));
                }
                mQuestionCount++;

            });
            mTwoPartButton.findViewById(R.id.TwoPartButton);
            mTwoPartButton.setOnClickListener(view -> {
                if (mQuestionCount == 0) {
                    ProfessionThreePart.add(ProfessionTwoPart.get(mQuestionCount));
                } else {
                    mOnePartButton.setText(ProfessionOnePart.get(mQuestionCount).getProfession());
                    mTwoPartButton.setText(ProfessionTwoPart.get(mQuestionCount).getProfession());
                    ProfessionThreePart.add(ProfessionTwoPart.get(mQuestionCount));
                }
                mQuestionCount++;


            });
            determineInteres();

        } else {
            // TODO: Переходим на следующий экран с выбором
        }
        return ProfDef;
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
        int realist = (int) ProfessionThreePart.stream().filter((p) -> p.getIdDefiniton() == 1).count();
        int intellectual = (int) ProfessionThreePart.stream().filter((p) -> p.getIdDefiniton() == 2).count();
        int social = (int) ProfessionThreePart.stream().filter((p) -> p.getIdDefiniton() == 3).count();
        int office = (int) ProfessionThreePart.stream().filter((p) -> p.getIdDefiniton() == 4).count();
        int entrepreneurial = (int) ProfessionThreePart.stream().filter((p) -> p.getIdDefiniton() == 5).count();
        int artistic = (int) ProfessionThreePart.stream().filter((p) -> p.getIdDefiniton() == 6).count();
        if (5 <= realist && realist <= 9)
            listRealist = ProfessionThreePart.stream().filter((p) -> p.getIdDefiniton() == 1).
                    map(ProfessionalDefinition::getProfession).collect(Collectors.toList());
        else if (5 <= intellectual && intellectual <= 10)
            listIntellectual = ProfessionThreePart.stream().filter((p) -> p.getIdDefiniton() == 2).
                    map(ProfessionalDefinition::getProfession).collect(Collectors.toList());
        else if (5 <= social && social <= 10)
            listSocial = ProfessionThreePart.stream().filter((p) -> p.getIdDefiniton() == 3).
                    map(ProfessionalDefinition::getProfession).collect(Collectors.toList());
        else if (5 <= office && office <= 10)
            listOffice = ProfessionThreePart.stream().filter((p) -> p.getIdDefiniton() == 4).
                    map(ProfessionalDefinition::getProfession).collect(Collectors.toList());
        else if (5 <= entrepreneurial && entrepreneurial <= 10)
            listEntrepreneurial = ProfessionThreePart.stream().filter((p) -> p.getIdDefiniton() == 5).
                    map(ProfessionalDefinition::getProfession).collect(Collectors.toList());
        else if (5 <= artistic && artistic <= 10)
            listArtistic = ProfessionThreePart.stream().filter((p) -> p.getIdDefiniton() == 6).
                    map(ProfessionalDefinition::getProfession).collect(Collectors.toList());

    }

}


