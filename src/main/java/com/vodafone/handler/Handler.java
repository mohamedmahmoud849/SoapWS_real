package com.vodafone.handler;

import com.vodafone.model.Card;

import java.sql.SQLException;

public abstract class Handler {
    private Handler next;

    public Handler setNextHandler(Handler nextHandler) {
        this.next = nextHandler;
        return next;
    }

    public abstract boolean handle(Card card);
    protected boolean handleNext(Card card){
        if(next == null) {
            return true;
        }
        return next.handle(card);
    }
}
