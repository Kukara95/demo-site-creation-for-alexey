package com.alexchern.demositecreation.domain.repository;

import com.alexchern.demositecreation.domain.entity.CryptoCurrency;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CryptoCurrencyRepository extends CrudRepository<CryptoCurrency, Long> {

    Optional<CryptoCurrency> findBySymbol(String symbol);
}
