package com.alexchern.demositecreation.web.controller;

import com.alexchern.demositecreation.domain.entity.CryptoCurrency;
import com.alexchern.demositecreation.domain.service.CryptoCurrencyService;
import com.alexchern.demositecreation.web.dto.CryptoCurrencyCreateRequest;
import com.alexchern.demositecreation.web.dto.CryptoCurrencyUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*")
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

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    private CryptoCurrency save(
            @RequestPart("createRequest") CryptoCurrencyCreateRequest createRequest,
            @RequestPart(value = "image", required = false) MultipartFile imageFile
    ) throws IOException {
        byte[] imageBytes = imageFile.getBytes();
        return service.create(createRequest, imageBytes);
    }

    @PatchMapping("/update/{id}")
    public CryptoCurrency update(@PathVariable long id, @RequestBody CryptoCurrencyUpdateRequest updateRequest) {
        return service.update(id, updateRequest);
    }
}
