package com.example.liquid.Models;

public class BuyShareModel {
    String corpName, companyName;
    int sharePrice, changeInPrice;
    int buyOrSell; // 0 for buy, 1 for sell

    public BuyShareModel(String corpName, String companyName, int sharePrice, int changeInPrice, int buyOrSell) {
        this.corpName = corpName;
        this.companyName = companyName;
        this.sharePrice = sharePrice;
        this.changeInPrice = changeInPrice;
        this.buyOrSell = buyOrSell;
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

    public int getSharePrice() {
        return sharePrice;
    }

    public void setSharePrice(int sharePrice) {
        this.sharePrice = sharePrice;
    }

    public int getChangeInPrice() {
        return changeInPrice;
    }

    public void setChangeInPrice(int changeInPrice) {
        this.changeInPrice = changeInPrice;
    }

    public int getBuyOrSell() {
        return buyOrSell;
    }

    public void setBuyOrSell(int buyOrSell) {
        this.buyOrSell = buyOrSell;
    }
}
