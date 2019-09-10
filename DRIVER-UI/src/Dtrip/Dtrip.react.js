import React from 'react';
import './Dtrip.css';
import logo1 from '../images/verizon pic1.jpg';
import {Switch, Route, Link} from 'react-router-dom';
import DisplayPassengerInfo from '../DisplayPassengerInfo/DisplayPassengerInfo.react';
// import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faCoffee } from '@fortawesome/free-solid-svg-icons';

class Dtrip extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            passengerName : "ABC",
            passengerPhone : 12345
        }
    }

    //Function to get the date and time at the start of the trip
    handleSubmit = () => {

        //to get current date
        let ts = Date.now();
        let date_ob = new Date(ts);
        let date = date_ob.getDate();
        let month = date_ob.getDay();
        let year = date_ob.getFullYear();
        let currentDate = date + "/" + month + "/" + year;
        console.log(currentDate);

        //TO get current Time
        // current hours
        let hours = date_ob.getHours();

        // current minutes
        let minutes = date_ob.getMinutes();
        let currentTime = hours + ":" + minutes;
        console.log(currentTime);
        
        //To Get Current Location
    }
    render() {
        return (
            <div className='dtrip_wrapper'>

                {/* NavBar to Display the title Trip Details */}
                <nav className="navbar navbar-expand-sm bg-dark navbar-dark">
                    <a className="navbar-brand" href="#">
                        <img className="logostyle" src={logo1} alt="logo"/>
                    </a>
                    <ul class="navbar-nav">
                        <li className="nav-item justify-content-center tripDetailStyle">Trip Details</li>
                    </ul>
                    </nav>
                    <br />

                    {/* Container to display the source and destination received from the passenger */}
                    <div className="container">
                    {/* <i class="fa fa-wifi-1"></i> */}
                    <label className="dot1"></label> &nbsp;
                    <input type="text" readOnly value="From Location" className="location"/>
                    <br />
                    
                    <br/>
                    <label className="dot2"></label> &nbsp;
                    <input type="text" readOnly value="To Location" className="location"/>
                    </div>
                    <hr/>

                    {/*Container to display the Map*/}
                    <hr/>
                    {/*User Details are displayed here*/}
                    <div>
                        <h6>Congrats! Your next trip is with &nbsp; {this.state.passengerName} </h6>
                            {/* <Link to="/getPassengerInfo" className="passengerNameStyle">{this.state.passengerName} </Link>  
                        </h6> */}

                            {/* <Switch>
                                <Route path="/getPassengerInfo" component={DisplayPassengerInfo}></Route>
                            </Switch> */}
                        <h6></h6>
                        <h6 id="myModal">
                           You could Speak to them at: {this.state.passengerPhone}   
                        </h6>
                        {/* <FontAwesomeIcon icon={faCoffee} /> */}
                    </div>

                <button className="btn btn-dark" onClick={this.handleSubmit}>Submit</button>
            </div>
        );
    }
}

export default Dtrip;