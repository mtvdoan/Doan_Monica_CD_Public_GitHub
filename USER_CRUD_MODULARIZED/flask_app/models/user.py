from flask_app.config.mysqlconnection import connectToMySQL

class User:
    db = "users_cr"

    def __init__(self, data):
        self.id = data['id']
        self.first_name = data['first_name']
        self.last_name = data['last_name']
        self.email = data['email']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']
    @classmethod
    def get_all(cls):
        query = "SELECT * FROM users"
        users_from_db = connectToMySQL(cls.db).query_db(query)
        users = []
        for user in users_from_db:
            users.append(cls(user))
        return users

    @classmethod
    def save(cls, data):
        query = "Insert INTO users (first_name,last_name,email,created_at,updated_at) VALUES(%(first_name)s,%(last_name)s,%(email)s,NOW(),NOW());"
        user_id = connectToMySQL(cls.db).query_db(query, data)
        return user_id

    @classmethod
    def show_one(cls, data):
        query = "SELECT * FROM users WHERE id = %(id)s;"
        user_id_result = connectToMySQL(cls.db).query_db(query, data)
        return cls(user_id_result[0])

    @classmethod
    def modify(cls, data):
        query = "UPDATE users SET first_name = %(first_name)s, last_name = %(last_name)s, email = %(email)s WHERE id = %(id)s;"

        result_from_edit = connectToMySQL(cls.db).query_db(query, data)
        return result_from_edit

    @classmethod
    def seek_and_destroy(cls, data):
        query = "DELETE FROM users WHERE id = %(id)s;"
        result = connectToMySQL(cls.db).query_db(query, data)
        return result
