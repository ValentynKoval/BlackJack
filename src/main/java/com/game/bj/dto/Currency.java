package com.game.bj.dto;

public enum Currency {
    UAH (1),
    USD (43),
    EUR (52),
    GBP (58),
    BAH (100),
    POINT (1);

    private final int point;

    Currency(int point) {
        this.point = point;
    }

    public int getPoint() {
        return point;
    }
}
