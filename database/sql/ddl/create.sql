

-- public.asset_price_history definition

-- Drop table

-- DROP TABLE public.asset_price_history;

CREATE TABLE public.asset_price_history (
    id varchar(255) NOT NULL,
    "close" float8 NULL,
    created_date timestamp NULL,
    "date" date NULL,
    high float8 NULL,
    low float8 NULL,
    "open" float8 NULL,
    updated_date timestamp NULL,
    volumn float8 NULL,
    asset_id varchar(255) NOT NULL,
    CONSTRAINT asset_price_history_pkey PRIMARY KEY (id)
);


-- public.asset_price_history foreign keys

ALTER TABLE public.asset_price_history ADD CONSTRAINT asset_id_fk FOREIGN KEY (asset_id) REFERENCES asset(id);

-- public.asset_transaction definition

-- Drop table

-- DROP TABLE public.asset_transaction;

CREATE TABLE public.asset_transaction (
    id varchar(255) NOT NULL,
    "cost" float8 NULL,
    created_date timestamp NULL,
    fee float8 NULL,
    notes varchar(255) NULL,
    price float8 NULL,
    proceeds float8 NULL,
    profit float8 NULL,
    quantity float8 NULL,
    "type" int4 NULL,
    updated_date timestamp NULL,
    asset_id varchar(255) NOT NULL,
    CONSTRAINT asset_transaction_pkey PRIMARY KEY (id)
);


-- public.asset_transaction foreign keys

ALTER TABLE public.asset_transaction ADD CONSTRAINT asset_id_fk FOREIGN KEY (asset_id) REFERENCES asset(id);
