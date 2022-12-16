import React from 'react';
import {useParams} from 'react-router-dom';
const PathEntry = (props) => {
    const {entry, colorText, bgColor} = useParams();
    return(
        <>
            <div>
                {
                    isNaN(entry)?
                    <div style={
                        colorText?
                        {color: colorText, backgroundColor: bgColor, height: "auto", width: "auto", border: "2px solid grey"}
                        :null
                    }>
                        This is a word: {entry}
                    </div>
                    : <p>
                        This is a number: {entry}
                    </p>
                }
            </div>
        </>
    )
};
export default PathEntry;