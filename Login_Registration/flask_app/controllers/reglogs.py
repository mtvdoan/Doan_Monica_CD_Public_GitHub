#CONTROLLER PYTHON FILE--------------------------------------------------------------------------------------------------------------------------------

from flask import render_template, redirect, session, request, flash
from flask_bcrypt import Bcrypt
from flask_app import app
from flask_app.models.reglog import Reglog
bcrypt = Bcrypt(app)

#HOME -----------------------------------------------------------------------------------------------
@app.route("/")
def index():
    print("test")
    return render_template("index.html")


#REGISTER------------User will enter info and click submit.  This will save all info in db and hash password at registration--------------------------------------------------------------------------------------------------------------------
@app.route('/register',methods=['POST'])
def register():
    if not Reglog.validate_register(request.form):
        return redirect('/')
    data ={ 
        "first_name": request.form['first_name'],
        "last_name": request.form['last_name'],
        "email": request.form['email'],
        "password": bcrypt.generate_password_hash(request.form['password'])
    }
    id = Reglog.save(data)
    session['reglog_id'] = id
    return redirect('/dashboard')


#LOGIN----------This is where user logs in.  All info will be validated with the database.  flash messages are in index.html-----------------------------------------------------
@app.route('/login', methods=['POST'])
def login(): 
    data = { "email" : request.form["email"] }
    reglog_in_db = Reglog.get_by_email(data)
    
    if not reglog_in_db:
        flash("Invalid Email/Password", "login")
        return redirect("/")
    if not bcrypt.check_password_hash(reglog_in_db.password, request.form['password']):
        flash("Invalid Email/Password", "login")
        return redirect('/')
    session['reglog_id'] = reglog_in_db.id
    return redirect("/dashboard")

#DASHBOARD (WELCOME PAGE POST LOGIN SUCCESS; FAIL WILL REMAIN ON SAME PAGE FLASHING ERROR MESSAGES :(----------------------------------------------------------------
@app.route('/dashboard')
def dashboard():
    if 'reglog_id' not in session:
        return redirect('/')
    data ={
        'id': session['reglog_id']
    }
    return render_template('dashboard.html', reglog=Reglog.get_by_id(data))


@app.route("/logout")
def logout():
    session.clear()
    return redirect('/')
    

#testing below

# @app.route('/success')
# def dashboard():
#     if 'reglog_id' not in session:
#         return redirect('/')
#     data ={
#         'id': session['reglog_id']
#     }
#     return render_template('success.html', reglog=Reglog.get_by_id(data))

# @app.route('/success')
# def dashboard():
#     return render_template('success.html', reglog=Reglog.get_by_id(data))

#--------------------------------------------------------------------------------
