DROP TABLE IF EXISTS user;

CREATE TABLE user (
     id int(11) unsigned NOT NULL AUTO_INCREMENT,
     first_name varchar(20) NOT NULL DEFAULT '',
     last_name varchar(20) NOT NULL DEFAULT '',
     email varchar(20) NOT NULL DEFAULT '',
     phone varchar(20) NOT NULL DEFAULT '',
     full_address varchar(20) NOT NULL DEFAULT '',
     username varchar(20) NOT NULL DEFAULT '',
     password varchar(20) NOT NULL DEFAULT '',
     active tinyint(1) NOT NULL DEFAULT '1',
     roles varchar(200) NOT NULL DEFAULT '',
     permissions varchar(200) NOT NULL DEFAULT '',
     PRIMARY KEY (id)
);

