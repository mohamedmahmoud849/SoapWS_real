package com.vodafone.handler;

import com.vodafone.model.Card;
import com.vodafone.repository.CardRepo;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@RequiredArgsConstructor
public class ExipreDateHandler extends Handler{

    private final CardRepo cardRepo;
    @Override
    public String handle(Card card) {
        LocalDate expireDate = null;
        expireDate = cardRepo.findCardByNumber(card.getCardNumber()).getExpireDate();
        if(!expireDate.equals(card.getExpireDate())) {
            return "The Card Expire Date is wrong.";
        }
        else if(card.getExpireDate().isBefore(LocalDate.now())) {
            return "This Card is expired.";
        }
        return handleNext(card);
    }
}
