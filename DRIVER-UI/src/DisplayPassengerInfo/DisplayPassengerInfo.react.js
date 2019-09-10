import React from 'react';

import './DisplayPassengerInfo.css';

class DisplayPassengerInfo extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div className='displaypassengerinfo_wrapper'>
                   {/* <!-- Modal --> */}
                <div class="modal fade" id="myModal" role="dialog" style={{display: 'contents'}}>
                    <div class="modal-dialog">
                    
                    {/* <!-- Modal content--> */}
                    <div class="modal-content">
                        <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>
                        <div class="modal-body">
                        <p>Some text in the modal.</p>
                        </div>
                        <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>
                    
                    </div>
             </div>
            </div>
        );
    }
}

export default DisplayPassengerInfo;