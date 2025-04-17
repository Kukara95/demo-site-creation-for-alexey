package com.alexchern.demositecreation.domain.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@Table(name = "crypto_currency")
public class CryptoCurrency {

    public CryptoCurrency(String name, String symbol, double price) {
        this.name = name;
        this.symbol = symbol;
        this.price = price;
    }

    @Id
    private long id;
    private String name;
    private String symbol;
    private double price;
}
