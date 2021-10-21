-- liquibase formatted sql

-- changeset Tharuka:1
CREATE TABLE `roles`
(
    `id`   INT(11)     NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(20) NULL DEFAULT NULL,
    PRIMARY KEY (`id`)
)
    COLLATE = 'latin1_swedish_ci'
    ENGINE = MyISAM
    AUTO_INCREMENT = 4
;

CREATE TABLE `student`
(
    `id`                      BIGINT(19)   NOT NULL AUTO_INCREMENT,
    `created_date`            DATETIME(6)  NULL DEFAULT NULL,
    `updated_date`            DATETIME(6)  NULL DEFAULT NULL,
    `is_deleted`              TINYINT(1)   NULL DEFAULT '0',
    `address`                 VARCHAR(500) NULL DEFAULT NULL,
    `district`                INT(10)      NULL DEFAULT NULL,
    `dob`                     DATE         NULL DEFAULT NULL,
    `home_contact_number`     INT(10)      NULL DEFAULT NULL,
    `image_data`              LONGBLOB     NULL DEFAULT NULL,
    `image_url`               VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
    `nic_no`                  VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
    `personal_contact_number` INT(10)      NULL DEFAULT NULL,
    `personal_email`          VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
    `postal_code`             INT(10)      NULL DEFAULT NULL,
    `province`                INT(10)      NULL DEFAULT NULL,
    `student_no`              VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
    `uni_email`               VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
    `year`                    INT(10)      NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `UK_5px5wtm1epr9wdtpkcp31ltb8` (`nic_no`) USING BTREE,
    UNIQUE INDEX `UK_ah6pnqt97bv1fcv5bv512fc0f` (`student_no`) USING BTREE
)
    COLLATE = 'utf8mb4_0900_ai_ci'
    ENGINE = InnoDB
;

CREATE TABLE `staff`
(
    `id`                      BIGINT(19)   NOT NULL AUTO_INCREMENT,
    `created_date`            DATETIME(6)  NULL DEFAULT NULL,
    `updated_date`            DATETIME(6)  NULL DEFAULT NULL,
    `is_deleted`              TINYINT(1)   NULL DEFAULT '0',
    `dob`                     DATE         NULL DEFAULT NULL,
    `home_contact_number`     INT(10)      NULL DEFAULT NULL,
    `image_data`              LONGBLOB     NULL DEFAULT NULL,
    `image_url`               VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
    `name`                    VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
    `personal_contact_number` INT(10)      NULL DEFAULT NULL,
    `personal_email`          VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
    `position`                VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
    `staff_no`                VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
    `uni_contact_number`      INT(10)      NULL DEFAULT NULL,
    `uni_email`               VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
    PRIMARY KEY (`id`) USING BTREE
)
    COLLATE = 'utf8mb4_0900_ai_ci'
    ENGINE = InnoDB
;

CREATE TABLE `user`
(
    `id`           BIGINT(19)   NOT NULL AUTO_INCREMENT,
    `created_date` DATETIME(6)  NULL DEFAULT NULL,
    `updated_date` DATETIME(6)  NULL DEFAULT NULL,
    `is_deleted`   TINYINT(1)   NULL DEFAULT '0',
    `email`        VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
    `password`     VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
    `username`     VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
    `staff_id`     BIGINT(19)   NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `UKsb8bbouer5wak8vyiiy4pf2bx` (`username`) USING BTREE,
    UNIQUE INDEX `UKob8kqyqqgmefl0aco34akdtpe` (`email`) USING BTREE,
    INDEX `FK2ldn2869etg8j5x6d4scmxxx1` (`staff_id`) USING BTREE,
    CONSTRAINT `FK2ldn2869etg8j5x6d4scmxxx1` FOREIGN KEY (`staff_id`) REFERENCES `staff` (`id`) ON UPDATE NO ACTION ON DELETE NO ACTION
)
    COLLATE = 'utf8mb4_0900_ai_ci'
    ENGINE = InnoDB
;


CREATE TABLE `user_roles`
(
    `user_id` BIGINT(20) NOT NULL,
    `role_id` INT(11)    NOT NULL,
    PRIMARY KEY (`user_id`, `role_id`),
    INDEX `FKh8ciramu9cc9q3qcqiv4ue8a6` (`role_id`)
)
    COLLATE = 'latin1_swedish_ci'
    ENGINE = MyISAM
;

CREATE TABLE `location`
(
    `id`            BIGINT(19)   NOT NULL AUTO_INCREMENT,
    `created_date`  DATETIME(6)  NULL DEFAULT NULL,
    `updated_date`  DATETIME(6)  NULL DEFAULT NULL,
    `is_deleted`    TINYINT(1)   NULL DEFAULT '0',
    `faculty`       VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
    `lat`           DOUBLE       NOT NULL,
    `location_code` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
    `lon`           DOUBLE       NOT NULL,
    `name`          VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
    PRIMARY KEY (`id`) USING BTREE
)
    COLLATE = 'utf8mb4_0900_ai_ci'
    ENGINE = InnoDB
;

CREATE TABLE `qr_client`
(
    `id`           BIGINT(19)   NOT NULL AUTO_INCREMENT,
    `created_date` DATETIME(6)  NULL DEFAULT NULL,
    `updated_date` DATETIME(6)  NULL DEFAULT NULL,
    `is_deleted`   TINYINT(1)   NULL DEFAULT '0',
    `name`         VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
    `location_id`  BIGINT(19)   NULL DEFAULT NULL,
    `staff_id`     BIGINT(19)   NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `FKlucjn44sukh7jptf1lpsw9ovt` (`location_id`) USING BTREE,
    INDEX `FKe2dm1udeu3mbgml6cv5v4r567` (`staff_id`) USING BTREE,
    CONSTRAINT `FKe2dm1udeu3mbgml6cv5v4r567` FOREIGN KEY (`staff_id`) REFERENCES `staff` (`id`) ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT `FKlucjn44sukh7jptf1lpsw9ovt` FOREIGN KEY (`location_id`) REFERENCES `location` (`id`) ON UPDATE NO ACTION ON DELETE NO ACTION
)
    COLLATE = 'utf8mb4_0900_ai_ci'
    ENGINE = InnoDB
;

CREATE TABLE `attendance`
(
    `id`           BIGINT(19)  NOT NULL AUTO_INCREMENT,
    `created_date` DATETIME(6) NULL DEFAULT NULL,
    `updated_date` DATETIME(6) NULL DEFAULT NULL,
    `is_deleted`   TINYINT(1)  NULL DEFAULT '0',
    `time_stamp`   DATETIME(6) NULL DEFAULT NULL,
    `location_id`  BIGINT(19)  NULL DEFAULT NULL,
    `qr_client_id` BIGINT(19)  NULL DEFAULT NULL,
    `recorded_by`  BIGINT(19)  NULL DEFAULT NULL,
    `student_id`   BIGINT(19)  NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `FK9tg02nxjffw4byk5k1v7ynd5g` (`location_id`) USING BTREE,
    INDEX `FKepfktenvpsbu2q9x3sphhu654` (`qr_client_id`) USING BTREE,
    INDEX `FK46cuxphi3uh5quom51s6i2q8x` (`recorded_by`) USING BTREE,
    INDEX `FKnq6vm31it076obtjf2qp5coim` (`student_id`) USING BTREE,
    CONSTRAINT `FK46cuxphi3uh5quom51s6i2q8x` FOREIGN KEY (`recorded_by`) REFERENCES `user` (`id`) ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT `FK9tg02nxjffw4byk5k1v7ynd5g` FOREIGN KEY (`location_id`) REFERENCES `location` (`id`) ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT `FKepfktenvpsbu2q9x3sphhu654` FOREIGN KEY (`qr_client_id`) REFERENCES `qr_client` (`id`) ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT `FKnq6vm31it076obtjf2qp5coim` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`) ON UPDATE NO ACTION ON DELETE NO ACTION
)
    COLLATE = 'utf8mb4_0900_ai_ci'
    ENGINE = InnoDB
;

