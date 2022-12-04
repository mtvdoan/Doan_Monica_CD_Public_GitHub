import React, { useState } from 'react';

// We will use an onChange synthetic event to capture into state 
//    each character as it is typed

const UserForm = (props) => {
    const [ firstName, setFirstName ] = useState("");
    const [ lastName, setLastName ] = useState("");
    const [ email, setEmail ] = useState("");
    const [ password, setPassword ] = useState("");
    const [ confirmPassword, setConfirmPassword] = useState("");



  // The return can only return a single React element, it does NOT
  //    have to be a div.  It can be a form or any other element.
  return (
    <>
        <div class="fluid">
            <form>
                <form class="input-group-text">
                    <label for="firstName" class="input-group-text" style={{ border: "none"}}>First Name</label>
                    <input type="text" onChange={ (e) => setFirstName(e.target.value) } class="form-control" name='firstName'/>
                </form>
                <div style={{ color: "red"}}>
                    {firstName.length < 2 && firstName.length > 0 ? (
                        <p>First name must be at least 2 characters.</p>
                    ): null}
                </div>
            </form>

            <form>
                <form class="input-group-text">
                    <label for="lastName" class="input-group-text" style={{ border: "none"}}>Last Name</label>
                    <input type="text" onChange={ (e) => setLastName(e.target.value) } class="form-control" name='lastName'/>
                </form>
            </form>
                <div style={{ color: "red"}}>
                    {lastName.length < 2 && lastName.length > 0 ? (
                        <p>Last name must be at least 2 characters.</p>
                    ): null}
                </div>
            <form>
                <form class="input-group-text">
                    <label for="email" class="input-group-text" style={{ border: "none"}}>Email</label>
                    <input type="email" onChange={ (e) => setEmail(e.target.value) } class="form-control" name='email'/>
                </form>
                <div style={{ color: "red"}}>
                    {email.length < 5 && email.length > 0 ? (
                        <p>Email must be at least 5 characters.</p>
                    ): null}
                </div>
            </form>

            <form>
                <form class="input-group-text">
                    <label for="password" class="input-group-text" style={{ border: "none"}}>Password</label>
                    <input type="password" onChange={ (e) => setPassword(e.target.value) } class="form-control" name='password'/>
                </form>
                <div style={{ color: "red"}}>
                    {password.length < 5 ? (
                        <p>Please enter a unique password.  Passwords must be at least 8 characters.</p>
                    ): null}
                </div>
            </form>

            <form>
                <form class="input-group-text">
                    <label for="confirmPassword" class="input-group-text" style={{ border: "none"}}>Confirm</label>
                    <input type="password" onChange={ (e) => setConfirmPassword(e.target.value) } class="form-control" name='confirmPassword'/>
                </form>
                <div style={{ color: "red"}}>
                    {confirmPassword !== password ? (
                        <p>Please confirm password.  Confirm password does not</p>
                    ): null}
                </div>
            </form>
        </div>
        <div>
            <h3 style={{ textAlign: 'center' }}>Your Form Data</h3>
            <p>
                <label>First Name: </label>{ firstName }
            </p>
            <p>
                <label>Last Name: </label>{ lastName }
            </p>
            <p>
                <label>Email: </label>{ email }
            </p>
            <p>
                <label>Password: </label>{ password }
            </p>
            <p>
                <label>Confirm Password: </label>{ confirmPassword }
            </p>
        </div>
        </>
    )
}

export default UserForm;