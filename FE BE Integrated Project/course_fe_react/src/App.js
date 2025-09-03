import './App.css';
import Header from './Components/Header.js';
import { Container, Row, Col, Button } from 'reactstrap';
import {ToastContainer, toast} from "react-toastify";
import 'react-toastify/dist/ReactToastify.css';
import Home from './Components/Home.js';
import Course from './Components/Course.js';
import AllCourses from './Components/AllCourses.js';
import AddCourse from './Components/AddCourse';
import Menus from './Components/Menus.js';
import {BrowserRouter as Router, Route, Routes}  from "react-router-dom";

function App() {

  const btnHandle=()=>{
    toast.error("done",{
      position:"top-center",
    });
  };

  return (
    
  <div>
  <Router>
    <ToastContainer/>
     <Container>
      <Header/>
      <Row>
        <Col md={4}>
          <Menus/>
        </Col>
        <Col md={8}>
          <Routes>
          <Route path='/' element={<Home/>} exact/>
          <Route path='/add-course' element={<AddCourse/>} exact/>
          <Route path='/view-courses' element={<AllCourses/>} exact/>
          </Routes>
        </Col>
      </Row>
     </Container>
  </Router>
    </div>
  );
}

export default App;
