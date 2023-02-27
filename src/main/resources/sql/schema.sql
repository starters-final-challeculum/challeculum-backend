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
    role          varchar(50) default 'role_member' not null #  role_member, role_admin
) charset = utf8mb4;

create table lecture
(
    lecture_id    int primary key auto_increment,
    category_name varchar(50)  not null, # category_it, category_language, category_school, category_certification
    platform      varchar(50)  not null, # platform_udemy, platform_inflearn, platform_cousera
    lecture_title varchar(255) not null,
    instructor    varchar(50)  not null,
    url           varchar(255) not null
) charset = utf8mb4;

create table ground
(
    ground_id      int primary key auto_increment,
    create_user_id int          not null,
    lecture_id     int          not null,
    ground_title   varchar(255) not null,
    information    text         not null,
    min_capacity   int          not null,
    deposit        int          not null,
    created_at     datetime              default now(),
    start_at       date         not null,
    end_at         date         not null default date_add(start_at, interval 7 day),
    status         varchar(30)  not null default 'ground_standby', # ground_standby, ground_ongoing, ground_completed
    constraint foreign key (lecture_id) references lecture (lecture_id),
    constraint foreign key (create_user_id) references user (user_id)
) charset = utf8mb4;


create table mission
(
    mission_id int primary key auto_increment,
    ground_id  int          not null,
    assignment varchar(255) not null,
    mission_at date         not null,
    constraint foreign key (ground_id) references ground (ground_id) on delete cascade
) charset = utf8mb4;

create table user_ground
(
    user_id    int not null,
    ground_id  int not null,
    is_success boolean,
    constraint foreign key (user_id) references user (user_id) on delete cascade,
    constraint foreign key (ground_id) references ground (ground_id) on delete cascade
) charset = utf8mb4;

create table review
(
    user_id   int not null,
    ground_id int not null,
    rating    int,
    comment   text,
    constraint foreign key (user_id) references user (user_id),
    constraint foreign key (ground_id) references ground (ground_id)
) charset = utf8mb4;

create table user_lecture
(
    user_id    int not null,
    lecture_id int not null,
    constraint foreign key (user_id) references user (user_id),
    constraint foreign key (lecture_id) references lecture (lecture_id)
) charset = utf8mb4;

create table user_mission
(
    user_id     int                           not null,
    mission_id  int                           not null,
    submit_at   datetime    default now()     not null,
    is_accepted varchar(50) default 'waiting' not null, # waiting, accepted, rejected
    image_url   varchar(255)                  not null,
    constraint foreign key (user_id) references user (user_id),
    constraint foreign key (mission_id) references mission (mission_id)
) charset = utf8mb4;
