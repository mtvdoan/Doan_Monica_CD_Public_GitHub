from flask import render_template, redirect, session, request
from flask_app import app
from flask_app.models.reglog import Reglog
from flask import flash


@app.route("/")
def index():
    return render_template("index.html")

@app.route('/register',methods=['POST'])
def register():
    verified_reglog = Reglog.insert_verified_reglog(request.form)
    
    if not verified_reglog:
        return redirect("/")

    session['reglog_id'] = verified_reglog.id
    
    return redirect('/recipes/wall')

@app.route('/login', methods=['POST'])
def login(): 
    real_reglog = Reglog.verified_reglog(request.form)
    if not real_reglog:
        flash("Invalid Email/Password", "login")
        return redirect("/")
    
    session["reglog_id"] = real_reglog.id
    return redirect("/recipes/wall")

@app.route("/logout")
def logout():
    session.clear()
    return redirect('/')

