CREATE TABLE `products` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE claims (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    businessName VARCHAR(32) NOT NULL,
    orderNumber BIGINT NOT NULL,
    returnReason VARCHAR(64) NOT NULL,
    claimStatus VARCHAR(100),
    preferredResolution VARCHAR(32) NOT NULL,
    businessResponse VARCHAR(255),
    approvedResolutionType VARCHAR(100),
    returnInstructions VARCHAR(255),
    claimActive BOOLEAN
);

CREATE TABLE warranties (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    warrantyName VARCHAR(100),
    warrantyDesc VARCHAR(250),
    productCategory VARCHAR(100),
    restockFees DECIMAL,
    email VARCHAR(250),
    phoneNumber VARCHAR(20),
    returnInstructions VARCHAR(250),
    expirationDate BIGINT
);

SELECT JSON_OBJECT(
    'id', id,
    'name', name,
    'price', price,
    'description', description
) AS product_json
FROM products;