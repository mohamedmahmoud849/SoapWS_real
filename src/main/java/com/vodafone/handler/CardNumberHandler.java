package com.vodafone.handler;

import com.vodafone.model.Card;


public class CardNumberHandler extends Handler{
    @Override
    public String handle(Card card){
        String cardNumber = String.valueOf(card.getCardNumber());
        if(cardNumber.length() != 16) {
            return "The Card Number should be 16 Digits.";
        }
        return handleNext(card);
    }
}
