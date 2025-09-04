import React from "react";
import { Link, useLocation } from "react-router-dom";

function About() {
    const location = useLocation();
    console.log(location.state); // This will log the state passed from Home component
  return (
    <div>
      {/* <h1>I am About page, name is {location.state.name} and my id is {location.state.id}</h1> */}
      <Link to="/">Home</Link>
      <br />
      <Link to="/contact">Contact</Link>
    </div>
  );
}

export default About;
