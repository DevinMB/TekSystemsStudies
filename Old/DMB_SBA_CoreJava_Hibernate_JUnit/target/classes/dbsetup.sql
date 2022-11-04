-- dbinserts 11.2.22

-- Creates
CREATE TABLE IF NOT EXISTS `Java_SBA`.`Student` (
  `email` VARCHAR(50) NOT NULL,
  `name` VARCHAR(50) NOT NULL,
  `password` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`email`),
  UNIQUE INDEX `idemail_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- students
insert into Student (email, name, password) values ('devinmbutts@gmail.com', 'Devin Butts', 'test');
insert into Student (email, name, password) values ('hluckham0@google.ru', 'Hazel Luckham', 'X1uZcoIh0dj');
insert into Student (email, name, password) values ('sbowden1@yellowbook.com', 'Sonnnie Bowden', 'SJc4aWSU');
insert into Student (email, name, password) values ('qllorens2@howstuffworks.com', 'Quillan Llorens', 'W6rJuxd');
insert into Student (email, name, password) values ('cstartin3@flickr.com', 'Clem Startin', 'XYHzJ1S');
insert into Student (email, name, password) values ('tattwool4@biglobe.ne.jp', 'Thornie Attwool', 'Hjt0SoVmuBz');
insert into Student (email, name, password) values ('hguerre5@deviantart.com', 'Harcourt Guerre', 'OzcxzD1PGs');
insert into Student (email, name, password) values ('htaffley6@columbia.edu', 'Holmes Taffley', 'xowtOQ');
insert into Student (email, name, password) values ('aiannitti7@is.gd', 'Alexandra Iannitti', 'TWP4hf5j');
insert into Student (email, name, password) values ('ljiroudek8@sitemeter.com', 'Laryssa Jiroudek', 'bXRoLUP');
insert into Student (email, name, password) values ('cjaulme9@bing.com', 'Cahra Jaulme', 'FnVklVgC6r6');



CREATE TABLE IF NOT EXISTS `Java_SBA`.`Course` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `instructor` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idCourse_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- courses
insert into Course (id, name, instructor) values (1, 'English', 'Anderea Scamaden');
insert into Course (id, name, instructor) values (2, 'Mathematics', 'Eustace Niemetz');
insert into Course (id, name, instructor) values (3, 'Anatomy', 'Reynolds Pastor');
insert into Course (id, name, instructor) values (4, 'Organic Chemistry', 'Odessa Belcher');
insert into Course (id, name, instructor) values (5, 'Physics', 'Dani Swallow');
insert into Course (id, name, instructor) values (6, 'Digital Logic', 'Glenden Reilingen');
insert into Course (id, name, instructor) values (7, 'Object Oriented Programming', 'Giselle Ardy');
insert into Course (id, name, instructor) values (8, 'Data Structures', 'Carolan Stoller');
insert into Course (id, name, instructor) values (9, 'Politics', 'Carmita De Maine');
insert into Course (id, name, instructor) values (10, 'Art', 'Kingsly Doxsey');


CREATE TABLE IF NOT EXISTS `Java_SBA`.`Student_Course` (
  `student_email` VARCHAR(50) NOT NULL,
  `course_id` INT NOT NULL,
  INDEX `FK_Student_Email_idx` (`course_id` ASC) VISIBLE,
  INDEX `FK_Student_Email` (`student_email` ASC) VISIBLE,
  CONSTRAINT `FK_Course_Id`
    FOREIGN KEY (`course_id`)
    REFERENCES `Java_SBA`.`Course` (`id`),
  CONSTRAINT `FK_Student_Email`
    FOREIGN KEY (`student_email`)
    REFERENCES `Java_SBA`.`Student` (`email`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- student courses
insert into Student_Course (student_email,course_id) values ('aiannitti7@is.gd',1);
insert into Student_Course (student_email,course_id) values ('cjaulme9@bing.com',1);
insert into Student_Course (student_email,course_id) values ('hguerre5@deviantart.com',1);
insert into Student_Course (student_email,course_id) values ('hluckham0@google.ru',1);
insert into Student_Course (student_email,course_id) values ('ljiroudek8@sitemeter.com',1);
insert into Student_Course (student_email,course_id) values ('qllorens2@howstuffworks.com',1);
insert into Student_Course (student_email,course_id) values ('sbowden1@yellowbook.com',1);
insert into Student_Course (student_email,course_id) values ('tattwool4@biglobe.ne.jp',1);
insert into Student_Course (student_email,course_id) values ('devinmbutts@gmail.com',2);
insert into Student_Course (student_email,course_id) values ('aiannitti7@is.gd',2);
insert into Student_Course (student_email,course_id) values ('cjaulme9@bing.com',2);
insert into Student_Course (student_email,course_id) values ('hguerre5@deviantart.com',2);
insert into Student_Course (student_email,course_id) values ('hluckham0@google.ru',3);
insert into Student_Course (student_email,course_id) values ('ljiroudek8@sitemeter.com',3);
insert into Student_Course (student_email,course_id) values ('qllorens2@howstuffworks.com',3);
insert into Student_Course (student_email,course_id) values ('sbowden1@yellowbook.com',3);
insert into Student_Course (student_email,course_id) values ('tattwool4@biglobe.ne.jp',3);
insert into Student_Course (student_email,course_id) values ('devinmbutts@gmail.com',4);
insert into Student_Course (student_email,course_id) values ('aiannitti7@is.gd',4);
insert into Student_Course (student_email,course_id) values ('cjaulme9@bing.com',4);
insert into Student_Course (student_email,course_id) values ('hguerre5@deviantart.com',4);
insert into Student_Course (student_email,course_id) values ('hluckham0@google.ru',5);
insert into Student_Course (student_email,course_id) values ('ljiroudek8@sitemeter.com',5);
insert into Student_Course (student_email,course_id) values ('qllorens2@howstuffworks.com',5);
insert into Student_Course (student_email,course_id) values ('sbowden1@yellowbook.com',6);
insert into Student_Course (student_email,course_id) values ('tattwool4@biglobe.ne.jp',6);
insert into Student_Course (student_email,course_id) values ('devinmbutts@gmail.com',7);
insert into Student_Course (student_email,course_id) values ('aiannitti7@is.gd',7);
insert into Student_Course (student_email,course_id) values ('cjaulme9@bing.com',7);
insert into Student_Course (student_email,course_id) values ('hguerre5@deviantart.com',7);
insert into Student_Course (student_email,course_id) values ('hluckham0@google.ru',7);
insert into Student_Course (student_email,course_id) values ('ljiroudek8@sitemeter.com',8);
insert into Student_Course (student_email,course_id) values ('qllorens2@howstuffworks.com',8);
insert into Student_Course (student_email,course_id) values ('sbowden1@yellowbook.com',8);
insert into Student_Course (student_email,course_id) values ('tattwool4@biglobe.ne.jp',8);
insert into Student_Course (student_email,course_id) values ('devinmbutts@gmail.com',9);
insert into Student_Course (student_email,course_id) values ('aiannitti7@is.gd',9);
insert into Student_Course (student_email,course_id) values ('cjaulme9@bing.com',9);
insert into Student_Course (student_email,course_id) values ('hguerre5@deviantart.com',9);
insert into Student_Course (student_email,course_id) values ('hluckham0@google.ru',10);
insert into Student_Course (student_email,course_id) values ('ljiroudek8@sitemeter.com',10);
insert into Student_Course (student_email,course_id) values ('qllorens2@howstuffworks.com',10);
insert into Student_Course (student_email,course_id) values ('sbowden1@yellowbook.com',10);
insert into Student_Course (student_email,course_id) values ('tattwool4@biglobe.ne.jp',10); 


-- views
SELECT * FROM Java_SBA.Student;
SELECT * FROM Java_SBA.Course;
SELECT * FROM Java_SBA.Student_Course;

