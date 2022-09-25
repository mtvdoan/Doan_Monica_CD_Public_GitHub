from flask import Flask, render_template
            
app = Flask(__name__) 

@app.route('/')
def route_1():
    return render_template("index.html", color1="white", color2="black", row = 8, column = 8)

@app.route('/4')
def route_2():
    return render_template("index.html", color1="white", color2="black", row = 8, column = 4)

@app.route('/<int:a>/<int:b>')
def route_3(a, b):
    return render_template("index.html", color1="white", color2="black", row = int(a), column = int(b))

@app.route('/<int:a>/<int:b>/<string:c1>/<string:c2>')
def route_4(a, b, c1, c2):
    return render_template("index.html", color1= str(c1), color2 = str(c2), row = int(a), column = int(b))

if __name__=="__main__": 
    app.run(debug=True) 
