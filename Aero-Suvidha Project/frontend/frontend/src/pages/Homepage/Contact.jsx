import React from "react";
import Navbar1 from "../../components/Navbar1";
import { MdOutlineContactPhone } from "react-icons/md";

const Contact =()=>{
    return(
        <>
        <div className="contact">
            <Navbar1></Navbar1>
           <br></br>
            <div id="sec">
                        <h3 style={{ paddingTop: "50px", paddingLeft: "500px" }}>Contact Us <MdOutlineContactPhone></MdOutlineContactPhone></h3>
                        <div style={{ padding: "30px 450px" }}>
                            <table className="table table-striped">
                                <tbody>
                                    <tr>
                                        <td><h4><b><i>Airline Management System</i></b></h4></td>
                                    </tr>
                                    <tr>
                                        <td><b>Address: Patna, Bihar</b></td>
                                    </tr>   
                                    <tr>
                                        <td>AeroSuvida Head office: Cdac Patna</td>
                                    </tr>
                                    <tr>
                                        <td>Head officer: Rushikesh Kalane</td>
                                    </tr>
                                    <tr>
                                        <td><b>Mobile: 021537892</b></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
        </div>
       
        
        </>
    )
}

export default Contact