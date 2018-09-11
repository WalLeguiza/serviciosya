PGDMP         ;        
        v            serviciosya    9.5.14    10.4     R           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            S           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            T           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false            U           1262    16393    serviciosya    DATABASE     �   CREATE DATABASE serviciosya WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'English_United States.1252' LC_CTYPE = 'English_United States.1252';
    DROP DATABASE serviciosya;
             postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
             postgres    false            V           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                  postgres    false    6            W           0    0    SCHEMA public    ACL     �   REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;
                  postgres    false    6                        3079    12355    plpgsql 	   EXTENSION     ?   CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;
    DROP EXTENSION plpgsql;
                  false            X           0    0    EXTENSION plpgsql    COMMENT     @   COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';
                       false    1            �            1259    16438    CITY_SEQ    SEQUENCE     s   CREATE SEQUENCE public."CITY_SEQ"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 !   DROP SEQUENCE public."CITY_SEQ";
       public       postgres    false    6            �            1259    16421    CITY    TABLE     �   CREATE TABLE public."CITY" (
    "ID" integer DEFAULT nextval('public."CITY_SEQ"'::regclass) NOT NULL,
    "NAME" character varying(48) NOT NULL,
    "PROVINCE" integer NOT NULL
);
    DROP TABLE public."CITY";
       public         postgres    false    186    6            �            1259    16436    COUNTRY_SEQ    SEQUENCE     v   CREATE SEQUENCE public."COUNTRY_SEQ"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public."COUNTRY_SEQ";
       public       postgres    false    6            �            1259    16404    COUNTRY    TABLE     �   CREATE TABLE public."COUNTRY" (
    "ID" integer DEFAULT nextval('public."COUNTRY_SEQ"'::regclass) NOT NULL,
    "NAME" character varying(48) NOT NULL
);
    DROP TABLE public."COUNTRY";
       public         postgres    false    185    6            �            1259    16442    OCCUPATION_SEQ    SEQUENCE     y   CREATE SEQUENCE public."OCCUPATION_SEQ"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public."OCCUPATION_SEQ";
       public       postgres    false    6            �            1259    16394 
   OCCUPATION    TABLE     �   CREATE TABLE public."OCCUPATION" (
    "ID" integer DEFAULT nextval('public."OCCUPATION_SEQ"'::regclass) NOT NULL,
    "NAME" character varying(48) NOT NULL,
    "DESCRIPTION" character varying(128) NOT NULL,
    "PARENT" integer
);
     DROP TABLE public."OCCUPATION";
       public         postgres    false    188    6            �            1259    16440    PROVINCE_SEQ    SEQUENCE     w   CREATE SEQUENCE public."PROVINCE_SEQ"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public."PROVINCE_SEQ";
       public       postgres    false    6            �            1259    16412    PROVINCE    TABLE     �   CREATE TABLE public."PROVINCE" (
    "ID" integer DEFAULT nextval('public."PROVINCE_SEQ"'::regclass) NOT NULL,
    "NAME" character varying(48) NOT NULL,
    "COUNTRY" integer NOT NULL
);
    DROP TABLE public."PROVINCE";
       public         postgres    false    187    6            �           2606    16425    CITY CITY_pk 
   CONSTRAINT     P   ALTER TABLE ONLY public."CITY"
    ADD CONSTRAINT "CITY_pk" PRIMARY KEY ("ID");
 :   ALTER TABLE ONLY public."CITY" DROP CONSTRAINT "CITY_pk";
       public         postgres    false    184            �           2606    16411    COUNTRY COUNTRY_pk 
   CONSTRAINT     V   ALTER TABLE ONLY public."COUNTRY"
    ADD CONSTRAINT "COUNTRY_pk" PRIMARY KEY ("ID");
 @   ALTER TABLE ONLY public."COUNTRY" DROP CONSTRAINT "COUNTRY_pk";
       public         postgres    false    182            �           2606    16398    OCCUPATION OCCUPATION_pk 
   CONSTRAINT     \   ALTER TABLE ONLY public."OCCUPATION"
    ADD CONSTRAINT "OCCUPATION_pk" PRIMARY KEY ("ID");
 F   ALTER TABLE ONLY public."OCCUPATION" DROP CONSTRAINT "OCCUPATION_pk";
       public         postgres    false    181            �           2606    16416    PROVINCE PROVINCE_pk 
   CONSTRAINT     X   ALTER TABLE ONLY public."PROVINCE"
    ADD CONSTRAINT "PROVINCE_pk" PRIMARY KEY ("ID");
 B   ALTER TABLE ONLY public."PROVINCE" DROP CONSTRAINT "PROVINCE_pk";
       public         postgres    false    183            �           2606    16431    CITY CITY_fk_PROVINCE    FK CONSTRAINT     �   ALTER TABLE ONLY public."CITY"
    ADD CONSTRAINT "CITY_fk_PROVINCE" FOREIGN KEY ("PROVINCE") REFERENCES public."PROVINCE"("ID");
 C   ALTER TABLE ONLY public."CITY" DROP CONSTRAINT "CITY_fk_PROVINCE";
       public       postgres    false    183    184    2008            �           2606    16399    OCCUPATION OCCUPATION_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public."OCCUPATION"
    ADD CONSTRAINT "OCCUPATION_fk" FOREIGN KEY ("PARENT") REFERENCES public."OCCUPATION"("ID");
 F   ALTER TABLE ONLY public."OCCUPATION" DROP CONSTRAINT "OCCUPATION_fk";
       public       postgres    false    2004    181    181            �           2606    16426    PROVINCE PROVINCE_fk_COUNTRY    FK CONSTRAINT     �   ALTER TABLE ONLY public."PROVINCE"
    ADD CONSTRAINT "PROVINCE_fk_COUNTRY" FOREIGN KEY ("COUNTRY") REFERENCES public."COUNTRY"("ID");
 J   ALTER TABLE ONLY public."PROVINCE" DROP CONSTRAINT "PROVINCE_fk_COUNTRY";
       public       postgres    false    2006    183    182           