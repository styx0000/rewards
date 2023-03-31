package com.spike.retailer.rewards.controller;

import com.spike.retailer.rewards.entity.Transaction;
import com.spike.retailer.rewards.handler.RewardsHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RewardsController {

    private final RewardsHandler handler;

    @Autowired
    public RewardsController(RewardsHandler handler) {
        this.handler = handler;
    }

    @PostMapping("/calculateRewards")
    public Long calculateRewards(@RequestBody List<Transaction> transactions) {
        return handler.calculateRewards(transactions);
    }
}
