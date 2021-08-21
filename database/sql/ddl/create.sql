-- public.asset_category definition

-- Drop table

-- DROP TABLE public.asset_category;

CREATE TABLE public.asset_category (
    id varchar(255) NOT NULL,
    description varchar(255) NULL,
    "name" varchar(255) NULL,
    CONSTRAINT asset_category_pkey PRIMARY KEY (id)
);


-- public.asset definition

-- Drop table

-- DROP TABLE public.asset;

CREATE TABLE public.asset (
    id varchar(255) NOT NULL,
    code varchar(255) NULL,
    created_date timestamp NULL,
    "name" varchar(255) NOT NULL,
    updated_date timestamp NULL,
    asset_category_id varchar(255) NULL,
    CONSTRAINT asset_pkey PRIMARY KEY (id),
    CONSTRAINT uk_otknfh1h0k4kcduk3i986nyxp UNIQUE (name),
    CONSTRAINT asset_category_id_fk FOREIGN KEY (asset_category_id) REFERENCES asset_category(id)
);


-- public.asset_holding definition

-- Drop table

-- DROP TABLE public.asset_holding;

CREATE TABLE public.asset_holding (
    id varchar(255) NOT NULL,
    "hold" float8 NULL,
    asset_id varchar(255) NOT NULL,
    CONSTRAINT asset_holding_pkey PRIMARY KEY (id),
    CONSTRAINT asset_id_fk FOREIGN KEY (asset_id) REFERENCES asset(id)
);


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
    CONSTRAINT asset_price_history_pkey PRIMARY KEY (id),
    CONSTRAINT asset_id_fk FOREIGN KEY (asset_id) REFERENCES asset(id)
);


-- public.asset_transaction definition

-- Drop table

-- DROP TABLE public.asset_transaction;

CREATE TABLE public.asset_transaction (
    id varchar(255) NOT NULL,
    created_date timestamp NULL,
    notes varchar(255) NULL,
    price float8 NULL,
    updated_date timestamp NULL,
    asset_holding_id varchar(255) NULL,
    CONSTRAINT asset_transaction_pkey PRIMARY KEY (id),
    CONSTRAINT fk5fah28dxk282ftjjlkp1rt64a FOREIGN KEY (asset_holding_id) REFERENCES asset_holding(id)
);


CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
SELECT uuid_generate_v4();