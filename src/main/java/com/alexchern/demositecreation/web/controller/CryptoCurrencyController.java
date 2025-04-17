package com.alexchern.demositecreation.web.controller;

import com.alexchern.demositecreation.domain.entity.CryptoCurrency;
import com.alexchern.demositecreation.domain.service.CryptoCurrencyService;
import com.alexchern.demositecreation.web.dto.CryptoCurrencyCreateRequest;
import com.alexchern.demositecreation.web.dto.CryptoCurrencyUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/crypto-currency")
@RequiredArgsConstructor
public class CryptoCurrencyController {

    private final CryptoCurrencyService service;

    @GetMapping
    public List<CryptoCurrency> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public CryptoCurrency getById(@PathVariable long id) {
        return service.getById(id);
    }

    @GetMapping("/by-symbol/{symbol}")
    public CryptoCurrency getBySymbol(@PathVariable String symbol) {
        return service.getBySymbol(symbol);
    }

    @PostMapping
    private CryptoCurrency save(@RequestBody CryptoCurrencyCreateRequest createRequest) {
        return service.create(createRequest);
    }

    @PatchMapping("/update/{id}")
    public CryptoCurrency update(@PathVariable long id, @RequestBody CryptoCurrencyUpdateRequest updateRequest) {
        return service.update(id, updateRequest);
    }
}
