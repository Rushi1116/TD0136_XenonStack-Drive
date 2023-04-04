import './index.css'
import { Link } from 'react-router-dom'
import { useState } from 'react'
import { toast } from 'react-toastify'
import axios from 'axios'
import { useNavigate } from 'react-router'
import './index.css'
import Navbar1 from '../../../components/Navbar1'
import Navbar3 from '../../../components/Navbar3'

const AddRoute=()=>
{
    const [source, setSource] = useState('')
    const [destination, setDestination] = useState('')
  
    const navigate = useNavigate()

    const AddRoute = () => {
  
       if (source.length == 0) 
       {
        toast.warning('Please enter Source')
      } else if (destination.length == 0) {
        toast.warning('Please  enter destination')
      }  else {
        const body = {
            source,
            destination,
        }
  
        // url to call the api
        const url = `http://localhost:8080/route/add`
  
        // http method: post
        // body: contains the data to be sent to the API
        axios.post(url, body).then((response) => {
          // get the data from the response
          const result = response.data
          console.log(result)
          if (result['status'] == 'success') {
            toast.success('Route added Sucessfully')
            navigate('/editroute')
          } else {
            toast.error(result['error'])
          }
        })
      }
    }

    return (
      
        <div className='aRoute'>
          <Navbar3></Navbar3><br></br>
        <h1 className='Ar'>ADD NEW ROUTE</h1>
        <br></br>
  
        <div className="row">
          <div className="col"></div>
          <div className="col">
            <div className="form">
  
              <div className="mb-3">
                <label htmlFor="" className="label-control">
                  <h2>Enter <strong className='name'>Source</strong></h2>
                </label>
                <input
                  onChange={(e) => {
                    setSource(e.target.value)
                  }}
                  type="text"
                  className="form-control"
                />
              </div>
  
              <div className="mb-3">
                <label htmlFor="" className="label-control">
                 <h2> Enter <strong className='name'>Destination</strong></h2>
                </label>
                <input
                  onChange={(e) => {
                    setDestination(e.target.value)
                  }}
                  type="text"
                  className="form-control"
                />
              </div>
  
              <div className="mb-6" >
                
                <button onClick={AddRoute} className="btn btn-warning">
                  Add Route
                </button>
              </div>
            </div>
          </div>
          <div className="col"></div>
        </div>
      </div>
          

    )
}
export default AddRoute