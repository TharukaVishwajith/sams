--liquibase formatted sql

--changeset Tharuka:1
INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_MODERATOR');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');

--changeset Tharuka:2
INSERT INTO `users` (`id`, `email`, `password`, `username`) VALUES (1, 'admin@gmail.com', '$2a$10$wlMBgSZ8B/qNglg.8XcsYuXOGsEqJ7rQQrQKkeXmc4dVKTR.aOy72', 'admin');
INSERT INTO `user_roles` (`user_id`, `role_id`) VALUES (1, 3);


