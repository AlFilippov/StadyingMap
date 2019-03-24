package com.alphilippov.studyingmap.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.alphilippov.studyingmap.R;
import com.alphilippov.studyingmap.network.dto.UserModelDto;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private LayoutInflater mLayoutInflater;
    private List<UserModelDto> mUserModelDtoList;
// TODO:Первый параметр в конструкторе LayoutInflater ?
    DataAdapter(Context context, List<UserModelDto> userModelDtoList) {
       this.mLayoutInflater=LayoutInflater.from(context);
        mUserModelDtoList = userModelDtoList;
    }


    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mLayoutInflater.inflate(R.layout.content_info_course,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder( DataAdapter.ViewHolder viewHolder, int position) {
UserModelDto userModelDto = mUserModelDtoList.get(position);
//TODO:Прописать гетеры из DTO
viewHolder.
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView mImageCourse;
TextView mNameCourse;
TextView mAuthorCourse;
RatingBar mRatingCourse;
        TextView mAverageRating;
        TextView mQuantityFeedBack;
        TextView mPriceCourse;
        TextView mPriceWithoutDiscount;
        ViewHolder(View view) {
            super(view);
            mImageCourse = view.findViewById(R.id.mImageCourse);
            mNameCourse = view.findViewById(R.id.mNameCourse);
            mAuthorCourse = view.findViewById(R.id.mAuthorCourse);
            mRatingCourse = view.findViewById(R.id.mRatingCourse);
            mAverageRating = view.findViewById(R.id.mAverageRating);
            mQuantityFeedBack = view.findViewById(R.id.mQuantityFeedBack);
            mPriceCourse = view.findViewById(R.id.mPriceCourse);
            mPriceWithoutDiscount = view.findViewById(R.id.mPriceWithoutDiscount);
        }


        }








    }

}
