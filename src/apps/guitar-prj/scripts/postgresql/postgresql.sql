CREATE USER xfjr WITH LOGIN SUPERUSER INHERIT CREATEDB CREATEROLE NOREPLICATION PASSWORD 'xfjr';
CREATE DATABASE xfjr WITH OWNER = xfjr ENCODING = 'UTF8' CONNECTION LIMIT = -1;
\c xfjr
CREATE SCHEMA xfjr_cb;
