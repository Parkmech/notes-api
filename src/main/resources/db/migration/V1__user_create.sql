DROP TABLE IF EXISTS `user_authentication`;
CREATE TABLE   `user_authentication`(
                                                 `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                                 `first_name` varchar(50) NOT NULL,
                                                 `email` varchar(100) NOT NULL,
                                                 `password_hash` varchar(64) NOT NULL,
                                                 `created_at` timestamp(6) NOT NULL,
                                                 PRIMARY KEY (`id`)
);

create unique index UK_User_authentication_email_unique
    on user_authentication (email);