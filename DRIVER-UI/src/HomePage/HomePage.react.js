import React from 'react';
import {slide as Menu} from 'react-burger-menu';
import './HomePage.css';
import {Link} from 'react-router-dom';
import Image  from 'react-bootstrap/Image';
const HomePage = () => {

    return (
        <div >
            <Menu>
                {/* <a id="home" className="menu-item" href="/">Home</a>
                <a id="Trips" className="menu-item" href="#">Trips</a>
                <a id="home2" className="menu-item" href="#">Settings</a> */}
                <Image src="" alt="DriverPic" rounded/>
                 {/* this place should have driver photo, name and rating */}
                <br />
                <Link  to='/'>Home</Link>
                <Link  to='/DriverRegister'>Register</Link>
                <Link  to='/DriverSettings'>Settings</Link>
            </Menu>
        </div>
    );

}

export default HomePage;