import { useNavigate } from 'react-router'
import Navbar1 from '../../../components/Navbar1'
import Navbar from '../../../components/Navebar'
import './index.css'

import { FaUserPlus } from "react-icons/fa";
import { SiAddthis } from "react-icons/si";
import { GiPriceTag } from "react-icons/gi";
import { BsCheck2All } from "react-icons/bs";
import { FaRoute } from "react-icons/fa";
import { BiEdit } from "react-icons/bi";
import { MdOutlinePriceChange } from "react-icons/md";
import { GrSchedule } from "react-icons/gr";
import { TbHandClick } from "react-icons/tb";
import { MdFlight } from "react-icons/md";

const AdminDashbord = () => {
    const navigate = useNavigate()
    const { id, firstName, lastName } = sessionStorage

    const toAddFlight = () => {
        navigate('/addFlight')
    }
    const toAddRoute = () => {
        navigate('/addRoute')
    }
    const scheduleFlight = () => {
        navigate('/addSchedule')
    }
    const toViewFlight = () => {
        navigate('/editflight')
    }
    const toViewRoute = () => {
        navigate('/editRoute')
    }
    const toViewSchedule = () => {
        navigate('/editSchedule')
    }
    const toSetPrice = () => {
        navigate('/addPrice')
    }
    const toViewPrice = () => {
        navigate('/priceList')
    }

    return (
        <div className='aD'>
            <br></br>
            <Navbar1></Navbar1>
            <br></br>
            <h1>Hello {firstName} Welcome to admin page</h1>

            <div className="container">
                <div class="row">
                    <div class="col">
                        <table class="table ">
                            <thead>
                                <tr>
                                    <th scope="col">Sr No</th>
                                    <th scope="col" align='center'>Description</th>
                                    <th scope='col'>Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <th scope="row">1</th>
                                    <td>Add Flight &nbsp; &nbsp;<SiAddthis></SiAddthis> &nbsp;<MdFlight></MdFlight></td>
                                    <td>
                                        <button onClick={toAddFlight} type="button" class="btn btn-success" ><i className="fas fa-edit"></i><i>Click Here <TbHandClick></TbHandClick></i></button>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">2</th>
                                    <td>Set Price for the Flight &nbsp; &nbsp; <GiPriceTag></GiPriceTag></td>
                                    <td>
                                        <button onClick={toSetPrice} type="button" class="btn btn-success" ><i class="fas fa-edit"></i><i>Click Here <TbHandClick></TbHandClick></i></button>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">3</th>
                                    <td>View All Flights &nbsp; &nbsp; <BsCheck2All></BsCheck2All></td>
                                    <td>
                                        <button onClick={toViewFlight} type="button" class="btn btn-success"><i>Click Here <TbHandClick></TbHandClick></i></button>
                                    </td>
                                </tr>

                                <tr>
                                    <th scope="row">4</th>
                                    <td>Add New Route  &nbsp; &nbsp; <FaRoute></FaRoute></td>
                                    <td>
                                        <button onClick={toAddRoute} type="button" class="btn btn-success"><i>Click Here <TbHandClick></TbHandClick></i></button>
                                    </td>
                                </tr>

                                <tr>
                                    <th scope="row">5</th>
                                    <td>View and Edit Schedule  &nbsp; &nbsp;<BiEdit></BiEdit></td>
                                    <td>
                                        <button onClick={toViewRoute} type="button" class="btn btn-success"><i>Click Here <TbHandClick></TbHandClick></i></button>
                                    </td>
                                </tr>

                                <tr>
                                    <th scope="row">6</th>
                                    <td>View Price Details  &nbsp; &nbsp;<MdOutlinePriceChange></MdOutlinePriceChange></td>
                                    <td>
                                        <button onClick={toViewPrice} type="button" class="btn btn-success"><i>Click Here <TbHandClick></TbHandClick></i></button>
                                    </td>
                                </tr>

                                <tr>
                                    <th scope="row">7</th>
                                    <td>Schedule Flight  &nbsp; &nbsp; <GrSchedule></GrSchedule></td>
                                    <td>
                                        <button onClick={scheduleFlight} type="button" class="btn btn-success"><i>Click Here <TbHandClick></TbHandClick></i></button>
                                    </td>
                                </tr>

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>











            {/*
<table class="table" border="2" cellPadding={2}>
    <tr>
        <td scope='col'>Add New Flight</td>
        <td scope='col'><button onClick={toAddFlight} type="button" class="btn btn-success">add new flight</button></td>
    </tr>

    <tr>
    <td scope='col'>Set Price</td>
    <td scope='col'><button onClick={toSetPrice} type="button" class="btn btn-info">SetPrice</button></td>
    </tr>



    </table>
*/}
            {/*<div className="row">
      <div className="col">
          <br></br>
          <br></br>
          <br></br>

      <button onClick={toAddFlight} type="button" class="btn btn-info">add new flight</button>
      <br></br>
      <br></br>
          <br></br>
          <br></br>
          <button onClick={toSetPrice} type="button" class="btn btn-info">SetPrice</button>
      <br></br>
      <br></br>
          <br></br>
          <br></br>
          <button onClick={toViewFlight} type="button" class="btn btn-info">view and edit flights</button>
          
      </div>
      <div className="col">
      <br></br> <br></br>  <br></br>
        
      <button onClick={toAddRoute} type="button" class="btn btn-info">add new Route</button>
      <br></br>
      <br></br>
          <br></br>
          <br></br>
          <button onClick={toViewRoute} type="button" class="btn btn-info">view and edit Route</button>
          <br></br>
      <br></br>
          <br></br>
          <br></br>
          <button onClick={toViewPrice} type="button" class="btn btn-info">view Price Details</button>
      </div>
      <div className="col">
      <br></br> <br></br>  <br></br>
        
      <button onClick={scheduleFlight} type="button" class="btn btn-info">Schedule Flight</button>
      <br></br>
      <br></br>
          <br></br>
          <br></br>
          <button onClick={toViewSchedule} type="button" class="btn btn-info">view and edit Schedule</button>
      </div>
   
      
    </div>
    */}
        </div>
    )
}
export default AdminDashbord