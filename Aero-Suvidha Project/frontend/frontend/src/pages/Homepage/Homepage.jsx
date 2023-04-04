
import React from 'react'
import { NavLink } from 'react-router-dom'
import Navbar1 from '../../components/Navbar1'
import web from '../../images/img3.jpg'




const Homepage =()=>{
    return(
        <>
        <div className='main-container'>
        <Navbar1></Navbar1>
        <br></br>
        <br></br>
        <section id="header" className="display-flex align-items-center">
            <div className='container-fluid nav_bg'>
                <div className='row'>
                    <div className='col-10 mx-auto'>
                        <div className='row'>
                        <div >
                            <h1 className='header'>Welcome to <strong className='name'>AeroSuvidha</strong></h1>
                            <div className='row'>
                            <h4 style={{ paddingLeft: "10px" }}>"Its better to <b>See</b> something once than to <b>Hear</b> about it a hundred times"</h4></div>
                              <br></br><br></br><br></br>
                               <div className="mt-3">
                                <NavLink to="/signin" className="btn btn-success">Book Ticket Now</NavLink>
                               </div>
                        </div>

                       {/* <div className='col-lg-6 order-1 order-lg-2 header-img'>
                            <img src={web} className="img-fluid animated" alt="Image not found"></img>
    </div>*/}
                    </div>
                    </div>
                </div>
            </div>

        </section>
        </div>
       
        
        
        </>
    )
}

export default Homepage