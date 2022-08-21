from flask import Flask  
app = Flask(__name__)
    
@app.route('/')         
def hello_world():              
    return "Hello World!"

@app.route('/<entry>')         
def dojo(entry):   
    if entry == 'dojo':
        return 'Dojo!'
    else:            
        return "Sorry! No response. Try again."
    
@app.route('/say/<name>')
def flask(name):
    return "Hi " + name + "!"


@app.route('/repeat/<int:num>/<name>') 
def repeat(num, name):
    return f"{num * name}"
    


if __name__=="__main__":
    app.run(debug=True)    
