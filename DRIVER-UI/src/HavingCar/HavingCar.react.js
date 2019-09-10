import React from 'react';

import './HavingCar.css';

class HavingCar extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div className='havingcar_wrapper'>
               <form>
                   <br /> <br />
                   <label>Car Type</label>
                   <select>
                    <option value="Mini">Mini</option>
                    <option value="Micro">Micro</option>
                    <option value="Sedan">Sedan</option>
                    <option value="SUV">SUV</option>
                    </select>
                    <br />

                   <label>Car Name</label>
                   <input type="text" /> <br />

                   <label>Car No</label>
                   <input type="" /> <br /> <br/>

                   <label>Driver License No</label>
                   <input type="" /> <br />

               </form>
            </div>
        );
    }
}

export default HavingCar;