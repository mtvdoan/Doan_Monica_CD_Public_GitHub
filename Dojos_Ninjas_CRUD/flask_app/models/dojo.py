from flask_app.config.mysqlconnection import connectToMySQL
from .ninja import Ninja

class Dojo:
    db = "dojos_ninjas_schema"

    def __init__(self, data):
        self.id = data['id']
        self.name = data['name']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']
        self.ninjas =[]

    @classmethod
    def get_all(cls):
        query = "SELECT * FROM dojos;"
        
        results = connectToMySQL('dojos_ninjas_schema').query_db(query)
        dojos = []
        
        for dojo in results:
            dojos.append(cls(dojo))
        return dojos

    @classmethod
    def save(cls, data):
        query = "INSERT INTO dojos (name) VALUES(%(name)s);"
        dojo_id = connectToMySQL('dojos_ninjas_schema').query_db(query, data)
        return dojo_id

    @classmethod
    def show_one(cls, data):
        query = "SELECT * FROM dojos LEFT JOIN ninjas on dojos.id = ninjas.dojos_id WHERE dojos.id = %(id)s;"
        
        results = connectToMySQL('dojos_ninjas_schema').query_db(query,data)
        print(results)
        dojo = cls(results[0])
        for row in results:
            n = {
                'id': row['ninjas.id'],
                'first_name': row['first_name'],
                'last_name': row['last_name'],
                'age': row['age'],
                'created_at': row['ninjas.created_at'],
                'updated_at': row['ninjas.updated_at']
            }
            dojo.ninjas.append( Ninja(n) )
        return dojo


    @classmethod
    def modify(cls, data):
        query = "UPDATE dojos SET name = %(name)s, WHERE id = %(id)s;"
        result_from_edit = connectToMySQL(cls.db).query_db(query, data)
        return result_from_edit

    @classmethod
    def seek_and_destroy(cls, data):
        query = "DELETE FROM dojos WHERE id = %(id)s;"
        result = connectToMySQL(cls.db).query_db(query, data)
        return result