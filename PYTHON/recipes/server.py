from flask_app import app
from flask_app.controllers import reglogs
from flask_app.controllers import recipes
# from flask_app.controllers import recipes

if __name__ == "__main__":
    app.run(debug=True)

# For macs, remember to add port = 5001 << something like this check the platform
 