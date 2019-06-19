package com.alphilippov.studyingmap.helperclasses;


import java.util.List;

public class DistributionInterests {
private String[] mArrInterest;

    private String[] distributionInt(List<String> listHigh, List<String> listMiddle, List<String> listLow) {
        if (listHigh.size() != 0) {
mArrInterest =listHigh.stream().toArray(String[]::new);
        } else if (listMiddle.size()!=0) {
            mArrInterest =listHigh.stream().toArray(String[]::new);
        } else if(listLow.size()!=0){
            mArrInterest =listHigh.stream().toArray(String[]::new);
        }


        return mArrInterest;
    }

    private void sendInteresInNetwork() {

    }
}
