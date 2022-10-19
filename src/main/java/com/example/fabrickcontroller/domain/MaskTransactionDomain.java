package com.example.fabrickcontroller.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = false)
public class MaskTransactionDomain {
    private List<TransactionDomain> list;

    public MaskTransactionDomain() {
        list = new ArrayList<>();
    }

    public List<TransactionDomain> getList() {
        return list;
    }

    public void setList(List<TransactionDomain> list) {
        this.list = list;
    }
}
