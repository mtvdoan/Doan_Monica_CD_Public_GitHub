#MODEL PYTHON FILE-----------------------------------------------------------------------------SHOULD BE SINGULAR.

from flask_app.config.mysqlconnection import connectToMySQL
from flask import flash
import re  #flash model info----------------------------------------------------------------
EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')

#OOP DICTIONARY THAT SHOWS INFORMATION USED FROM APP AND DATABASE

class Reglog:
#'db' = is the name of the schema file on the SQL.  ----------------------------------------------------------------
    db = "registration_login_schema"
    def __init__(self,data):
        self.id = data['id']
        self.first_name = data['first_name']
        self.last_name = data['last_name']
        self.email = data['email']
        self.password = data['password']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']
        
#VALIDATE REGISTERATION----------------------------------------------------------------
    @staticmethod
    def validate_register(reglog):
        SpecialSym =['$', '@', '#', '%']
        is_valid = True # we assume this is true
        query = "SELECT * FROM users WHERE email = %(email)s;"
        results = connectToMySQL(Reglog.db).query_db(query,reglog)
        if not reglog['first_name'] or len(reglog['first_name']) < 3:
            flash("First name must be at least 2 characters!", "register")
            is_valid = False
        if not reglog['last_name'] or len(reglog['last_name']) < 3:
            flash("Last name must be at least 2 characters!", "register")
            is_valid = False
        if  not EMAIL_REGEX.match(reglog['email']):
            flash("Invalid email address!", "register")
            is_valid = False
        if not reglog['password'] or len(reglog['password']) < 7:
            flash("Password must be at least 7 characters!", "register")
            is_valid = False
        if not any(char.isdigit() for char in reglog["password"]):
            flash("Password should have at least one numeral", "register")
            is_valid = False
        if not any(char.isupper() for char in reglog["password"]):
            flash("Password should have at least one uppercase letter", "register")
            is_valid = False
        if not any(char.islower() for char in reglog["password"]):
            flash("Password should have at least one lowercase letter", "register")
            is_valid = False
        if not any(char in SpecialSym for char in reglog["password"]):
            flash("Password should have at least one of the symbols $@#", "register")
            is_valid = False     
        if reglog['password'] != reglog['confirmpassword']:
            flash("The password does not match!", "register")
            is_valid = False
        return is_valid
    
#SAVE FUNCTION -------------THIS LETS US SAVE THE INFO TO THE DATABASE (SQL) WHEN WE REGISTER A NEW USER-----------------------
    @classmethod
    def save(cls,data):
        query = "INSERT INTO reglogs (first_name, last_name, email, password) VALUES (%(first_name)s, %(last_name)s, %(email)s, %(password)s);"
        return connectToMySQL(cls.db).query_db(query, data)

#GET ALL OR SHOW ALL / ADD THE NEW INFORMATION SUBMITTED TO DATABASE ON LAST ROW OF TABLE----------------------------------------------------------------
    @classmethod
    def get_all(cls):
        query = "SELECT * FROM reglogs"
        reglogs_from_db = connectToMySQL(cls.db).query_db(query)
        reglogs = []
        for row in reglogs_from_db:
            reglogs.append(cls(row))
        return reglogs
    
#GET INFORMATION BY id--------------------------------------------------------------------------------------------------------------------------------
    @classmethod
    def get_by_id(cls, data):
        query = "SELECT * FROM reglogs WHERE id = %(id)s;"
        reglog_id_result = connectToMySQL(cls.db).query_db(query, data)
        return cls(reglog_id_result[0])  

#--GET INFORMATION OF A USER BY EMAIL-----------IF NO EMAIL MATCHES THE ONES ALREADY IN DATABASE, RETURNS FALSE-------------------------------
    @classmethod
    def get_by_email(cls,data):
        #remember all queries for sql needs to ehdn with a semicolon ---
        query = "SELECT * FROM reglogs WHERE email = %(email)s;"
        reglog_email_result = connectToMySQL(cls.db).query_db(query,data)
        if len(reglog_email_result) < 1:
            return False
        print("test get by email")
        print(data)
        return cls(reglog_email_result[0])
    
