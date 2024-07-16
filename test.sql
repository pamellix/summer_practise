CREATE TABLE public.ports
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    name character varying NOT NULL,
    city character varying NOT NULL,
    quantity_of_ships character varying NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS public.ports
    OWNER to postgres;

CREATE TABLE public.ships
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    name character varying NOT NULL,
    capacity character varying NOT NULL,
    size character varying NOT NULL,
    speed character varying NOT NULL,
    route integer NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT route FOREIGN KEY (route)
        REFERENCES public.ports (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

ALTER TABLE IF EXISTS public.ships
    OWNER to postgres;

CREATE TABLE public.tourists
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    name character varying NOT NULL,
    surname character varying NOT NULL,
    ship integer NOT NULL,
    quantity_of_days integer NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT ship FOREIGN KEY (ship)
        REFERENCES public.ships (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

ALTER TABLE IF EXISTS public.tourists
    OWNER to postgres;