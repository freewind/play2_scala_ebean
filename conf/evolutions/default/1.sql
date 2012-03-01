# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table answers (
  id                        bigint not null,
  content                   varchar(255),
  question_id               bigint,
  created_at                timestamp,
  constraint pk_answers primary key (id))
;

create table articles (
  id                        bigint not null,
  content                   varchar(255),
  constraint pk_articles primary key (id))
;

create table comments (
  comment_for               varchar(31) not null,
  id                        bigint not null,
  content                   varchar(255),
  created_at                timestamp,
  updated_at                timestamp,
  anser_id                  bigint,
  constraint pk_comments primary key (id))
;

create table questions (
  id                        bigint not null,
  title                     varchar(255),
  content                   varchar(255),
  created_at                timestamp,
  constraint pk_questions primary key (id))
;

create table tags (
  id                        bigint not null,
  name                      varchar(255),
  created_at                timestamp,
  updated_at                timestamp,
  constraint pk_tags primary key (id))
;


create table question_tag_r (
  questions_id                   bigint not null,
  tags_id                        bigint not null,
  constraint pk_question_tag_r primary key (questions_id, tags_id))
;
create sequence answers_seq;

create sequence articles_seq;

create sequence comments_seq;

create sequence questions_seq;

create sequence tags_seq;

alter table answers add constraint fk_answers_question_1 foreign key (question_id) references questions (id) on delete restrict on update restrict;
create index ix_answers_question_1 on answers (question_id);
alter table comments add constraint fk_comments_anser_2 foreign key (anser_id) references answers (id) on delete restrict on update restrict;
create index ix_comments_anser_2 on comments (anser_id);



alter table question_tag_r add constraint fk_question_tag_r_questions_01 foreign key (questions_id) references questions (id) on delete restrict on update restrict;

alter table question_tag_r add constraint fk_question_tag_r_tags_02 foreign key (tags_id) references tags (id) on delete restrict on update restrict;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists answers;

drop table if exists articles;

drop table if exists comments;

drop table if exists questions;

drop table if exists question_tag_r;

drop table if exists tags;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists answers_seq;

drop sequence if exists articles_seq;

drop sequence if exists comments_seq;

drop sequence if exists questions_seq;

drop sequence if exists tags_seq;

