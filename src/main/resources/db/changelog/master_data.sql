--liquibase formatted sql

--changeset Tharuka:1
INSERT INTO roles(`id`, `name`)
VALUES (1, 'ROLE_USER'),
       (2, 'ROLE_MODERATOR'),
       (3, 'ROLE_ADMIN');


--changeset Tharuka:2
INSERT INTO `staff` (`id`, `created_date`, `updated_date`, `dob`, `home_contact_number`, `image_data`, `image_url`,
                     `name`, `personal_contact_number`, `personal_email`, `position`, `staff_no`, `uni_contact_number`,
                     `uni_email`)
VALUES (1, '2021-10-21 16:49:07.000000', '2021-10-21 16:49:08.000000', '2021-10-21', 770429201, NULL, NULL,
        'Admin Staff', 742565856, 'admin@kln.ac.lk.com', 'Admin', 'ST003', NULL, NULL),
       (2, '2021-10-21 16:49:07.000000', '2021-10-21 16:49:08.000000', '2021-10-21', 770429201, NULL, NULL,
        'Tharuka Srathchandra', 742565856, 'tharukas@kln.ac.lk', 'Lecturer', 'ST001', NULL, NULL),
       (3, '2021-10-21 16:49:07.000000', '2021-10-21 16:49:08.000000', '2021-10-21', 770429201, NULL, NULL,
        'Sidath R Liyanage', 742565856, 'sidath@kln.ac.lk.com', 'Senior Lecturer', 'ST002', NULL, NULL);


--changeset Tharuka:3
INSERT INTO `user` (`id`, `email`, `password`, `username`, `staff_id`)
VALUES
    (1, 'admin@kln.ac.lk', '$2a$10$wlMBgSZ8B/qNglg.8XcsYuXOGsEqJ7rQQrQKkeXmc4dVKTR.aOy72', 'admin', 1),
    (2, 'tharuks@kln.ac.lk', '$2a$10$wlMBgSZ8B/qNglg.8XcsYuXOGsEqJ7rQQrQKkeXmc4dVKTR.aOy72', 'tharuka', 2),
    (3, 'sidath@kln.ac.lk', '$2a$10$wlMBgSZ8B/qNglg.8XcsYuXOGsEqJ7rQQrQKkeXmc4dVKTR.aOy72', 'sidath', 3);

INSERT INTO `user_roles` (`user_id`, `role_id`)
VALUES (1, 3),
       (2, 2),
       (3, 1);

INSERT INTO `student` (`id`, `created_date`, `updated_date`, `address`, `district`, `first_name`, `last_name`, `dob`,
                       `home_contact_number`,
                       `image_data`, `image_url`, `nic_no`, `personal_contact_number`, `personal_email`, `postal_code`,
                       `province`, `student_no`, `uni_email`, `year`, `is_suspended`, `faculty`, `department`)
VALUES (1, '2021-10-21 17:03:02.000000', '2021-10-21 17:03:03.000000', 'Bombuwala', 'KALUTARA', 'Tharuka',
        'Sarathchandra', '2021-10-21', NULL, NULL, NULL,
        '945265859V', NULL, NULL, NULL, 'WP', 'SE-2013-039', NULL, 2, 0, 'SCIENCE', 'SOFTWARE ENGINEERING'),
       (2, '2021-10-21 17:03:02.000000', '2021-10-21 17:03:03.000000', 'New Town', 'HAMBANTOTA', 'Thisara',
        'Pramuditha', '2021-10-21', NULL, NULL, NULL,
        '945265856V', NULL, NULL, NULL, 'SP', 'SE-2013-037', NULL, 1, 0, 'SCIENCE', 'SOFTWARE ENGINEERING'),
       (3, '2021-10-21 17:03:02.000000', '2021-10-21 17:03:03.000000', 'Kuliyapitiya', 'KURUNEGALA', 'Kanushka', 'Gayan',
        '2021-10-21', NULL, NULL, NULL,
        '945265852V', NULL, NULL, NULL, 'NP', 'SE-2013-036', NULL, 3, 0, 'SCIENCE', 'SOFTWARE ENGINEERING');
INSERT INTO `location` (`id`, `created_date`, `updated_date`, `faculty`, `lat`, `location_code`, `lon`, `name`)
VALUES (1, '2021-10-21 16:47:52.000000', '2021-10-21 16:47:52.000000', 'FCT', 33.8, 'F001', 10.2, 'Lab');
INSERT INTO `qr_client` (`id`, `created_date`, `updated_date`, `name`, `location_id`, `staff_id`)
VALUES (1, '2021-10-21 16:47:27.000000', '2021-10-21 16:47:28.000000', 'Lab C1', 1, 1);
