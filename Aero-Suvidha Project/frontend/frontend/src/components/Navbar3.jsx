import React from "react";
import { Link, NavLink } from "react-router-dom";
import './Nav.css'
import'./../../src/index'

const Navbar3 = () => {

    return (
        <>
            <div className="container-fluid nav_bg">
                <div className="row">
                    <div className="col-9 mx-auto">


                        <nav className="navbar navbar-expand-lg bg-light">
                            <div className="container-fluid">
                                <NavLink className="navbar-brand" to="/homepage">Aero-Suvidha</NavLink>
                                <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                                    <span className="navbar-toggler-icon"></span>
                                </button>
                                <div className="collapse navbar-collapse" id="navbarSupportedContent">
                                    <ul className="navbar-nav ml-auto mb-2 mb-lg-0 mr-24">
                                        <li className="nav-item">
                                            <NavLink activeClassName='menu_active' className="nav-link active" aria-current="page" to="/homepage">Home</NavLink>
                                        </li>
                                        <li className="nav-item">
                                            <NavLink activeClassName='menu_active' className="nav-link" to="/about">About Us</NavLink>
                                        </li>

                                        <li className="nav-item">
                                            <NavLink activeClassName='menu_active' className="nav-link" to="/contact">Contact</NavLink>
                                        </li>

                                        <li className="nav-item">
                                            <Link activeClassName='menu_active' className="nav-link" to="/signin">Log out</Link>
                                        </li>
                                    </ul>

                                </div>
                            </div>

                        </nav>
                    </div>
                </div>
            </div>
        </>
    )
}

export default Navbar3