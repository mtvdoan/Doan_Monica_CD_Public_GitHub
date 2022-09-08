from flask import render_template, redirect, session, request, flash
from flask_bcrypt import Bcrypt
from flask_app import app
from flask_app.models.reglog import Reglog
bcrypt = Bcrypt(app)
# example password


# print(bcrypt.generate_password_hash("monica"))
# print(bcrypt.generate_password_hash("alex"))
# print(bcrypt.generate_password_hash("adeline"))
# print(bcrypt.generate_password_hash("isaac"))
# print(bcrypt.generate_password_hash("icothecorgi"))


# printed results:
# monica: $2b$12$YzNsqnFHcSQsRX6LV8oQBOF0BEyoTPWwiJp2Fi5k63fF8ovJnmSrK
# alex: $2b$12$93aJ0ZHog/pyEwgM1034gOB2wYUp8Okf8Nu5mOCwrD6MKp7sLuoCS
# adeline: $2b$12$rlUDiUdEFPdeK7Gnugi9MeiLDETG6R/TPrkQe.5i8E7IuJWw8aUgO
# isaac: $2b$12$w5Gy47j/wN2s7UiKKVrRv.HYqwLmkJcoda69qTWW..ZJC.rAAtBF6
# icothecorgi: $2b$12$0ZX4pXXqjcJIe0VXG1bX/uyflNsQ3g4eXCfyd.IXS2Ajq2SEiau2q


# updated my SQL
# UPDATE reglogs SET password = "$2b$12$YzNsqnFHcSQsRX6LV8oQBOF0BEyoTPWwiJp2Fi5k63fF8ovJnmSrK" WHERE id = 2;
# UPDATE reglogs SET password = "$2b$12$YzNsqnFHcSQsRX6LV8oQBOF0BEyoTPWwiJp2Fi5k63fF8ovJnmSrK" WHERE id = 2;
# UPDATE reglogs SET password = "$2b$12$93aJ0ZHog/pyEwgM1034gOB2wYUp8Okf8Nu5mOCwrD6MKp7sLuoCS" WHERE id = 3;
# UPDATE reglogs SET password = "$2b$12$w5Gy47j/wN2s7UiKKVrRv.HYqwLmkJcoda69qTWW..ZJC.rAAtBF6" WHERE id = 4;
# UPDATE reglogs SET password = "$2b$12$0ZX4pXXqjcJIe0VXG1bX/uyflNsQ3g4eXCfyd.IXS2Ajq2SEiau2q" WHERE id = 5;







