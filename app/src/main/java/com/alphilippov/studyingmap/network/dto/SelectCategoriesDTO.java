package com.alphilippov.studyingmap.network.dto;


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
        "id",
        "artisticCategories",
        "entrepreneurialCategories",
        "intellectualCategories",
        "officeCategories",
        "realistCategories",
        "socialCategories"
})
public class SelectCategoriesDTO {

    @JsonProperty("id")
    private long id;
    @JsonProperty("artisticCategories")
    private List<ArtisticCategoryDTO> artisticCategories = null;
    @JsonProperty("entrepreneurialCategories")
    private List<EntrepreneurialCategoryDTO> entrepreneurialCategories = null;
    @JsonProperty("intellectualCategories")
    private List<IntellectualCategoryDTO> intellectualCategories = null;
    @JsonProperty("officeCategories")
    private List<OfficeCategoryDTO> officeCategories = null;
    @JsonProperty("realistCategories")
    private List<RealistCategoryDTO> realistCategories = null;
    @JsonProperty("socialCategories")
    private List<SocialCategoryDTO> socialCategories = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(long id) {
        this.id = id;
    }

    @JsonProperty("artisticCategories")
    public List<ArtisticCategoryDTO> getArtisticCategories() {
        return artisticCategories;
    }

    @JsonProperty("artisticCategories")
    public void setArtisticCategories(List<ArtisticCategoryDTO> artisticCategories) {
        this.artisticCategories = artisticCategories;
    }

    @JsonProperty("entrepreneurialCategories")
    public List<EntrepreneurialCategoryDTO> getEntrepreneurialCategories() {
        return entrepreneurialCategories;
    }

    @JsonProperty("entrepreneurialCategories")
    public void setEntrepreneurialCategories(List<EntrepreneurialCategoryDTO> entrepreneurialCategories) {
        this.entrepreneurialCategories = entrepreneurialCategories;
    }

    @JsonProperty("intellectualCategories")
    public List<IntellectualCategoryDTO> getIntellectualCategories() {
        return intellectualCategories;
    }

    @JsonProperty("intellectualCategories")
    public void setIntellectualCategories(List<IntellectualCategoryDTO> intellectualCategories) {
        this.intellectualCategories = intellectualCategories;
    }

    @JsonProperty("officeCategories")
    public List<OfficeCategoryDTO> getOfficeCategories() {
        return officeCategories;
    }

    @JsonProperty("officeCategories")
    public void setOfficeCategories(List<OfficeCategoryDTO> officeCategories) {
        this.officeCategories = officeCategories;
    }

    @JsonProperty("realistCategories")
    public List<RealistCategoryDTO> getRealistCategories() {
        return realistCategories;
    }

    @JsonProperty("realistCategories")
    public void setRealistCategories(List<RealistCategoryDTO> realistCategories) {
        this.realistCategories = realistCategories;
    }

    @JsonProperty("socialCategories")
    public List<SocialCategoryDTO> getSocialCategories() {
        return socialCategories;
    }

    @JsonProperty("socialCategories")
    public void setSocialCategories(List<SocialCategoryDTO> socialCategories) {
        this.socialCategories = socialCategories;
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


