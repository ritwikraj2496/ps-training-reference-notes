import React from 'react'
import { useParams } from 'react-router-dom';

function UserProfile() {
    const {username} = useParams();
  return (
    <div>
      <h2>User Profile Page</h2>
      <p>Welcome, <strong>{username}</strong></p>
    </div>
  )
}

export default UserProfile
