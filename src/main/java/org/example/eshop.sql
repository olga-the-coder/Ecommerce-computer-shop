CREATE DATABASE eshop;
use eshop;


CREATE TABLE if NOT EXISTS product (
    id int(8) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name varchar(128) NOT NULL,
    price float NOT NULL,
    quantity int NOT NULL,
    image varchar(128)
);

INSERT INTO product(name, price, quantity, image) VALUES ("Ben's Picture", 4000.0, 10, "images/picture.jpg");
INSERT INTO product(name, price, quantity, image) VALUES ("GPU 3080 Ti", 1949.86, 10, "images/gpu.jpg");
INSERT INTO product(name, price, quantity, image) VALUES ("Keyboard", 89.99, 10, "images/keyboard.jpg");
INSERT INTO product(name, price, quantity, image) VALUES ("Microphone", 231.18, 10, "images/microphone.jpg");
INSERT INTO product(name, price, quantity, image) VALUES ("Monitor", 325.2, 10, "images/monitor.jpg");
INSERT INTO product(name, price, quantity, image) VALUES ("Mouse", 38.99, 10, "images/mouse.jpg");
INSERT INTO product(name, price, quantity, image) VALUES ("Speaker", 109.31, 10, "images/speaker.jpg");
INSERT INTO product(name, price, quantity, image) VALUES ("USB HD camera", 205.49, 10, "images/usb.jpg");