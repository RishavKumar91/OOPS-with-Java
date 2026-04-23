import React, { useEffect, useState } from "react";
import axios from "axios";

function Dashboard() {
  const [books, setBooks] = useState([]);
  const [users, setUsers] = useState([]);

  useEffect(() => {
    axios.get("http://localhost:8080/books")
      .then(res => setBooks(res.data));

    axios.get("http://localhost:8080/users")
      .then(res => setUsers(res.data));
  }, []);

  return (
    <div className="grid">

      <div className="card">
        <h2>Total Books</h2>
        <h1>{books.length}</h1>
      </div>

      <div className="card">
        <h2>Total Users</h2>
        <h1>{users.length}</h1>
      </div>

    </div>
  );
}

export default Dashboard;