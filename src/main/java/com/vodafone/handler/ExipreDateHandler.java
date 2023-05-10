package com.vodafone.handler;

import com.vodafone.model.Card;
import com.vodafone.repository.CardRepo;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@RequiredArgsConstructor
public class ExipreDateHandler extends Handler{

    private final CardRepo cardRepo;
    @Override
    public boolean handle(Card card) {
        LocalDate expireDate = null;
        expireDate = cardRepo.findCardByNumber(card.getCardNumber()).getExpireDate();
        if(!expireDate.equals(card.getExpireDate())) {
            System.out.println("The Card Expire Date is wrong.");
            return false;
        }
        else if(card.getExpireDate().isBefore(LocalDate.now())) {
            System.out.println("This Card is expired.");
            return false;
        }
        return handleNext(card);
    }
}
