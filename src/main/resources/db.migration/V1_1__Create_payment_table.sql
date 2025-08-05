create table if not exists payment (
                                       payment_id     varchar primary key,
                                       amount         double precision not null,
                                       devise         varchar not null,
                                       type_payment   varchar not null,
                                       payment_status varchar not null,
                                       creation_instant timestamp with time zone not null default now()
    );