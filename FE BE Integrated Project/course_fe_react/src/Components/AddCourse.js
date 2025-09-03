import { Form, FormGroup, Input, Fragment } from 'reactstrap';
import { Container, Button  } from 'reactstrap';
import { useEffect, useState } from "react";
import base_url from "../api/bootapi.js";
import axios from "axios";
import { toast } from 'react-toastify';
const AddCourse = () => {
    useEffect(() => {
        document.title="Course"
    },[]);

    const[course, setCourse] = useState({});

    //form handler
    const handleForm = (e) => {
        console.log(course);
        postDataToServer(course);
        e.preventDefault();
    };

    //creating function to post data on server
    const postDataToServer=(data)=>{
        axios.post(`${base_url}/courses`, data).then(
            (response)=>{
                console.log(response);
                console.log("success");
                toast.success("Course added successfully");
            },
            (error) => {
                console.log(error);
                console.log("error");
                toast.error("Error! Something went wrong");
            }
        );
    };
    return (
        <div>
            <h1 className='text-center my-3'>Fill Course Details</h1>
            <Form onSubmit={handleForm}>
                <FormGroup>
                    <label for="userId">CourseId</label>
                    <Input
                        type='text'
                        placeholder='Enter here'
                        name='userId'
                        id='userId'
                        onChange={(e) => {
                            setCourse({...course, id: e.target.value});
                        }}
                    />
                </FormGroup>
                <FormGroup>
                    <label for="title">Course Title</label>
                    <Input type="text" placeholder="Enter title here" id="title"
                    onChange={(e) => {
                        setCourse({...course, title: e.target.value});
                    }}
                    />
                </FormGroup>
                <FormGroup>
                    <label for="description">Course Description</label>
                    <Input type="textarea" placeholder="Enter description here" id="description" style={{ height: 100 }} 
                    onChange={(e) => {
                        setCourse({...course, description: e.target.value});
                    }}
                    />
                </FormGroup>

                <Container className="text-center">
                    <Button type= "submit"color="success">Add Course</Button>
                    <Button type="reset" color="warning ml-2">Clear</Button>
                </Container>

            </Form>
        </div>
    );
};

export default AddCourse;