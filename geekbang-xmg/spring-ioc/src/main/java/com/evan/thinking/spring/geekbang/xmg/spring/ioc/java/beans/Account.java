package com.evan.thinking.spring.geekbang.xmg.spring.ioc.java.beans;

/**
 * @desc: zhanghuxin
 * @author: evan 
 * @date: 2022/3/19
 */ 
public class Account {

    /**
     *
     */
    private Long totalAmount;

    private String cardNo;


    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }
}
