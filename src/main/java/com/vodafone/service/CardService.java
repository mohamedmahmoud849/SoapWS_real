package com.vodafone.service;

import com.vodafone.handler.*;
import com.vodafone.model.Card;
import com.vodafone.repository.CardRepo;

import java.time.LocalDate;

public class CardService {

    public String validateCard(long cardNumber, int pin, LocalDate expireDate){
        Card card = Card.builder()
                .cardNumber(cardNumber)
                .pin(pin)
                .expireDate(expireDate)
                .build();

        CardRepo cardRepo = new CardRepo();
        Handler handler = new CardNumberHandler();
        handler.setNextHandler(new CardExistHandler(cardRepo))
                .setNextHandler(new PinHandler(cardRepo))
                .setNextHandler(new ExipreDateHandler(cardRepo));

        return handler.handle(card);
    }

}
