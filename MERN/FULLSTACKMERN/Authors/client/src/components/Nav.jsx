import {Link} from 'react-router-dom';
const Nav = () => {
    return(
        <>
            <div>
                <Link align="center" to={"/authors/create/"}>
                    <h3>Add a new Author</h3>
                </Link>
            </div>
        </>
    )
}
export default Nav;