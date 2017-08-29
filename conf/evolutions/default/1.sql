# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table tweet (
  id                        integer not null,
  comment                   varchar(255),
  user_user_id              integer,
  postdate                  timestamp not null,
  constraint pk_tweet primary key (id))
;

create table user (
  user_id                   integer not null,
  username                  varchar(255),
  twitter_name              varchar(255),
  password                  varchar(255),
  constraint pk_user primary key (user_id))
;

create table user_follows (
  relation_id               integer not null,
  follower_user_id          integer,
  followed_user_id          integer,
  constraint pk_user_follows primary key (relation_id))
;

create sequence tweet_seq;

create sequence user_seq;

create sequence user_follows_seq;

alter table tweet add constraint fk_tweet_user_1 foreign key (user_user_id) references user (user_id) on delete restrict on update restrict;
create index ix_tweet_user_1 on tweet (user_user_id);
alter table user_follows add constraint fk_user_follows_follower_2 foreign key (follower_user_id) references user (user_id) on delete restrict on update restrict;
create index ix_user_follows_follower_2 on user_follows (follower_user_id);
alter table user_follows add constraint fk_user_follows_followed_3 foreign key (followed_user_id) references user (user_id) on delete restrict on update restrict;
create index ix_user_follows_followed_3 on user_follows (followed_user_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists tweet;

drop table if exists user;

drop table if exists user_follows;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists tweet_seq;

drop sequence if exists user_seq;

drop sequence if exists user_follows_seq;

