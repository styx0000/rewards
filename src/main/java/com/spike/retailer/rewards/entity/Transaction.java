package com.spike.retailer.rewards.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Transaction {
    private double amount;
    private Timestamp timestamp;
}
