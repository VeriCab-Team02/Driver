import React from 'react';
import './DriverRegister.css';


class CarRegister extends React.Component {
    constructor(props) {
        super(props);
            this.state = {
                carFlag : false,
                newDriver : {
                    driveId:0,
                    name:"",
                    gender:"",
                    rating: 0,
                    email:"",
                    phoneNumber:"",
                    dob:"",
                    username:"",
                    password:"",
                    licenseNumber:""
                },

                Car : {
                    cardId:0,
                    manufacturer:"",
                    variant:"",
                    registrationNumber:"",
                    noOfSeats:0,
                    type:"",
                    ratePerKm:0
                },
                link : "http://localhost:8080/addDriver"
            }
    }

    CarInfo = (e) => {
        let inp = e.target.value;
        console.log(inp);
         this.setState( { carFlag : !this.state.carFlag } )
    }

    handleChange = (event) => {
        console.log(event.target.name);
        console.log(event.target.value);

        let name = event.target.name;
        let value = event.target.value;

        console.log(this.state.newDonor);
        this.setState(prevState =>({newDriver : {...prevState.newDriver}, [name] : value}));
    
    }

    
    render() {
    return (
        <div className='container' style={{alignContent:'center'}}>
             <form class="form-horizontal" action={this.state.link}>
                <h1>Register</h1>
                <p>Please fill in this form to create an account.</p>
                <hr />
                
                <div class="form-group row">
                    <label class="col-form-label col-sm-2">Name: </label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" name="name" placeholder="Enter Username" id="name" onChange={this.handleChange} required/>
                    </div>
                </div>   
                    
                <div className="form-group row">
                <label class="col-form-label col-sm-2">Gender: </label>
                     <input type="radio" name="gender" value="Male" onChange={this.handleChange} /> Male &nbsp;
                     <input type="radio" name="gender" value="Female"/> Female &nbsp;
                     <input type="radio" name="gender" value="Other"/> Other
                </div>
                

                <div class="form-group row">
                    <label class="col-form-label col-sm-2">Email:</label>
                    <div class="col-sm-4">
                        <input type="email" class="form-control" id="email" placeholder="Enter email" name="email" onChange={this.handleChange} required />
                    </div>
                 </div>
                 
                <div class="form-group row">
                    <label class="col-form-label col-sm-2" > DOB:</label>
                    <div class="col-sm-4">
                        <input type="date" class="form-control" name="dob" id="dob" placeholder="Enter DOB" onChange={this.handleChange} required />
                    </div>
                 </div>
                
                

                 <div class="form-group row">
                    <label class="col-form-label col-sm-2">Username:</label>
                    <div class="col-sm-4">          
                        <input type="text" class="form-control" id="username" placeholder="Enter UserName" name="username" onChange={this.handleChange} required />
                    </div>
                 </div>


                 <div class="form-group row">
                    <label class="col-form-label col-sm-2">Password:</label>
                    <div class="col-sm-4">          
                        <input type="password" class="form-control" id="password" placeholder="Enter Password" name="password" onChange={this.handleChange} required />
                    </div>
                 </div>


                 <div class="form-group row">
                    <label class="col-form-label col-sm-2">Phone Number:</label>
                    <div class="col-sm-4">  
                     <input type="text" class="form-control" id="phoneNumber" placeholder="Enter Phone Number" name="phoneNumber" onChange={this.handleChange} required/>
                    </div>
                 </div>
                 <div className="form-group row">
                            <label class="col-form-label col-sm-2">Driver License No</label>
                            <div className="col-sm-4">
                                <input type="text" className="form-control" name="licenseNumber" id="licenseNumber"/> 
                            </div>
                 </div>


                {/* <tr>
                <td><label>City: </label> </td>
                <td> <input type="text" name="driver-city" required></input> </td>
                </tr>
                <br /> */}
                
                <div className="form-group row">
                     <label class="col-form-label col-sm-2">Do you have a car? </label>
                                <input type="radio" name="AskCar" value="Yes" onChange={this.CarInfo}/>Yes 
                                <input type="radio" name="AskCar" value="No" onChange={this.CarInfo}/> No
                 </div>
                        
                         {this.state.carFlag && 
                         <div>
                            <div className="form-group row" >
                                <label class="col-form-label col-sm-2">Car Type</label>
                                <select className="col-sm-2">
                                     <option value="Mini" name="type" onChange={this.handleChange}>Mini</option>
                                    <option value="Micro" name="type" onChange={this.handleChange}>Micro</option>
                                    <option value="Sedan" name="type" onChange={this.handleChange}>Sedan</option>
                                    <option value="SUV" name="type" onChange={this.handleChange}>SUV</option>
                                </select>
                             <br />
                            </div>

                            <div className="form-group row">
                                <label class="col-form-label col-sm-2">Car Manufacturer</label>
                                <div className="col-sm-4">
                                    <input type="text" className="form-control" name="manufacturer" onChange={this.handleChange} required/> 
                                </div>
                            </div>

                            <div className="form-group row">
                                <label class="col-form-label col-sm-2">Car Variant</label>
                                <div className="col-sm-4">
                                    <input type="text" className="form-control" name="variant" onChange={this.handleChange} required />
                                </div>
                            </div> 

                            <div className="form-group row">
                               <label class="col-form-label col-sm-2">Car Seats</label>
                               <div className="col-sm-4">
                                <input type="text" className="form-control"name="noOfSeats" onChange={this.handleChange} required /> 
                                </div>
                            </div>

                            <div className="form-group row">
                                <label class="col-form-label col-sm-2">Car Registration No</label>
                                <div className="col-sm-4">
                                    <input type="text" className="form-control" name="registrationNumber" onChange={this.handleChange} required/> 
                                </div>
                            </div>

                            <div className="form-group row">
                                <label class="col-form-label col-sm-2">Rate per Km</label>
                                <div className="col-sm-4">
                                    <input type="number" className="form-control" name="ratePerKm" onChange={this.handleChange} required/> 
                                </div>
                            </div>

                            <div className="form-group row">
                                <label class="col-form-label col-sm-2">Driver License No</label>
                                <div className="col-sm-4">
                                    <input type="text" className="form-control" name="licenseNumber" onChange={this.handleChange} required/> 
                                </div>
                            </div>

                         </div>
                         
                            }
   

                          <hr />
              
                <center> <button type="submit" class="btn btn-success">Register</button> </center>
                       
            </form>
            </div>
    );

}
}

export default DriverRegister;