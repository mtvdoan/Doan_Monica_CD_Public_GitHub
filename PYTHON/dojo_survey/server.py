from flask import Flask, request, render_template, redirect, session
app = Flask(__name__)
app.secret_key ="It's password."

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/fillout', methods =["POST"])
def fillout():
        session["first_name"] = request.form.get("fname")
        session["last_name"] = request.form.get("lname")
        session["location"] = request.form.get("selectlocation")
        session["favlang"] = request.form.get("favoritelang")
        session["comments"] = request.form.get("commententry")
        return redirect('/results')
    
@app.route('/results')
def results():
    return render_template('results.html')

if __name__== "__main__":
    app.run(debug=True)