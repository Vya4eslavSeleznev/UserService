
CREATE TABLE IF NOT EXISTS public.contact
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY,
    email character varying COLLATE pg_catalog."default" NOT NULL,
    phone character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT contact_pkey PRIMARY KEY (id),
    CONSTRAINT uq_email UNIQUE (email)
        INCLUDE(email),
    CONSTRAINT uq_phone UNIQUE (phone)
        INCLUDE(phone)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.contact
    OWNER to postgres;




CREATE TABLE IF NOT EXISTS public.credential
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY,
    username character varying COLLATE pg_catalog."default" NOT NULL,
    password character varying COLLATE pg_catalog."default" NOT NULL,
    role character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT credential_pkey PRIMARY KEY (id),
    CONSTRAINT uq_login UNIQUE (username)
        INCLUDE(username)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.credential
    OWNER to postgres;




CREATE TABLE IF NOT EXISTS public.customer
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY,
    name character varying COLLATE pg_catalog."default" NOT NULL,
    surname character varying COLLATE pg_catalog."default" NOT NULL,
    last_name character varying COLLATE pg_catalog."default" NOT NULL,
    contact_id integer NOT NULL,
    credential_id integer NOT NULL,
    birth_date timestamp without time zone NOT NULL,
    CONSTRAINT customer_pkey PRIMARY KEY (id),
    CONSTRAINT fk_contact FOREIGN KEY (contact_id)
        REFERENCES public.contact (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
        NOT VALID,
    CONSTRAINT fk_credential FOREIGN KEY (credential_id)
        REFERENCES public.credential (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.customer
    OWNER to postgres
