
from flask import Flask, render_template, redirect, session, request
import random

app = Flask(__name__)
app.secret_key = 'I am Groot'

@app.route('/')
def index():
    if 'num' not in session:
        session['num'] = random.randint(1,100)
        print(f"psst! The secret number is: {session['num']}")
        
    return render_template('index.html')

@app.route('/guess', methods=['POST'])
def guess():
    session['guess'] = int(request.form['guess'])
    return redirect('/')

@app.route('/reset')
def reset():
    session.clear()
    return redirect('/')
    

if __name__== "__main__":
    app.run(debug=True)
