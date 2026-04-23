import React, { useState } from "react";
import axios from "axios";
import BASE_URL from "../api";

function AddUser() {

  const [user, setUser] = useState({
    name: "",
    email: "",
    password: "",
    role: ""
  });

  const handleChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value });
  };

  const handleSubmit = () => {

    if(!user.name || !user.email || !user.password){
      alert("Fill all fields");
      return;
    }

    axios.post(`${BASE_URL}/users`, user)
      .then(() => {
        alert("User Added");
        window.location.reload();
      })
      .catch(() => alert("Error adding user"));
  };

  return (
    <div className="card">
      <h2>Add User</h2>

      <input
        name="name"
        placeholder="Name"
        onChange={handleChange}
      />

      <input
        name="email"
        placeholder="Email"
        onChange={handleChange}
      />

      <input
        name="password"
        placeholder="Password"
        type="password"
        onChange={handleChange}
      />

      <input
        name="role"
        placeholder="Role (ADMIN/USER)"
        onChange={handleChange}
      />

      <button onClick={handleSubmit}>Add User</button>
    </div>
  );
}

export default AddUser;