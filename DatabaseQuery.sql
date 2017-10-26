-----------	Create Users Table ------------

CREATE TABLE users (
	id IDENTITY,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	email VARCHAR(100),
	phone_no VARCHAR(50),
	role VARCHAR(100),
	password VARCHAR(60),
	enabled BOOLEAN,
	
	CONSTRAINT pk_user_id PRIMARY KEY (id)
);

-----------	Insert Into Users Table ------------

INSERT INTO users (first_name, last_name, email, phone_no, role, password, enabled) 
VALUES ('Admin', 'Administrator', 'admin@gmail.com', '08020908829', 'admin', '$2y$10$PJ6p4zf94Civ.mRuXTwiMeOaGYdNpzQNhtuR1T7GMKe5foVIhwLM6', true);

INSERT INTO users (first_name, last_name, email, phone_no, role, password, enabled) 
VALUES ('Merchant', 'Seller', 'merchant@gmail.com', '08012345678', 'merchant', '$2y$10$IY8wkK3gnk0.8cvjWp/0sOmoibvVWsNuvyrgewGIci1NpSi2gumbm', true);

INSERT INTO users (first_name, last_name, email, phone_no, role, password, enabled) 
VALUES ('Customer', 'User', 'user@gmail.com', '08089898171', 'user', '$2y$10$jdZGjh0aA12XEYcsUg4Xt.qQrxNk.6LJ9h5X4HvVKsV8p568.CF1K', true);


-----------	Create Addresses Table ------------

CREATE TABLE addresses (
	id IDENTITY,
	user_id INT,
	address_1 VARCHAR(100),
	address_2 VARCHAR(100),
	city VARCHAR(50),
	state VARCHAR(50),
	country VARCHAR(50),
	postal_code VARCHAR(10),
	shipping BOOLEAN,
	billing BOOLEAN,
	
	CONSTRAINT pk_address_id PRIMARY KEY (id)
);


-----------	Insert Into Addresses Table ------------
INSERT INTO addresses (user_id, address_1, address_2, city, state, country, postal_code, shipping, billing) 
VALUES (1, 'Badore Ajah', 'Langbasa Eti-Osa Ajah', 'Lekki', 'Lagos', 'Nigeria', '23401', true, true);


-----------	Create Categories Table ------------
CREATE TABLE categories (
	id IDENTITY,
	name VARCHAR(50),
	description VARCHAR(255),
	image_url VARCHAR(50),
	is_active BOOLEAN,
	
	CONSTRAINT pk_category_id PRIMARY KEY (id)
);

-----------	Insert Into Categories Table ------------

INSERT INTO categories (name, description, image_url, is_active) 
VALUES ('Mobiles', 'This is a description for mobiles', 'mobile.png', true);

INSERT INTO categories (name, description, image_url, is_active) 
VALUES ('Laptops', 'This is a description for Laptops', 'laptop.png', true);

INSERT INTO categories (name, description, image_url, is_active) 
VALUES ('Telavision', 'This is a description for Laptops', 'tv.png', true);


-----------	Create Products Table ------------

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

-----------	Insert Into Products Table ------------

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


-----------	Create Users Table ------------

CREATE TABLE carts (
	id IDENTITY,
	user_id INT,
	grand_total DECIMAL(10,2),
	cart_lines INT,
	
	CONSTRAINT pk_cart_id PRIMARY KEY (id)
);


-----------	Create CartLines Table ------------

CREATE TABLE cart_line (
	id IDENTITY,
	cart_id INT,
	total DECIMAL(10, 2),
	product_id INT,
	product_count INT,
	buying_price DECIMAL(10, 2),
	is_available BOOLEAN,
	
	CONSTRAINT fk_cartline_cart_id FOREIGN KEY (cart_id) REFERENCES carts (id),
	CONSTRAINT fk_cartline_product_id FOREIGN KEY (product_id) REFERENCES products (id),
	CONSTRAINT pk_cartline_id PRIMARY KEY (id)
)
