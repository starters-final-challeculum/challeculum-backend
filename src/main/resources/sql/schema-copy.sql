drop table if exists user_mission;
drop table if exists user_lecture;
drop table if exists user_ground;
drop table if exists mission;
drop table if exists user;
drop table if exists ground;
drop table if exists lecture;
drop table if exists category;

create table user
(
    id            int primary key auto_increment,
    oauth_id      varchar(50),
    username      varchar(50) unique           not null,
    password      varchar(255)                 not null,
    nickname      varchar(50) unique,
    phone         varchar(11),
    point         int         default 3000     not null,
    mission_score int         default 1000     not null,
    role          varchar(50) default 'member' not null
);

create table category
(
    id   int primary key auto_increment,
    name varchar(30) not null
);

create table lecture
(
    id          int primary key auto_increment,
    category_id int          not null,
    platform    varchar(50)  not null,
    title       varchar(255) not null,
    instructor  varchar(50)  not null,
    url         varchar(255) not null,
    constraint foreign key (category_id) references category (id)
);

create table ground
(
    id                 int primary key auto_increment,
    lecture_id         int                           not null,
    title              varchar(255)                  not null,
    information        text                          not null,
    level              int                           not null,
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
    constraint foreign key (lecture_id) references lecture (id)
);

create table mission
(
    id         int primary key auto_increment,
    ground_id  int          not null,
    assignment varchar(255) not null,
    start_at   date         not null,
    end_at     date         not null,
    constraint foreign key (ground_id) references ground (id) on delete cascade
);

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
);

create table user_lecture
(
    id           int primary key auto_increment,
    user_id      int not null,
    lecture_id   int not null,
    is_completed boolean default false,
    constraint foreign key (user_id) references user (id),
    constraint foreign key (lecture_id) references lecture (id)
);

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
);