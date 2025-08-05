create table if not exists donor (
                                     id         varchar primary key,
                                     full_name  varchar not null,
                                     email      varchar not null unique,
                                     creation_instant timestamp with time zone not null default now()
    );
create index if not exists donor_email_index on donor (email);
