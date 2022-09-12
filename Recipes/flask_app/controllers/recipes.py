from flask import Flask, render_template, session, redirect, request
from flask_app import app
from flask_app.models.reglog import Reglog
from flask_app.models.recipe import Recipe
from flask import flash

@app.route("/recipes/wall")
def recipes_wall():
    if "reglog_id" not in session:
        flash("Please login in order to access all recipes!")
        return redirect("/")
    
    reglog = Reglog.get_by_id(session["reglog_id"])
    recipes = Recipe.get_all()

    return render_template("recipes.html", reglog=reglog, recipes = recipes)

@app.route("/recipes/<int:recipe_id>")
def recipe_detail(recipe_id):
    reglog = Reglog.get_by_id(session["reglog_id"])
    recipe = Recipe.get_by_id(recipe_id)
    return render_template("recipe_details.html", reglog=reglog, recipe=recipe)

@app.route("/recipes/edit/<int:recipe_id>")
def recipe_edit_page(recipe_id):
    reglog = Reglog.get_by_id(session["reglog_id"])
    recipe = Recipe.get_by_id(recipe_id)
    return render_template("edit.html", reglog=reglog, recipe=recipe)

@app.route("/recipes/<int:recipe_id>", methods=["POST"])
def update_recipe(recipe_id):

    valid_recipe = Recipe.update_recipe(request.form, session["reglog_id"])

    if not valid_recipe:
        return redirect(f"/recipes/edit/{recipe_id}")
        
    return redirect(f"/recipes/{recipe_id}")


@app.route("/recipes/delete/<int:recipe_id>")
def delete_recipe_by_id(recipe_id):
    Recipe.delete_recipe_by_id(recipe_id)
    return redirect("/recipes/wall")        


