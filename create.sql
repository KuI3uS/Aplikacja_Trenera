use `trenerzy-db`;

create table trener (
id int primary key auto_increment,
imie varchar(50),
nazwisko varchar(255),
email varchar(255) unique,
telefon varchar(15)
);

truncate trener;