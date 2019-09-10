import React from 'react';

import './DriverSettings.css';
import DriverRegister from '../DriverRegister/DriverRegister.react';
import DriverCar from '../DriverCar/DriverCar.react';

class DriverSettings extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div className='driversettings_wrapper'>
                <br />
                <br />
                <br />
               <center>
            <form> 
                <table>
                    <thead></thead>
                    <tbody>
                <tr>
                <td><label>Name: </label> </td>
                <td> <input type="text" name="driverName" id="driverName"></input> </td>
                </tr>
                <br />

                <tr>
                <td><label>Gender: </label> </td>
                <td>
                     <input type="radio" name="gender" value="Male"/> Male &nbsp;
                     <input type="radio" name="gender" value="Female"/> Female &nbsp;
                     <input type="radio" name="gender" value="Other"/> Other
                 </td>
                </tr>
                <br />

                <tr>
                <td><label> DOB: </label> </td>
                <td> <input type="date" name="driverdob" id="driverdob" /> </td>
                </tr>
                <br />

                <tr>
                <td><label>Email: </label> </td>
                <td> <input type="email" /> </td>
                </tr>
                <br />

                <tr>
                <td><label>Phone No: </label> </td>
                <td> <input type="number" ></input> </td>
                </tr>
                <br />

                    <input type="submit" value="Edit Details" /> 
                
                </tbody>
                </table>        
            </form>
            </center>
            </div>
        );
    }
}

export default DriverSettings;