--liquibase formatted sql

--changeset Tharuka:1
INSERT INTO roles(name)
VALUES ('ROLE_USER');
INSERT INTO roles(name)
VALUES ('ROLE_MODERATOR');
INSERT INTO roles(name)
VALUES ('ROLE_ADMIN');

--changeset Tharuka:2
INSERT INTO `user` (`id`, `email`, `password`, `username`)
VALUES (1, 'admin@gmail.com', '$2a$10$wlMBgSZ8B/qNglg.8XcsYuXOGsEqJ7rQQrQKkeXmc4dVKTR.aOy72', 'admin');
INSERT INTO `user_roles` (`user_id`, `role_id`)
VALUES (1, 3);
INSERT INTO `staff` (`id`, `created_date`, `updated_date`, `dob`, `home_contact_number`, `image_data`, `image_url`,
                     `name`, `personal_contact_number`, `personal_email`, `position`, `staff_no`, `uni_contact_number`,
                     `uni_email`)
VALUES (1, '2021-10-21 16:49:07.000000', '2021-10-21 16:49:08.000000', '2021-10-21', 770429201, NULL, NULL,
        'Tharuka Vishwajith', 742565856, 'tharuka@gmail.com', 'Lecturer', NULL, NULL, NULL);
INSERT INTO `student` (`id`, `created_date`, `updated_date`, `address`, `district`, `dob`, `home_contact_number`,
                       `image_data`, `image_url`, `nic_no`, `personal_contact_number`, `personal_email`, `postal_code`,
                       `province`, `student_no`, `uni_email`, `year`)
VALUES (1, '2021-10-21 17:03:02.000000', '2021-10-21 17:03:03.000000', 'Bombuwala', 1, '2021-10-21', NULL, NULL, NULL,
        '945265851V', NULL, NULL, NULL, 1, 's001', NULL, NULL);
INSERT INTO `location` (`id`, `created_date`, `updated_date`, `faculty`, `lat`, `location_code`, `lon`, `name`)
VALUES (1, '2021-10-21 16:47:52.000000', '2021-10-21 16:47:52.000000', 'FCT', 33.8, 'F001', 10.2, 'Lab');
INSERT INTO `qr_client` (`id`, `created_date`, `updated_date`, `name`, `location_id`, `staff_id`)
VALUES (1, '2021-10-21 16:47:27.000000', '2021-10-21 16:47:28.000000', 'Lab C1', 1, 1);
