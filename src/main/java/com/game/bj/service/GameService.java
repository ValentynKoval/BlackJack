package com.game.bj.service;

import com.game.bj.dto.Card;
import com.game.bj.dto.GameResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

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

    public int getComputerScore() {
        return new Random().nextInt(17, 28);
    }

    public List<Card> getComputerHand(Stack<Card> deck) {
        List<Card> computerHand = new ArrayList<>();
        int numberOfCard = new Random().nextInt(2, 6);
        for (int i = 0; i < numberOfCard; i++) {
            computerHand.add(deck.pop());
        }
        return computerHand;
    }

    public List<Card> getDealerHand(DeckService deckService) {
        List<Card> dealerHand = new ArrayList<>();
        dealerHand.add(deckService.dealCard());
        do {
            dealerHand.add(deckService.dealCard());
        } while (calculateScore(dealerHand) < 17);
        return dealerHand;
    }

    public GameResult getGameResult(int pScore, int dScore) {
        if (dScore > 21) {
            if (pScore > 21) {
                return GameResult.LOSE;
            }
            return GameResult.PLAYER;
        } else {
            if (pScore > 21) {
                return GameResult.DEALER;
            } else if (pScore > dScore) {
                return GameResult.PLAYER;
            } else if (dScore > pScore) {
                return GameResult.DEALER;
            }
        }
        return GameResult.DRAW;
    }
}