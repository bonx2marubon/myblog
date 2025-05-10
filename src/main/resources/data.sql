-- categories テーブルにデータを挿入
INSERT INTO categories(name) VALUES
('仕事'),
('遊び'),
('勉強');

-- users テーブルにデータを挿入
INSERT INTO users(email, name, password) VALUES('tanaka@aaa.com', '田中太郎', 'test123'),
('suzuki@aaa.com', '鈴木一郎', 'test456'),
('tanisaki@aaa.com', 'たにやん', 'taniyan');

-- blogs テーブルにデータを挿入
INSERT INTO blogs(category_id, user_id, title, body) VALUES
(1, 1, '見積もり', '見積もり金額を明日までに提出'),
(2, 1, 'ゲームの作り方', 'ゲームを作るにはいっぱいコードを覚えないといけない！'),
(3, 1, 'コーヒー豆の煎り方', 'コーヒーは別に得意じゃないけど、かっこよく豆を煎りたい');