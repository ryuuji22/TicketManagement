--
-- PostgreSQL database dump
--

-- Dumped from database version 12.3
-- Dumped by pg_dump version 12.3

-- Started on 2020-10-11 13:08:51

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
-- TOC entry 2875 (class 0 OID 16854)
-- Dependencies: 203
-- Data for Name: usuarios; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.usuarios VALUES (1, 'dhinojosa', '827ccb0eea8a706c4c34a16891f84e7b', true, false, true);
INSERT INTO public.usuarios VALUES (2, 'agente', 'f77538d26d37221483971c3323d5f050', false, true, true);
INSERT INTO public.usuarios VALUES (3, 'usuario1', '122b738600a0f74f7c331c0ef59bc34c', true, false, true);
INSERT INTO public.usuarios VALUES (4, 'agente2', 'e04a34d8963b0d287791975d2e379bea', false, true, true);
INSERT INTO public.usuarios VALUES (5, 'admin', '21232f297a57a5a743894a0e4a801fc3', true, true, true);


--
-- TOC entry 2885 (class 0 OID 16942)
-- Dependencies: 213
-- Data for Name: autoridades; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.autoridades VALUES (1, 1, 'ROLE_USER');
INSERT INTO public.autoridades VALUES (2, 2, 'ROLE_USER');
INSERT INTO public.autoridades VALUES (3, 3, 'ROLE_USER');
INSERT INTO public.autoridades VALUES (4, 4, 'ROLE_USER');
INSERT INTO public.autoridades VALUES (5, 5, 'ROLE_USER');


--
-- TOC entry 2877 (class 0 OID 16865)
-- Dependencies: 205
-- Data for Name: estados; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.estados VALUES (1, 'Abierto', '#000000');
INSERT INTO public.estados VALUES (3, 'Escalado', '#D41E24');
INSERT INTO public.estados VALUES (2, 'Cerrado', '#045c30');


--
-- TOC entry 2879 (class 0 OID 16879)
-- Dependencies: 207
-- Data for Name: prioridades; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.prioridades VALUES (2, 'Media', '#FF6600');
INSERT INTO public.prioridades VALUES (3, 'Alta', '#FF0000');
INSERT INTO public.prioridades VALUES (1, 'Baja', '#045c30');


--
-- TOC entry 2881 (class 0 OID 16890)
-- Dependencies: 209
-- Data for Name: cticket; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.cticket VALUES (16, 'Problema con el router', 'Por favor necesito que me ayuden no tengo internet y el router se está calentando mucho', 2, 3, 1, 4, '2020-10-11 12:39:14.929', '2020-10-11 12:44:30.399');
INSERT INTO public.cticket VALUES (17, 'Problemas con mi máquina', 'También mi PC se está reiniciando a cada rato', 2, 2, 1, 5, '2020-10-11 12:40:01.312', '2020-10-11 12:55:39.998');


--
-- TOC entry 2883 (class 0 OID 16921)
-- Dependencies: 211
-- Data for Name: dticket; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.dticket VALUES (19, 17, 'Intente por favor desconectar la PC de la corriente, espere 1 minuto, vuelva a conectar y prenda nuevamente.', '2020-10-11 12:41:27.275', 2);
INSERT INTO public.dticket VALUES (20, 17, 'Seguí sus indicaciones pero sigue con el mismo problema', '2020-10-11 12:42:22.043', 1);
INSERT INTO public.dticket VALUES (21, 16, 'Se ha reconfigurado el router remotamente. El problema queda solucionado.', '2020-10-11 12:44:19.307', 4);
INSERT INTO public.dticket VALUES (22, 17, 'Se enviará un técnico a revisar su máquina', '2020-10-11 12:51:38.87', 5);
INSERT INTO public.dticket VALUES (23, 17, 'El técnico ha resuelto el problema, muchas gracias.', '2020-10-11 12:52:15.272', 1);


--
-- TOC entry 2891 (class 0 OID 0)
-- Dependencies: 212
-- Name: autoridades_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.autoridades_id_seq', 5, true);


--
-- TOC entry 2892 (class 0 OID 0)
-- Dependencies: 208
-- Name: cticket_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cticket_id_seq', 17, true);


--
-- TOC entry 2893 (class 0 OID 0)
-- Dependencies: 210
-- Name: dticket_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.dticket_id_seq', 23, true);


--
-- TOC entry 2894 (class 0 OID 0)
-- Dependencies: 204
-- Name: estados_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.estados_id_seq', 3, true);


--
-- TOC entry 2895 (class 0 OID 0)
-- Dependencies: 206
-- Name: prioridades_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.prioridades_id_seq', 3, true);


--
-- TOC entry 2896 (class 0 OID 0)
-- Dependencies: 202
-- Name: usuarios_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.usuarios_id_seq', 5, true);


-- Completed on 2020-10-11 13:08:52

--
-- PostgreSQL database dump complete
--

