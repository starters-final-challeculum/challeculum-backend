
-- ----  user
ALTER TABLE user
    AUTO_INCREMENT = 1;
INSERT INTO user (username, password, nickname, phone, role)
VALUES ('user1@EXAMPLE.com', '$2a$10$Fv48kjkkWAV8KJZFE3OW9Oo36pHkK1eCAy7muhiTJrnljKZh0I70O', '박종현', '01012341234',
        'ROLE_MEMBER'),
       ('user2@EXAMPLE.com', '$2a$10$Fv48kjkkWAV8KJZFE3OW9Oo36pHkK1eCAy7muhiTJrnljKZh0I70O', '한광희', '01012341234',
        'ROLE_MEMBER'),
       ('user3@EXAMPLE.com', '$2a$10$Fv48kjkkWAV8KJZFE3OW9Oo36pHkK1eCAy7muhiTJrnljKZh0I70O', '왕기영', '01012341234',
        'ROLE_MEMBER'),
       ('user4@EXAMPLE.com', '$2a$10$Fv48kjkkWAV8KJZFE3OW9Oo36pHkK1eCAy7muhiTJrnljKZh0I70O', '장소정', '01012341234',
        'ROLE_MEMBER'),
       ('user5@EXAMPLE.com', '$2a$10$Fv48kjkkWAV8KJZFE3OW9Oo36pHkK1eCAy7muhiTJrnljKZh0I70O', '정화준', '01012341234',
        'ROLE_MEMBER'),
       ('user6@EXAMPLE.com', '$2a$10$Fv48kjkkWAV8KJZFE3OW9Oo36pHkK1eCAy7muhiTJrnljKZh0I70O', '조현준', '01012341234',
        'ROLE_MEMBER'),
       ('user7@EXAMPLE.com', '$2a$10$Fv48kjkkWAV8KJZFE3OW9Oo36pHkK1eCAy7muhiTJrnljKZh0I70O', '이진형', '01012341234',
        'ROLE_MEMBER'),
       ('user8@EXAMPLE.com', '$2a$10$Fv48kjkkWAV8KJZFE3OW9Oo36pHkK1eCAy7muhiTJrnljKZh0I70O', '고의석', '01012341234',
        'ROLE_MEMBER'),
       ('user9@EXAMPLE.com', '$2a$10$Fv48kjkkWAV8KJZFE3OW9Oo36pHkK1eCAy7muhiTJrnljKZh0I70O', '황영환', '01012341234',
        'ROLE_MEMBER'),
       ('user10@EXAMPLE.com', '$2a$10$Fv48kjkkWAV8KJZFE3OW9Oo36pHkK1eCAy7muhiTJrnljKZh0I70O', '곽희진', '01012341234',
        'ROLE_MEMBER'),



		 ('user11@EXAMPLE.com', '$2a$10$Fv48kjkkWAV8KJZFE3OW9Oo36pHkK1eCAy7muhiTJrnljKZh0I70O', '김소현', '01012341234',
        'ROLE_MEMBER'),
		 ('user12@EXAMPLE.com', '$2a$10$Fv48kjkkWAV8KJZFE3OW9Oo36pHkK1eCAy7muhiTJrnljKZh0I70O', '김지운', '01012341234',
        'ROLE_MEMBER'),
		 ('user13@EXAMPLE.com', '$2a$10$Fv48kjkkWAV8KJZFE3OW9Oo36pHkK1eCAy7muhiTJrnljKZh0I70O', '홍한솔', '01012341234',
        'ROLE_MEMBER'),
		 ('user14@EXAMPLE.com', '$2a$10$Fv48kjkkWAV8KJZFE3OW9Oo36pHkK1eCAy7muhiTJrnljKZh0I70O', '김수연', '01012341234',
        'ROLE_MEMBER'),
		 ('user15@EXAMPLE.com', '$2a$10$Fv48kjkkWAV8KJZFE3OW9Oo36pHkK1eCAy7muhiTJrnljKZh0I70O', '조준형', '01012341234',
        'ROLE_MEMBER'),
		 ('user16@EXAMPLE.com', '$2a$10$Fv48kjkkWAV8KJZFE3OW9Oo36pHkK1eCAy7muhiTJrnljKZh0I70O', '김민지', '01012341234',
        'ROLE_MEMBER'),
		 ('user17@EXAMPLE.com', '$2a$10$Fv48kjkkWAV8KJZFE3OW9Oo36pHkK1eCAy7muhiTJrnljKZh0I70O', '정태현', '01012341234',
        'ROLE_MEMBER'),
		 ('user18@EXAMPLE.com', '$2a$10$Fv48kjkkWAV8KJZFE3OW9Oo36pHkK1eCAy7muhiTJrnljKZh0I70O', '오현경', '01012341234',
        'ROLE_MEMBER'),
		 ('user19@EXAMPLE.com', '$2a$10$Fv48kjkkWAV8KJZFE3OW9Oo36pHkK1eCAy7muhiTJrnljKZh0I70O', '최원준', '01012341234',
        'ROLE_MEMBER');


-- ------- lecture
-- “CATEGORY_IT”, “CATEGORY_LANGUAGE”, “CATEGORY_SCHOOL”, “CATEGORY_CERTIFICATION”
-- “PLATFORM_UDEMY”, “PLATFORM_INFLEARN”, “PLATFORM_COUSERA”
ALTER TABLE lecture
    AUTO_INCREMENT = 1;
INSERT INTO lecture (lecture_id, category_name, platform, lecture_title, instructor, url)
VALUES (1, 'CATEGORY_IT', 'PLATFORM_COURSERA', 'Programming for Everybody (Getting Started with Python)', 'Charles Russell Severance', 'https://www.PLATFORM_COURSERA.com/course/1'),
       (2, 'CATEGORY_IT', 'PLATFORM_INFLEARN', '스프링 입문 - 코드로 배우는 스프링 부트, 웹 MVC, DB 접근 기술', '김영한', 'https://www.PLATFORM_INFLEARN.com/course/2'),
       (3, 'CATEGORY_LANGUAGE', 'PLATFORM_UDEMY', '비대면 시대에 꼭 필요한 비즈니스 영어', 'Victoria Shin', 'https://www.PLATFORM_UDEMY.com/course/3'),
       (4, 'CATEGORY_LANGUAGE', 'PLATFORM_COURSERA', 'Lesson | Small Talk & Conversational Vocabulary by Amalia B. Stephens', 'Amalia B. Stephens', 'https://www.PLATFORM_COURSERA.com/course/4'),
       (5, 'CATEGORY_SCHOOL', 'PLATFORM_INFLEARN', 'udemy category_school High School Math: Understand it, Ace it!', 'Gary Thomson', 'https://www.PLATFORM_INFLEARN.com/course/5'),
       (6, 'CATEGORY_CERTIFICATION', 'PLATFORM_UDEMY', 'Certified Kubernetes Administrator (CKA) with Practice Tests', 'Mumshad Mannambeth', 'https://www.PLATFORM_UDEMY.com/course/6'),
       (7, 'CATEGORY_LANGUAGE', 'PLATFORM_COURSERA', 'Arizona State University TESOL 전문 인증서', 'Jessica Cinco', 'https://www.PLATFORM_COURSERA.com/course/7'),
       (8, 'CATEGORY_SCHOOL', 'PLATFORM_INFLEARN', '머신러닝/딥러닝으로 이어지는 선형대수', '딥러닝호형', 'https://www.PLATFORM_INFLEARN.com/course/8'),
       (9, 'CATEGORY_CERTIFICATION', 'PLATFORM_UDEMY', '실무에서 바로 사용하는 ITQ 엑셀 자격 과정', '이지은', 'https://www.PLATFORM_UDEMY.com/course/9'),
       (10, 'CATEGORY_LANGUAGE', 'PLATFORM_INFLEARN', '실무에서 바로 쓰는 영어 이메일', '런어데이', 'https://www.PLATFORM_INFLEARN.com/course/10'),


       (11, 'CATEGORY_IT', 'PLATFORM_UDEMY', 'Docker & Kubernetes : 실전 가이드', 'Maximilian Schwarzmuller', 'https://www.PLATFORM_UDEMY.com/course/11'),
       (12, 'CATEGORY_IT', 'PLATFORM_INFLEARN', '자바 개발자를 위한 코틀린 입문(Java to Kotlin Starter Guide)', '최태현', 'https://www.PLATFORM_INFLEARN.com/course/12'),
       (13, 'CATEGORY_IT', 'PLATFORM_UDEMY', '완전 초보자를 위한 Java 프로그래밍 : 단기간에 Java 완벽 정복', 'Ranga Karanam', 'https://www.PLATFORM_UDEMY.com/course/13'),
       (14, 'CATEGORY_LANGUAGE', 'PLATFORM_INFLEARN', '취미로 시작하는 중국어 회화 (입문)', '홍차는홍차', 'https://www.PLATFORM_INFLEARN.com/course/14'),
       (15, 'CATEGORY_SCHOOL', 'PLATFORM_UDEMY', '미적분 1 마스터하기', 'Krista King', 'https://www.PLATFORM_UDEMY.com/course/15'),
       (16, 'CATEGORY_CERTIFICATION', 'PLATFORM_UDEMY', '실무에서 바로 사용하는 ITQ 파워포인트 자격 과정', '이지은', 'https://www.PLATFORM_UDEMY.com/course/16'),
       (17, 'CATEGORY_LANGUAGE', 'PLATFORM_INFLEARN', '씨리얼 오픽 2급(IM3~IH) 과정', '다름에듀', 'https://www.PLATFORM_INFLEARN.com/course/17'),
       (18, 'CATEGORY_SCHOOL', 'PLATFORM_INFLEARN', '선형대수학개론', '조범희', 'https://www.PLATFORM_INFLEARN.com/course/18'),
       (19, 'CATEGORY_CERTIFICATION', 'PLATFORM_COURSERA', '구글 데이터 애널리틱스 전문 인증서', 'Google Career Certificates', 'https://www.PLATFORM_COURSERA.com/course/19'),
       (20, 'CATEGORY_LANGUAGE', 'PLATFORM_UDEMY', '현역 일본 직장인이 알려주는 활용도 100% 실무 비즈니스 일본어 & 매너', 'RINGOYA', 'https://www.PLATFORM_UDEMY.com/course/20');


INSERT INTO user_lecture (user_id, lecture_id)
VALUES (1, 1),
		 (14, 1),
       (1, 2),
       (8, 2),
       (1, 3),
       (14, 3),
       (2, 4),
       (8, 4),
       (2, 5),
       (4, 5),
       (3, 6),
       (19, 6),
       (4, 7),
       (13, 7),
       (15, 6),
       (1, 6),
       (19, 14),
       (8, 14),
       (7, 17),
       (16, 17),
       (9, 2),
       (3, 2),
       (8, 16),
       (11, 16),
       (3, 4),
       (5, 1),
       (5, 4),
       (6, 7);



-- ------- ground
ALTER TABLE ground
    AUTO_INCREMENT = 1;
-- 그라운드 더미 데이터 수작업--
INSERT INTO final.ground (ground_id, create_user_id, lecture_id, ground_title, information, min_capacity, deposit, created_at, start_at, end_at, status)
VALUES (1, 1, 1, '파이썬 그라운드', 'Charles Russell Severance 파이썬 초급 강의', 2, 1000, '2023-02-23 13:59:54', '2023-02-26', '2023-03-05', 'GROUND_ONGOING');
INSERT INTO final.ground (ground_id, create_user_id, lecture_id, ground_title, information, min_capacity, deposit, created_at, start_at, end_at, status)
VALUES (2, 1, 2, '스프링 입문 그라운드', '김영한 스프링 입문 강의', 2, 2000, '2023-02-17 13:59:54', '2023-02-21', '2023-02-28', 'GROUND_COMPLETED');
INSERT INTO final.ground (ground_id, create_user_id, lecture_id, ground_title, information, min_capacity, deposit, created_at, start_at, end_at, status)
VALUES (3, 1, 3, '비즈니스 영어 그라운드', '비대면 비즈니스 영어 강의', 2, 5000, '2023-02-25 13:59:54', '2023-03-05', '2023-03-12', 'GROUND_STANDBY');
INSERT INTO final.ground (ground_id, create_user_id, lecture_id, ground_title, information, min_capacity, deposit, created_at, start_at, end_at, status)
VALUES (4, 2, 4, 'Conversational Vocabulary 그라운드', '영어 회화에 필요한 단어 강의', 2, 3000, '2023-02-20 13:59:54', '2023-02-25', '2023-03-03', 'GROUND_ONGOING');
INSERT INTO final.ground (ground_id, create_user_id, lecture_id, ground_title, information, min_capacity, deposit, created_at, start_at, end_at, status)
VALUES (5, 2, 5, '고등 수학 그라운드', '미국 고등학교 수학 강의', 2, 4000, '2023-02-23 11:42:54', '2023-03-04', '2023-03-10', 'GROUND_STANDBY');
INSERT INTO final.ground (ground_id, create_user_id, lecture_id, ground_title, information, min_capacity, deposit, created_at, start_at, end_at, status)
VALUES (6, 3, 6, '쿠버네티스 그라운드', '쿠버네티스 강의', 2, 4000, '2023-02-23 11:42:54', '2023-03-07', '2023-03-13', 'GROUND_STANDBY');
INSERT INTO final.ground (ground_id, create_user_id, lecture_id, ground_title, information, min_capacity, deposit, created_at, start_at, end_at, status)
VALUES (7, 4, 7, 'TESOL 자격증 그라운드', 'Arizona State University TESOL 강의', 2, 6000, '2023-02-15 11:42:54', '2023-02-17', '2023-02-23', 'GROUND_COMPLETED');



INSERT INTO final.ground (ground_id, create_user_id, lecture_id, ground_title, information, min_capacity, deposit, created_at, start_at, end_at, status)
VALUES (8, 15, 6, 'CKA 자격증 그라운드', 'Mumshad Mannambeth의 CKF 자격증 강의', 2, 2000, '2023-02-17 16:42:54', '2023-02-25', '2023-03-03', 'GROUND_ONGOING');
INSERT INTO final.ground (ground_id, create_user_id, lecture_id, ground_title, information, min_capacity, deposit, created_at, start_at, end_at, status)
VALUES (9, 19, 14, '중국어 회화 입문 그라운드', '홍차는홍차의 중국어 회화 입문 강의', 2, 5000, '2023-02-28 09:42:54', '2023-03-04', '2023-03-10', 'GROUND_STANDBY');
INSERT INTO final.ground (ground_id, create_user_id, lecture_id, ground_title, information, min_capacity, deposit, created_at, start_at, end_at, status)
VALUES (10, 7, 17, '씨리얼 오픽 2급(IM3~IH) 그라운드', '다름에듀의 씨리얼 오픽 2급(IM3~IH) 강의', 2, 3000, '2023-02-16 11:20:54', '2023-02-18', '2023-02-24', 'GROUND_COMPLETED');
INSERT INTO final.ground (ground_id, create_user_id, lecture_id, ground_title, information, min_capacity, deposit, created_at, start_at, end_at, status)
VALUES (11, 9, 2, '김영한 스프링 입문 그라운드', '김영한의 스프링 입문자를 위한 강의', 2, 6000, '2023-02-16 16:08:54', '2023-02-20', '2023-02-26', 'GROUND_COMPLETED');
INSERT INTO final.ground (ground_id, create_user_id, lecture_id, ground_title, information, min_capacity, deposit, created_at, start_at, end_at, status)
VALUES (12, 8, 16, 'ITQ 파워포인트 자격증 그라운드', '이지은의 ITQ 자격증 강의', 2, 4000, '2023-02-27 17:12:54', '2023-03-07', '2023-03-13', 'GROUND_STANDBY');




-- ----------mission
INSERT INTO mission(ground_id, assignment, mission_at)
VALUES (1, '파이썬 초급 mission1', '2023-02-26'),
       (1, '파이썬 초급 mission2', '2023-02-27'),
       (1, '파이썬 초급 mission3', '2023-02-28'),
       (1, '파이썬 초급 mission4', '2023-03-01'),
       (1, '파이썬 초급 mission5', '2023-03-02'),
       (1, '파이썬 초급 mission6', '2023-03-03'),
       (1, '파이썬 초급 mission7', '2023-03-04'),
       (2, '스프링 입문 mission1', '2023-02-21'),
       (2, '스프링 입문 mission2', '2023-02-22'),
       (2, '스프링 입문 mission3', '2023-02-23'),
       (2, '스프링 입문 mission4', '2023-02-24'),
       (2, '스프링 입문 mission5', '2023-02-25'),
       (2, '스프링 입문 mission6', '2023-02-26'),
       (2, '스프링 입문 mission7', '2023-02-27'),
       (3, '비즈니스 영어 mission1', '2023-03-06'),
       (3, '비즈니스 영어 mission2', '2023-03-07'),
       (3, '비즈니스 영어 mission3', '2023-03-08'),
       (3, '비즈니스 영어 mission4', '2023-03-09'),
       (3, '비즈니스 영어 mission5', '2023-03-10'),
       (3, '비즈니스 영어 mission6', '2023-03-11'),
       (3, '비즈니스 영어 mission7', '2023-03-12'),
       (4, '영단어 mission1', '2023-02-25'),
       (4, '영단어 mission2', '2023-02-26'),
       (4, '영단어 mission3', '2023-02-27'),
       (4, '영단어 mission4', '2023-02-28'),
       (4, '영단어 mission5', '2023-03-01'),
       (4, '영단어 mission6', '2023-03-02'),
       (4, '영단어 mission7', '2023-03-03'),
       (5, '미국 고등 수학 mission1', '2023-03-04'),
       (5, '미국 고등 수학 mission2', '2023-03-05'),
       (5, '미국 고등 수학 mission3', '2023-03-06'),
       (5, '미국 고등 수학 mission4', '2023-03-07'),
       (5, '미국 고등 수학 mission5', '2023-03-08'),
       (5, '미국 고등 수학 mission6', '2023-03-09'),
       (5, '미국 고등 수학 mission7', '2023-03-10'),
       (6, '쿠버네티스 mission1', '2023-03-07'),
       (6, '쿠버네티스 mission2', '2023-03-08'),
       (6, '쿠버네티스 mission3', '2023-03-09'),
       (6, '쿠버네티스 mission4', '2023-03-10'),
       (6, '쿠버네티스 mission5', '2023-03-11'),
       (6, '쿠버네티스 mission6', '2023-03-12'),
       (6, '쿠버네티스 mission7', '2023-03-13'),
       (7, 'TESOL mission1', '2023-02-17'),
       (7, 'TESOL mission2', '2023-02-18'),
       (7, 'TESOL mission3', '2023-02-19'),
       (7, 'TESOL mission4', '2023-02-20'),
       (7, 'TESOL mission5', '2023-02-21'),
       (7, 'TESOL mission6', '2023-02-22'),
       (7, 'TESOL mission7', '2023-02-23'),

       (8, 'CKA mission1', '2023-02-25'),
       (8, 'CKA mission2', '2023-02-26'),
       (8, 'CKA mission3', '2023-02-27'),
       (8, 'CKA mission4', '2023-02-28'),
       (8, 'CKA mission5', '2023-03-01'),
       (8, 'CKA mission6', '2023-03-02'),
       (8, 'CKA mission7', '2023-03-03'),
       (9, '중국어 회화 입문 mission1', '2023-03-04'),
       (9, '중국어 회화 입문 mission2', '2023-03-05'),
       (9, '중국어 회화 입문 mission3', '2023-03-06'),
       (9, '중국어 회화 입문 mission4', '2023-03-07'),
       (9, '중국어 회화 입문 mission5', '2023-03-08'),
       (9, '중국어 회화 입문 mission6', '2023-03-09'),
       (9, '중국어 회화 입문 mission7', '2023-03-10'),
       (10, '오픽 2급 mission1', '2023-02-18'),
       (10, '오픽 2급 mission2', '2023-02-19'),
       (10, '오픽 2급 mission3', '2023-02-20'),
       (10, '오픽 2급 mission4', '2023-02-21'),
       (10, '오픽 2급 mission5', '2023-02-22'),
       (10, '오픽 2급 mission6', '2023-02-23'),
       (10, '오픽 2급 mission7', '2023-02-24'),
       (11, '김영한 스프링 입문 mission1', '2023-02-20'),
       (11, '김영한 스프링 입문 mission2', '2023-02-21'),
       (11, '김영한 스프링 입문 mission3', '2023-02-22'),
       (11, '김영한 스프링 입문 mission4', '2023-02-23'),
       (11, '김영한 스프링 입문 mission5', '2023-02-24'),
       (11, '김영한 스프링 입문 mission6', '2023-02-25'),
       (11, '김영한 스프링 입문 mission7', '2023-02-26'),
       (12, 'ITQ 파워포인트 자격증 mission1', '2023-03-07'),
       (12, 'ITQ 파워포인트 자격증 mission2', '2023-03-08'),
       (12, 'ITQ 파워포인트 자격증 mission3', '2023-03-09'),
       (12, 'ITQ 파워포인트 자격증 mission4', '2023-03-10'),
       (12, 'ITQ 파워포인트 자격증 mission5', '2023-03-11'),
       (12, 'ITQ 파워포인트 자격증 mission6', '2023-03-12'),
       (12, 'ITQ 파워포인트 자격증 mission7', '2023-03-13');


-- ----------- user_ground
INSERT INTO user_ground (user_id, ground_id, is_success)
VALUES (1, 1, 0),      -- 1
		 (14, 1, NULL),  -- 1
       (1, 2, 1),      -- 2
       (8, 2, 0),      -- 2
       (1, 3, NULL),   -- 3
       (14, 3, NULL),  -- 3
       (2, 4, NULL),   -- 4
       (8, 4, NULL),   -- 4
       (2, 5, NULL),   -- 5
       (4, 5, NULL),   -- 5
       (3, 6, NULL),   -- 6
       (19, 6, NULL),  -- 6
       (4, 7, 0),      -- 7
       (13, 7, 1),     -- 7
       (15, 8, NULL),  -- 6
       (1, 8, NULL),   -- 6
       (19, 9, NULL),  -- 14
       (8, 9, NULL),   -- 14
       (7, 10, 1),     -- 17
       (16, 10, 1),    -- 17
       (9, 11, 1),     -- 2
       (3, 11, 0),     -- 2
       (8, 12, NULL),  -- 16
       (11, 12, NULL), -- 16
       (3, 4, NULL),   -- 4
       (5, 1, NULL),   -- 1
       (5, 4, 0),      -- 4
       (6, 7, 1);      -- 7


-- ------------ user_mission (ground.status 상태가 GROUND_ONGOING, GROUND_COMPLETE)
INSERT INTO user_mission (user_id, mission_id, submit_at, is_accepted, image_url)
VALUES (1, 1, '2023-02-26 13:59:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
		 (1, 2, '2023-02-27 13:59:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
		 (1, 3, '2023-02-28 13:59:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
		 (1, 4, '2023-03-01 16:35:54', 'REJECTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),

		 (14, 1, '2023-02-26 13:59:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
		 (14, 2, '2023-02-27 13:59:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
		 (14, 3, '2023-02-28 13:59:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
		 (14, 4, '2023-03-01 13:59:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
		 (14, 5, '2023-03-02 13:59:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
		 (14, 6, '2023-03-03 13:59:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),

		 (1, 8, '2023-02-21 13:59:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (1, 9, '2023-02-22 11:59:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/d166e86b-4b1b-40d2-9cfc-f7602d7791a8'),
       (1, 10, '2023-02-23 12:59:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/bd683c99-cc6a-44d7-940f-a93890caf266'),
       (1, 11, '2023-02-24 13:59:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (1, 12, '2023-02-25 14:59:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (1, 13, '2023-02-26 15:59:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (1, 14, '2023-02-27 16:59:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),

       (8, 8, '2023-02-21 16:59:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),

       (2, 22, '2023-02-25 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (2, 23, '2023-02-26 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (2, 24, '2023-02-27 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (2, 25, '2023-02-28 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (2, 26, '2023-03-01 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (2, 27, '2023-03-02 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (2, 28, '2023-03-03 16:35:54', 'WAITING', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),

		 (8, 22, '2023-02-25 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (8, 23, '2023-02-26 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (8, 24, '2023-02-27 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (8, 25, '2023-02-28 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (8, 26, '2023-03-01 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (8, 27, '2023-03-02 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (8, 28, '2023-03-03 16:35:54', 'WAITING', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),

       (4, 43, '2023-02-17 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (4, 44, '2023-02-18 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (4, 45, '2023-02-19 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),

       (13, 43, '2023-02-17 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (13, 44, '2023-02-18 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (13, 45, '2023-02-19 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (13, 43, '2023-02-20 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (13, 44, '2023-02-21 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (13, 45, '2023-02-22 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (13, 43, '2023-02-23 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),

       (15, 50, '2023-02-25 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (15, 51, '2023-02-26 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (15, 52, '2023-02-27 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (15, 53, '2023-02-28 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (15, 54, '2023-03-01 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (15, 55, '2023-03-02 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),

       (1, 50, '2023-02-25 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (1, 51, '2023-02-26 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (1, 52, '2023-02-27 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (1, 53, '2023-02-28 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (1, 54, '2023-03-01 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (1, 55, '2023-03-02 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (1, 56, '2023-03-03 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),

       (7, 64, '2023-02-18 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (7, 65, '2023-02-19 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (7, 66, '2023-02-20 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (7, 67, '2023-02-21 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (7, 68, '2023-02-22 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (7, 69, '2023-02-23 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (7, 70, '2023-02-24 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),

		 (16, 64, '2023-02-18 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (16, 65, '2023-02-19 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (16, 66, '2023-02-20 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (16, 67, '2023-02-21 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (16, 68, '2023-02-22 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (16, 69, '2023-02-23 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (16, 70, '2023-02-24 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),

       (9, 71, '2023-02-20 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (9, 72, '2023-02-21 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (9, 73, '2023-02-22 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (9, 74, '2023-02-23 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (9, 75, '2023-02-24 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (9, 76, '2023-02-25 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (9, 77, '2023-02-26 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),

		 (3, 71, '2023-02-20 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (3, 72, '2023-02-21 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (3, 73, '2023-02-22 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (3, 74, '2023-02-23 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (3, 75, '2023-02-24 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),

       (3, 22, '2023-02-25 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (3, 23, '2023-02-26 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (3, 24, '2023-02-27 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (3, 25, '2023-02-28 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (3, 26, '2023-03-01 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (3, 27, '2023-03-02 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),

       (5, 1, '2023-02-26 13:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (5, 2, '2023-02-27 14:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (5, 3, '2023-02-28 15:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (5, 4, '2023-03-01 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (5, 5, '2023-03-02 13:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (5, 6, '2023-03-03 14:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),

       (5, 22, '2023-02-25 13:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (5, 23, '2023-02-26 14:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),

       (6, 43, '2023-02-17 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (6, 44, '2023-02-18 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (6, 45, '2023-02-19 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (6, 46, '2023-02-20 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (6, 47, '2023-02-21 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (6, 48, '2023-02-22 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg'),
       (6, 49, '2023-02-23 16:35:54', 'ACCEPTED', 'https://s3.ap-northeast-3.amazonaws.com/team3.finalproject/fc107715-0a50-454b-8f6c-0a565c7438a1_bulgogi_burger_test.jpeg');

-- ------- review
INSERT INTO review (user_id, ground_id, rating, comment)
VALUES (1, 2, 5, '스프링은 갓영환'),
       (4, 7, 2, '강의가 너무 어려워요');