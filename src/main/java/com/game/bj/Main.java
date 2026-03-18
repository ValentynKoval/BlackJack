package com.game.bj;

import com.game.bj.dto.Card;
import com.game.bj.dto.GameResult;
import com.game.bj.dto.Player;
import com.game.bj.service.DeckService;
import com.game.bj.service.GameService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Black Jack");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter number of games: ");
        int numberOfGames = scanner.nextInt();

        Player player = new Player(name);

        System.out.println(String.format("Welcome %s, you have %d games to play", player.getName(), numberOfGames));

        DeckService deckService = new DeckService();
        GameService gameService = new GameService();
        deckService.createDeck(1);

        int counter = 1;

        scanner.nextLine();

        do {
            System.out.println("-------------------->>>>>>");
            System.out.println(String.format("Game %d", counter));
            game(player, deckService, scanner, gameService);

            List<Card> dealerHand = gameService.getDealerHand(deckService);

            int pScore = gameService.calculateScore(player.getHand());
            int dScore = gameService.calculateScore(dealerHand);

            System.out.println("===================");
            System.out.println("Player Hand: " + player.getHand() + " Score: " + pScore);
            System.out.println("Dealer Hand: " + dealerHand + " Score: " + dScore);
            System.out.println("===================");

            GameResult gameResult = gameService.getGameResult(pScore, dScore);
            System.out.println("Game Result: " + gameResult);
        } while (nextGame(counter++, numberOfGames, scanner));
    }

    private static boolean nextGame(int gameNumber, int games, Scanner scanner) {
        if (gameNumber != games) {
            System.out.print("Do you want to play another game? (y/n) ");
            return scanner.nextLine().equalsIgnoreCase("y");
        }
        return false;
    }

    private static void game(Player player, DeckService deckService, Scanner scanner, GameService gameService) {
        String nextcard;
        player.clearHand();
        do {
            List<Card> hand = player.getHand();
            if (hand.isEmpty()) {
                hand.add(deckService.dealCard());
            }
            hand.add(deckService.dealCard());
            int score = gameService.calculateScore(hand);
            System.out.println("player hand: " + hand + " score: " + score);

            if (score < 21) {
                System.out.print("Next card? (y/n) ");
                nextcard = scanner.nextLine();
            } else {
                break;
            }



        } while (nextcard.equalsIgnoreCase("y"));
    }
}
