USE `keyvalidation-db`;

CREATE TABLE IF NOT EXISTS license_keys
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    license  VARCHAR(255) NOT NULL UNIQUE,
    active       BOOLEAN      NOT NULL,
    is_activated BOOLEAN      NOT NULL,
    expire_date  DATE         NOT NULL
    );