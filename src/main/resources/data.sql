-- categories テーブルにデータを挿入
INSERT INTO categories(id, name) VALUES
(1, '仕事'),
(2, '遊び'),
(3, '勉強');

-- users テーブルにデータを挿入
INSERT INTO users(id, email, name, password) VALUES(1, 'tanaka@aaa.com', '田中太郎', 'test123'),
(2, 'suzuki@aaa.com', '鈴木一郎', 'test456');

-- blogs テーブルにデータを挿入
INSERT INTO blogs(id, category_id, user_id, title, body) VALUES
(1, 1, 1, '見積もり', '見積もり金額を明日までに提出');