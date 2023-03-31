package com.spike.retailer.rewards.handler;

import com.spike.retailer.rewards.entity.Transaction;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class RewardsHandler {

    private static final long threeMonthDiff = 8035200;
    public Long calculateRewards(List<Transaction> transactions) {
        long totalPoints = 0;
        for (Transaction t : transactions) {
            Timestamp currentTimeStamp = new Timestamp(System.currentTimeMillis());
            if (currentTimeStamp.getTime() - t.getTimestamp().getTime() < threeMonthDiff) {
                double amount = t.getAmount();
                if (amount > 50 && amount <= 100) {
                    totalPoints += Math.round(amount - 50);
                } else if (amount > 100) {
                    totalPoints += Math.round(((amount - 100)) * 2);
                }
            }
        }
        return totalPoints;
    }
}
