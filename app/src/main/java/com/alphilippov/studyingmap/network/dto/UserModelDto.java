package com.alphilippov.studyingmap.network.dto;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserModelDto {
    @JsonProperty("count")
    private int count;
    @JsonProperty("next")
    private String next;
    @JsonProperty("previous")
    private Object previous;
    @JsonProperty("results")
    private List<Result> results = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public class PriceDetail {

        @JsonProperty("currency")
        private String currency;
        @JsonProperty("currency_symbol")
        private String currencySymbol;
        @JsonProperty("price_string")
        private String priceString;
        @JsonProperty("amount")
        private float amount;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        @JsonAnyGetter
        private Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        private void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }
    public class Result {

        @JsonProperty("_class")
        private String _class;
        @JsonProperty("id")
        private int id;
        @JsonProperty("title")
        private String title;
        @JsonProperty("url")
        private String url;
        @JsonProperty("is_paid")
        private boolean isPaid;
        @JsonProperty("price")
        private String price;
        @JsonProperty("price_detail")
        private PriceDetail priceDetail;
        @JsonProperty("visible_instructors")
        private List<VisibleInstructor> visibleInstructors = null;
        @JsonProperty("image_125_H")
        private String image125H;
        @JsonProperty("image_240x135")
        private String image240x135;
        @JsonProperty("is_practice_test_course")
        private boolean isPracticeTestCourse;
        @JsonProperty("image_480x270")
        private String image480x270;
        @JsonProperty("published_title")
        private String publishedTitle;
        @JsonProperty("predictive_score")
        private Object predictiveScore;
        @JsonProperty("relevancy_score")
        private float relevancyScore;
        @JsonProperty("input_features")
        private Object inputFeatures;
        @JsonProperty("lecture_search_result")
        private Object lectureSearchResult;
        @JsonProperty("curriculum_lectures")
        private List<Object> curriculumLectures = null;
        @JsonProperty("order_in_results")
        private Object orderInResults;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        @JsonAnyGetter
        private Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        private void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }
    public class VisibleInstructor {

        @JsonProperty("title")
        private String title;
        @JsonProperty("image_50x50")
        private String image50x50;
        @JsonProperty("job_title")
        private String jobTitle;
        @JsonProperty("url")
        private String url;
        @JsonProperty("image_100x100")
        private String image100x100;
        @JsonProperty("_class")
        private String _class;
        @JsonProperty("display_name")
        private String displayName;
        @JsonProperty("initials")
        private String initials;
        @JsonProperty("name")
        private String name;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }

}
