INSERT INTO users (username, password_hash, email, account_status, last_login) VALUES
('admin', '$2a$10$hashedpass', 'admin@suib.ru', 'ACTIVE', '2025-11-29 10:00:00'),
('user1', '$2a$10$hashedpass', 'user1@suib.ru', 'ACTIVE', '2025-11-29 09:45:23'),
('user2', '$2a$10$hashedpass', 'user2@suib.ru', 'ACTIVE', '2025-11-29 08:30:15'),
('guest', '$2a$10$hashedpass', 'guest@suib.ru', 'INACTIVE', NULL),
('hacker', '$2a$10$hashedpass', 'hacker@darknet.ru', 'BLOCKED', NULL);

INSERT INTO role (role_name, description) VALUES
('ADMIN', 'Полные права администратора системы'),
('USER', 'Обычный пользователь SUIB SPD'),
('GUEST', 'Гость с ограниченными правами'),
('AUDITOR', 'Только просмотр логов и отчетов'),
('SECURITY', 'Специалист по СЗИ и сетевой безопасности');

INSERT INTO user_role (user_id, role_id) VALUES
(1, 1),  -- admin → ADMIN
(1, 4),  -- admin → AUDITOR
(2, 2),  -- user1 → USER
(3, 2),  -- user2 → USER
(3, 5),  -- user2 → SECURITY
(4, 3),  -- guest → GUEST
(5, 3);  -- hacker → GUEST

INSERT INTO authentication_record (user_id, auth_timestamp, auth_method, success_flag) VALUES
(1, '2025-11-29 10:00:00', 'PASSWORD', true),
(1, '2025-11-29 10:01:23', 'PASSWORD', true),
(2, '2025-11-29 10:02:15', 'PASSWORD', false),
(3, '2025-11-29 10:03:47', 'PASSWORD', true),
(1, '2025-11-29 10:05:12', 'PASSWORD', true),
(2, '2025-11-29 10:06:34', 'PASSWORD', false),
(4, '2025-11-29 10:07:56', 'PASSWORD', false),
(1, '2025-11-29 10:09:18', 'PASSWORD', true),
(3, '2025-11-29 10:10:40', 'PASSWORD', false),
(2, '2025-11-29 10:12:02', 'PASSWORD', true),
(1, '2025-11-29 10:15:30', 'LDAP', true),
(5, '2025-11-29 10:17:45', 'PASSWORD', false),
(2, '2025-11-29 10:20:12', 'KERBEROS', true),
(3, '2025-11-29 10:22:33', 'PASSWORD', true),
(1, '2025-11-29 10:25:01', 'OTP', true),
(4, '2025-11-29 10:27:19', 'PASSWORD', false),
(2, '2025-11-29 10:30:44', 'PASSWORD', true),
(5, '2025-11-29 10:33:22', 'PASSWORD', false),
(1, '2025-11-29 10:35:56', 'LDAP', true),
(3, '2025-11-29 10:38:14', 'KERBEROS', false),
(2, '2025-11-29 10:40:37', 'OTP', true),
(1, '2025-11-29 10:43:09', 'PASSWORD', true),
(4, '2025-11-29 10:45:28', 'PASSWORD', false),
(5, '2025-11-29 10:47:51', 'PASSWORD', false),
(3, '2025-11-29 10:50:13', 'LDAP', true),
(2, '2025-11-29 10:52:36', 'PASSWORD', true),
(1, '2025-11-29 10:55:02', 'KERBEROS', true),
(5, '2025-11-29 10:57:24', 'PASSWORD', false),
(3, '2025-11-29 11:00:41', 'OTP', true),
(2, '2025-11-29 11:03:07', 'PASSWORD', true);