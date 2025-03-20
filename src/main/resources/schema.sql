-- 各種テーブル削除
DROP TABLE IF EXISTS categories;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS blogs;

-- categories（カテゴリー）
CREATE TABLE categories(
   id SERIAL PRIMARY KEY,
   name VARCHAR(20)
);
-- users（ユーザー）
CREATE TABLE users(
   id SERIAL PRIMARY KEY,
   email VARCHAR(255),
   name VARCHAR(20),
   password VARCHAR(50)
);
-- blogs（記事）
CREATE TABLE blogs(
   id SERIAL PRIMARY KEY,
   category_id INTEGER,
   user_id INTEGER,
   title VARCHAR(255),
   body TEXT
);