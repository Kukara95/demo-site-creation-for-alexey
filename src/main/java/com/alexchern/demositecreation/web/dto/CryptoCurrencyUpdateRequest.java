package com.alexchern.demositecreation.web.dto;

import lombok.Data;

@Data
public class CryptoCurrencyUpdateRequest {
    private String symbol;
    private Double price;
    private String name;
}
