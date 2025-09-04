import React, { useState } from "react";
import axios from "axios";

function PostAxios() {
  const data = { firstName: "", lastName: "" };
  const [inputData, setInputData] = useState(data);

  const handleData = (e) => {
    setInputData({ ...inputData, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    axios
      .post("https://jsonplaceholder.typicode.com/users ", inputData)
      .then((response) => {
        console.log(response.data);
      });
  };

  return (
    <div>
      <label>First Name:</label>
      <input
        type="text"
        name="firstName"
        value={inputData.firstName}
        onChange={handleData}
      />
      <label>Last Name:</label>
      <input
        type="text"
        name="lastName"
        value={inputData.lastName}
        onChange={handleData}
      />
      <button onClick={handleSubmit}>Submit</button>
    </div>
  );
}

export default PostAxios;
