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
SELECT category.id             AS category_id,
       platform_names.platform AS platform,
       CONCAT('강의 제목', ROW_NUMBER() OVER (ORDER BY 1)),
       CONCAT('강사', ROW_NUMBER() OVER (ORDER BY 1)),
       CONCAT('https://www.', platform_names.platform, '.com/course/', ROW_NUMBER() OVER (ORDER BY 1))
FROM category,
     (SELECT 'INFLEARN' AS platform UNION ALL SELECT 'FASTCAMPUS' UNION ALL SELECT 'UDEMY') platform_names
         CROSS JOIN
     (SELECT 0 AS dummy UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) a,
     (SELECT 0 AS dummy UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) b
WHERE category.id = FLOOR(RAND() * 6) + 1
LIMIT 20;


-- ground 테이블에 더미 데이터 추가
INSERT INTO ground (lecture_id, title, information, level, min_capacity, max_capacity, deposit, is_validated,
                    is_premium, start_at, end_at, status, mission_fail_limit, user_id)
SELECT FLOOR(RAND() * 20) + 1                                AS lecture_id,
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
SELECT FLOOR(RAND() * 100) + 1                               AS ground_id,
       CONCAT('Assignment', ROW_NUMBER() OVER (ORDER BY 1))  AS assignment,
       DATE_ADD(NOW(), INTERVAL FLOOR(RAND() * 30) DAY)      AS start_at,
       DATE_ADD(NOW(), INTERVAL FLOOR(RAND() * 30 + 30) DAY) AS end_at
FROM (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) a,
     (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) b,
     (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) c,
     (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) d
LIMIT 500;

INSERT INTO user_ground (user_id, ground_id, is_attending, is_success, rating, review)
SELECT FLOOR(RAND() * 625) + 1           AS user_id,
       FLOOR(RAND() * 50) + 1            AS ground_id,
       IF(FLOOR(RAND() * 10) <= 8, 1, 0) AS is_attending,
       CASE
           WHEN FLOOR(RAND() * 2) = 0 THEN NULL
           ELSE FLOOR(RAND() * 5) + 1
           END                           AS is_success,
       CASE
           WHEN FLOOR(RAND() * 2) = 0 THEN NULL
           ELSE FLOOR(RAND() * 5) + 1
           END                           AS rating,
       CASE
           WHEN FLOOR(RAND() * 2) = 0 THEN NULL
           ELSE CONCAT('Comment', ROW_NUMBER() OVER (ORDER BY 1))
           END                           AS review
FROM (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) a,
     (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) b,
     (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) c,
     (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) d,
     (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) e
LIMIT 2000;

INSERT INTO user_lecture (user_id, lecture_id, is_completed)
SELECT FLOOR(RAND() * 625) + 1 AS user_id,
       FLOOR(RAND() * 20) + 1  AS lecture_id,
       FLOOR(RAND() * 2)       AS is_completed
FROM (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) a,
     (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) b,
     (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) c,
     (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) d
LIMIT 1000;

INSERT INTO user_mission (user_id, mission_id, submit_at, is_accepted, image_url)
SELECT FLOOR(RAND() * 625) + 1                                        AS user_id,
       FLOOR(RAND() * 500) + 1                                        AS mission_id,
       DATE_ADD(NOW(), INTERVAL FLOOR(RAND() * 30) DAY)               AS submit_at,
       CASE
           WHEN FLOOR(RAND() * 2) = 0 THEN 'waiting'
           ELSE 'accepted'
           END                                                        AS is_accepted,
       CONCAT('https://www.example.com/image/', FLOOR(RAND() * 1000)) AS image_url
FROM (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) a,
     (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) b,
     (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) c,
     (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) d,
     (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) e
LIMIT 3000;