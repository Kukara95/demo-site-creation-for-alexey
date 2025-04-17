create table if not exists crypto_currency
(
    id     serial       primary key,
    symbol varchar(30)  unique,
    name   varchar(150),
    price  double precision
);

create index if not exists idx_crypto_currency_symbol on crypto_currency (symbol);
