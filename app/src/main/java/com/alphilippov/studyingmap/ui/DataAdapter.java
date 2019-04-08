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
    private Context mContext;
    private List<UserModelDto> mCourseModelDtoList;
    private List<UserModelDto.Result> mInfoCourseResult;
    private List<UserModelDto.PriceDetail>mInfoCourseDetail;
    private List<UserModelDto.VisibleInstructor> mVisibleInstructors;

    public DataAdapter(Context context, List<UserModelDto> courseModelDtoList) {
        mContext = context;
        mCourseModelDtoList = courseModelDtoList;

    }

    @NonNull
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.content_info_course, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapter.ViewHolder viewHolder, int position) {
        viewHolder.mNameCourse.setText(mInfoCourseResult.get(position).getTitle());
        viewHolder.mAuthorCourse.setText(mVisibleInstructors.get(position).getTitle());
        viewHolder.mPriceCourse.setText(mInfoCourseResult.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return mCourseModelDtoList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
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


