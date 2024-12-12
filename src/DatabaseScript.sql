-- Drop existing tables
drop table if exists Level cascade;
drop table if exists Board cascade;
drop table if exists GameSession cascade;
drop table if exists Player cascade;
drop table if exists Square cascade;
drop table if exists SaveGameState cascade;
drop table if exists Game cascade;

-- Create tables
create table if not exists Level(
    levelId serial not null primary key,
    sizeX int not null,
    sizeY int not null
);

create table if not exists Board(
    boardId serial not null primary key,
    levelId int references Level
);

create table if not exists Player(
    playerId serial not null primary key,
    playerName varchar(255) not null unique,
    password varchar(255) not null
);

create table if not exists Square(
    squareId serial not null primary key,
    levelId int references Level,
    positionX int not null,
    positionY int not null,
    type char(1) not null,
    number char(1) not null,
    direction char(1) not null
);

create table if not exists GameSession(
    sessionId serial not null primary key,
    playerId int references Player,
    levelId int references Level,
    time int not null
);

create table if not exists Game(
     gameId serial not null primary key,
     playerId int references Player,
     boardId int references Board,
     state varchar(10) not null
);

create table if not exists SaveGameState(
    saveId serial not null primary key,
    gameId int references Game,
    saveData varchar(255) not null,
    saveTime int not null
);

-- Seed table(s) values {as needed}
insert into Level (
    sizeX,
    sizeY
) values (
    10,
    10
);

insert into Player (playerName, password) values ('a', 'a');
insert into Player (playerName, password) values ('b', 'a');
insert into Player (playerName, password) values ('c', 'a');
insert into Player (playerName, password) values ('d', 'a');
insert into Player (playerName, password) values ('e', 'a');

insert into GameSession(playerId, levelId, time)values (1,1, 360);
insert into GameSession(playerId, levelId, time)values (2,1, 280);
insert into GameSession(playerId, levelId, time)values (3,1, 180);
insert into GameSession(playerId, levelId, time)values (4,1, 60);
insert into GameSession(playerId, levelId, time)values (5,1, 460);

insert into Level(sizeX, sizeY) values (10,10);

insert into Square(levelId, positionX, positionY, type, number, direction)
values (1, 1, 0, 'B', '5', 'R');
insert into Square(levelId, positionX, positionY, type, number, direction)
values (1, 2, 3, 'B', '3', 'D');
insert into Square(levelId, positionX, positionY, type, number, direction)
values (1, 4, 4, 'W', '7', 'U');
insert into Square(levelId, positionX, positionY, type, number, direction)
values (1, 8, 2, 'W', '5', 'L');
insert into Square(levelId, positionX, positionY, type, number, direction)
values (1, 7, 3, 'B', '1', 'D');
insert into Square(levelId, positionX, positionY, type, number, direction)
values (1, 3, 9, 'W', '2', 'U');

