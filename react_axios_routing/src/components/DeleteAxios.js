import React from "react";
import axios from "axios";
import { useState } from "react";

function DeleteAxios() {
  const data = { firstName: "", lastName: "" };
  const [inputData, setInputData] = useState(data);

  const handleData = (e) => {
    setInputData({ ...inputData, [e.target.name]: e.target.value });
  };

  const handleDelete = (e) => {
    e.preventDefault();
    axios
      .delete("https://jsonplaceholder.typicode.com/users/1")
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
      <button onClick={handleDelete}>Delete</button>
    </div>
  );
}

export default DeleteAxios;
