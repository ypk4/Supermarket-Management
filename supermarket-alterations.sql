
alter table product add column id int;
 
alter table product add foreign key(id) references distributor(id);
