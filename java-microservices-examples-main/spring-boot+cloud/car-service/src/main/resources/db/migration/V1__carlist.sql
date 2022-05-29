 drop table if exists carlist;

 create table carlist (
 id bigint not null auto_increment,
  name varchar(255),
  color varchar (45),
   primary key (id));
