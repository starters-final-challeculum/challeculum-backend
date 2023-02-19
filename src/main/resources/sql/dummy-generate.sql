INSERT INTO category (name)
VALUES ('IT'), ('Language'), ('Science'), ('Technology'), ('Business');

INSERT INTO lecture (category_id, platform, title, instructor, url)
SELECT
    category.id AS category_id,
    platform_names.platform AS platform,
    CONCAT('강의 제목', ROW_NUMBER() OVER (ORDER BY 1)),
    CONCAT('강사', ROW_NUMBER() OVER (ORDER BY 1)),
    CONCAT('https://www.', platform_names.platform, '.com/course/', ROW_NUMBER() OVER (ORDER BY 1))
FROM
    category,
    (SELECT '인프런' AS platform UNION ALL SELECT '패스트캠퍼스' UNION ALL SELECT '유데미') platform_names
        CROSS JOIN
    (SELECT 0 AS dummy UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) a,
    (SELECT 0 AS dummy UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) b
LIMIT 100;

INSERT INTO user (oauth_id, username, password, nickname, phone, point, mission_score, role)
SELECT
    null AS oauth_id,
    CONCAT('user', ROW_NUMBER() OVER (ORDER BY 1), '@example.com') AS username,
    '$2a$10$Fv48kjkkWAV8KJZFE3OW9Oo36pHkK1eCAy7muhiTJrnljKZh0I70O' AS password,
    CONCAT('nickname', ROW_NUMBER() OVER (ORDER BY 1)) AS nickname,
    CONCAT('010', LPAD(FLOOR(RAND() * 10000), 4, '0'), LPAD(FLOOR(RAND() * 10000), 4, '0')) AS phone,
    3000 AS point,
    1000 AS mission_score,
    'ROLE_MEMBER' AS role
FROM
    (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) a,
    (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) b,
    (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) c,
    (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) d
LIMIT 100;


INSERT INTO ground (user_id, lecture_id, title, information, level, min_capacity, max_capacity, deposit, is_validated, is_premium, start_at, end_at, validated_at, status, mission_fail_limit)
SELECT
        FLOOR(RAND() * 100) + 1,
        FLOOR(RAND() * 100) + 1,
        CONCAT('그라운드 제목 ', ROW_NUMBER() over ()),
        CONCAT('그라운드 설명 ', ROW_NUMBER() over ()),
        FLOOR(RAND() * 2) + 1,
        FLOOR(RAND() * 10) + 1,
        FLOOR(RAND() * 30) + 10,
        FLOOR(RAND() * 10000) + 1000,
        FALSE,
        IF(FLOOR(RAND() * 2) = 0, FALSE, TRUE),
        DATE_ADD(NOW(), INTERVAL FLOOR(RAND() * 30) DAY),
        DATE_ADD(NOW(), INTERVAL FLOOR(RAND() * 30 + 1) DAY),
        NULL,
        'waiting',
        FLOOR(RAND() * 3) + 1
FROM
    (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) a,
    (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) b,
    (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) c,
    (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) d
LIMIT 100;

INSERT INTO mission (ground_id, assignment, start_at, end_at)
SELECT
        FLOOR(RAND() * 100) + 1 AS ground_id,
        CONCAT('assignment_', FLOOR(RAND() * 1000)) AS assignment,
        DATE_ADD('2022-01-01', INTERVAL FLOOR(RAND() * 365) DAY) AS start_at,
        DATE_ADD('2022-01-01', INTERVAL FLOOR(RAND() * 365) DAY) AS end_at
FROM
    (SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 5) a,
    (SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 5) b,
    (SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 5) c,
    (SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 5) d
LIMIT 200;


