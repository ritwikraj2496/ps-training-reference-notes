import { useEffect, useState } from "react";
import {Button} from "reactstrap";
import Course from "./Course.js";
import base_url from "../api/bootapi.js";
import axios from "axios";
import {toast} from "react-toastify";

const AllCourses=()=>{
    useEffect(() => {
        document.title="Courses"
    },[]);


    const getAllCoursesFromServer = () => {
        axios.get(`${base_url}/courses`).then(
            (response)=>{
                console.log(response.data);
                toast.success("courses has been loaded",{
                    position: "bottom-center",
                });
                setCourses(response.data);
            },
            (error)=>{
                console.log(error);
                toast.error("something went wrong");
            }
        );
    };

    useEffect(() => {
        getAllCoursesFromServer();
    }, [])

    const[courses, setCourses]=useState([
        // {title:"Java Course", description:"this is java Course"},
        // {title:"Django Course" ,description:"this is Django Course"},
        // {title:"PHP Course" ,description:"this is PHP Course"},
    ])

    const updateCourses = (id) => {
        setCourses(courses.filter((c) => c.id != id));
    }

    return(
        <div>
            {/* <Button onClick={() => {
                console.log("test");
                // courses.push({
                //     title:"PHP Course" ,
                //     description:"this is PHP Course"
                // });
                setCourses([...courses,{title:"PHP Course" ,description:"this is PHP Course"}]);
            }}> Test</Button> */}
            <h1>All Courses</h1>
            <p>List of courses are as follows:-</p>

            {
                courses.length>0 
                ? courses.map((item) => <Course key={item.id} course={item} update={updateCourses}/>) 
                : "No courses"
            }
        </div>
    )
}

export default AllCourses;