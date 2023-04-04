import { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'
import { useLocation } from 'react-router'
import { toast } from 'react-toastify'
import axios from 'axios'
import { useNavigate } from 'react-router'
import Navbar from '../../../components/Navebar'
import './index.css'
import Navbar3 from '../../../components/Navbar3'
const PriceList= () =>
{
    const navigate = useNavigate()
    const { state } = useLocation()
    const [priceList, setPriceList] = useState([])
    const getPrice = () => {
        const url = `http://localhost:8080/price/getAll`
        axios.get(url).then((response) => {
            const result = response.data
            if (result['status'] == 'success') {
                setPriceList(result['data'])
            } else {
              toast.error(result['error'])
            }
          })
        }
         //to call function to get list of flights
      useEffect(() => {
        getPrice()
        console.log('getting called')
      }, [])
         
    
     
return(
    <div className='tTitle'>
      <Navbar3></Navbar3>
  
<h1 className='tTi'>Ticket Price List</h1>
<div class="d-grid gap-2 d-md-flex justify-content-md-end">
  <button class="btn btn-warning me-md-2" type="button"
  onClick={() => {
    navigate('/addPrice')
  }}
  >Add price</button>
</div>
<br/>
<br/>
<div className='tTable'>
    <table class="table ">
  <thead>
    <tr>
      <th scope="col">Airline Name</th>
      <th scope="col">Source </th>
      <th scope="col">Destination</th>
      <th scope="col">BusinessClassPrice</th>
      <th scope="col">EconomyClassPrice</th>
      <th scope="col">FirstClassPrice</th>
      <th scope="col"><i>Update</i></th>
      </tr>
  </thead>
  <tbody>
    {priceList.map((price) => <tr> 
      <th scope="col">{price.airlineName}</th>
      <th scope="col">{price.source}</th>
      <th scope="col">{price.destination}</th>
      <th scope="col">{price.businessClassPrice}</th>
      <th scope="col">{price.economyClassPrice}</th>
      <th scope="col">{price.firstClassPrice}</th>

      <th scope="col"><button type="button" onClick={() => {
                navigate('/modifyprice', { state: { price: price } })
              }} className="btn btn-primary">Edit</button></th>
      
        
    </tr>)} 
    </tbody>
     </table>
     </div>
     </div>
)
}
export default PriceList