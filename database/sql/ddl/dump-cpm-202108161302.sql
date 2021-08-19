--
-- PostgreSQL database dump
--

-- Dumped from database version 12.2
-- Dumped by pg_dump version 12.2

-- Started on 2021-08-16 13:02:26

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 3 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO postgres;

--
-- TOC entry 2822 (class 0 OID 0)
-- Dependencies: 3
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'standard public schema';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 202 (class 1259 OID 102902)
-- Name: cryptocurrency; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cryptocurrency (
    id character varying(255) NOT NULL,
    code character varying(255),
    created_date timestamp without time zone,
    name character varying(255) NOT NULL,
    updated_date timestamp without time zone
);


ALTER TABLE public.cryptocurrency OWNER TO postgres;

--
-- TOC entry 2816 (class 0 OID 102902)
-- Dependencies: 202
-- Data for Name: cryptocurrency; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2687 (class 2606 OID 102909)
-- Name: cryptocurrency cryptocurrency_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cryptocurrency
    ADD CONSTRAINT cryptocurrency_pkey PRIMARY KEY (id);


--
-- TOC entry 2689 (class 2606 OID 102911)
-- Name: cryptocurrency uk_86rdj5sxbvou7laumldq058m5; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cryptocurrency
    ADD CONSTRAINT uk_86rdj5sxbvou7laumldq058m5 UNIQUE (name);


-- Completed on 2021-08-16 13:02:26

--
-- PostgreSQL database dump complete
--

