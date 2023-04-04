import { useEffect, useState } from 'react'
import { toast } from 'react-toastify'
import axios from 'axios'
import { useNavigate } from 'react-router'
import { Link } from 'react-router-dom'
import './index.css'

const Ticket = () => {
  const { userId, passengerId, scheduleId, seatType, firstName } = sessionStorage
  const [ticketDetails, setticketDetails] = useState("")
  // const [userId, setUserID] = useState("")

  // setUserID(id)
  const navigate = useNavigate()
  const genrateTicket = () => {
    const body = {
      passengerId,
      scheduleId,
      userId,
      seatType
    }
    const url = `http://localhost:8080/after/pay`
    axios.post(url, body).then((response) => {

      const result = response.data
      console.log(result)
      if (result['status'] == 'success') {
        setticketDetails(result['data'])

      } else {
        toast.error(result['error'])
      }
    })
  }

  const logoutUser = () => {
    // remove the logged users details from session storage
    sessionStorage.removeItem('id')
    sessionStorage.removeItem('firstName')
    sessionStorage.removeItem('lastName')
    sessionStorage.removeItem('loginStatus')

    // navigate to sign in component
    navigate('/signin')
  }

  useEffect(() => {
    genrateTicket()
  }, [])

  return (

    <div className='ticket'>
      <div className="row">
        <div className="col">
          <div className="float-end">
            <div className="btn-group " role="group">
              <button
                id="btnGroupDrop1"
                type="button"
                className="btn btn-primary dropdown-toggle"
                data-bs-toggle="dropdown"
                aria-expanded="false"
              >
                Welcome {firstName}
              </button>
              <ul className="dropdown-menu" aria-labelledby="btnGroupDrop1">
                <li>
                  <Link to="/Profile" className="dropdown-item">
                    Profile
                  </Link>
                </li>
                <li>
                  <button onClick={() => {
                    navigate('/Home')
                  }} className="dropdown-item">Home
                  </button>
                </li>
                <li>
                  <button onClick={() => { navigate('/upcomingBookings') }} className="dropdown-item">
                    Upcoming Bookings
                  </button>
                </li>

                <li>
                  <button onClick={() => { navigate('/completedBookings') }} className="dropdown-item">
                    Completed Bookings
                  </button>
                </li>

                <li>
                  <button onClick={() => { navigate('/cancelledBookings') }} className="dropdown-item">
                    Cancelled Bookings
                  </button>
                </li>
                <li>
                  <button onClick={logoutUser} className="dropdown-item">
                    Logout
                  </button>
                </li>
              </ul>
            </div>
          </div>
        </div>
      </div>


      <br />
      <br />
      <h2 class="title">Ticket</h2><br></br>
      <div class="container-fluid" >
        <div class="row justify-content-around">
          
          <div class="col-4">
           <h3>Airline name : <strong><b> {ticketDetails.companyName}</b></strong></h3>
          </div>
          <div class="col-4">
          <h3>Flight id :  <strong><b>{ticketDetails.airlineName}</b></strong></h3>
          </div>
        </div>
        <br />
        <div class="row justify-content-around">
          <div class="col-4">
          <h3> From  : <b>{ticketDetails.source}</b></h3>
          </div>
          <div class="col-4">
          <h3>To  : <b>{ticketDetails.destination}</b></h3>
          </div>
        </div>
        

        <br />
        <div class="row justify-content-around">
          <div class="col-4">
          <h3>Date : <b>
            {ticketDetails.takeoffDate}</b></h3>
          </div>
          <div class="col-4">
          <h3> Time  :  <b>
            {ticketDetails.takeoffTime}</b></h3>
          </div>
        </div>
        <br />

        <div class="row justify-content-around">
          <div class="col-4">
          <h3>Passenger name : <b>
            {ticketDetails.passengerName}</b></h3>
          </div>
          <div class="col-4">
          <h3> Seat no :  <b> {ticketDetails.seatNo}</b> </h3>
          </div>
        </div>
        <br />


        <div class="row justify-content-around">
          <div class="col-4">
          <h3> Class  : <b>{seatType}</b></h3>
          </div>
          <div class="col-4">
          </div>
        </div>

        <div class="row justify-content-around">
          <div class="col-4">
          <h3> Ticket-ID  : <b>{seatType+"F51265"}</b></h3>

          </div>
          <div class="col-4">
          

          </div>
        </div>
        

      </div>

    </div>

  )
}

export default Ticket