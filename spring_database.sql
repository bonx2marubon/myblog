\c postgres
DROP DATABASE IF EXISTS spring_blog;
DROP ROLE IF EXISTS student;
CREATE ROLE student WITH PASSWORD 'himitu' LOGIN;
CREATE DATABASE spring_blog OWNER student ENCODING 'UTF8';
