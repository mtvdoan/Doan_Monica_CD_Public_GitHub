from flask_app.config.mysqlconnection import connectToMySQL
from flask import flash
import re
EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')
#-------FIRST NEED SET UP CLASS AND DICTIONARY AND db-------------------------------------------------------
class Cookie:
    db = "cookies_schema"
    
    def __init__(self,data):
        self.id = data['id']
        self.customer_name = data['customer_name']
        self.cookie_type = data['cookie_type']
        self.number_of_boxes = data['number_of_boxes']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']
        
    #    GET ALL-------------SHOWS ALL ON PAGE---------------------------------------------------
    @classmethod
    def get_all(cls):
        query = "SELECT * FROM cookies"
        cookies_from_db = connectToMySQL(cls.db).query_db(query)
        cookies = []
        for cookie in cookies_from_db:
            cookies.append(cls(cookie))
        return cookies
    
    #   SAVE ----------------------------------------------------------------------
    @classmethod
    def save(cls,data):
        query = """
        INSERT INTO cookies (customer_name,cookie_type,number_of_boxes,created_at,updated_at) VALUES(%(customer_name)s,%(cookie_type)s,%(number_of_boxes)s,NOW(),NOW());
        """
        return connectToMySQL(cls.db).query_db(query,data)
    #------SHOW ONE TO EDIT----------------------------------------------------------
    @classmethod
    def show_one(cls, data):
        query = "SELECT * FROM cookies WHERE id = %(id)s;"
        cookie_id_result = connectToMySQL(cls.db).query_db(query, data)
        return cls(cookie_id_result[0])

        # return cookie_id


    @classmethod
    def modify(cls, data):
        query = "UPDATE cookies SET customer_name = %(customer_name)s, cookie_type = %(cookie_type)s, number_of_boxes = %(number_of_boxes)s WHERE id = %(id)s;"

        result_from_edit = connectToMySQL(cls.db).query_db(query, data)
        return result_from_edit
    
    @classmethod
    def seek_and_destroy(cls, data):
        query = "DELETE FROM cookies WHERE id = %(id)s;"
        result = connectToMySQL(cls.db).query_db(query, data)
        return result

# ------------------------------------------------------------------------------------------------
    #below is  FLASH stuff

    @staticmethod
    def validate_cookie(cookie):
        is_valid = True # we assume this is trueß
        if len(cookie['customer_name']) < 3:
            flash("Customer name must be at least 2 characters!")
            is_valid = False
        if len(cookie['cookie_type']) < 3:
            flash("Cookie type must be at least 2 characters!")
            is_valid = False
        if not cookie['number_of_boxes'] or int(cookie['number_of_boxes']) < 0:
            flash("Number of boxes must be positive!")
            is_valid = False
            
            print("not enough cookies")
            
        return is_valid