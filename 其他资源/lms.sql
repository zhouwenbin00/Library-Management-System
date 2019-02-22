/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019-02-22 20:55:00                          */
/*==============================================================*/


drop table if exists role;

drop table if exists tb_authority;

drop table if exists tb_book;

drop table if exists tb_category;

drop table if exists tb_readers;

drop table if exists tb_record;

drop table if exists tb_user;

/*==============================================================*/
/* Table: role                                                  */
/*==============================================================*/
create table role
(
   id                   integer not null,
   role_name            varchar(10),
   role_authority       varchar(255),
   primary key (id)
);

/*==============================================================*/
/* Table: tb_authority                                          */
/*==============================================================*/
create table tb_authority
(
   user_id              integer not null,
   autority             varchar(255),
   primary key (user_id)
);

/*==============================================================*/
/* Table: tb_book                                               */
/*==============================================================*/
create table tb_book
(
   id                   integer not null,
   book_code            varchar(10),
   book_name            varchar(10) not null,
   ISBN                 varchar(10),
   author               varchar(10),
   category_id          integer,
   price                double,
   press                varchar(10),
   page                 integer,
   total_num            integer,
   left_num             integer,
   register_date        date,
   position             varchar(10),
   primary key (id)
);

/*==============================================================*/
/* Table: tb_category                                           */
/*==============================================================*/
create table tb_category
(
   id                   integer not null auto_increment,
   category             varchar(10),
   primary key (id)
);

/*==============================================================*/
/* Table: tb_readers                                            */
/*==============================================================*/
create table tb_readers
(
   id                   integer not null,
   reader_name          varchar(10),
   reader_num           varchar(10),
   sex                  varchar(1),
   tel                  integer(11),
   status               varchar(10),
   college              varchar(10),
   balance              double,
   class                integer(10),
   borrow_time          integer(10),
   register_date        date,
   validity_date        date,
   primary key (id)
);

/*==============================================================*/
/* Table: tb_record                                             */
/*==============================================================*/
create table tb_record
(
   id                   integer not null,
   book_num             varchar(10),
   book_name            varchar(10),
   reader_name          varchar(10),
   borrow_date          date,
   return_date          date,
   status               varchar(10),
   rent                 double,
   borrows_days         integer,
   over_days            integer,
   over_rent            double,
   primary key (id)
);

/*==============================================================*/
/* Table: tb_user                                               */
/*==============================================================*/
create table tb_user
(
   id                   integer not null,
   username             varchar(10) not null,
   password             varchar(10) not null,
   role_id              varchar(10),
   primary key (id)
);

