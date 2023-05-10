package com.vodafone.handler;

import com.vodafone.model.Card;
import com.vodafone.repository.CardRepo;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PinHandler extends Handler{
    private final CardRepo cardRepo;
    @Override
    public boolean handle(Card card){
        int pin = 0;
        pin = cardRepo.findCardByNumber(card.getCardNumber()).getPin();
        if (card.getPin() != pin) {
            System.out.println("The Card Pin isn't correct.");
            return false;
        }
        return handleNext(card);
    }
}
