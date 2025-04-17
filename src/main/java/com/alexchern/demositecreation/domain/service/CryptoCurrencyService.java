package com.alexchern.demositecreation.domain.service;

import com.alexchern.demositecreation.domain.entity.CryptoCurrency;
import com.alexchern.demositecreation.domain.repository.CryptoCurrencyRepository;
import com.alexchern.demositecreation.web.dto.CryptoCurrencyCreateRequest;
import com.alexchern.demositecreation.web.dto.CryptoCurrencyUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CryptoCurrencyService {

    private final CryptoCurrencyRepository repository;

    @Transactional(readOnly = true)
    public List<CryptoCurrency> findAll() {
        return (List<CryptoCurrency>) repository.findAll();
    }

    @Transactional(readOnly = true)
    public CryptoCurrency getById(Long id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("CryptoCurrency with id: %s doesn't exists".formatted(id)));
    }

    @Transactional(readOnly = true)
    public CryptoCurrency getBySymbol(String symbol) {
        return repository
                .findBySymbol(symbol)
                .orElseThrow(() -> new IllegalArgumentException("CryptoCurrency with symbol: %s doesn't exists".formatted(symbol)));
    }

    public CryptoCurrency update(long id, CryptoCurrencyUpdateRequest updateRequest) {
        CryptoCurrency cryptoCurrency = getById(id);
        boolean wasUpdated = false;

        if (updateRequest.getName() != null) {
            cryptoCurrency.setName(updateRequest.getName());
            wasUpdated = true;
        }

        if (updateRequest.getSymbol() != null) {
            cryptoCurrency.setSymbol(updateRequest.getSymbol());
            wasUpdated = true;
        }

        if (updateRequest.getPrice() != null) {
            cryptoCurrency.setPrice(updateRequest.getPrice());
            wasUpdated = true;
        }

        if (wasUpdated) {
            repository.save(cryptoCurrency);
        }

        return cryptoCurrency;
    }

    public CryptoCurrency create(CryptoCurrencyCreateRequest updateRequest) {
        CryptoCurrency cryptoCurrency = new CryptoCurrency(
                updateRequest.getName(),
                updateRequest.getSymbol(),
                updateRequest.getPrice()
        );

        return repository.save(cryptoCurrency);
    }
}
