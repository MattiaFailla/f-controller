package com.example.fabrickcontroller.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MaskBalanceDomain {
    private String status;
    private List<String> error;
    private BalanceDomain payload;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getError() {
        return error;
    }

    public void setError(List<String> error) {
        this.error = error;
    }

    public BalanceDomain getPayload() {
        return payload;
    }

    public void setPayload(BalanceDomain payload) {
        this.payload = payload;
    }
}
