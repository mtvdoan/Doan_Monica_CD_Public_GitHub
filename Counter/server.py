from flask import Flask, render_template, session, redirect, request

app = Flask(__name__)
app.secret_key = 'this is a secret'

counter = 1

@app.route("/")
def counter():
    if 'counter' in session:
        session['counter'] = session.get('counter') + 1
    else:
        session['counter'] = 1
    return render_template (
        'index.html', 
        counter = session['counter'],
        ) 
@app.route("/addtwo", methods = ['POST'])
def add2():
    session['counter'] = session.get('counter') + 2
    return render_template("index.html", counter = session['counter'])

@app.route("/reset", methods = ['POST'])
def reset():
    session['counter'] = 1
    return render_template('index.html', counter = session['counter'])

@app.route('/destroy_session')
def destroy_session():
    return render_template(
        'destroy.html',
        ) 
if __name__== "__main__":
    app.run(debug=True)

