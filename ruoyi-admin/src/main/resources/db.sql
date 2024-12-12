
create table module_developer
(
    id          bigint auto_increment
        primary key,
    module_id   bigint       null comment '模块id',
    dev_type    char(1)         null comment '1前端 2后端',
    user_id     varchar(256) null comment '开发人员',
    create_time datetime     null,
    update_time datetime     null,
    create_by   varchar(32)  null,
    update_by   varchar(32)  null
)
    comment '模块开发者';

create table module
(
    id          bigint auto_increment
        primary key,
    project_id  bigint          null comment '项目id',
    code        varchar(32)     null comment '唯一编码',
    name        varchar(32)     null comment '模块名称',
    remark      text            null comment '备注',
    sort        int default 999 null comment '排序',
    create_time datetime        null,
    update_time datetime        null,
    create_by   varchar(32)     null,
    update_by   varchar(32)     null,
    constraint code
        unique (code)
)
    comment '模块';

create table project
(
    id              bigint auto_increment
        primary key,
    project_name    varchar(32)     null comment '项目名称',
    code            varchar(32)     null comment '唯一编码',
    remark          text            null comment '备注',
    start_date      date            null comment '开始日期',
    end_date        date            null comment '结束日期',
    sort            int default 999 null comment '排序',
    manager_user_id bigint          null comment '管理者id',
    create_time     datetime        null,
    update_time     datetime        null,
    create_by       varchar(32)     null,
    update_by       varchar(32)     null,
    constraint code
        unique (code),
    constraint project_name
        unique (project_name)
)
    comment '项目';



create table task
(
    id          bigint auto_increment
        primary key,
    create_time datetime    null,
    update_time datetime    null,
    create_by   varchar(32) null,
    update_by   varchar(32) null,
    project_id  bigint      null comment '项目id',
    module_id   bigint      null comment '模块id',
    name        varchar(32) null comment '任务名称',
    remark      text        null comment '备注',
    start_date  date        null comment '开始日期',
    end_date    date        null comment '结束日期',
    state       char        null comment '1 未开始 2 进行中 3 已完成 4 已测试'
)
    comment '任务表';

create table task_developer
(
    id           bigint auto_increment
        primary key,
    create_time  datetime    null,
    update_time  datetime    null,
    create_by    varchar(32) null,
    update_by    varchar(32) null,
    project_id   bigint      null comment '项目id',
    module_id    bigint      null comment '模块id',
    task_id      bigint      null comment '任务id',
    developer_id bigint      null comment '开发者id',
    start_date   date        null comment '开始日期',
    end_date     date        null comment '结束日期',
    state        char(1)        null comment '1 未开始 2 进行中 3 已完成 4 已测试'
)
    comment '任务-开发者表';



