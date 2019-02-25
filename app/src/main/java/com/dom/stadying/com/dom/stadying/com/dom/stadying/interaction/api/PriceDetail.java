package com.dom.stadying.com.dom.stadying.com.dom.stadying.interaction.api;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "currency",
        "currency_symbol",
        "price_string",
        "amount"
})
public class PriceDetail {

    @JsonProperty("currency")
    private String currency;
    @JsonProperty("currency_symbol")
    private String currencySymbol;
    @JsonProperty("price_string")
    private String priceString;
    @JsonProperty("amount")
    private double amount;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @JsonProperty("currency_symbol")
    public String getCurrencySymbol() {
        return currencySymbol;
    }

    @JsonProperty("currency_symbol")
    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

    @JsonProperty("price_string")
    public String getPriceString() {
        return priceString;
    }

    @JsonProperty("price_string")
    public void setPriceString(String priceString) {
        this.priceString = priceString;
    }

    @JsonProperty("amount")
    public double getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(double amount) {
        this.amount = amount;
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
