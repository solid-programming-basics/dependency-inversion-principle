CREATE TABLE orders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    code VARCHAR(50) UNIQUE,
    name VARCHAR(100),
    customer_id VARCHAR(50)
);

INSERT INTO orders (code, name, customer_id) VALUES ('ORD-001', 'Order 1', 'C123');
INSERT INTO orders (code, name, customer_id) VALUES ('ORD-002', 'Order 2', 'C123');
INSERT INTO orders (code, name, customer_id) VALUES ('ORD-003', 'Order 3', 'C456');