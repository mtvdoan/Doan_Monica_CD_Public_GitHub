from flask_app import app
from flask import render_template, redirect, request
from flask_app.models.user import User

@app.route("/")
def index():
    return redirect("/users")


@app.route('/users')
def users():
    return render_template('all_users.html', users=User.get_all())

@app.route('/users/new')
def new_user():
    return render_template('create.html')

@app.route('/create', methods=['POST'])
def create():
    #check if the form info is valid input
    if User.is_valid_user(request.form):
        User.save(request.form)
        return redirect("/")
    else: 
        return redirect('/users/new')
        #this is a dictionary (request.form)
        
    #create the user if valid
    #if not -- send direct the user back to the create page 
    
@app.route('/create/user', methods=['POST'])
def create_user():
    data = {
        "first_name": request.form['first_name'],
        "last_name": request.form['last_name'],
        "email": request.form['email']
    }
    User.save(data)
    print()
    print("create_user")
    print(data)
    print()
    if data['email']: 
        return redirect("/users")
    else:
        print("No email.")
    return redirect('/users')

@app.route('/user/<int:id>')
def show_user(id):
    user_data = {
        'id': id
    }
    return render_template('show.html', user=User.show_one(user_data))

@app.route('/user/edit/<int:id>')
def render_edit(id):
    user_data = {
        'id': id
    }
    return render_template('edit.html', user=User.show_one(user_data))


@app.route('/user/edit/<int:id>', methods=['POST'])
def edit_user(id):
    edit_data = {
        'id': id,
        "first_name": request.form['first_name'],
        "last_name": request.form['last_name'],
        "email": request.form['email']
    }
    User.modify(edit_data)
    return redirect(f'/user/{id}')

@app.route('/user/delete/<int:id>')
def delete(id):
    user_data = {
        'id': id
    }
    User.seek_and_destroy(user_data)
    return redirect('/')
