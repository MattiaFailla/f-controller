package com.example.fabrickcontroller.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MaskTransactionListDomain {
    private String status;
    private List<String> error;
    private TransactionListDomain payload;

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

    public TransactionListDomain getPayload() {
        return payload;
    }

    public void setPayload(TransactionListDomain payload) {
        this.payload = payload;
    }
}
