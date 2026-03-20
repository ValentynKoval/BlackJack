package com.game.bj.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
public class Amount {
    private BigInteger amount;
    private Currency currency;

    public Amount(BigInteger amount) {
        this.amount = amount;
        this.currency = Currency.POINT;
    }

    public Amount(BigInteger amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    @Override
    public String toString() {
        return String.format("%s %s", amount, currency);
    }
}
