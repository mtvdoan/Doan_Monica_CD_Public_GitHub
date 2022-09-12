from flask import render_template, redirect, session, request, flash
from flask_bcrypt import Bcrypt
from flask_app import app
from flask_app.models.reglog import Reglog
bcrypt = Bcrypt(app)
# example password


# print(bcrypt.generate_password_hash("monica"))
# print(bcrypt.generate_password_hash("alex"))
print(bcrypt.generate_password_hash("adeline"))
# print(bcrypt.generate_password_hash("isaac"))
# print(bcrypt.generate_password_hash("icothecorgi"))


# printed results:
# monica: $2b$12$YzNsqnFHcSQsRX6LV8oQBOF0BEyoTPWwiJp2Fi5k63fF8ovJnmSrK
# alex: $2b$12$93aJ0ZHog/pyEwgM1034gOB2wYUp8Okf8Nu5mOCwrD6MKp7sLuoCS
# adeline: $2b$12$T7s3jF9SiHmad3CMg5Ei1.F7YOZZedgb6H5GtnSV2ljhZ6slBWrMW
# isaac: $2b$12$w5Gy47j/wN2s7UiKKVrRv.HYqwLmkJcoda69qTWW..ZJC.rAAtBF6
# icothecorgi: $2b$12$0ZX4pXXqjcJIe0VXG1bX/uyflNsQ3g4eXCfyd.IXS2Ajq2SEiau2q


# updated my SQL
UPDATE reglogs SET password = "$2b$12$YzNsqnFHcSQsRX6LV8oQBOF0BEyoTPWwiJp2Fi5k63fF8ovJnmSrK" WHERE id = 1;
UPDATE reglogs SET password = "$2b$12$93aJ0ZHog/pyEwgM1034gOB2wYUp8Okf8Nu5mOCwrD6MKp7sLuoCS" WHERE id = 2;
UPDATE reglogs SET password = "$2b$12$T7s3jF9SiHmad3CMg5Ei1.F7YOZZedgb6H5GtnSV2ljhZ6slBWrMW" WHERE id = 3;
UPDATE reglogs SET password = "$2b$12$w5Gy47j/wN2s7UiKKVrRv.HYqwLmkJcoda69qTWW..ZJC.rAAtBF6" WHERE id = 4;
UPDATE reglogs SET password = "$2b$12$0ZX4pXXqjcJIe0VXG1bX/uyflNsQ3g4eXCfyd.IXS2Ajq2SEiau2q" WHERE id = 5;



INSERT INTO reglogs(first_name, last_name, email, password, created_at, updated_at) VALUES("Monica", "Doan", "monica@email.com", "monica", NOW(), NOW());

INSERT INTO reglogs(first_name, last_name, email, password, created_at, updated_at) VALUES("Alex", "Ames", "alex@email.com", "alex", NOW(), NOW());

INSERT INTO reglogs(first_name, last_name, email, password, created_at, updated_at) VALUES("Adeline", "Ames", "adeline@email.com", "adeline", NOW(), NOW());

INSERT INTO reglogs(first_name, last_name, email, password, created_at, updated_at) VALUES("Isaac", "Ames", "isaac@email.com", "isaac", NOW(), NOW());

INSERT INTO reglogs(first_name, last_name, email, password, created_at, updated_at) VALUES("Ico-The-Corgi", "Doan", "icothecorgi@email.com", "icothecorgi", NOW(), NOW());



INSERT INTO recipes(recipe_name, recipe_description, recipe_instructions, recipe_date_made, recipe_under_30, created_at, updated_at, reglog_id) 
VALUES(Tamagoyaki, Sweet egg omlete roll, 1987-01-08 24:00:00, 1);

INSERT INTO recipes(recipe_name, recipe_description, recipe_instructions, recipe_date_made, recipe_under_30, created_at, updated_at, reglog_id) 
VALUES(Tamagoyaki, Sweet egg omlete roll, 1987-01-08 24:00:00, 1);



INSERT INTO recipes(recipe_name, recipe_description, recipe_under_30, created_at, updated_at, reglog_id)
	VALUES
		("Tamagoyaki", "Japanese sweet rolled omelette", 1, NOW(), NOW(), 1),
		("Garbage Fried Rice", "Take that leftovers", 1, NOW(), NOW(), 2),
		("Onigiri", "A simple snack on the go", 1, NOW(), NOW(), 3),
		("Animal Crackers", "A child's favorite snack", 1, NOW(), NOW(), 4),
		("Taste of the Wild", "Kibble for senior corgis", 1, NOW(), NOW(), 5);
INSERT INTO recipes(recipe_instructions) 
	VALUES
		("Fry egg mixture of (1 egg, 1 teaspoon sugar, 1 teaspoon soy sauce) in a makiyakinabe frying pan. Roll egg. Enjoy"),
        ("Take all leftovers like fries, leftover shrimp, leftover steak, 3 cups of last night's cooked white rice out of fridge. Fry in pan with sesame oil. Crack 2 eggs and stir fry. Eat" ),
        ("Mix cooked short grain sushi rice with sugar and sushi rice vinegar to taste. Mix well and mold it to a triangle. Add furikake seasoning. Yum"),
        ("Go to store. Buy animal cracker box. Open package. Enjoy"),
        ("Buy bag of Taste of the Wild Dog Food from SmartPets Store. Open bag. Place 3/4 cup of kibble in bowl. Om nom nom nom...");
