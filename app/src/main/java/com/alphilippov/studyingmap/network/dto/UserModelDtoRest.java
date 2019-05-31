package com.alphilippov.studyingmap.network.dto;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class UserModelDtoRest {
    @JsonProperty("idDefinition")
    private long idDefinition;
    @JsonProperty("indexDefenition")
    private long indexDefenition;
    @JsonProperty("profession")
    private String profession;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("idDefinition")
    public long getIdDefinition() {
        return idDefinition;
    }

    @JsonProperty("idDefinition")
    public void setIdDefinition(long idDefinition) {
        this.idDefinition = idDefinition;
    }

    @JsonProperty("indexDefenition")
    public long getIndexDefenition() {
        return indexDefenition;
    }

    @JsonProperty("indexDefenition")
    public void setIndexDefenition(long indexDefenition) {
        this.indexDefenition = indexDefenition;
    }

    @JsonProperty("profession")
    public String getProfession() {
        return profession;
    }

    @JsonProperty("profession")
    public void setProfession(String profession) {
        this.profession = profession;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }



}
