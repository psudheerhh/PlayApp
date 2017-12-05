# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table record (
  id                            bigint not null,
  first_name                    varchar(255),
  last_name                     varchar(255),
  address                       varchar(255),
  zip_code                      varchar(255),
  phone_number                  varchar(255),
  color                         varchar(255),
  constraint pk_record primary key (id)
);
create sequence record_seq;


# --- !Downs

drop table if exists record;
drop sequence if exists record_seq;

