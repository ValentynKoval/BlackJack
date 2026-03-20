package com.game.bj.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ToString
public class Player {
    private String name;
    private int numberOfGames = 0;
    private int numberOfWins = 0;
    private Amount amount;

    private List<Card> hand = new ArrayList<>();

    public Player(String name, BigInteger amount) {
        this.name = name;
        this.amount = new Amount(amount);
    }

    public void incrementNumberOfGames() {
        numberOfGames++;
    }

    public void incrementNumberOfWins() {
        numberOfWins++;
    }

    public void clearHand() {
        hand.clear();
    }
}
