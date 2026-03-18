package com.game.bj.dto;

public enum Suit {
    HEARTS('♥'),
    SPADES('♠'),
    DIAMONDS('♦'),
    CLUBS('♣');

    private final char symbol;

    public char getSymbol() {
        return symbol;
    }

    Suit(char symbol) {this.symbol = symbol;}
}
