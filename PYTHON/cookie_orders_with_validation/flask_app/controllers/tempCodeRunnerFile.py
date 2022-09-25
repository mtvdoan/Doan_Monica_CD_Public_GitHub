@app.route('/cookies')
def cookies():

    return redirect('index.html', cookies=Cookie.get_all())