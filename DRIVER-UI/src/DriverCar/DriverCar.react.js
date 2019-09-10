import React from 'react';

import './DriverCar.css';
import HavingCar from '../HavingCar/HavingCar.react';

class DriverCar extends React.Component {
    constructor(props) {
        super(props);
            this.state = {
                carFlag : false
            }
    }

    CarInfo = (e) => {
        let inp = e.target.value;
        console.log(inp);
         this.setState( { carFlag : !this.state.carFlag } )
         
    }
    render() {
        return (
            <div className='drivercar_wrapper'>
                <form>
                    <table>
                        <tbody>
                        <tr>
                            <td>  <label>Do you have a car? </label> </td>
                            <td>     
                                <input type="radio" name="AskCar" value="Yes" onChange={this.CarInfo}/>Yes 
                                <input type="radio" name="AskCar" value="No" onChange = {this.CarInfo}/> No
                            </td>
                        </tr>
                         {this.state.carFlag && <HavingCar></HavingCar>}
                          {!this.state.carFlag && 
                          <div>
                            <label>Driver License No</label>
                            <input type="text" /> <br />
                          </div>}
                        </tbody>
                    </table>

                </form>
            </div>
        );
    }
}

export default DriverCar;