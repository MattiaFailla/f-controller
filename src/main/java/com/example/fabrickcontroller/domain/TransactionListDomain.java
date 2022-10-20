package com.example.fabrickcontroller.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionListDomain {
    private List<TransactionDomain> list;

    public List<TransactionDomain> getList() {
        return list;
    }

    public void setList(List<TransactionDomain> list) {
        this.list = list;
    }
}
