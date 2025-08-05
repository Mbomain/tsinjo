create table if not exists donation (
                                        id             varchar primary key,
                                        donor_id       varchar not null
                                        references donor (id) on delete cascade,
    payment_id     varchar not null
    references payment (payment_id) on delete cascade,
    date_donation  date not null,
    creation_instant timestamp with time zone not null default now()
    );