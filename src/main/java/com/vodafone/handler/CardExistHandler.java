package com.vodafone.handler;

import com.vodafone.model.Card;
import com.vodafone.repository.CardRepo;
import lombok.RequiredArgsConstructor;

import java.sql.SQLException;

@RequiredArgsConstructor
public class CardExistHandler extends Handler{

    private final CardRepo cardRepo;
    @Override
    public boolean handle(Card card) {
        if(cardRepo.findCardByNumber(card.getCardNumber()) == null) {
            System.out.println("This Card doesn't exist.");
            return false;
        }
        return handleNext(card);
    }
}
