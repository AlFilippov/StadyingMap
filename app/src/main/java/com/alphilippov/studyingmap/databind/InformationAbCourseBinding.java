package com.alphilippov.studyingmap.databind;

public class InformationAbCourseBinding {
    private String mNameAboutCourse;
    private String mAuthorAboutCourse;
    private String mNameRatingAboutCourse;
    private int mRatingAboutCourse;
    private String mPriceAboutCourse;
    private String mBuyAboutCourse ;

    public InformationAbCourseBinding(String nameAboutCourse,
                                      String authorAboutCourse,
                                      String nameRatingAboutCourse,
                                      int ratingAboutCourse,
                                      String buyAboutCourse) {
        mNameAboutCourse = nameAboutCourse;
        mAuthorAboutCourse = authorAboutCourse;
        mNameRatingAboutCourse = nameRatingAboutCourse;
        mRatingAboutCourse = ratingAboutCourse;
        mBuyAboutCourse = buyAboutCourse;
    }

    public String getNameAboutCourse() {
        return mNameAboutCourse;
    }

    public void setNameAboutCourse(String nameAboutCourse) {
        mNameAboutCourse = nameAboutCourse;
    }



    public String getAuthorAboutCourse() {
        return mAuthorAboutCourse;
    }

    public void setAuthorAboutCourse(String authorAboutCourse) {
        mAuthorAboutCourse = authorAboutCourse;
    }

    public String getNameRatingAboutCourse() {
        return mNameRatingAboutCourse;
    }

    public void setNameRatingAboutCourse(String nameRatingAboutCourse) {
        mNameRatingAboutCourse = nameRatingAboutCourse;
    }

    public int getRatingAboutCourse() {
        return mRatingAboutCourse;
    }

    public void setRatingAboutCourse(int ratingAboutCourse) {
        mRatingAboutCourse = ratingAboutCourse;
    }

    public String getPriceAboutCourse() {
        return mPriceAboutCourse;
    }

    public void setPriceAboutCourse(String priceAboutCourse) {
        mPriceAboutCourse = priceAboutCourse;
    }

    public String getBuyAboutCourse() {
        return mBuyAboutCourse;
    }

    public void setBuyAboutCourse(String buyAboutCourse) {
        mBuyAboutCourse = buyAboutCourse;
    }
}
