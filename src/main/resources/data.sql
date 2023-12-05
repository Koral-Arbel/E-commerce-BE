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
     user_id INT(11) NOT NULL,
     order_id INT(11) NOT NULL,
     item_id INT(11) NOT NULL,
     price DOUBLE NOT NULL DEFAULT 0,
     quantity INT(11) NOT NULL,
     PRIMARY KEY (id),
     FOREIGN KEY (user_id) REFERENCES custom_user(id),
     FOREIGN KEY (order_id) REFERENCES orders(id),
     FOREIGN KEY (item_id) REFERENCES item(id)
);



INSERT INTO item (title,photo,price,available_stock) VALUES
('iPone 15 Pro', 'https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/store-card-50-holiday-iphone-15-pro-202311?wid=480&hei=500&fmt=p-jpg&qlt=95&.v=1696863030449',999.99, 12),
('iPone 15', 'https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/store-card-50-holiday-iphone-15-202311?wid=480&hei=500&fmt=p-jpg&qlt=95&.v=1698188084112',799.99, 12),
('Apple Watch Ultra 2', 'https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/store-card-50-holiday-watch-ultra-2-202311?wid=480&hei=500&fmt=p-jpg&qlt=95&.v=1698766696911',799.99, 8),
('Apple Watch Series 9', 'https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/store-card-50-holiday-watch-s9-202311?wid=480&hei=500&fmt=p-jpg&qlt=95&.v=1696865069259',399.99, 8),
('Apple Watch SE', 'https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/store-card-50-holiday-watch-se-202311?wid=480&hei=500&fmt=p-jpg&qlt=95&.v=1696863032977',249.99, 8),
('MacBook Air', 'https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/store-card-50-holiday-macbook-air-202311?wid=480&hei=500&fmt=p-jpg&qlt=95&.v=1696863032996', 1299.99, 10),
('MacBook Pro', 'https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/store-card-50-holiday-macbook-pro-202311?wid=480&hei=500&fmt=p-jpg&qlt=95&.v=1696872235281', 1599.99, 10),
('iPad', 'https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/store-card-50-holiday-ipad-202311?wid=480&hei=500&fmt=p-jpg&qlt=95&.v=1696863030352',449.99, 12),
('iPad Air', 'https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/store-card-50-holiday-ipad-air-202311?wid=480&hei=500&fmt=p-jpg&qlt=95&.v=1696863032946',599.99, 10),
('AirPods Pro', 'https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/MTJV3?wid=572&hei=572&fmt=jpeg&qlt=95&.v=1694014871985',249.99, 13),
('Beats Fit Pro True Wireless Earbuds Coral Pink', 'https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/MPLJ3_AV3?wid=572&hei=572&fmt=jpeg&qlt=95&.v=1674696408547',199.99, 2),
('Beats Fit Pro True Wireless Earbuds Tidal Blue', 'https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/MPLL3_AV2?wid=572&hei=572&fmt=jpeg&qlt=95&.v=1674696409340',199.99, 2),
('AirTag', 'https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/airtag-single-select-202104_FV1?wid=445&hei=370&fmt=jpeg&qlt=95&.v=1617761670000',29.99, 11);


