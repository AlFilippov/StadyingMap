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
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private Context mContext;
    private List<UserModelDto.Result> mResultList;

    public DataAdapter(Context context, List<UserModelDto.Result> resultList) {
        mContext = context;
        mResultList = resultList;
    }

    @NonNull
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.content_info_course, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapter.ViewHolder viewHolder, int position) {
        viewHolder.mNameCourse.setText(mResultList.get(position).getTitle());
       viewHolder.mPriceCourse.setText(String.valueOf(mResultList.get(position).getPriceDetail().getAmount()));
        viewHolder.mCurrencySymbol.setText(mResultList.get(position).getPriceDetail().getCurrencySymbol());
        viewHolder.mRatingCourse.setRating(4);
        viewHolder.mAuthorCourse.setText(mResultList.get(position).getVisibleInstructors().get(0).getTitle());

        Glide.with(mContext)
                .applyDefaultRequestOptions(new RequestOptions().fitCenter())
                .load(mResultList.get(position).getImage480x270())
                .into(viewHolder.mImageCourse);
    }

    @Override
    public int getItemCount() {
        return mResultList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageCourse;
        TextView mNameCourse;
        TextView mAuthorCourse;
        RatingBar mRatingCourse;
        TextView mPriceCourse;
        TextView mCurrencySymbol;

        ViewHolder(View view) {
            super(view);
            mImageCourse = view.findViewById(R.id.mImageCourse);
            mNameCourse = view.findViewById(R.id.mNameCourse);
            mAuthorCourse = view.findViewById(R.id.mAuthorCourse);
            mRatingCourse = view.findViewById(R.id.mRatingCourse);
            mPriceCourse = view.findViewById(R.id.mPriceCourse);
            mCurrencySymbol = view.findViewById(R.id.mCurrencySymbol);
        }


    }


}


