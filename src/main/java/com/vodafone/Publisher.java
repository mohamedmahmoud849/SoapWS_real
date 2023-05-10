package com.vodafone;


import com.vodafone.service.CardService;

import javax.xml.ws.Endpoint;
import java.sql.SQLException;

public class Publisher {
    public static void main(String[] args) throws SQLException {
        Endpoint.publish("http://localhost:9090/wsdl", new HelloWorldImpl(new CardService()));
    }
}
