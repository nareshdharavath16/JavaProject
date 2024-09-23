CREATE TABLE user_portal (
    user_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    date_birth DATE NOT NULL,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    mobile_number VARCHAR(20) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    created_on DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_on DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE roles1 (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    role_name VARCHAR(50) UNIQUE NOT NULL,
    skills VARCHAR(20) NOT NULL,
    experience BOOLEAN NOT NULL,
    fresher BOOLEAN NOT NULL,
    user_id BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user_portal(user_id)
);

CREATE TABLE personal_details (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    gender VARCHAR(20) NULL,
    martial_status VARCHAR(20) NULL,
    citizen VARCHAR(20) NULL,
    physically_handicapped VARCHAR(10) NULL,
    FOREIGN KEY (user_id) REFERENCES user_portal(user_id)
);

CREATE TABLE addresses (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    street VARCHAR(100) NOT NULL,
    city VARCHAR(50) NOT NULL,
    state VARCHAR(50) NOT NULL,
    zip_code VARCHAR(20) NOT NULL,
    country VARCHAR(50) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user_portal(user_id)
);

CREATE TABLE education_details (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    institution_name VARCHAR(100) NOT NULL,
    degree VARCHAR(50) NOT NULL,
    field_of_study VARCHAR(50) NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE,
    grade VARCHAR(10),
    FOREIGN KEY (user_id) REFERENCES user_portal(user_id)
);
