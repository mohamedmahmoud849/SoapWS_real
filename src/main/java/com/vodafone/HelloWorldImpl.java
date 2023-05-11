package com.vodafone;

import com.vodafone.service.CardService;
import lombok.RequiredArgsConstructor;

import javax.jws.WebService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@RequiredArgsConstructor
@WebService(endpointInterface = "com.vodafone.HelloWorld")
public class HelloWorldImpl implements HelloWorld{

    private final CardService cardService;
    @Override
    public String hello(String name) {
        return "Hello ya " + name;
    }

    @Override
    public String validateCard(long cardNumber, int pin, String expireDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        formatter = formatter.withLocale(Locale.ENGLISH);
        LocalDate date = LocalDate.parse(expireDate, formatter);
        return cardService.validateCard(cardNumber, pin, date);
    }
}
