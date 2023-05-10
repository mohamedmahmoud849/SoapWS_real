package com.vodafone;


import com.vodafone.model.Card;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.sql.SQLException;
import java.time.LocalDate;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public interface HelloWorld {

    @WebMethod
    String hello(String name);

    @WebMethod
    boolean validateCard(long cardNumber, int pin, String expireDate);
}
