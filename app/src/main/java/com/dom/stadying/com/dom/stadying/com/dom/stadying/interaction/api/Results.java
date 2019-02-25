package com.dom.stadying.com.dom.stadying.com.dom.stadying.interaction.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "_class",
        "id",
        "title",
        "url",
        "is_paid",
        "price",
        "price_detail",
        "visible_instructors",
        "image_125_H",
        "image_240x135",
        "is_practice_test_course",
        "image_480x270",
        "published_title",
        "predictive_score",
        "relevancy_score",
        "input_features",
        "lecture_search_result",
        "curriculum_lectures",
        "order_in_results"
})
public class Results {

    @JsonProperty("_class")
    private String _class;
    @JsonProperty("id")
    private long id;
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
    private double relevancyScore;
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

    @JsonProperty("_class")
    public String getClass_() {
        return _class;
    }

    @JsonProperty("_class")
    public void setClass_(String _class) {
        this._class = _class;
    }

    @JsonProperty("id")
    public long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(long id) {
        this.id = id;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("is_paid")
    public boolean isIsPaid() {
        return isPaid;
    }

    @JsonProperty("is_paid")
    public void setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    @JsonProperty("price")
    public String getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(String price) {
        this.price = price;
    }

    @JsonProperty("price_detail")
    public PriceDetail getPriceDetail() {
        return priceDetail;
    }

    @JsonProperty("price_detail")
    public void setPriceDetail(PriceDetail priceDetail) {
        this.priceDetail = priceDetail;
    }

    @JsonProperty("visible_instructors")
    public List<VisibleInstructor> getVisibleInstructors() {
        return visibleInstructors;
    }

    @JsonProperty("visible_instructors")
    public void setVisibleInstructors(List<VisibleInstructor> visibleInstructors) {
        this.visibleInstructors = visibleInstructors;
    }

    @JsonProperty("image_125_H")
    public String getImage125H() {
        return image125H;
    }

    @JsonProperty("image_125_H")
    public void setImage125H(String image125H) {
        this.image125H = image125H;
    }

    @JsonProperty("image_240x135")
    public String getImage240x135() {
        return image240x135;
    }

    @JsonProperty("image_240x135")
    public void setImage240x135(String image240x135) {
        this.image240x135 = image240x135;
    }

    @JsonProperty("is_practice_test_course")
    public boolean isIsPracticeTestCourse() {
        return isPracticeTestCourse;
    }

    @JsonProperty("is_practice_test_course")
    public void setIsPracticeTestCourse(boolean isPracticeTestCourse) {
        this.isPracticeTestCourse = isPracticeTestCourse;
    }

    @JsonProperty("image_480x270")
    public String getImage480x270() {
        return image480x270;
    }

    @JsonProperty("image_480x270")
    public void setImage480x270(String image480x270) {
        this.image480x270 = image480x270;
    }

    @JsonProperty("published_title")
    public String getPublishedTitle() {
        return publishedTitle;
    }

    @JsonProperty("published_title")
    public void setPublishedTitle(String publishedTitle) {
        this.publishedTitle = publishedTitle;
    }

    @JsonProperty("predictive_score")
    public Object getPredictiveScore() {
        return predictiveScore;
    }

    @JsonProperty("predictive_score")
    public void setPredictiveScore(Object predictiveScore) {
        this.predictiveScore = predictiveScore;
    }

    @JsonProperty("relevancy_score")
    public double getRelevancyScore() {
        return relevancyScore;
    }

    @JsonProperty("relevancy_score")
    public void setRelevancyScore(double relevancyScore) {
        this.relevancyScore = relevancyScore;
    }

    @JsonProperty("input_features")
    public Object getInputFeatures() {
        return inputFeatures;
    }

    @JsonProperty("input_features")
    public void setInputFeatures(Object inputFeatures) {
        this.inputFeatures = inputFeatures;
    }

    @JsonProperty("lecture_search_result")
    public Object getLectureSearchResult() {
        return lectureSearchResult;
    }

    @JsonProperty("lecture_search_result")
    public void setLectureSearchResult(Object lectureSearchResult) {
        this.lectureSearchResult = lectureSearchResult;
    }

    @JsonProperty("curriculum_lectures")
    public List<Object> getCurriculumLectures() {
        return curriculumLectures;
    }

    @JsonProperty("curriculum_lectures")
    public void setCurriculumLectures(List<Object> curriculumLectures) {
        this.curriculumLectures = curriculumLectures;
    }

    @JsonProperty("order_in_results")
    public Object getOrderInResults() {
        return orderInResults;
    }

    @JsonProperty("order_in_results")
    public void setOrderInResults(Object orderInResults) {
        this.orderInResults = orderInResults;
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