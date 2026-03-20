package com.game.bj.service;

import com.game.bj.dto.Currency;

import java.math.BigInteger;

public class ExchengeService {
    public BigInteger toPoint(int amount, Currency currency) {
        return BigInteger.valueOf((long) amount * currency.getPoint());
    }

    public BigInteger toFiat(BigInteger amount, Currency currency) {
        return amount.divide(BigInteger.valueOf(currency.getPoint()));
    }
}
