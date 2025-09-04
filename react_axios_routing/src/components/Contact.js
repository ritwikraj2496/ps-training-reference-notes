import React from "react";
import { Link } from "react-router-dom";

function Contact() {
  return (
    <div>
      <h1>I am Contact page</h1>
      <Link to="/">Home</Link>
      <br />
      <Link to="/about">About</Link>
    </div>
  );
}

export default Contact;
