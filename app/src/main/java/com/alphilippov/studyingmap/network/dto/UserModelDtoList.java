package com.alphilippov.studyingmap.network.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class UserModelDtoList {
    @JsonProperty("userModelDtoList")
    private ArrayList<UserModelDto> userModelDtoList;

    public UserModelDtoList(ArrayList<UserModelDto> userModelDtoList) {
        this.userModelDtoList = userModelDtoList;
    }

    public ArrayList<UserModelDto> getUserModelDtoList() {
        return userModelDtoList;
    }
}
