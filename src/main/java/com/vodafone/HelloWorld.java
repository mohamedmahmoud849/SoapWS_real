package com.vodafone;


import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public interface HelloWorld {

    @WebMethod
    String hello(String name);

    @WebMethod
    String validateCard(long cardNumber, int pin, String expireDate);
}
