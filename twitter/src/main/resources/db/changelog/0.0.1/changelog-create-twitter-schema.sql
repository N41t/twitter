--liquibase formatted sql

--changeset MikhailBelozerov:create-twitter-schema
--comment create new schema
create schema twitter;
--rollback drop schema twitter;

