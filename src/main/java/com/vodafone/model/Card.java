package com.vodafone.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Setter
@Getter
@ToString
@Builder
public class Card {
    private long cardNumber;
    private int pin;
    private LocalDate expireDate;


}
