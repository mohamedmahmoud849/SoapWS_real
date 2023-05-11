package com.vodafone.handler;

import com.vodafone.model.Card;

public abstract class Handler {
    private Handler next;

    public Handler setNextHandler(Handler nextHandler) {
        this.next = nextHandler;
        return next;
    }

    public abstract String handle(Card card);
    protected String handleNext(Card card){
        if(next == null) {
            return "Valid";
        }
        return next.handle(card);
    }
}
