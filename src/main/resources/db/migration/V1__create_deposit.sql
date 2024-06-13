create schema if not exists depositsmtsbank;
create table if not exists depositsmtsbank.deposits (
    id_deposit int primary key,
    deposit_account_id int not null,
    deposit_type_id int not null unique ,
    deposit_refill boolean not null default true,
    deposit_amount numeric(20,2) not null default 10000.00,
    start_date date not null,
    end_date date not null,
    deposit_rate decimal(4,2),
    type_percent_payment_id int unique ,
    percent_payment_date date,
    percent_payment_account_id int not null,
    capitalization boolean not null,
    deposit_refund_account_id integer not null
);
create table if not exists depositsmtsbank.deposit_types(
    id_deposit_types int primary key,
    deposit_types_name character varying(28) not null
);
create table if not exists depositsmtsbank.types_percent_payment(
    id_type_percent_payment int primary key,
    type_percent_payment_period character varying(13) not null
);
create table if not exists depositsmtsbank.customer_deposits(
    customer_id int,
    deposit_id int primary key
);
create table if not exists depositsmtsbank.requests(
    id_request int primary key,
    customer_id int not null,
    request_date date not null,
    deposit_id integer not null unique
);
create table if not exists depositsmtsbank.current_request_status(
    request_id int not null unique ,
    request_status_id int not null unique ,
    change_datatime time with time zone not null,
    primary key (request_id, request_status_id)
);
create table if not exists depositsmtsbank.request_statuses(
    id_request_status int primary key,
    request_status_name character varying(21) not null
);
alter table depositsmtsbank.deposits add constraint
    fk_customer_deposit foreign key (id_deposit)
        references depositsmtsbank.customer_deposits(deposit_id);

alter table depositsmtsbank.requests add constraint
    fk_requests_deposit foreign key (deposit_id) references
        depositsmtsbank.deposits(id_deposit);

alter table depositsmtsbank.deposit_types add constraint
fk_deposit_types_deposits foreign key (id_deposit_types)
references depositsmtsbank.deposits(deposit_type_id);

alter table depositsmtsbank.types_percent_payment add constraint
fk_types_percent_payment foreign key (id_type_percent_payment)
references depositsmtsbank.deposits(type_percent_payment_id);

alter table depositsmtsbank.requests add  constraint
fk_requests_current_status_request foreign key (id_request)
references depositsmtsbank.current_request_status(request_id);

alter table depositsmtsbank.current_request_status add constraint
fk_current_requests_statuses foreign key (request_status_id)
references depositsmtsbank.request_statuses(id_request_status);
