package com.vodafone.handler;

import com.vodafone.model.Card;

import java.sql.SQLException;

public class CardNumberHandler extends Handler{
    @Override
    public boolean handle(Card card){
        String cardNumber = String.valueOf(card.getCardNumber());
        if(cardNumber.length() != 16) {
            System.out.println("The Card Number should be 16 Digits.");
            return false;
        }
        return handleNext(card);
    }
}
