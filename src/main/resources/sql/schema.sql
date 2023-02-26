SET foreign_key_checks = 0;
SET foreign_key_checks = 1;

drop table if exists user_mission;
drop table if exists user_lecture;
drop table if exists user_ground;
drop table if exists review;
drop table if exists mission;
drop table if exists ground;
drop table if exists user;
drop table if exists lecture;

create table user
(
    user_id       int primary key auto_increment,
    oauth_id      varchar(50),
    username      varchar(50) unique                not null,
    password      varchar(255)                      not null,
    nickname      varchar(50) unique,
    phone         varchar(11),
    point         int         default 3000          not null,
    mission_score int         default 1000          not null,
    role          varchar(50) default 'ROLE_MEMBER' not null #  ROLE_MEMBER, ROLE_ADMIN
) CHARSET = utf8mb4;

create table lecture
(
    lecture_id    int primary key auto_increment,
    category_name varchar(50)  not null, # CATEGORY_IT, CATEGORY_LANGUAGE, CATEGORY_SCHOOL, CATEGORY_CERTIFICATION
    platform      varchar(50)  not null, # PLATFORM_UDEMY, PLATFORM_INFLEARN, PLATFORM_COUSERA
    lecture_title varchar(255) not null,
    instructor    varchar(50)  not null,
    url           varchar(255) not null
) CHARSET = utf8mb4;

CREATE TABLE ground
(
    ground_id      int PRIMARY KEY AUTO_INCREMENT,
    create_user_id int          NOT NULL,
    lecture_id     int          NOT NULL,
    ground_title   varchar(255) NOT NULL,
    information    text         NOT NULL,
    min_capacity   int          NOT NULL,
    deposit        int          NOT NULL,
    created_at     datetime              DEFAULT NOW(),
    start_at       date         NOT NULL,
    end_at         date         NOT NULL DEFAULT DATE_ADD(start_at, INTERVAL 7 DAY),
    status         varchar(30)  NOT NULL DEFAULT 'GROUND_STANDBY', # GROUND_STANDBY, GROUND_ONGOING, GROUND_COMPLETED
    CONSTRAINT FOREIGN KEY (lecture_id) REFERENCES lecture (lecture_id),
    CONSTRAINT FOREIGN KEY (create_user_id) REFERENCES user (user_id)
) CHARSET = utf8mb4;


create table mission
(
    mission_id int primary key auto_increment,
    ground_id  int          not null,
    assignment varchar(255) not null,
    mission_at date         not null,
    constraint foreign key (ground_id) references ground (ground_id) on delete cascade
) CHARSET = utf8mb4;

create table user_ground
(
    user_id    int not null,
    ground_id  int not null,
    is_success boolean,
    constraint foreign key (user_id) references user (user_id) on delete cascade,
    constraint foreign key (ground_id) references ground (ground_id) on delete cascade
) CHARSET = utf8mb4;

create table review
(
    user_id   int not null,
    ground_id int not null,
    rating    int,
    review    text,
    constraint foreign key (user_id) references user (user_id),
    constraint foreign key (ground_id) references ground (ground_id)
) CHARSET = utf8mb4;

create table user_lecture
(
    user_id    int not null,
    lecture_id int not null,
    constraint foreign key (user_id) references user (user_id),
    constraint foreign key (lecture_id) references lecture (lecture_id)
) CHARSET = utf8mb4;

create table user_mission
(
    user_id     int                           not null,
    mission_id  int                           not null,
    submit_at   datetime    default now()     not null,
    is_accepted varchar(50) default 'WAITING' not null, # WAITING, ACCEPTED, REJECTED
    image_url   varchar(255)                  not null,
    constraint foreign key (user_id) references user (user_id),
    constraint foreign key (mission_id) references mission (mission_id)
) CHARSET = utf8mb4;
