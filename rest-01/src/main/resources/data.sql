-- ids start with 10001 to avoid ids collision when testing user creation, 
-- actually this must be fixed in the Java somehow 
insert into user(id, name, birth_date) values(10001, 'Baha Rahov', sysdate());
insert into user(id, name, birth_date) values(10002, 'Maha Shanin', sysdate());
insert into user(id, name, birth_date) values(10003, 'Maga Gamov', sysdate());
insert into post(id, description, user_id) values(20001, 'My First Blog Post', 10001);
insert into post(id, description, user_id) values(20002, 'This is the Second Blog Post', 10002);
