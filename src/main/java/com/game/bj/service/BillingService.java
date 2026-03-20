package com.game.bj.service;

import com.game.bj.dto.Amount;
import com.game.bj.exception.NotEnoughtMoneyException;

import java.math.BigInteger;
import java.util.Scanner;

public class BillingService {
    public void addAmount(Amount amount, BigInteger bet) {
        amount.setAmount(amount.getAmount().add(bet));
    }

    public void substructAmount(Amount amount, BigInteger bet) {
        amount.setAmount(amount.getAmount().subtract(bet));
    }

    public BigInteger validateAmount(Amount amount, BigInteger bet) {
        Scanner scanner = new Scanner(System.in);

        if (amount.getAmount().compareTo(BigInteger.ZERO) <= 0) {
            throw new NotEnoughtMoneyException("Game over ...");
        }

        if (bet.compareTo(amount.getAmount()) > 0) {
            try {
                System.out.printf("You can put %s points. Countinue? (y/n) ", amount.getAmount());
                String answer = scanner.nextLine();
                if (!answer.equalsIgnoreCase("y")) {
                    System.out.printf("Put your bet less then %s points", amount.getAmount());
                    bet = scanner.nextBigInteger();
                    scanner.nextLine();
                    validateAmount(amount, bet);
                } else {
                    bet = amount.getAmount();
                }
            } catch (NumberFormatException e) {

            }
        }
        return bet;
    }
}
