package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class GameBetPayoffTest {

    @Test
    public void newGamePlayerHasZeroBalance() throws Exception {
        Game game = new Game();

        assertThat(game.playerBalance())
                .isZero();
    }

    @Test
    public void playerDeposits25BalanceIs25() throws Exception {
        Game game = new Game();

        game.playerDeposits(25);

        assertThat(game.playerBalance())
                .isEqualTo(25);
    }


    @Test
    public void playerWith100BalanceBets50ThenBalance50() throws Exception {
        Game game = new Game();
        game.playerDeposits(100);

        game.playerBets(50);

        assertThat(game.playerBalance())
                .isEqualTo(100 - 50);
    }


    @Test
    public void playerWith100BalanceBets50AndWinsThenBalanceIs150() throws Exception {
        Game game = new Game();
        game.playerDeposits(100);
        game.playerBets(50);

        game.playerWins();

        assertThat(game.playerBalance())
                .isEqualTo(100 - 50 + (50 * 2));
    }

}