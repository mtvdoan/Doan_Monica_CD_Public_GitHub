SELECT * FROM reglogs;
INSERT INTO reglogs(first_name, last_name, email, password, created_at, updated_at) VALUES("Monica", "Doan", "monica@gmail.com", "monica", NOW(), NOW());
INSERT INTO reglogs(first_name, last_name, email, password, created_at, updated_at) VALUES("Alex", "Ames", "alex@gmail.com", "alex", NOW(), NOW());
INSERT INTO reglogs(first_name, last_name, email, password, created_at, updated_at) VALUES("Adeline", "Ames", "adeline@gmail.com", "adeline", NOW(), NOW());
INSERT INTO reglogs(first_name, last_name, email, password, created_at, updated_at) VALUES("Isaac", "Ames", "isaac@gmail.com", "isaac", NOW(), NOW());
INSERT INTO reglogs(first_name, last_name, email, password, created_at, updated_at) VALUES("Ico", "Doan", "icothecorgi@gmail.com", "icothecorgi", NOW(), NOW());

UPDATE reglogs SET password = "$2b$12$YzNsqnFHcSQsRX6LV8oQBOF0BEyoTPWwiJp2Fi5k63fF8ovJnmSrK" WHERE id = 1;


UPDATE reglogs SET password = "$2b$12$YzNsqnFHcSQsRX6LV8oQBOF0BEyoTPWwiJp2Fi5k63fF8ovJnmSrK" WHERE id = 2;
UPDATE reglogs SET password = "$2b$12$93aJ0ZHog/pyEwgM1034gOB2wYUp8Okf8Nu5mOCwrD6MKp7sLuoCS" WHERE id = 3;
UPDATE reglogs SET password = "$2b$12$w5Gy47j/wN2s7UiKKVrRv.HYqwLmkJcoda69qTWW..ZJC.rAAtBF6" WHERE id = 4;
UPDATE reglogs SET password = "$2b$12$0ZX4pXXqjcJIe0VXG1bX/uyflNsQ3g4eXCfyd.IXS2Ajq2SEiau2q" WHERE id = 5;
