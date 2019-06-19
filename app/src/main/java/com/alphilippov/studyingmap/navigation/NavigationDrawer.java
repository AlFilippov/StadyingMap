package com.alphilippov.studyingmap.navigation;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.alphilippov.studyingmap.R;
import com.alphilippov.studyingmap.fragments.InformationAboutCourse;
import com.alphilippov.studyingmap.fragments.ProfessionDefinition;
import com.alphilippov.studyingmap.fragments.ResultOfCoursesAfterSearch;
import com.alphilippov.studyingmap.fragments.ResultOfCoursesAfterTests;
import com.alphilippov.studyingmap.fragments.SearchCourseInUdemy;
import com.alphilippov.studyingmap.fragments.VariableLearning;
import com.alphilippov.studyingmap.network.RestService;
import com.alphilippov.studyingmap.network.dto.ArtisticCategoryDTO;
import com.alphilippov.studyingmap.network.dto.GetProfessionDTO;
import com.alphilippov.studyingmap.network.dto.ProfessionDataListDTO;
import com.alphilippov.studyingmap.network.dto.SelectCategoriesDTO;
import com.alphilippov.studyingmap.utils.AppConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class NavigationDrawer extends MainActivity
        implements NavigationView.OnNavigationItemSelectedListener, VariableLearning.OnChangedFragment,
        ProfessionDefinition.sentDataFragmentProfessionDefenition,
        ResultOfCoursesAfterTests.sentDataInInformationAboutCourse, SearchCourseInUdemy.replaceFragment {
    private static final String YES_DECIDED = "ydecided";
    private static final String WANT_DEFENITION = "wdecided";
    private static final String YES = "YES";
    private static final String SEARCH_RESULT = "result";
    public List<ProfessionDataListDTO> professionDataLists = new ArrayList<>();
    public HashMap<String, List<ProfessionDataListDTO>> mHashMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        loadDataAboutProfession(0);
        loadSelectedCategoryAboutProfession(6);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        VariableLearning askMe = new VariableLearning();
        ft.add(R.id.container, askMe);
        ft.commit();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//TODO:Значок конверта - переделать в Избранное
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> Snackbar.make(view, "There will be your courses", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }


    public RestService configurationRetrofit() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit mRetrofit = new Retrofit.Builder()
                .baseUrl(AppConfig.BASE_URL_TWO)
                .client(client)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        return mRetrofit.create(RestService.class);
    }

    private void loadSelectedCategoryAboutProfession(int index) {
        configurationRetrofit().getCategoryRequest(index).enqueue(new Callback<SelectCategoriesDTO>() {
            @Override
            public void onResponse(Call<SelectCategoriesDTO> call, Response<SelectCategoriesDTO> response) {
                if (response.body().getArtisticCategories().size() != 0) {
                    List<ArtisticCategoryDTO> artisticCategories = response.body().getArtisticCategories();
                }
            }

            @Override
            public void onFailure(Call<SelectCategoriesDTO> call, Throwable t) {

            }
        });
    }

    //Передача параметров в фрагмент ProfessionDefenition
    public void loadDataAboutProfession(int index) {
        configurationRetrofit().getAllProfession(index).enqueue(new Callback<GetProfessionDTO>() {
            @Override
            public void onResponse(Call<GetProfessionDTO> call, Response<GetProfessionDTO> response) {
                response.body().getProfessionDataLists();
                professionDataLists.addAll(response.body().getProfessionDataLists());
                mHashMap.put(WANT_DEFENITION, professionDataLists);
            }

            @Override
            public void onFailure(Call<GetProfessionDTO> call, Throwable t) {

            }
        });
    }

    //Реализация вызова фрагмента с информацие о варианте поиска курсов
    @Override
    public void ChangeFragmentAskMe(String s) {
        if (s.equals(YES_DECIDED)) {
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            SearchCourseInUdemy searchCourseInUdemy = new SearchCourseInUdemy();
            ft.addToBackStack(null);
            ft.replace(R.id.container, searchCourseInUdemy);
            ft.commit();
        } else if (s.equals(WANT_DEFENITION)) {
            Bundle bundle = new Bundle();
            bundle.putSerializable(WANT_DEFENITION, mHashMap);
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ProfessionDefinition professionDefinition = new ProfessionDefinition();
            professionDefinition.setArguments(bundle);
            ft.addToBackStack(null);
            ft.replace(R.id.container, professionDefinition);
            ft.commit();
        }
    }

    //Реализация вызова фрагмента с информаций о пройденном тесте
    @Override
    public void onSendDataProfessionDefinition(String d, HashMap hashMap) {
        if (d.equals(YES)) {
            Bundle bundle = new Bundle();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ResultOfCoursesAfterTests sR = new ResultOfCoursesAfterTests();
            bundle.putSerializable(SEARCH_RESULT, hashMap);
            sR.setArguments(bundle);
            ft.addToBackStack(null);
            ft.replace(R.id.container, sR);
            ft.commit();
        }
    }

    //Реализация вызова фрагмента с информация о определенном курсе
    @Override
    public void onSentDataInInformationAbCourse(String key, HashMap hashmap) {
        if (key.equals("info")) {
            Bundle bundle = new Bundle();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            InformationAboutCourse informationAboutCourse = new InformationAboutCourse();
            bundle.putSerializable("info", hashmap);
            informationAboutCourse.setArguments(bundle);
            ft.replace(R.id.container, informationAboutCourse);
            ft.addToBackStack(null);
            ft.commit();
        }
    }

    //Реализация вызова фрагмента и передача ему ключегового слова
    @Override
    public void sentDataInSearchInUdemy(String keyChangeFragment, String keyWords) {
        if (keyChangeFragment.equals("ok")) {
            Bundle bundle = new Bundle();
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            ResultOfCoursesAfterSearch resultOfCoursesBeforeSearch = new ResultOfCoursesAfterSearch();
            bundle.putString("ok", keyWords);
            resultOfCoursesBeforeSearch.setArguments(bundle);
            fragmentTransaction.replace(R.id.container, resultOfCoursesBeforeSearch);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }


    //Проверяется открыта ли шторка , при нажатии кнопки назад
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // раздувает меню; это добавляет элементы в панель действий, если она присутствует.
        getMenuInflater().inflate(R.menu.navigation_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Обрабатывает щелчки элементов панели действий здесь.

        int id = item.getItemId();


        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //Обрабатывает навигацию по меню

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.nav_news) {
        } else if (id == R.id.nav_lessons) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            VariableLearning askMe = new VariableLearning();
            ft.add(R.id.container, askMe);
            ft.commit();
        } else if (id == R.id.nav_tasks) {

        } else if (id == R.id.nav_settings) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }
        item.setChecked(true);
        setTitle(item.getTitle());
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
