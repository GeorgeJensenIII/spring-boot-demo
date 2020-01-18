create table users(
	username varchar(50) not null primary key,
	password varchar(500) not null,
	enabled boolean not null);

create table authorities (
	username varchar(50) not null,
	authority varchar(50) not null,
	constraint fk_authorities_users foreign key(username) references users(username));

create unique index ix_auth_username on authorities (username,authority);


INSERT INTO `users` (`username`, `password`, `enabled`)
VALUES ('admin-01', '{noop}admin01@123#', true);

INSERT INTO `users` (`username`, `password`, `enabled`)
VALUES ('user-01', '{noop}user01@123#', true);


INSERT INTO `authorities` (`username`, `authority`)
VALUES ('admin-01', 'ROLE_ADMIN');

INSERT INTO `authorities` (`username`, `authority`)
VALUES ('user-01', 'ROLE_USER');

commit;