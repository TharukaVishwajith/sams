-- liquibase formatted sql

-- changeset Tharuka:1
CREATE TABLE `roles` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(20) NULL DEFAULT NULL,
	PRIMARY KEY (`id`)
)
COLLATE='latin1_swedish_ci'
ENGINE=MyISAM
AUTO_INCREMENT=4
;

CREATE TABLE `users` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`email` VARCHAR(255) NULL DEFAULT NULL,
	`password` VARCHAR(255) NULL DEFAULT NULL,
	`username` VARCHAR(255) NULL DEFAULT NULL,
	PRIMARY KEY (`id`),
	UNIQUE INDEX `UKr43af9ap4edm43mmtq01oddj6` (`username`),
	UNIQUE INDEX `UK6dotkott2kjsp8vw4d0m25fb7` (`email`)
)
COLLATE='latin1_swedish_ci'
ENGINE=MyISAM
AUTO_INCREMENT=3
;

CREATE TABLE `user_roles` (
	`user_id` BIGINT(20) NOT NULL,
	`role_id` INT(11) NOT NULL,
	PRIMARY KEY (`user_id`, `role_id`),
	INDEX `FKh8ciramu9cc9q3qcqiv4ue8a6` (`role_id`)
)
COLLATE='latin1_swedish_ci'
ENGINE=MyISAM
;