package com.alphilippov.studyingmap.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Toast;

import com.alphilippov.studyingmap.R;
import com.alphilippov.studyingmap.helperclasses.ReplaceFragment;
import com.alphilippov.studyingmap.network.RestService;
import com.alphilippov.studyingmap.network.dto.UserModelDto;
import com.alphilippov.studyingmap.ui.DataAdapter;
import com.alphilippov.studyingmap.ui.RecyclerViewClickListener;
import com.alphilippov.studyingmap.ui.RecyclerViewTouchListener;
import com.alphilippov.studyingmap.utils.AppConfig;
import com.google.common.io.BaseEncoding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class ResultOfCoursesAfterTests extends Fragment implements ReplaceFragment {

    public List<String> intellectualList = new ArrayList<>();
    public List<String> realistList = new ArrayList<>();
    public List<String> socialList = new ArrayList<>();
    public List<String> officeList = new ArrayList<>();
    public List<String> entrepreneuriaList = new ArrayList<>();
    public List<String> artistictList = new ArrayList<>();
    public List<List<String>> intGroup = new ArrayList<>();
    public List<String> selectionResultProfession = new ArrayList<>();
    private ArrayList<UserModelDto.Result> moreUserModel = new ArrayList<>();
    private ArrayList<UserModelDto.Result> userModeltoInfAboutCourse = new ArrayList<>();
    private HashMap<String, List<UserModelDto.Result>> mUserModelResult = new HashMap<>();
    private HashMap<String, List<String>> mListHashMap;
    private final static String TAG = ResultOfCoursesAfterTests.class.getSimpleName();
    private static final String SEARCH_RESULT = "result";
    private static final String HIGH_INT_KEY = "high";
    private static final String MIDDLE_INT_KEY = "middle";
    private static final String LOW_INT_KEY = "low";
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(getActivity());
    private boolean isScrolling;
    private int page = 1;
    private int indexInterest = 0;


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View qView = inflater.inflate(R.layout.search_result_of_courses, container, false);
        mRecyclerView = qView.findViewById(R.id.list);

        return qView;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataList();
        Bundle bundle = new Bundle(getArguments());
        mListHashMap = (HashMap<String, List<String>>) bundle.getSerializable(SEARCH_RESULT);
        compareGroup(mListHashMap);
        initRequest(page, indexInterest);


    }

    RecyclerView.OnScrollListener recyclerViewOnScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                isScrolling = true;
            }
        }

        @Override
        public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            int currentItems = mLinearLayoutManager.getChildCount();
            int totalItems = mLinearLayoutManager.getItemCount();
            int scrollItems = mLinearLayoutManager.findFirstVisibleItemPosition();
            if (isScrolling) {
                if ((currentItems + scrollItems) == totalItems
                        && scrollItems >= 0) {
                    isScrolling = false;
                    loadMoreInformation(page, indexInterest);
                    page++;
                    indexInterest++;


                }
            }
        }
    };

    public void initRequest(int page, int indexInterest) {
        configurationRetrofitForUdemyApi().getResult(page,
                AppConfig.PropertiesRequest.PAGE_SIZE,
                selectionResultProfession.get(indexInterest),
                AppConfig.PropertiesRequest.PRICE,
                AppConfig.PropertiesRequest.AFFILIATE,
                AppConfig.PropertiesRequest.LANGUAGE,
                AppConfig.PropertiesRequest.LEVEL_COURSES,
                AppConfig.PropertiesRequest.ORDERING,
                AppConfig.PropertiesRequest.RATINGS).enqueue(new Callback<UserModelDto>() {
            @Override
            public void onResponse(Call<UserModelDto> call, Response<UserModelDto> response) {
                moreUserModel.addAll(response.body().getResults());
                generateContent(moreUserModel);
            }

            @Override
            public void onFailure(Call<UserModelDto> call, Throwable t) {
                Log.d(TAG, t.toString());
            }
        });
    }

    public RestService configurationRetrofitForUdemyApi() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(chain -> {
            Request original = chain.request();
            Request.Builder requestBuilder = original.newBuilder()
                    .header("Authorization", "Basic " + getBasicAuthenticator());
            Request request = requestBuilder.build();
            return chain.proceed(request);
        }).addInterceptor(httpLoggingInterceptor).build();


        Retrofit mRetrofit = new Retrofit.Builder()
                .baseUrl(AppConfig.BASE_URL_UDEMY_API)
                .client(client)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        return mRetrofit.create(RestService.class);
    }

    private String getBasicAuthenticator() {
        String authStr = AppConfig.Authorization.CLIENT_ID + ":" + AppConfig.Authorization.CLIENT_SECRET;
        return BaseEncoding.base64().encode(authStr.getBytes());

    }

    private void compareGroup(HashMap hashMap) {
        String[] mNameGroupInterest = {"realist", "intellectual", "social", "office", "entrepreneurial", "artistic"};
        String[] keyArray = {HIGH_INT_KEY, MIDDLE_INT_KEY, LOW_INT_KEY};

        for (int j = 0; j <= keyArray.length - 1; j++) {
            for (int i = 0; i <= mNameGroupInterest.length - 1; i++) {
                if (getListIntHshMap(hashMap, keyArray[j]).contains(mNameGroupInterest[i])
                        && getListIntHshMap(hashMap, keyArray[j]).size() > 0)
                    getPositionList(i, intGroup);

            }

        }
    }

    private void generateContent(ArrayList<UserModelDto.Result> results) {
        DataAdapter mData = new DataAdapter(getContext(), results);
        mRecyclerView.setAdapter(mData);
        mData.notifyDataSetChanged();
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.addOnScrollListener(recyclerViewOnScrollListener);
        mRecyclerView.addOnItemTouchListener(new RecyclerViewTouchListener(getContext(),
                mRecyclerView, new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(getContext(), results.get(position).getTitle()
                        + " is clicked", Toast.LENGTH_SHORT).show();

                //   userModeltoInfAboutCourse.add(results.get(position));
              //   mUserModelResult.put("info", userModeltoInfAboutCourse);
                //   replaceFragment("info", mUserModelResult);
             //'   getCourseView(getConcatUrl(results, position));

            }

            @Override
            public void onLongClick(View view, int position) {
                Toast.makeText(getContext(), "remove you finger PLEASE ", Toast.LENGTH_SHORT).show();

            }
        }));
    }

    private void initDataList() {
        intellectualList.add("web-development");
        intellectualList.add("mobile-apps");
        intellectualList.add("programming-languages");
        intellectualList.add("databases");
        intellectualList.add("software-testing");
        intellectualList.add("game-development");
        realistList.add("interior-design");
        realistList.add("home-improvement");
        realistList.add("architectural-design");
        realistList.add("yoga");
        realistList.add("massage");
        realistList.add("acupressure");
        realistList.add("aromatherapy");
        realistList.add("life-coaching");
        realistList.add("reflexology");
        socialList.add("psychology-fundamentals");
        socialList.add("social-psychology");
        socialList.add("accounting");
        socialList.add("counseling");
        socialList.add("digital-marketing");
        socialList.add("advertising");
        socialList.add("public-relations");
        socialList.add("marketing-fundamentals");
        socialList.add("branding");
        socialList.add("social-media-marketing");
        officeList.add("accounting");
        officeList.add("digital-marketing");
        officeList.add("economics");
        officeList.add("management");
        entrepreneuriaList.add("business-law");
        entrepreneuriaList.add("home-business");
        entrepreneuriaList.add("leadership");
        entrepreneuriaList.add("human-resources");
        entrepreneuriaList.add("finance");
        entrepreneuriaList.add("entrepreneurship");
        entrepreneuriaList.add("communications");
        entrepreneuriaList.add("management");
        artistictList.add("design-thinking");
        artistictList.add("web-design");
        artistictList.add("mobile-app-design");
        artistictList.add("user-experience-design");
        artistictList.add("photography-fundamentals");
        artistictList.add("portraits");
        intGroup.add(intellectualList);
        intGroup.add(realistList);
        intGroup.add(socialList);
        intGroup.add(officeList);
        intGroup.add(entrepreneuriaList);
        intGroup.add(artistictList);

    }

    private List<String> getListIntHshMap(HashMap hashMap, String key) {
        return (List<String>) hashMap.get(key);

    }

    private void getPositionList(int i, List<List<String>> mList) {
        selectionResultProfession.addAll(mList.get(i));

    }


    private String getConcatUrl(ArrayList<UserModelDto.Result> results, int position) {
        return AppConfig.BASE_URL_UDEMY + results.get(position).getUrl();
    }

    private void getCourseView(String url) {
        Intent getWeb = new Intent();
        getWeb.setPackage("com.android.chrome");
        getWeb.setAction(Intent.ACTION_VIEW);
        getWeb.setData(Uri.parse(url));
        startActivity(getWeb);
    }

    private void loadMoreInformation(int page, int indexInterest) {

        configurationRetrofitForUdemyApi().getResult(page,
                AppConfig.PropertiesRequest.PAGE_SIZE,
                selectionResultProfession.get(indexInterest),
                AppConfig.PropertiesRequest.PRICE,
                AppConfig.PropertiesRequest.AFFILIATE,
                "en",
                AppConfig.PropertiesRequest.LEVEL_COURSES,
                AppConfig.PropertiesRequest.ORDERING,
                AppConfig.PropertiesRequest.RATINGS).enqueue(new Callback<UserModelDto>() {
            @Override
            public void onResponse(Call<UserModelDto> call, Response<UserModelDto> response) {
                moreUserModel.addAll(response.body().getResults());
                generateContent(moreUserModel);
            }

            @Override
            public void onFailure(Call<UserModelDto> call, Throwable t) {

            }
        });

    }

    @Override
    public void replaceFragment(String key, HashMap hashMap) {
        mSentDataInInformationAboutCourse.onSentDataInInformationAbCourse(key, hashMap);
    }

    public interface sentDataInInformationAboutCourse {
        void onSentDataInInformationAbCourse(String key, HashMap hashmap);
    }

    sentDataInInformationAboutCourse mSentDataInInformationAboutCourse;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mSentDataInInformationAboutCourse = (sentDataInInformationAboutCourse) context;
    }
}
