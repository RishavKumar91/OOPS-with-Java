import React, { useState } from "react";
import "./App.css";

import Login from "./components/Login";
import BookList from "./components/BookList";
import AddUser from "./components/AddUser";
import IssueBook from "./components/IssueBook";
import IssuedList from "./components/IssuedList";

function App() {

  // 🔥 SESSION LOGIN
  const [user, setUser] = useState(
    JSON.parse(sessionStorage.getItem("user"))
  );

  const [page, setPage] = useState("books");

  // 🔥 अगर login नहीं है → login page दिखाओ
  if (!user) {
    return <Login setUser={setUser} />;
  }

  // 🔥 logout function
  const handleLogout = () => {
    sessionStorage.clear();
    window.location.reload();
  };

  return (
    <div className="layout">

      {/* 🔥 SIDEBAR */}
      <div className="sidebar">
        <h2>📚 Library</h2>

        <p onClick={() => setPage("books")}>Books</p>
        <p onClick={() => setPage("users")}>Users</p>
        <p onClick={() => setPage("issue")}>Issue</p>
        <p onClick={() => setPage("issued")}>Issued</p>

        <hr />

        <button onClick={handleLogout}>Logout</button>
      </div>

      {/* 🔥 MAIN */}
      <div className="main">

        <div className="navbar">
          Welcome {user.name}
        </div>

        <div className="container">

          {page === "books" && <BookList />}
          {page === "users" && <AddUser />}
          {page === "issue" && <IssueBook />}
          {page === "issued" && <IssuedList />}

        </div>
      </div>

    </div>
  );
}

export default App;