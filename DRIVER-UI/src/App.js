import React from 'react';

import './App.css';
import HomePage from './HomePage/HomePage.react';
import Navigation from './Navigation/Navigation.react';
import DriverTrip from './DriverTrip/DriverTrip.react';
import Dtrip from './Dtrip/Dtrip.react';
import DisplayPassengerInfo from './DisplayPassengerInfo/DisplayPassengerInfo.react';
import History from './History/History.react';
import DriverRegister from './DriverRegister/DriverRegister.react';

function App() {
  return (
    <div className="App">
      {/* <HomePage></HomePage>
      <Navigation></Navigation> */}
      {/* <DriverTrip></DriverTrip> */}
      {/* <Dtrip></Dtrip> */}
      {/* <DisplayPassengerInfo></DisplayPassengerInfo> */}
      {/*<History></History>*/}
       <DriverRegister></DriverRegister> 
    </div>

  );
}

export default App;
