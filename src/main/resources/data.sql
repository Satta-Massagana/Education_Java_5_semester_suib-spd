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
(1, '2025-11-29 10:01:23', 'OTP', true),
(2, '2025-11-29 10:02:15', 'PASSWORD', false),
(3, '2025-11-29 10:03:47', 'KERBEROS', true),
(1, '2025-11-29 10:05:12', 'PASSWORD', true),
(2, '2025-11-29 10:06:34', 'LDAP', false),
(4, '2025-11-29 10:07:56', 'LDAP', false),
(1, '2025-11-29 10:09:18', 'PASSWORD', true),
(3, '2025-11-29 10:10:40', 'KERBEROS', false),
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

INSERT INTO incident (timestamp, incident_type, description, severity, status) VALUES
('2025-12-06 10:05:00', 'DDoS', 'Распределенная атака на веб-сервер', 'CRITICAL', 'IN_PROGRESS'),
('2025-12-06 09:30:00', 'BRUTE_FORCE', 'Подбор пароля SSH на сервере 10.0.0.50', 'HIGH', 'RESOLVED'),
('2025-12-06 11:15:00', 'MALWARE', 'Обнаружен троян в сети', 'HIGH', 'IN_PROGRESS'),
('2025-12-06 08:45:00', 'DATA_LEAK', 'Подозрение на утечку данных', 'CRITICAL', 'INVESTIGATION'),
('2025-12-06 14:20:00', 'PHISHING', 'Фишинговое письмо сотруднику', 'MEDIUM', 'RESOLVED');

INSERT INTO notification (notify_timestamp, notify_type, recipient_id, incident_id) VALUES
-- Инцидент DDoS (ID=1)
('2025-12-06 10:05:30', 'EMAIL', 1, 1),     -- Иванов (Главный админ)
('2025-12-06 10:06:00', 'SMS', 2, 1),       -- Петров (Сетевой админ)
-- Инцидент BRUTE_FORCE (ID=2)
('2025-12-06 09:30:15', 'SMS', 1, 2),        -- Иванов (Главный админ)
('2025-12-06 09:31:00', 'EMAIL', 7, 2),      -- Новиков (Руководитель ИБ)
-- Инцидент MALWARE (ID=3)
('2025-12-06 11:15:30', 'PUSH', 6, 3),       -- Васильев (IDS админ)
('2025-12-06 11:16:00', 'EMAIL', 3, 3),      -- Сидорова (Инженер КИБ)
-- Инцидент DATA_LEAK (ID=4)
('2025-12-06 08:45:30', 'EMAIL', 10, 4),     -- Лебедев (Архитектор)
('2025-12-06 08:46:00', 'SMS', 9, 4),        -- Федорова (Compliance)
-- Инцидент PHISHING (ID=5)
('2025-12-06 14:20:30', 'EMAIL', 5, 5);      -- Смирнова (Аудитор)

INSERT INTO security_admin (name, contact_info, role) VALUES
('Иванов Иван Иванович', '+7 (495) 123-45-67, ivanov@suib.ru', 'Главный администратор СЗИ'),
('Петров Петр Петрович', '+7 (495) 234-56-78, petrov@suib.ru', 'Администратор сетевой безопасности'),
('Сидорова Анна Сергеевна', '+7 (495) 345-67-89, sidorova@suib.ru', 'Инженер по кибербезопасности'),
('Козлов Дмитрий Александрович', '+7 (495) 456-78-90, kozlov@suib.ru', 'Специалист по мониторингу'),
('Смирнова Елена Владимировна', '+7 (495) 567-89-01, smirnova@suib.ru', 'Аудитор информационной безопасности'),
('Васильев Алексей Михайлович', '+7 (495) 678-90-12, vasiliev@suib.ru', 'Администратор IDS'),
('Морозова Ольга Николаевна', '+7 (495) 789-01-23, morozova@suib.ru', 'Аналитик угроз безопасности'),
('Новиков Сергей Юрьевич', '+7 (495) 890-12-34, novikov@suib.ru', 'Руководитель отдела ИБ'),
('Федорова Мария Андреевна', '+7 (495) 901-23-45, fedorova@suib.ru', 'Специалист по compliance'),
('Лебедев Михаил Геннадьевич', '+7 (495) 012-34-56, lebedev@suib.ru', 'Архитектор безопасности');
