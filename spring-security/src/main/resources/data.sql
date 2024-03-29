insert into uaa_users(id, username, `name`, mobile, password_hash, enabled, account_non_expired, account_non_locked,
                       credentials_non_expired, email)
values (1, 'user', 'Zhang San', '13000000001', '{bcrypt}$2a$10$jhS817qUHgOR4uQSoEBRxO58.rZ1dBCmCTjG8PeuQAX4eISf.zowm',
        1, 1, 1, 1, 'zhangsan@local.dev'),
       (2, 'old_user', 'Li Si', '13000000002', '{SHA-1}7ce0359f12857f2a90c7de465f40a95f01cb5da9', 1, 1, 1, 1,
        'lisi@local.dev');
insert into uaa_roles(id, role_name)
values (1, 'ROLE_USER'),
       (2, 'ROLE_ADMIN');
insert into uaa_users_roles(user_id, role_id)
values (1, 1),
       (1, 2),
       (2, 1);