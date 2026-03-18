package com.game.bj.service;

import com.game.bj.dto.Card;
import com.game.bj.exception.DeckException;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class DeckServiceTest {

    @Test
    void createDeck() {
        DeckService deckService = new DeckService();
        deckService.createDeck(1);
        assertEquals(52, deckService.getCardCount());
        deckService.createDeck(2);
        assertEquals(104, deckService.getCardCount());
    }

    @Test
    void createDeckException() {
        DeckService deckService = new DeckService();
        assertThrows(DeckException.class, () -> deckService.createDeck(0));
        assertThrows(DeckException.class, () -> deckService.createDeck(9));
        assertDoesNotThrow(() -> deckService.createDeck(1));
    }

    @Test
    void getDeck() {
        DeckService deckService = new DeckService();
        deckService.createDeck(1);
        assertNotNull(deckService.getDeck());
        assertTrue(deckService.getDeck() instanceof Stack<Card>);
    }

    @Test
    void getCardCount() {
        DeckService deckService = new DeckService();
        deckService.createDeck(1);
        assertEquals(52, deckService.getCardCount());
    }

    @Test
    void dealCard() {
        DeckService deckService = new DeckService();
        deckService.createDeck(1);
        assertEquals(52, deckService.getCardCount());
        deckService.dealCard();
        assertEquals(51, deckService.getCardCount());
    }
}