package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class HandValueTest {

    private static final Suit DUMMY_SUIT = Suit.DIAMONDS;

    @Test
    public void handWithCardsValuedAt20IsNotBusted() throws Exception {
        List<Card> cards = List.of(new Card(DUMMY_SUIT, "Q"),
                                   new Card(DUMMY_SUIT, "K"));
        Hand hand = new Hand(cards);

        assertThat(hand.isBusted())
                .isFalse();
    }

    @Test
    public void handWithCardsValuedAt21IsNotBusted() throws Exception {
        List<Card> cards = List.of(new Card(DUMMY_SUIT, "Q"),
                                   new Card(DUMMY_SUIT, "9"),
                                   new Card(DUMMY_SUIT, "2"));
        Hand hand = new Hand(cards);

        assertThat(hand.isBusted())
                .isFalse();
    }

    @Test
    public void handWithCardsValuedAt22IsBusted() throws Exception {
        List<Card> cards = List.of(new Card(DUMMY_SUIT, "Q"),
                                   new Card(DUMMY_SUIT, "9"),
                                   new Card(DUMMY_SUIT, "3"));
        Hand hand = new Hand(cards);

        assertThat(hand.isBusted())
                .isTrue();
    }

}
