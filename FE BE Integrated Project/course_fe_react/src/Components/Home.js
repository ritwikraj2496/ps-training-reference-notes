import {Jumbotron, Container, Button} from 'reactstrap';
import { useEffect, useState } from "react";
const Home=()=>{
    useEffect(() => {
        document.title="Home || A Simple Application"
    },[]);
    return(
        <div>
            <div class="jumbotron">
                <h1>Hello! Welcome Back</h1>
                <p>This is the Home Page of our Course Project, Keep adding new course and upskill</p>
            
            <Container>
                <Button color="primary">
                    Click Me!
                </Button>
            </Container>
            </div>
        </div>
    );
};

export default Home;