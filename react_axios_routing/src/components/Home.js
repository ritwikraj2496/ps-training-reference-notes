import React from "react";
import { Link, useNavigate } from "react-router-dom";

function Home() {
    const navigate = useNavigate();

    function goToAbout() {
        navigate("/about", {state: {id: 2, name: "ritwik"}});
    }   

  return (
    <div>
      <h1>I am Home page</h1>
      {/* <Link to="/contact">Contact</Link>
      <br />
      <Link to="/about">About</Link> */}

        <button onClick={goToAbout}>About</button>

    </div>
  );
}

export default Home;
