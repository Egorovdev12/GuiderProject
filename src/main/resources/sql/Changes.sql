--userCredentials
INSERT INTO user_credentials (email, password) VALUES ('qwe123@mail.ru', '1234');
INSERT INTO user_credentials (email, password) VALUES ('belka@mail.ru', '123');
INSERT INTO user_credentials (email, password) VALUES ('slon@mail.ru', 'qwe');
INSERT INTO user_credentials (email, password) VALUES ('pirate@mail.ru', '2233');


--users
INSERT INTO users (user_publications, user_rating, username, user_credentials_id) VALUES (0, 0,  'Grom', 1);
INSERT INTO users (user_publications, user_rating, username, user_credentials_id) VALUES (12, 783, 'UsefulGuider', 2);
INSERT INTO users (user_publications, user_rating, username, user_credentials_id) VALUES (7, 332.1, 'KunaevBikes', 3);
INSERT INTO users (user_publications, user_rating, username,user_credentials_id) VALUES (52, 1299.2, 'Alex322', 4);

--user_personal_info
INSERT INTO user_personal_info (age, bio, city, name, user_user_credentials_id) VALUES (14, 'I am a Boy', 'Moscow', 'Sergey Malkov', 1);
INSERT INTO user_personal_info (age, bio, city, name, user_user_credentials_id) VALUES (26, ':)', 'Saint-P', 'Gleb Vasnetsov', 2);
INSERT INTO user_personal_info (age, bio, city, name, user_user_credentials_id) VALUES (33, 'This is my blog about MTB', 'Moscow', 'Ivan Kunaev', 3);
INSERT INTO user_personal_info (age, bio, city, name, user_user_credentials_id) VALUES (37, 'New Russian Pirate', 'Pskov', 'Alexander Pistoletov', 4);