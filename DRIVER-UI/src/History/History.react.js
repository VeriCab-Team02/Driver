import React from 'react';

import './History.css';
import { faAlignCenter } from '@fortawesome/free-solid-svg-icons';
import axios from 'axios';

let TripList = [
    {date : "02-06-2018, 5:16pm", fare : 125.00 , passengerName:"Raghul"},
    {date : "05-08-2019 2:45pm", fare : 205.00 , passengerName:"Yoharaj"},
    {date : "27-04-2019 9:16am", fare : 300.00 , passengerName:"Rashmika"}
];



class History extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            trips:[]
        }
    }
    componentDidMount() {
        axios.get(`https://jsonplaceholder.typicode.com/users`)
          .then(res => {
            const trips = res.data;
            this.setState({ trips });
          })
      }
    

    render() {
        return (
            <div className='history_wrapper'>
                <nav className="navbar navbar-expand-sm bg-dark navbar-dark justify-content-center">
                    <h5 style={{color:'white'}}> Your Past Trips</h5>
                </nav>
                
                <div>
                    <h6>FONT-AWESOME-RATING-ICON </h6>
                    <hr />
                </div>
               
                <div>
                    <h6 className="RidesStyle">Rides</h6>
                    {/* <div>
                        {
                            TripList.map( (eachTrip, index) => {
                                <div class="card">
                                <div class="card-header">{eachTrip.date}</div>
                                <div class="card-body">{eachTrip.fare}</div>
                                <div class="card-footer">{eachTrip.passengerName}</div>
                                </div>
                            } )
                        }
                    </div> */}
                   
                    {/* <p>{TripList[1].fare}</p> */}

                
                    <div> 
                        {  
                        this.state.trips.map( (eachTrip, index) => {
                            return <div class="card cardStyle shadow p-3 mb-5">
                        {/* <div class="card-header"> </div> */}
                        <div class="card-body">
                                <div className="row">
                                    <h6 className="DateInfoStyle col"> {eachTrip.name}</h6>
                                    <h6 className="FareInfoStyle col"> Rs {eachTrip.fare}</h6>
                                </div>

                            <div className="row">
                                <div className="col justify-content-center col-sm-10">
                                <label className="PassengerInfoStyle"> {eachTrip.passengerName}  </label>
                                </div>
                            </div>

                            {/* Trip Location Details */}
                            <div className="row justify-content-center"> 
                                <label className="dot1"></label>  &nbsp; &nbsp;
                                <input type="text" readOnly value={eachTrip.passengerName} className="location"/>
                            </div>
                                
                                <div className="row justify-content-center">
                                    <label className="dot2"></label> &nbsp; &nbsp;
                                    <input type="text" readOnly value={eachTrip.passengerName} className="location"/>
                                </div>
                        
                        </div>
                        </div>
                        })
                        }
                    </div>
                
                </div> 
            </div>
        );
    }
}

export default History;