drop table if exists user_mission;
drop table if exists user_lecture;
drop table if exists user_ground;
drop table if exists mission;
drop table if exists ground;
drop table if exists user;
drop table if exists lecture;
drop table if exists category;

create table user
(
    id            int primary key auto_increment,
    oauth_id      varchar(50),
    username      varchar(50) unique                not null,
    password      varchar(255)                      not null,
    nickname      varchar(50) unique,
    phone         varchar(11),
    point         int         default 3000          not null,
    mission_score int         default 1000          not null,
    role          varchar(50) default 'ROLE_MEMBER' not null
) CHARSET = utf8mb4;

create table category
(
    id   int primary key auto_increment,
    name varchar(30) not null
) CHARSET = utf8mb4;

create table lecture
(
    id          int primary key auto_increment,
    category_id int          not null,
    platform    varchar(50)  not null,
    title       varchar(255) not null,
    instructor  varchar(50)  not null,
    url         varchar(255) not null,
    constraint foreign key (category_id) references category (id)
) CHARSET = utf8mb4;

create table ground
(
    id                 int primary key auto_increment,
    lecture_id         int                           not null,
    title              varchar(255)                  not null,
    information        text                          not null,
    level              int                           not null,
    min_capacity       int                           not null,
    max_capacity       int                           not null,
    deposit            int                           not null,
    is_validated       boolean     default false     not null,
    is_premium         boolean     default false     not null,
    created_at         datetime    default now(),
    start_at           date                          not null,
    end_at             date                          not null,
    validated_at       datetime,
    status             varchar(30) default 'waiting' not null,
    mission_fail_limit int         default 0         not null,
    user_id            int                           not null,
    constraint foreign key (lecture_id) references lecture (id),
    constraint foreign key (user_id) references user (id)
) CHARSET = utf8mb4;

create table mission
(
    id         int primary key auto_increment,
    ground_id  int          not null,
    assignment varchar(255) not null,
    start_at   date         not null,
    end_at     date         not null,
    constraint foreign key (ground_id) references ground (id)
) CHARSET = utf8mb4;

create table user_ground
(
    id           int primary key auto_increment,
    user_id      int                  not null,
    ground_id    int                  not null,
    is_attending boolean default true not null,
    is_success   boolean,
    rating       int,
    comment      text,
    constraint foreign key (user_id) references user (id),
    constraint foreign key (ground_id) references ground (id)
) CHARSET = utf8mb4;

create table user_lecture
(
    id           int primary key auto_increment,
    user_id      int not null,
    lecture_id   int not null,
    is_completed boolean default false,
    constraint foreign key (user_id) references user (id),
    constraint foreign key (lecture_id) references lecture (id)
) CHARSET = utf8mb4;

create table user_mission
(
    id          int primary key auto_increment,
    user_id     int                           not null,
    mission_id  int                           not null,
    submit_at   datetime    default now()     not null,
    is_accepted varchar(50) default 'waiting' not null,
    image_url   varchar(255)                  not null,
    constraint foreign key (user_id) references user (id),
    constraint foreign key (mission_id) references mission (id)
) CHARSET = utf8mb4;

-- user 테이블에 더미 데이터 추가
INSERT INTO user (oauth_id, username, password, nickname, phone, point, mission_score, role)
SELECT null                                                                                    AS oauth_id,
       CONCAT('user', ROW_NUMBER() OVER (ORDER BY 1), '@example.com')                          AS username,
       '$2a$10$Fv48kjkkWAV8KJZFE3OW9Oo36pHkK1eCAy7muhiTJrnljKZh0I70O'                          AS password,
       CONCAT('nickname', ROW_NUMBER() OVER (ORDER BY 1))                                      AS nickname,
       CONCAT('010', LPAD(FLOOR(RAND() * 10000), 4, '0'), LPAD(FLOOR(RAND() * 10000), 4, '0')) AS phone,
       3000                                                                                    AS point,
       1000                                                                                    AS mission_score,
       'ROLE_MEMBER'                                                                           AS role
FROM (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) a,
     (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) b,
     (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) c,
     (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) d
LIMIT 625;

-- category 테이블에 더미 데이터 추가
INSERT INTO category (name)
VALUES ('CATEGORY_ALL'),
       ('CATEGORY_IT'),
       ('CATEGORY_LANGUAGE'),
       ('CATEGORY_DESIGN'),
       ('CATEGORY_MARKETING'),
       ('CATEGORY_SCHOOL');

-- 각 카테고리별로 20개의 더미 데이터 추가
INSERT INTO lecture (category_id, platform, title, instructor, url)
SELECT
    category.id AS category_id,
    platform_names.platform AS platform,
    CONCAT('강의 제목', ROW_NUMBER() OVER (ORDER BY 1)),
    CONCAT('강사', ROW_NUMBER() OVER (ORDER BY 1)),
    CONCAT('https://www.', platform_names.platform, '.com/course/', ROW_NUMBER() OVER (ORDER BY 1))
FROM
    category,
    (SELECT 'INFLEARN' AS platform UNION ALL SELECT 'FASTCAMPUS' UNION ALL SELECT 'UDEMY') platform_names
        CROSS JOIN
    (SELECT 0 AS dummy UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) a,
    (SELECT 0 AS dummy UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) b
WHERE category.id = FLOOR(RAND() * 6) + 1
LIMIT 20;





-- ground 테이블에 더미 데이터 추가
INSERT INTO ground (lecture_id, title, information, level, min_capacity, max_capacity, deposit, is_validated,
                    is_premium, start_at, end_at, status, mission_fail_limit, user_id)
SELECT FLOOR(RAND() * 20) + 1                               AS lecture_id,
       CONCAT('Title', ROW_NUMBER() OVER (ORDER BY 1))       AS title,
       CONCAT('Information', ROW_NUMBER() OVER (ORDER BY 1)) AS information,
       FLOOR(RAND() * 5) + 1                                 AS level,
       FLOOR(RAND() * 5) + 1                                 AS min_capacity,
       FLOOR(RAND() * 10) + 10                               AS max_capacity,
       FLOOR(RAND() * 1000) + 1000                           AS deposit,
       FLOOR(RAND() * 2)                                     AS is_validated,
       FLOOR(RAND() * 2)                                     AS is_premium,
       DATE_ADD(NOW(), INTERVAL FLOOR(RAND() * 30) DAY)      AS start_at,
       DATE_ADD(NOW(), INTERVAL FLOOR(RAND() * 30 + 30) DAY) AS end_at,
       CASE
           WHEN FLOOR(RAND() * 6) = 0 THEN 'waiting'
           WHEN FLOOR(RAND() * 6) = 1 THEN 'standby'
           WHEN FLOOR(RAND() * 6) = 2 THEN 'ongoing'
           WHEN FLOOR(RAND() * 6) = 3 THEN 'ongoing'
           WHEN FLOOR(RAND() * 6) = 4 THEN 'ongoing'
           ELSE 'completed'
           END                                               AS status,
       FLOOR(RAND() * 5)                                     AS mission_fail_limit,
       FLOOR(RAND() * 100) + 1                               AS user_id
FROM (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) a,
     (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) b,
     (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) c
LIMIT 100;

INSERT INTO mission (ground_id, assignment, start_at, end_at)
SELECT
        FLOOR(RAND() * 100) + 1 AS ground_id,
        CONCAT('Assignment', ROW_NUMBER() OVER (ORDER BY 1)) AS assignment,
        DATE_ADD(NOW(), INTERVAL FLOOR(RAND() * 30) DAY) AS start_at,
        DATE_ADD(NOW(), INTERVAL FLOOR(RAND() * 30 + 30) DAY) AS end_at
FROM (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) a,
     (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) b,
     (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) c,
     (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) d
LIMIT 500;

INSERT INTO user_ground (user_id, ground_id, is_attending, is_success, rating, comment)
SELECT
        FLOOR(RAND() * 625) + 1 AS user_id,
        FLOOR(RAND() * 50) + 1 AS ground_id,
        IF(FLOOR(RAND() * 10) <= 8, 1, 0) AS is_attending,
        CASE
            WHEN FLOOR(RAND() * 2) = 0 THEN NULL
            ELSE FLOOR(RAND() * 5) + 1
            END AS is_success,
        CASE
            WHEN FLOOR(RAND() * 2) = 0 THEN NULL
            ELSE FLOOR(RAND() * 5) + 1
            END AS rating,
        CASE
            WHEN FLOOR(RAND() * 2) = 0 THEN NULL
            ELSE CONCAT('Comment', ROW_NUMBER() OVER (ORDER BY 1))
            END AS comment
FROM
    (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) a,
    (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) b,
    (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) c,
    (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) d,
    (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) e
LIMIT 2000;

INSERT INTO user_lecture (user_id, lecture_id, is_completed)
SELECT
        FLOOR(RAND() * 625) + 1 AS user_id,
        FLOOR(RAND() * 20) + 1 AS lecture_id,
        FLOOR(RAND() * 2) AS is_completed
FROM
    (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) a,
    (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) b,
    (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) c,
    (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) d
LIMIT 1000;

INSERT INTO user_mission (user_id, mission_id, submit_at, is_accepted, image_url)
SELECT
        FLOOR(RAND() * 625) + 1 AS user_id,
        FLOOR(RAND() * 500) + 1 AS mission_id,
        DATE_ADD(NOW(), INTERVAL FLOOR(RAND() * 30) DAY) AS submit_at,
        CASE
            WHEN FLOOR(RAND() * 2) = 0 THEN 'waiting'
            ELSE 'accepted'
            END AS is_accepted,
        CONCAT('https://www.example.com/image/', FLOOR(RAND() * 1000)) AS image_url
FROM
    (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) a,
    (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) b,
    (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) c,
    (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) d,
    (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) e
LIMIT 3000;