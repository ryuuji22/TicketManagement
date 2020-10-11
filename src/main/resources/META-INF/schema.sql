--
-- PostgreSQL database dump
--

-- Dumped from database version 12.3
-- Dumped by pg_dump version 12.3

-- Started on 2020-10-11 13:07:31

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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 213 (class 1259 OID 16942)
-- Name: autoridades; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.autoridades (
    id integer NOT NULL,
    usuario integer,
    rol character varying
);


ALTER TABLE public.autoridades OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 16940)
-- Name: autoridades_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.autoridades_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.autoridades_id_seq OWNER TO postgres;

--
-- TOC entry 2879 (class 0 OID 0)
-- Dependencies: 212
-- Name: autoridades_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.autoridades_id_seq OWNED BY public.autoridades.id;


--
-- TOC entry 209 (class 1259 OID 16890)
-- Name: cticket; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cticket (
    id integer NOT NULL,
    asunto character varying(500),
    descripcion text,
    estado integer,
    prioridad integer,
    usuario integer,
    agente integer,
    creado timestamp without time zone,
    completado timestamp without time zone
);


ALTER TABLE public.cticket OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 16888)
-- Name: cticket_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cticket_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.cticket_id_seq OWNER TO postgres;

--
-- TOC entry 2880 (class 0 OID 0)
-- Dependencies: 208
-- Name: cticket_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cticket_id_seq OWNED BY public.cticket.id;


--
-- TOC entry 211 (class 1259 OID 16921)
-- Name: dticket; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.dticket (
    id integer NOT NULL,
    cticket integer,
    comentario text,
    creado timestamp without time zone,
    usuario integer
);


ALTER TABLE public.dticket OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 16919)
-- Name: dticket_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.dticket_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.dticket_id_seq OWNER TO postgres;

--
-- TOC entry 2881 (class 0 OID 0)
-- Dependencies: 210
-- Name: dticket_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.dticket_id_seq OWNED BY public.dticket.id;


--
-- TOC entry 205 (class 1259 OID 16865)
-- Name: estados; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.estados (
    id integer NOT NULL,
    nombre character varying,
    color character varying
);


ALTER TABLE public.estados OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 16863)
-- Name: estados_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.estados_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.estados_id_seq OWNER TO postgres;

--
-- TOC entry 2882 (class 0 OID 0)
-- Dependencies: 204
-- Name: estados_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.estados_id_seq OWNED BY public.estados.id;


--
-- TOC entry 206 (class 1259 OID 16877)
-- Name: prioridades_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.prioridades_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 2147483647
    CACHE 1;


ALTER TABLE public.prioridades_id_seq OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 16879)
-- Name: prioridades; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.prioridades (
    id integer DEFAULT nextval('public.prioridades_id_seq'::regclass) NOT NULL,
    nombre character varying,
    color character varying
);


ALTER TABLE public.prioridades OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 16854)
-- Name: usuarios; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuarios (
    id integer NOT NULL,
    username character varying,
    password character varying,
    usuario boolean,
    agente boolean,
    enabled boolean
);


ALTER TABLE public.usuarios OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 16852)
-- Name: usuarios_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.usuarios_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.usuarios_id_seq OWNER TO postgres;

--
-- TOC entry 2883 (class 0 OID 0)
-- Dependencies: 202
-- Name: usuarios_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.usuarios_id_seq OWNED BY public.usuarios.id;


--
-- TOC entry 2728 (class 2604 OID 16945)
-- Name: autoridades id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.autoridades ALTER COLUMN id SET DEFAULT nextval('public.autoridades_id_seq'::regclass);


--
-- TOC entry 2726 (class 2604 OID 16893)
-- Name: cticket id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cticket ALTER COLUMN id SET DEFAULT nextval('public.cticket_id_seq'::regclass);


--
-- TOC entry 2727 (class 2604 OID 16924)
-- Name: dticket id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.dticket ALTER COLUMN id SET DEFAULT nextval('public.dticket_id_seq'::regclass);


--
-- TOC entry 2724 (class 2604 OID 16868)
-- Name: estados id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.estados ALTER COLUMN id SET DEFAULT nextval('public.estados_id_seq'::regclass);


--
-- TOC entry 2723 (class 2604 OID 16857)
-- Name: usuarios id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuarios ALTER COLUMN id SET DEFAULT nextval('public.usuarios_id_seq'::regclass);


--
-- TOC entry 2740 (class 2606 OID 16950)
-- Name: autoridades autoridades_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.autoridades
    ADD CONSTRAINT autoridades_pkey PRIMARY KEY (id);


--
-- TOC entry 2736 (class 2606 OID 16898)
-- Name: cticket cticket_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cticket
    ADD CONSTRAINT cticket_pkey PRIMARY KEY (id);


--
-- TOC entry 2738 (class 2606 OID 16929)
-- Name: dticket dticket_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.dticket
    ADD CONSTRAINT dticket_pkey PRIMARY KEY (id);


--
-- TOC entry 2732 (class 2606 OID 16873)
-- Name: estados estados_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.estados
    ADD CONSTRAINT estados_pkey PRIMARY KEY (id);


--
-- TOC entry 2734 (class 2606 OID 16887)
-- Name: prioridades prioridades_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.prioridades
    ADD CONSTRAINT prioridades_pkey PRIMARY KEY (id);


--
-- TOC entry 2730 (class 2606 OID 16862)
-- Name: usuarios usuarios_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT usuarios_pkey PRIMARY KEY (id);


--
-- TOC entry 2745 (class 2606 OID 16930)
-- Name: dticket dticket_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.dticket
    ADD CONSTRAINT dticket_fk1 FOREIGN KEY (cticket) REFERENCES public.cticket(id);


--
-- TOC entry 2746 (class 2606 OID 16935)
-- Name: dticket dticket_fk2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.dticket
    ADD CONSTRAINT dticket_fk2 FOREIGN KEY (usuario) REFERENCES public.usuarios(id);


--
-- TOC entry 2741 (class 2606 OID 16899)
-- Name: cticket ticket_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cticket
    ADD CONSTRAINT ticket_fk1 FOREIGN KEY (estado) REFERENCES public.estados(id);


--
-- TOC entry 2742 (class 2606 OID 16904)
-- Name: cticket ticket_fk2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cticket
    ADD CONSTRAINT ticket_fk2 FOREIGN KEY (prioridad) REFERENCES public.prioridades(id);


--
-- TOC entry 2743 (class 2606 OID 16909)
-- Name: cticket ticket_fk3; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cticket
    ADD CONSTRAINT ticket_fk3 FOREIGN KEY (usuario) REFERENCES public.usuarios(id);


--
-- TOC entry 2744 (class 2606 OID 16914)
-- Name: cticket ticket_fk4; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cticket
    ADD CONSTRAINT ticket_fk4 FOREIGN KEY (agente) REFERENCES public.usuarios(id);


--
-- TOC entry 2747 (class 2606 OID 16951)
-- Name: autoridades usuarios_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.autoridades
    ADD CONSTRAINT usuarios_fk1 FOREIGN KEY (usuario) REFERENCES public.usuarios(id);


-- Completed on 2020-10-11 13:07:31

--
-- PostgreSQL database dump complete
--

