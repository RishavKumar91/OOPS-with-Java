import React, { useState, useEffect } from "react";
import axios from "axios";

function IssueBook() {

  const [users, setUsers] = useState([]);
  const [books, setBooks] = useState([]);

  const [selectedUser, setSelectedUser] = useState("");
  const [selectedBook, setSelectedBook] = useState("");
  const [error, setError] = useState("");

  useEffect(() => {
    axios.get("http://localhost:8080/users")
      .then(res => setUsers(res.data))
      .catch(err => console.log(err));

    axios.get("http://localhost:8080/books")
      .then(res => setBooks(res.data))
      .catch(err => console.log(err));
  }, []);

  const issueBook = () => {

    setError("");

    if (!selectedUser || !selectedBook) {
      setError("Select user and book");
      return;
    }

    axios.post("http://localhost:8080/issue", {
      user: { id: selectedUser },
      book: { id: selectedBook }
    })
    .then(() => {
      alert("✅ Book Issued Successfully");
    })
    .catch(err => {

      console.log("FULL ERROR:", err);

      const msg =
        err.response?.data ||
        err.message ||
        "Something went wrong";

      setError(typeof msg === "string" ? msg : JSON.stringify(msg));
    });
  };

  return (
    <div style={{ padding: "20px" }}>
      <h2>Issue Book</h2>

      {error && <p style={{ color: "red" }}>{error}</p>}

      <select onChange={(e) => setSelectedUser(e.target.value)}>
        <option value="">Select User</option>
        {users.map(u => (
          <option key={u.id} value={u.id}>{u.name}</option>
        ))}
      </select>

      <br /><br />

      <select onChange={(e) => setSelectedBook(e.target.value)}>
        <option value="">Select Book</option>
        {books.map(b => (
          <option key={b.id} value={b.id}>
            {b.title} (Qty: {b.quantity})
          </option>
        ))}
      </select>

      <br /><br />

      <button onClick={issueBook}>Issue</button>
    </div>
  );
}

export default IssueBook;