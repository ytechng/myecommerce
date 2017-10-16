CREATE TABLE categories (
	id IDENTITY,
	name VARCHAR(50),
	description VARCHAR(255),
	image_url VARCHAR(50),
	is_active BOOLEAN,
	
	CONSTRAINT pk_category_id PRIMARY KEY (id)
);

INSERT INTO categories (name, description, image_url, is_active) 
VALUES ('Mobiles', 'This is a description for mobiles', 'mobile.png', true);

INSERT INTO categories (name, description, image_url, is_active) 
VALUES ('Laptops', 'This is a description for Laptops', 'laptop.png', true);

INSERT INTO categories (name, description, image_url, is_active) 
VALUES ('Telavision', 'This is a description for Laptops', 'tv.png', true);



CREATE TABLE users (
	id IDENTITY,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	role VARCHAR(50),
	enabled BOOLEAN,
	email VARCHAR(50),
	password VARCHAR(100),
	phone_no VARCHAR(13),
	
	CONSTRAINT pk_user_id PRIMARY KEY (id)
);

INSERT INTO users (first_name, last_name, role, enabled, email, password, phone_no) 
VALUES ('Opeyemi', 'Ajayi', 'admin', true, 'ytechng@gmail.com', 'test1234', '2348020908829');

INSERT INTO users (first_name, last_name, role, enabled, email, password, phone_no)
VALUES ('Test', 'Merchant', 'merchant', true, 'test@gmail.com', 'test1234', '2347062980332');

INSERT INTO users (first_name, last_name, role, enabled, email, password, phone_no)
VALUES ('Merchant', 'Seller', 'merchant', true, 'merchant@gmail.com', 'test1234', '2348076867680');



CREATE TABLE products (
	id IDENTITY,
	code varchar(20),
	name VARCHAR(50),
	brand VARCHAR(50),
	description VARCHAR(250),
	price DECIMAL(10, 2),
	quantity INT,
	is_active BOOLEAN,
	category_id INT,
	merchant_id INT,
	purchases INT DEFAULT 0,
	views INT DEFAULT 0,
	
	CONSTRAINT pk_product_id PRIMARY KEY (id),
	CONSTRAINT fk_product_category_id FOREIGN KEY (category_id) REFERENCES categories (id),
	CONSTRAINT fk_product_merchant_id FOREIGN KEY (merchant_id) REFERENCES users (id)
);

INSERT INTO products (code, name, brand, description, price, quantity, is_active, category_id, merchant_id) 
VALUES ('PRDWHT123BDQ', 'Xperia Z5', 'Sony', 'This is a water and scratch resistance smartphone', 160000, 10, true, 1, 2);

INSERT INTO products (code, name, brand, description, price, quantity, is_active, category_id, merchant_id)
VALUES ('PRDWHT41HA3Q', 'Galaxy S7', 'Samsung', 'This is a smartphone designed by Samsung', 1250000, 10, true, 2, 2);

INSERT INTO products (code, name, brand, description, price, quantity, is_active, category_id, merchant_id)
VALUES ('PRDWHT123BDQ', 'Macbook Pro', 'Apple', 'This is most available best laptop on Apple store', 430000, 10, true, 2, 3);

INSERT INTO products (code, name, brand, description, price, quantity, is_active, category_id, merchant_id)
VALUES ('PRDMGA123BDC', 'iphone 7s', 'Apple', 'This is one of the best smartphone ever', 220000, 10, true, 1, 3);

INSERT INTO products (code, name, brand, description, price, quantity, is_active, category_id, merchant_id)
VALUES ('PRDKAL123ACN', 'Vaio Flip 14', 'Sony', 'This is most available best laptop on Sony store', 430000, 10, true, 2, 2);

INSERT INTO products (code, name, brand, description, price, quantity, is_active, category_id, merchant_id)
VALUES ('PRDWHT123LPA', 'Samsung LCE Tv', 'Samsung', 'This is a good lcd television from Samsung', 63000, 10, true, 3, 3);

INSERT INTO products (code, name, brand, description, price, quantity, is_active, category_id, merchant_id)
VALUES ('PRDWHT123BDQ', 'LG LED Tv', 'LG', 'This is good led television from LG', 60000, 10, true, 3, 2);