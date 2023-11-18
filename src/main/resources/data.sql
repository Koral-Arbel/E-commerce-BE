DROP TABLE IF EXISTS custom_user;
DROP TABLE IF EXISTS customer_order;
DROP TABLE IF EXISTS item;
DROP TABLE IF EXISTS favorite_item;
DROP TABLE IF EXISTS item_order;

CREATE TABLE custom_user (
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

CREATE TABLE customer_order (
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
    user_id int(11) NOT NULL DEFAULT '',
    order_date DATE DEFAULT CURRENT_DATE,
    shipping_address varchar(20) NOT NULL DEFAULT '',
    total_price DOUBLE NOT NULL DEFAULT 0,
    status varchar(20) NOT NULL DEFAULT 'TEMP',
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES custom_user(id)
);


CREATE TABLE item (
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
    title varchar(20) NOT NULL DEFAULT '',
    price double(11) NOT NULL DEFAULT 0,
    photo varchar(300) NOT NULL DEFAULT '',
    quantity int(11) NOT NULL DEFAULT 0,
    PRIMARY KEY (id)
);

CREATE TABLE favorite_item (
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
    user_id int(11) NOT NULL DEFAULT '',
    item_id int(11) NOT NULL DEFAULT '',
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES custom_user(id),
    FOREIGN KEY (item_id) REFERENCES item(id)
);


CREATE TABLE item_order (
     id int(11) unsigned NOT NULL AUTO_INCREMENT,
     user_id int(11) NOT NULL DEFAULT '',
     order_id int(11) NOT NULL DEFAULT '',
     title_item int(11) NOT NULL DEFAULT '',
     quantity int(11) NOT NULL DEFAULT '',
     price int(11) NOT NULL DEFAULT '',
     PRIMARY KEY (id),
     FOREIGN KEY (user_id) REFERENCES customer_order(user_id),
     FOREIGN KEY (order_id) REFERENCES customer_order(id),
     FOREIGN KEY (title_item) REFERENCES item(title)
);

INSERT INTO custom_user (first_name, last_name, email, phone, full_address, username, password, active , roles, permissions) VALUES
    ('Koral', 'Arbel', 'korali@gmail.com', '0549565777', 'Haifa Ofra Haza 21, Israel', 'korali', '1234', 1, '', '');

INSERT INTO item (title, price, photo, quantity) VALUES
('Airpods2', 400.99, 'http://atlas-content-cdn.pixelsquid.com/stock-images/apple-airpods-earphones-exdGm2B-600.jpg', 12),
('AirpodsPro', 599.99, 'https://static.esrgear.com/blog/wp-content/uploads/2022/06/airpods-pro-magsafe-case.png', 8),
('Buds', 349.99, 'https://www.imgshop.co.il/images/itempics/3638_260120211231561_large.jpg', 10),
('Laptop', 3299.99, 'https://cdn.pixabay.com/photo/2020/10/21/18/07/laptop-5673901__340.jpg', 9),
('Apple Watch', 2500.99, 'https://photos5.appleinsider.com/gallery/50368-99094-000-lead-Two-Apple-Watches-xl.jpg', 12),
('iPhone-12', 3029.99, 'https://gadget-team.co.il/wp-content/uploads/2021/03/12-Apple-iPhone-12-128G-.jpg', 10),
('iphone-12ProMax',3999.99, 'https://fdn2.gsmarena.com/vv/pics/apple/apple-iphone-12-pro-max-2.jpg', 13),
('iPhone-13-ProMax', 4029.99, 'https://fdn2.gsmarena.com/vv/pics/apple/apple-iphone-13-pro-max-2.jpg', 12),
('iPhone-11', 2500.99, 'https://gadget-team.co.il/wp-content/uploads/2021/03/IPHONE-11.jpg', 12),
('iPhone-11ProMax', 3900.99, 'https://fdn2.gsmarena.com/vv/pics/apple/apple-iphone-pro-10.jpg', 12);


