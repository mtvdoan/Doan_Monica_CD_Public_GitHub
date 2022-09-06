from flask_app import app
from flask import render_template, redirect, request
from flask_app.models.cookie import Cookie

@app.route("/")
def index():
    return render_template('index.html', cookies=Cookie.get_all())

@app.route('/cookies')
def cookies():
    print("")
    print(Cookie.get_all())
    return redirect('/index')


@app.route('/cookie/edit/<int:id>', methods=['GET'])
def render_edit(id):
    cookie_data = {
        'id': id
    }
    print()
    print("render_edit")
    print()
    return render_template('edit.html', cookie=Cookie.show_one(cookie_data))


@app.route('/cookie/edit/<int:id>', methods=['POST'])
def edit_cookie(id):
    edit_data = {
        'id': id,
        "customer_name": request.form['customer_name'],
        "cookie_type": request.form['cookie_type'],
        "number_of_boxes": request.form['number_of_boxes']
    }
    print()
    print("edit_cookie")
    print(edit_data)
    print()
    Cookie.modify(edit_data)
    return redirect(f'/')

@app.route('/cookie/delete/<int:id>')
def delete(id):
    cookie_data = {
        'id': id
    }
    Cookie.seek_and_destroy(cookie_data)
    print()
    print("delete cookie")
    print()
    
    return redirect('/')

@app.route('/cookie/new')
def new_cookie():
    return render_template('new.html')


@app.route('/create/cookie', methods=['POST'])
def create_cookie():
    data = {
        "customer_name": request.form['customer_name'],
        "cookie_type": request.form['cookie_type'],
        "number_of_boxes": request.form['number_of_boxes'],
    }
    Cookie.save(data)
    print()
    print("create_cookie()")
    print(data)
    print()
    return redirect('/') 

@app.route('/create', methods=['POST'])
def validate_create_cookie():
    if not Cookie.validate_cookie(request.form):
        return redirect('/cookie/new')
    # redirect to the route where the cookie form is rendered.
    Cookie.save(request.form)
    return redirect("/")


