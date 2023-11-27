DROP TABLE IF EXISTS custom_user;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS item;
DROP TABLE IF EXISTS favorite_item;
DROP TABLE IF EXISTS order_item;

CREATE TABLE custom_user (
    id INT(11) unsigned NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(20) NOT NULL DEFAULT '',
    last_name VARCHAR(20) NOT NULL DEFAULT '',
    email VARCHAR(20) NOT NULL DEFAULT '',
    phone VARCHAR(20) NOT NULL DEFAULT '',
    full_address VARCHAR(255) NOT NULL DEFAULT '',
    username VARCHAR(20) NOT NULL DEFAULT '',
    password VARCHAR(20) NOT NULL DEFAULT '',
    active tinyint(1) NOT NULL DEFAULT '1',
    roles VARCHAR(200) NOT NULL DEFAULT '',
    permissions VARCHAR(200) NOT NULL DEFAULT '',
    PRIMARY KEY (id)
);

CREATE TABLE orders (
    id INT(11) unsigned NOT NULL AUTO_INCREMENT,
    user_id INT(11) NOT NULL,
    order_date DATE DEFAULT CURRENT_DATE,
    shipping_address VARCHAR(255) NOT NULL DEFAULT '',
    total_price DOUBLE NOT NULL DEFAULT 0,
    status varchar NOT NULL DEFAULT 'TEMP',
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES custom_user(id)
);


CREATE TABLE item (
    id INT(11) unsigned NOT NULL AUTO_INCREMENT,
    title varchar(50) NOT NULL DEFAULT '',
    photo varchar(255) NOT NULL DEFAULT '',
    price DOUBLE NOT NULL DEFAULT 0,
    available_stock INT(11) NOT NULL DEFAULT 0,
    PRIMARY KEY (id)
);

CREATE TABLE favorite_item (
    id INT(11) unsigned NOT NULL AUTO_INCREMENT,
    user_id INT(11) NOT NULL,
    item_id INT(11) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES custom_user(id),
    FOREIGN KEY (item_id) REFERENCES item(id)
);


CREATE TABLE order_item (
     id INT(11) unsigned NOT NULL AUTO_INCREMENT,
     order_id INT(11) NOT NULL,
     item_id INT(11) NOT NULL,
     quantity INT(11) NOT NULL,
     PRIMARY KEY (id),
     FOREIGN KEY (order_id) REFERENCES orders(id),
     FOREIGN KEY (item_id) REFERENCES item(id)
);



INSERT INTO item (title,photo,price,available_stock) VALUES
('Airpods2', 'http://atlas-content-cdn.pixelsquid.com/stock-images/apple-airpods-earphones-exdGm2B-600.jpg',400.99, 12),
('AirpodsPro', 'https://static.esrgear.com/blog/wp-content/uploads/2022/06/airpods-pro-magsafe-case.png',599.99, 8),
('Buds', 'https://www.imgshop.co.il/images/itempics/3638_260120211231561_large.jpg', 349.99, 10),
('Laptop', 'https://cdn.pixabay.com/photo/2020/10/21/18/07/laptop-5673901__340.jpg',3299.99, 9),
('Apple Watch', 'https://photos5.appleinsider.com/gallery/50368-99094-000-lead-Two-Apple-Watches-xl.jpg',2500.99, 12),
('iPhone-12', 'https://gadget-team.co.il/wp-content/uploads/2021/03/12-Apple-iPhone-12-128G-.jpg',3029.99, 10),
('iphone-12ProMax', 'https://fdn2.gsmarena.com/vv/pics/apple/apple-iphone-12-pro-max-2.jpg',3999.99, 13),
('iPhone-13-ProMax', 'https://fdn2.gsmarena.com/vv/pics/apple/apple-iphone-13-pro-max-2.jpg',4029.99, 12),
('iPhone-11', 'https://gadget-team.co.il/wp-content/uploads/2021/03/IPHONE-11.jpg',2500.99, 12),
('iPhone-11ProMax', 'https://fdn2.gsmarena.com/vv/pics/apple/apple-iphone-pro-10.jpg',3900.99, 12);


