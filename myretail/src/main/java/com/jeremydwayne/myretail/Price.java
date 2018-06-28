package com.jeremydwayne.myretail;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Price {
    @Id public long id;
    private double value;
    private String currencyCode;

    public Price(){
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrency_code(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    // json representation of current price
    public String toString(){
        return "\"current_price\":{\"value\":" + value + ",\"currency_code\":\"" + currencyCode + "\"}";
    }

}

