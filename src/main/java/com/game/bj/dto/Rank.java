package com.game.bj.dto;

public enum Rank {
    TWO("2", 2, 2),
    THREE("3", 3, 3),
    FOUR("4", 4, 4),
    FIVE("5", 5, 5),
    SIX("6", 6, 6),
    SEVEN("7", 7, 7),
    EIGHT("8", 8, 8),
    NINE("9", 9, 9),
    TEN("10", 10, 10),
    JACK("J", 11, 10),
    QUEEN("Q", 12, 10),
    KING("K", 13, 10),
    ACE("A", 14, 11);

    private final String name;
    private final int value;
    private final int cost;

    public int getCost() {
        return cost;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    Rank(String name, int value, int cost) {
        this.name = name;
        this.value = value;
        this.cost = cost;
    }
}
