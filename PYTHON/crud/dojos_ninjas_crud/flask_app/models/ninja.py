from flask_app.config.mysqlconnection import connectToMySQL

class Ninja:
    
    db = "dojos_ninjas_schema"
    
    def __init__(self, data):
        self.first_name = data['first_name']
        self.last_name = data['last_name']
        self.age = data['age']
        self.id = data ['id']

    @classmethod
    def save(cls,data):
        query = "INSERT INTO ninjas (first_name, last_name, age, dojos_id) VALUES (%(first_name)s, %(last_name)s, %(age)s, %(dojos_id)s);"
        print()
        print(query)
        print(data)
        print()
        return connectToMySQL('dojos_ninjas_schema').query_db(query,data)