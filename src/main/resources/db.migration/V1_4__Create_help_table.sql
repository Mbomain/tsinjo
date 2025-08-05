create table if not exists help (
                                    id             varchar primary key,
                                    beneficiary_id varchar not null
                                    references beneficiary (id) on delete cascade,
    payment_id     varchar not null
    references payment (payment_id) on delete cascade,
    notif_help     text,
    date_help      date not null,
    creation_instant timestamp with time zone not null default now()
    );