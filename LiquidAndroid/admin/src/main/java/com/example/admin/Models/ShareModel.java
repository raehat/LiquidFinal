package com.example.admin.Models;

public class ShareModel {
    String corpName, companyName;
    int noOfPeople;

    public ShareModel(String corpName, String companyName, int noOfPeople) {
        this.corpName = corpName;
        this.companyName = companyName;
        this.noOfPeople = noOfPeople;
    }

    public String getCorpName() {
        return corpName;
    }

    public void setCorpName(String corpName) {
        this.corpName = corpName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getNoOfPeople() {
        return noOfPeople;
    }

    public void setNoOfPeople(int noOfPeople) {
        this.noOfPeople = noOfPeople;
    }
}
