package com.game.bj.service;

import com.game.bj.dto.Card;

import java.util.List;

public class GameService {
    public int calculateScore(List<Card> hand) {
        int score = 0;
        for (Card card : hand) {
            score += card.getCost();
        }
        if (hand.size() == 2 && isBlackJack(score)) return 21;
        if (score > 21 && hasAce(hand)) score -= 10;
        return score;
    }

    private boolean isBlackJack(int score) {
        return score == 22;
    }

    private boolean hasAce(List<Card> hand) {
        for (Card card : hand) {
            if (card.getCost() == 11) return true;
        }
        return false;
    }
}
