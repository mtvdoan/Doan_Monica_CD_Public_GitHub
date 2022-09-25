# import the function that will return an instance of a connection
from flask_app.config.mysqlconnection import connectToMySQL
from flask import flash
from flask_app import app
from flask_bcrypt import Bcrypt
from flask_app.models import reglog
import re
db = "reglog-User_to_Recipes"

class Recipe:
    def __init__(self,recipe):
        self.id = recipe['id']
        self.recipe_name = recipe['recipe_name']
        self.recipe_description = recipe['recipe_description']
        self.recipe_instructions = recipe['recipe_instructions']
        self.recipe_data_made = recipe['recipe_date_made']
        self.recipe_under_30 = recipe['recipe_under_30']
        self.created_at = recipe['created_at']
        self.updated_at = recipe['updated_at']
        self.reglog = None
    
    @classmethod #Have NOT finished this
    def create_valid_recipe(cls, recipe_dictionary):
        if not cls.is_valid(recipe_dictionary):
            return False
    
    
    @classmethod
    def get_by_id(cls, recipe_id):
        print(f"get recipe by id {recipe_id}")
        data = {"id": recipe_id}
        
        query = """SELECT recipes.id, recipes.created_at, recipes.updated_at, recipe_instructions, recipe_description, recipe_name, recipe_date_made, recipe_under_30, 
        reglogs.id as reglog_id, first_name, last_name, email, password, reglogs.created_at as rlc, reglogs.updated_at as rlu 
                    FROM recipes 
                    JOIN reglogs on reglogs.id = recipes.reglog_id 
                    WHERE recipes.id = %(id)s;"""
        
        result = connectToMySQL(db).query_db(query,data)
        print("result of query:")
        print(result)
        result = result[0]
        recipe = cls(result)
        
        recipe.reglog = reglog.Reglog(
                {
                    "id": result["reglog_id"],
                    "first_name": result["first_name"],
                    "last_name": result["last_name"],
                    "email": result["email"],
                    "password": result["password"],
                    "created_at": result["rlc"],
                    "updated_at": result["rlu"]
                }
            )
        return recipe
    
    @classmethod
    def get_all(cls):

        query ="""SELECT recipes.id, recipes.created_at, recipes.updated_at, recipe_instructions, recipe_description, recipe_name, recipe_date_made, recipe_under_30, 
                    reglogs.id as reglog_id, first_name, last_name, email, password, reglogs.created_at as rlc, reglogs.updated_at as rlu 
                    FROM recipes 
                    JOIN reglogs on reglogs.id = recipes.reglog_id;"""
        recipe_data = connectToMySQL(db).query_db(query)

        recipes = []

        for recipe in recipe_data:

            recipe_obj = cls(recipe)

            recipe_obj.reglog = reglog.Reglog(
                {
                    "id": recipe["reglog_id"],
                    "first_name": recipe["first_name"],
                    "last_name": recipe["last_name"],
                    "email": recipe["email"],
                    "password": recipe["password"],
                    "created_at": recipe["rlc"],
                    "updated_at": recipe["rlu"]
                }
            )
            recipes.append(recipe_obj)
        return recipes
    
    #not working for me.  Need to edit later
    @classmethod
    def update_recipe(cls, recipe_dictionary, session_id):

        recipe = cls.get_by_id(recipe_dictionary["id"])
        if recipe.reglog.id != session_id:
            flash("You must be the creator to update this recipe.")
            return False

        if not cls.is_valid(recipe_dictionary):
            return False
        
        query = """UPDATE recipes
                    SET name = %(recipe_name)s, recipe_description = %(recipe_description)s, recipe_instructions = %(recipe_instructions)s, recipe_date_made=%(recipe_date_made)s, recipe_under_30 = %(recipe_under_30)s
                    WHERE id = %(id)s;"""
                    
        connectToMySQL(db).query_db(query,recipe_dictionary)
        recipe = cls.get_by_id(recipe_dictionary["id"])
        
        return recipe
    

    @classmethod
    def delete_recipe_by_id(cls, recipe_id):
        
        data = {"id": recipe_id}
        query = "DELETE FROM recipes WHERE id = %(id)s;"
        connectToMySQL(db).query_db(query, data)
        
        return recipe_id 
    #I have not finished this...Or rather I can't get it to work
    @staticmethod
    def is_valid(recipe_dictionary):
        valid = True
        if len(recipe_dictionary["name"]) < 3:
            flash("Recipe Name: " + "Changes are required and must be at least 3 characters")
            valid = False
        if len(recipe_dictionary["recipe_description"]) < 3:
            flash("Recipe Description: " + "Changes are required and must be at least 3 characters")
            valid = False
        if len(recipe_dictionary["recipe_instructions"]) < 3:
            flash("Recipe Instructions: " + "Changes are required and must be at least 3 characters")
            valid = False

        if len(recipe_dictionary["recipe_date_made"]) <= 0:
            flash("Creation date required.")
            valid = False
        if "under_30" not in recipe_dictionary:
            flash("Can you make this in 30 minutes?")
            valid = False

        return valid
        