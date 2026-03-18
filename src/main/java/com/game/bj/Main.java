package com.game.bj;

import com.game.bj.dto.Player;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Black Jack");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Enter number of games:");
        int numberOfGames = scanner.nextInt();

        Player player = new Player(name);

        System.out.println(String.format("Welcome %s, you have %d games to play", player.getName(), numberOfGames));
    }
}
