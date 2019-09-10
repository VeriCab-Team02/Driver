import React from 'react';
import './DriverRegister.css';
import axios from 'axios';

class DriverRegister extends React.Component {
    constructor(props) {
        super(props);
            this.state = {
                carFlag : false,
                file:null,
                newDriver : {
                    name:"",
                    gender:"",
                    email:"",
                    phoneNumber:"",
                    dob:"",
                    username:"",
                    password:"",
                    licenseNumber:""
                },

                car : {
                    manufacturer:"",
                    variant:"",
                    registrationNumber:"",
                    noOfSeaters:0,
                    type:"",
                    ratePerKm:0
                },
                link : 'http://localhost:8080/addDriver'
            }
    }

    CarInfo = (e) => {
        let inp = e.target.value;
        if(inp === 'Yes'){
            this.setState({carFlag:true})
            this.setState( { link : 'http://localhost:8080/addCar' } )
        }
        else{
            this.setState({carFlag:false})
            this.setState( { link : 'http://localhost:8080/addDriver' } )
        }
            
    }

    // componentDidUpdate(){
    //     console.log('Current link-----'+this.state.link);
    // }

    handleChange = (event) => {
        let name = event.target.name;
        let value = event.target.value;
        // this.setState(prevState =>({newDriver : {...prevState.newDriver}, [name] : value})); 
        this.setState(prevState =>( {newDriver:{...prevState.newDriver,[name]:value}}));
        this.setState(prevState =>( {car:{...prevState.car,[name]:value}}));
        console.log(this.state.car);
    }

    handleFile = (event) => {
        
        this.setState({file: event.target.files[0]} )     
    }

    handleSubmit=(event)=>{
       
        document.getElementById("clearForm").reset();
        event.preventDefault();
   
        let data = new FormData();

        data.append('file', this.state.file);
        //data.append('driverModel', JSON.stringify(this.state.newDriver));
        data.append('name', this.state.newDriver.name);
        data.append('gender', this.state.newDriver.gender);
        data.append('email', this.state.newDriver.email);
        data.append('phoneNumber', this.state.newDriver.phoneNumber);
        data.append('dob', this.state.newDriver.dob);
        data.append('username', this.state.newDriver.username);
        data.append('password', this.state.newDriver.password);
        data.append('licenseNumber', this.state.newDriver.licenseNumber);

        data.append('manufacturer', this.state.car.manufacturer);
        data.append('variant', this.state.car.variant);
        data.append('registrationNumber', this.state.car.registrationNumber);
        data.append('noOfSeaters', this.state.car.noOfSeaters);
        data.append('type', this.state.car.type);
        data.append('ratePerKm', this.state.car.ratePerKm);

         axios.post(this.state.link, data)
         .then(response => console.log(response))
         .catch(error => console.log(error))
        console.log("submit called");
    }
    
    render() {
    return (
        
        <div className='container' style={{alignContent:'center'}}>
             <form className="form-horizontal" onSubmit={this.handleSubmit}  id='clearForm'>
                <h1>Register</h1>
                <p>Please fill in this form to create an account.</p>
                <hr />
                <div className="form-group row">
                    <label className="col-form-label col-sm-2">Name: </label>
                    <div className="col-sm-4">
                        <input type="text" className="form-control" name="name" placeholder="Enter Username" id="name" onChange={this.handleChange} required/>
                    </div>
                </div>   
                    
                <div className="form-group row">
                <label className="col-form-label col-sm-2">Gender: </label> &emsp;
                     <input type="radio" name="gender" value="Male" onChange={this.handleChange} /> Male &emsp;
                     <input type="radio" name="gender" value="Female"/> Female &emsp;
                     <input type="radio" name="gender" value="Other"/> Other
                </div>
                

                <div className="form-group row">
                    <label className="col-form-label col-sm-2">Email:</label>
                    <div className="col-sm-4">
                        <input type="email" className="form-control" id="email" placeholder="Enter email" name="email" onChange={this.handleChange} />
                    </div>
                 </div>
                 
                <div className="form-group row">
                    <label className="col-form-label col-sm-2" > DOB:</label>
                    <div className="col-sm-4">
                        <input type="date" className="form-control" name="dob" id="dob" placeholder="Enter DOB" onChange={this.handleChange} />
                    </div>
                 </div>
                
                

                 <div className="form-group row">
                    <label className="col-form-label col-sm-2">Username:</label>
                    <div className="col-sm-4">          
                        <input type="text" className="form-control" id="username" placeholder="Enter UserName" name="username" onChange={this.handleChange} />
                    </div>
                 </div>


                 <div className="form-group row">
                    <label className="col-form-label col-sm-2">Password:</label>
                    <div className="col-sm-4">          
                        <input type="password" className="form-control" id="password" placeholder="Enter Password" name="password" onChange={this.handleChange} />
                    </div>
                 </div>


                 <div className="form-group row">
                    <label className="col-form-label col-sm-2">Phone Number:</label>
                    <div className="col-sm-4">  
                     <input type="text" className="form-control" id="phoneNumber" placeholder="Enter Phone Number" name="phoneNumber" onChange={this.handleChange}/>
                    </div>
                 </div>
                 <div className="form-group row">
                    <label className="col-form-label col-sm-2">Photograph:</label>
                    <div className="col-sm-4">  
                     <input type="file" className="form-control" id="file" placeholder="Enter Phone Number"  accept=".jpg,.jpeg,.png" name="file" onChange={this.handleFile}/>
                    </div>
                 </div>
                 <div className="form-group row">
                            <label className="col-form-label col-sm-2">Driver License No</label>
                            <div className="col-sm-4">
                                <input type="text" className="form-control" name="licenseNumber" id="licenseNumber" onChange={this.handleChange} /> 
                            </div>
                 </div>


                {/* <tr>
                <td><label>City: </label> </td>
                <td> <input type="text" name="driver-city" required></input> </td>
                </tr>
                <br /> */}
                
                <div className="form-group row"> 
                     <label className="col-form-label col-sm-2">Do you have a car? </label>
                               &emsp;
                               <input type="radio" name="AskCar" value="No" onChange={this.CarInfo} defaultChecked/> No&emsp;
                                <input type="radio" name="AskCar" value="Yes" onChange={this.CarInfo} /> Yes
                                
                 </div>
                        
                         {this.state.carFlag && 
                         <div>
                            <div className="form-group row" >
                                <label className="col-form-label col-sm-2">Car Type</label>&emsp;
                                <select className="col-sm-2" onSelect={this.handleChange}>
                                     <option value="Mini" name="type" onSelect={this.handleChange}  >   Mini</option>
                                    <option value="Micro" name="type" onSelect={this.handleChange}>Micro</option>
                                    <option value="Sedan" name="type" onSelect={this.handleChange}>Sedan</option>
                                    <option value="SUV" name="type" onSelect={this.handleChange}>SUV</option>
                                </select>
                             <br />
                            </div>

                            <div className="form-group row">
                                <label className="col-form-label col-sm-2">Car Manufacturer</label>
                                <div className="col-sm-4">
                                    <input type="text" className="form-control" name="manufacturer" onChange={this.handleChange} required/> 
                                </div>
                            </div>

                            <div className="form-group row">
                                <label className="col-form-label col-sm-2">Car Variant</label>
                                <div className="col-sm-4">
                                    <input type="text" className="form-control" name="variant" onChange={this.handleChange} required />
                                </div>
                            </div> 

                            <div className="form-group row">
                               <label className="col-form-label col-sm-2">Car Seats</label>&emsp;
                               <select className="col-sm-2">
                                     <option value="4" name="type" onChange={this.handleChange}>4 seaters</option>
                                    <option value="6" name="type" onChange={this.handleChange}>6 seaters</option>
                                </select>
                            </div>

                            <div className="form-group row">
                                <label className="col-form-label col-sm-2">Car Registration No</label>
                                <div className="col-sm-4">
                                    <input type="text" className="form-control" name="registrationNumber" onChange={this.handleChange} required/> 
                                </div>
                            </div>

                            <div className="form-group row">
                                <label className="col-form-label col-sm-2">Rate per Km</label>
                                <div className="col-sm-4">
                                    <input type="number" className="form-control" name="ratePerKm" onChange={this.handleChange} required/> 
                                </div>
                            </div>
                         </div>
                         
                            }
   

                          <hr />
              
                <center> <button type="submit" className="btn btn-success">Register</button> </center>
                       
            </form>
            </div>
    );

}
}

export default DriverRegister;