import axios from "axios";
import React, { useEffect, useState } from "react";

function GetAxios() {
  //   useEffect(() => {
  //     fetch("https://jsonplaceholder.typicode.com/posts")
  //       .then((response) => response.json())
  //       .then((data) => console.log(data))
  //       .catch((error) => console.error("Error fetching data:", error));
  //   }, []);

  const [userData, setUserData] = useState([]);

  useEffect(() => {
    axios.get("https://jsonplaceholder.typicode.com/posts").then((response) => {
      console.log(response.data);
      setUserData(response.data);
    });
  },[]);

  return (
    <div>
      {userData.map((user) => (
        <div key={user.id}>
          <h3>{user.title}</h3>
          <p>{user.body}</p>
        </div>
      ))}
    </div>
  );
}

export default GetAxios;
