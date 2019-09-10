import React from 'react';
import {Switch, Route} from 'react-router-dom';
import DriverRegister from '../DriverRegister/DriverRegister.react';
import DriverSettings from '../DriverSettings/DriverSettings.react';

class Navigation extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div >
                <Switch>
                    <Route exact path="/">Home</Route>
                    <Route path="/DriverRegister" component={DriverRegister}></Route>
                    <Route path="/DriverSettings" component={DriverSettings}></Route>
                </Switch>
            </div>
        );
    }
}

export default Navigation;