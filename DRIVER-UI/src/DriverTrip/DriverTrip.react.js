import React from 'react';

import './DriverTrip.css';
import {Map, GoogleApiWrapper} from 'google-maps-react';

const mapStyles = {
  width: '80%',
  height: '80%'
};

class DriverTrip extends React.Component {
    constructor(props) {
        super(props);
        this.setState = {
                dateInfo : ""
                     }
    }

    handleStartTrip = () => {

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
            <div className='drivertrip_wrapper'>

                    <div>
                    <p>Driver Name Trip Details</p>
                    </div> 
                    < hr />

                    <div>
                     <p>from---</p>
                     <p>to----</p>
                    <hr/>

                    {/* Display Map  */}
                    <div>
                    <Map
                        google={this.props.google}
                        zoom={8}
                        style={mapStyles}
                        initialCenter={{lat:47.444, lng:122.176}}
                    />
                    </div>
                    <br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /> ><br /><br /><br /> ><br /><br /><br /> ><br /><br /><br /> 

                    <hr/>
                    </div>
                   
                   {/* user and trip information will be displayed here */}
                    Username
                    phone number 
                   
                    <input type="submit" value="Start Trip" onClick={this.handleStartTrip}></input>
                    {/* <ButtonToolbar> 
                        <Button variant="primary">Hello</Button>
                    </ButtonToolbar> */}
            </div>
        );
    }

}

export default GoogleApiWrapper({
    apiKey: 'AIzaSyAOrhuGkBNZuE782Vm4fM6-w0q56KRNXWw'
  })(DriverTrip);