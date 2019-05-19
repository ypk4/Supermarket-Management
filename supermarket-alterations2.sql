alter table product drop foreign key product_ibfk_1;

alter table product add foreign key(id) references distributor(id) on delete cascade;
