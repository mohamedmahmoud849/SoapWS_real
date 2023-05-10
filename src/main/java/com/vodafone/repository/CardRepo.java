package com.vodafone.repository;

import com.vodafone.model.Card;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CardRepo {

    public Card findCardByNumber(long cardNumber) {
        String query = "select * from card where card_number = ?;";
        PreparedStatement stmt = null;
        try {
            stmt = DBConnection.conn.prepareStatement(query);
            stmt.setLong(1, cardNumber);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return Card.builder().cardNumber(rs.getLong("card_number"))
                        .pin(rs.getInt("pin"))
                        .expireDate(rs.getDate("expire_date").toLocalDate())
                        .build();
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
