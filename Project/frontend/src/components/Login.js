import React, { useState } from "react";
import axios from "axios";
import BASE_URL from "../api";

function Login({ setUser }) {

  const [data, setData] = useState({
    email: "",
    password: ""
  });

  const handleChange = (e) => {
    setData({ ...data, [e.target.name]: e.target.value });
  };

  const handleLogin = () => {

    if(!data.email || !data.password){
      alert("Enter email and password");
      return;
    }

    axios.post(`${BASE_URL}/users/login`, data)
      .then(res => {

        // 🔥 store in session (auto logout on refresh)
        sessionStorage.setItem("user", JSON.stringify(res.data));

        setUser(res.data);

      })
      .catch(err => {
        alert(err.response?.data?.error || "Login failed");
      });
  };

  return (
    <div className="card">
      <h2>Login</h2>

      <input
        name="email"
        placeholder="Email"
        onChange={handleChange}
      />

      <input
        name="password"
        type="password"
        placeholder="Password"
        onChange={handleChange}
      />

      <button onClick={handleLogin}>Login</button>
    </div>
  );
}

export default Login;