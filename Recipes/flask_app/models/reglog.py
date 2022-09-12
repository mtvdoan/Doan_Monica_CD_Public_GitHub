    #MODEL PYTHON FILE-----------------------------------------------------------------------------SHOULD BE SINGULAR.
from flask_app import app
from flask_app.config.mysqlconnection import connectToMySQL
from flask import flash
from flask_bcrypt import Bcrypt
from flask_app.models import recipe
import re 
bcrypt = Bcrypt(app)
EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')
db = "reglog-User_to_Recipes"

class Reglog:
    
    def __init__(self,reglog):
        
        self.id = reglog['id']
        self.first_name = reglog['first_name']
        self.last_name = reglog['last_name']
        self.email = reglog['email']
        self.password = reglog['password']
        self.created_at = reglog['created_at']
        self.updated_at = reglog['updated_at']
        
    @classmethod
    def get_by_email(cls,email):
        
        data = {
            "email":email
        }
        query = "SELECT * FROM reglogs WHERE email = %(email)s;"
        reglog_email_result = connectToMySQL(db).query_db(query, data)
        if len(reglog_email_result) < 1:
            print("get_by_email route: return False")
            return False
        return cls(reglog_email_result[0])
    @classmethod
    def get_all(cls):
        query = "SELECT * FROM reglogs"
        reglogs_from_db = connectToMySQL(db).query_db(query)
        reglogs = []
        for row in reglogs_from_db:
            reglogs.append(cls(row))
        return reglogs
    
    @classmethod
    def get_by_id(cls, reglog_id):
        
        data={"id": reglog_id}

        query = "SELECT * FROM reglogs WHERE id = %(id)s;"
        reglog_id_result = connectToMySQL(db).query_db(query, data)
        if len(reglog_id_result) < 1:
            return False
        return cls(reglog_id_result[0])  

    @classmethod
    def is_valid(cls,reglog):
        is_valid = True
        SpecialSym =['$', '@', '#', '%', '!']
        if not EMAIL_REGEX.match(reglog['email']):
            is_valid = False
            flash("Invalid email address!", "register")
        if not reglog['first_name'] or len(reglog['first_name']) < 3:
            is_valid = False
            flash("First name must be at least 2 characters!", "register")
        if not reglog['last_name'] or len(reglog['last_name']) < 3:
            is_valid = False
            flash("Last name must be at least 2 characters!", "register")
        if not reglog['password'] or len(reglog['password']) < 3:
            is_valid = False
            flash("Password must be at least 3 characters!", "register")
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
            flash("Password should have at least one of the symbols $@#!", "register")
            is_valid = False     
        if reglog['password'] != reglog['confirmpassword']:
            flash("The password does not match!", "register")
            is_valid = False
            
        email_already_has_account = Reglog.get_by_email(reglog["email"])
        if email_already_has_account:
            flash("An account with that email already exists, please log in.", "register")
            is_valid = False
            
        return is_valid

    @classmethod
    def verified_reglog(cls, reglog_input):
        is_valid = True
        existing_reglog = cls.get_by_email(reglog_input["email"])
        verified_password = True
        
        if not existing_reglog:
            is_valid = False
        else:
            print()
            print("verified reglog route", existing_reglog)
            verified_password = bcrypt.check_password_hash(existing_reglog.password, reglog_input["password"])
            if not verified_password:
                is_valid = False
        if not is_valid:
            flash("Email/Password do not match our records!")  #maybe add filter category here...
            return False
        return existing_reglog

#This route will create a user that meets requirements and puts information into db. first it will validate and if it's not it returns FALSE. password will also be hashed....
    @classmethod
    def insert_verified_reglog(cls, reglog):
        if not cls.is_valid(reglog):
            return False
        password_hash = bcrypt.generate_password_hash(reglog['password'])
        reglog = reglog.copy()
        reglog["password"] = password_hash
        print("Reglog after adding pw: ", reglog)
                
        query = """INSERT into reglogs (first_name, last_name, email, password)
                    VALUES (%(first_name)s, %(last_name)s, %(email)s, %(password)s);"""
        new_reglog_id = connectToMySQL(db).query_db(query, reglog)
        new_reglog = cls.get_by_id(new_reglog_id)
        
        print("inserted reglog:")
        print("query:" , query)
        
        return new_reglog
        

#SAVE FUNCTION -------------THIS LETS US SAVE THE INFO TO THE DATABASE (SQL) WHEN WE REGISTER A NEW USER-----------------------
    # @classmethod
    # def save(cls,data):
    #     query = """INSERT INTO reglogs (first_name, last_name, email, password) 
    #                 VALUES (%(first_name)s, %(last_name)s, %(email)s, %(password)s);"""
                    
    #     print("save: ", data)
    #     print("query: ", query)
        
    #     return connectToMySQL(db).query_db(query, data)


#--GET INFORMATION OF A USER BY EMAIL-----------IF NO EMAIL MATCHES THE ONES ALREADY IN DATABASE, RETURNS FALSE-------------------------------
    
