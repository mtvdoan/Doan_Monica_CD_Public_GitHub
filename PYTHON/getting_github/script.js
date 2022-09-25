document.getElementById('git_data').onclick = get_user_data
    // function above is used to trigger 'get_user_data' function below when button is clicked.

text_field = document.getElementById('username')
    // creates a blank input text field for user to type in their github username

function get_user_data() {
    //Async/Await Function 'get_user_data'
        //Sends async keyword to the function and wait for the data to come back
            //
    fetch(`https://api.github.com/users/${text_field.value}`)
    //this will send a 
    //Note that $(____) allows us to enter what we want in the input field and it will go in here, but id of input in the html MUST match
    //text_field is the variable above.  value is just whatever you enter in the input field
    .then(response => response.json() )
    .then(user_data => {
        console.log(user_data)
        let avatar_url = user_data.avatar_url
        let name = user_data.name
        let followers = user_data.followers
        //need to create objects avatar_url, name, and followers.

        if (document.getElementById('main_container')){
            document.getElementById('main_container').remove()
        }

        const container = document.createElement('div')
        container.id = 'main_container'
        document.body.appendChild(container)
        //Adds a PARENT div element with id called 'main_character'
        //Adds the following below into the body of html doc.
            //<div class='container' id='main_character'></div> 

        const header = document.createElement('h1')
        header.innerText = `${name} has ${followers} followers!`
        container.appendChild(header)
        //adds <h1></h1> as the CHILD element under the PARENT element CONTAINER 
        //<div class='container' id='main_character'></div>
            // <div class='container' id='main_character'></div>
                    //<h1>'___ has ___ followers!</h1>

        const avatar = new Image()
        avatar.src = avatar_url
        container.appendChild(avatar)
        //variable = avatar
        //represents the 'new Image() function' as the object 'avatar'
        //places that image into the container html field.
        //container is the parent
        //avatar (new Image()) is the CHILD
    })
    .catch(err => console.log(err))
}