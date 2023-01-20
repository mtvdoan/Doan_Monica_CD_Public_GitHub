import {Link} from 'react-router-dom';
const Nav = () => {
    return(
        <>
            <div>
                <Link to={"/products/create/"}>
                    <h3>Add Product</h3>
                </Link>
                <Link to={"/products/"}>
                    <h3>Display Product</h3>
                </Link>
            </div>
        </>
    )
}
export default Nav;