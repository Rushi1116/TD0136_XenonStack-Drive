import { BrowserRouter, Route, Routes, Link ,Redirect} from 'react-router-dom'
import { ToastContainer } from 'react-toastify'
import 'react-toastify/dist/ReactToastify.css'

import "../node_modules/bootstrap/dist/css/bootstrap.min.css"
import "../node_modules/bootstrap/dist/js/bootstrap.bundle"

import Signin from './pages/Signin';
import Signup from "./pages/Signup";
import Home from './pages/User/Home'

import FlightList from './pages/User/FlightList'
import BookFlight from './pages/User/BookFlight'
import Payment from './pages/User/Payment'
import Ticket from './pages/User/Ticket'
import ShowUpcomingBookings from './pages/User/ShowBookings/ShowUpcomingBookings'
import ShowCompletedBookings from './pages/User/ShowBookings/ShowCompletedBookings'
import ShowCancelledBookings from './pages/User/ShowBookings/ShowCancelledBookings'

import AdminProfile from './pages/Admin/Adminprofile';
import UserProfile from './pages/Admin/Userprofile';

import AddFlight from './pages/Admin/AddFlight';
import EditFlight from './pages/Admin/EditFlight';
import ModifyFlight from './pages/Admin/ModifyFlight';
import DeleteFlight from './pages/Admin/DeleteFlight';

import AdminDashbord from './pages/Admin/AdminDashbord';
// import UserDashbord from './pages/UserDashbord';

import AddRoute from './pages/Admin/AddRoute';
import EditRoute from './pages/Admin/EditRoute';
import ModifyRoute from './pages/Admin/ModifyRoute';

import AddPrice from './pages/Admin/AddPrice';
import PriceList from './pages/Admin/PriceList';
import ModifyPrice from './pages/Admin/ModifyPrice';

import Schedule from './pages/Admin/Schedule';
import EditSchedule from './pages/Admin/EditSchedule';
import ModifySchedule from './pages/Admin/ModifySchedule';

import Homepage from './pages/Homepage/Homepage'
import About from './pages/Homepage/About'
import Contact from './pages/Homepage/Contact'

const AuthorizeUser = () => {
  const loginStatus = sessionStorage['loginStatus']
  return loginStatus == '1' ? <Home /> : <Signin />
}

function App() {
  return (
    <div className="container">
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<AuthorizeUser />} />
          <Route path="/signin" element={<Signin />} />
          <Route path="/signup" element={<Signup />} />
          <Route path="/Home" element={<Home />} />
          <Route path="/FlightList" element={<FlightList />} />
          <Route path="/BookFlight" element={<BookFlight />} />
          <Route path="/Payment" element={<Payment />} />
          <Route path="/Ticket" element={<Ticket />} />

          <Route path="/upcomingBookings" element={<ShowUpcomingBookings />} />
          <Route path="/completedBookings" element={<ShowCompletedBookings />} />
          <Route path="/cancelledBookings" element={<ShowCancelledBookings />} />

          <Route path="/admin" element={<AdminDashbord/>} />

          <Route path="/addRoute" element={<AddRoute/>} />
          <Route path="/editRoute" element={<EditRoute/>}/>
          <Route path="/modifyroute" element={<ModifyRoute/>}/>

          <Route path="/admin/profile" element={<AdminProfile/>}/>
          <Route path="/user/profile" element={<UserProfile/>}/>

          <Route path="/addSchedule" element={<Schedule/>}/>
          <Route path="/modifyschedule" element={<ModifySchedule/>}/>
          <Route path="/editSchedule" element={<EditSchedule/>}/>

          <Route path="/addflight" element={<AddFlight/>}/>
          <Route path="/editflight" element={<EditFlight/>}/>
          <Route path="/modifyflight" element={<ModifyFlight/>}/>
          <Route path="/deleteflight" element={<DeleteFlight/>}/>

          <Route path="/addPrice" element={<AddPrice/>}/>
          <Route path="/priceList" element={<PriceList/>}/>
          <Route path="/modifyprice" element={<ModifyPrice/>}/>

          <Route path="/homepage" element={<Homepage></Homepage>}></Route>
          <Route path="/about" element={<About></About>}></Route>
          <Route path="/contact" element={<Contact></Contact>}></Route>

          {/*<Redirect path="/" ></Redirect>*/}
       
          
          
          
          
          

       
       
        </Routes>
      </BrowserRouter>
      <ToastContainer theme="colored" />
    </div>
  )
}

export default App