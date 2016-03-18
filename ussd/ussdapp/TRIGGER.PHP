CREATE TRIGGER TIME AFTER INSERT on student FOR EACH ROW
INSERT INTO last_time values(DEFAULT);
   
   DELIMITER @@
   CREATE TRIGGER FIRST after insert on student
   for EACH ROW
   
   BEGIN
   Decrare id int;
   Decrare name varchar(23);
   select name from inserted;
   select id  from inserted;
   insert into report values('id','name');
   
   END;