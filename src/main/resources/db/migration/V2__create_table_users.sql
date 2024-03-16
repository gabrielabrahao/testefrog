CREATE TABLE IF NOT EXISTS public.users
(
    id uuid NOT NULL PRIMARY KEY,
    Username varchar NOT NULL UNIQUE,
    password varchar NOT NULL,
    role varchar NOT NULL
);