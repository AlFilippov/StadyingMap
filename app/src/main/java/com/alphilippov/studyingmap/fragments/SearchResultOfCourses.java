package com.alphilippov.studyingmap.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Toast;

import com.alphilippov.studyingmap.R;
import com.alphilippov.studyingmap.network.NetworkService;
import com.alphilippov.studyingmap.network.dto.UserModelDto;
import com.alphilippov.studyingmap.ui.DataAdapter;
import com.alphilippov.studyingmap.utils.AppConfig;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchResultOfCourses extends Fragment {
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(getActivity());
    private boolean isScrolling;
    private ProfessionDefinition mProfessionDefinition = new ProfessionDefinition();
    private int page = 1;
    private int indexInterest = 0;
    protected ArrayList<UserModelDto.Result> moreUserModel = new ArrayList<>();
    public final static String SEND_DATA_FRAGMENT = "data_fragment";
    public HashMap<String, ArrayList<String>> mHashMap = new HashMap<>();
    public HashMap<String, ArrayList<String>> mHashMap1 = new HashMap<>();
    public ArrayList<String> mCollection;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO:Могу словить classCastEx , нужно затестить
        Bundle args = getArguments();
        sentSortResultCollection(args);
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View qView = inflater.inflate(R.layout.search_result_of_courses, container, false);
        mRecyclerView = qView.findViewById(R.id.list);
        Bundle bundle = getArguments();
        return qView;
    }

    //Контроль позиции представления , для дальнешей реализации пагинации
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

    //Составление запросов
    private void loadMoreInformation(int page, int indexInterest) {

        NetworkService.getInstance().getJSONApi().getResult(page,
                AppConfig.PropertiesRequest.PAGE_SIZE,
                //TODO:Передать данные из фрагмента ProfessionDefinition
                mCollection.get(indexInterest),
                AppConfig.PropertiesRequest.PRICE,
                AppConfig.PropertiesRequest.AFFILIATE,
                "ru",
                AppConfig.PropertiesRequest.LEVEL_COURSES,
                AppConfig.PropertiesRequest.ORDERING,
                AppConfig.PropertiesRequest.RATINGS).enqueue(new Callback<UserModelDto>() {
            @Override
            public void onResponse(Call<UserModelDto> call, Response<UserModelDto> response) {
                moreUserModel.addAll(response.body().getResults());
                generateContent(response.body().getResults());
            }

            @Override
            public void onFailure(Call<UserModelDto> call, Throwable t) {

            }
        });
    }

    private void sentSortResultCollection(Bundle args) {
        if (args != null) {
            mHashMap = (HashMap<String, ArrayList<String>>) args.getSerializable("MapProfessionDef");
            if (mHashMap.size() != 0) {
                sortResultCollection(mHashMap);
            }
        } else {
            Toast.makeText(getActivity(),"Неверные коллекции" ,Toast.LENGTH_SHORT).show();
        }


    }
//TODO:Исправить добавление коллекции из HashMap
    private void sortResultCollection(HashMap map) {
        if (map.get("HighInterest") != null) {
            mCollection .addAll(ArrayList<String> map.get("HighInterest"));
        } else if (map.get("MiddleInterest") != null) {
            mCollection = (ArrayList<String>) map.get("MiddleInterest");
        } else if (map.get("LowInterest") != null) {
            mCollection = (ArrayList<String>) map.get("LowInterest");
        }
    }

    //Данные отправляются в адаптер из результатов запроса
    private void generateContent(ArrayList<UserModelDto.Result> results) {
        DataAdapter mDataAdapter = new DataAdapter(getContext(), results);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setAdapter(mDataAdapter);
        mRecyclerView.addOnScrollListener(recyclerViewOnScrollListener);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }
}
