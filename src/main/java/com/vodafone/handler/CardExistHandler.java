package com.vodafone.handler;

import com.vodafone.model.Card;
import com.vodafone.repository.CardRepo;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class CardExistHandler extends Handler{

    private final CardRepo cardRepo;
    @Override
    public String handle(Card card) {
        if (cardRepo.findCardByNumber(card.getCardNumber()) == null) {
            return "This Card doesn't exist.";
        }
        return handleNext(card);
    }
}
