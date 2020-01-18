create table userinfo (
  id int PRIMARY KEY AUTO_INCREMENT,
	first_name varchar(50) not null,
	last_name varchar(50) not null,
	email_address varchar(50) not null,
	password varchar(500) not null);

create unique index idx_user_email on userinfo (email_address);

create table roles (
  id int PRIMARY KEY AUTO_INCREMENT,
  role_name varchar(50) not null
);

create unique index ids_roles_rolename on roles (role_name);

create table user_roles (
	id int PRIMARY KEY AUTO_INCREMENT,
	user_id int not null,
	role_id int not null,
	constraint fk_userroles_user_id foreign key(user_id) references userinfo(id),
	constraint fk_userroles_role_id foreign key(role_id) references roles(id)
);

create unique index idx_user_role_id on user_roles (user_id, role_id);

-- Password is welcome@123#
INSERT INTO `userinfo` (`first_name`, `last_name`, `email_address`, `password`)
VALUES ('Super', 'Admin', 'admin@tw.com', '$2a$10$yPIWEiYj8sGLox.9cPKPZe6GgGRy.T8iV/sR2Br1PyA0UzLaYVOa.');

-- Password is welcome@123#
INSERT INTO `userinfo` (`first_name`, `last_name`, `email_address`, `password`)
VALUES ('Test', 'User', 'testuser@tw.com', '$2a$10$yPIWEiYj8sGLox.9cPKPZe6GgGRy.T8iV/sR2Br1PyA0UzLaYVOa.');



INSERT INTO `roles` (`role_name`)
VALUES ('ROLE_ADMIN');

INSERT INTO `roles` (`role_name`)
VALUES ('ROLE_USER');

INSERT INTO `user_roles` (`user_id`, `role_id`)
VALUES(1, 1);

INSERT INTO `user_roles` (`user_id`, `role_id`)
VALUES(2, 2);

commit;