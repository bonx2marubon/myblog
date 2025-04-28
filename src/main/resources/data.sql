-- categories テーブルにデータを挿入
INSERT INTO categories(id, name) VALUES
(1, '仕事'),
(2, '遊び'),
(3, '勉強');

-- users テーブルにデータを挿入
INSERT INTO users(id, email, name, password) VALUES(1, 'tanaka@aaa.com', '田中太郎', 'test123'),
(2, 'suzuki@aaa.com', '鈴木一郎', 'test456'),
(3, 'tanisaki@aaa.com', 'たにやん', 'taniyan');

-- blogs テーブルにデータを挿入
INSERT INTO blogs(id, category_id, user_id, title, body) VALUES
(1, 1, 1, '見積もり', '見積もり金額を明日までに提出'),
(2, 2, 1, 'ゲームの作り方', 'ゲームを作るにはいっぱいコードを覚えないといけない！'),
(3, 3, 1, 'コーヒー豆の煎り方', 'コーヒーは別に得意じゃないけど、かっこよく豆を煎りたい');