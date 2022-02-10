drop table if exists `mushrooms` CASCADE;
CREATE TABLE mushrooms (
    id BIGINT AUTO_INCREMENT,
    deadliness INTEGER NOT NULL,
    is_edible VARCHAR(255),
    latin VARCHAR(255),
    name VARCHAR(255),
    PRIMARY KEY (id)
);
