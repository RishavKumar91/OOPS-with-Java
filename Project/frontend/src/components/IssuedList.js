import React, { useEffect, useState } from "react";
import axios from "axios";

function IssuedList() {

  const [issues, setIssues] = useState([]);
  const [books, setBooks] = useState([]);
  const [users, setUsers] = useState([]);

  const user = JSON.parse(sessionStorage.getItem("user"));

  const loadData = () => {
    axios.get(`http://localhost:8080/issue/user/${user.id}`)
      .then(res => setIssues(res.data));

    axios.get(`http://localhost:8080/books`)
      .then(res => setBooks(res.data));

    axios.get(`http://localhost:8080/users`)
      .then(res => setUsers(res.data));
  };

  useEffect(() => {
    loadData();
  }, []);

  const getBookName = (id) => {
    const b = books.find(x => x.id === id);
    return b ? b.title : "Unknown";
  };

  const getUserName = (id) => {
    const u = users.find(x => x.id === id);
    return u ? u.name : "Unknown";
  };

  const returnBook = (id) => {
    axios.put(`http://localhost:8080/issue/return/${id}`)
      .then(() => {
        alert("Returned");
        loadData();   // 🔥 refresh data
      })
      .catch(() => alert("Error"));
  };

  return (
    <div className="card">
      <h2>Issued Books</h2>

      <table>
        <thead>
          <tr>
            <th>User</th>
            <th>Book</th>
            <th>Issue Date</th>
            <th>Return Date</th>
            <th>Status</th>
            <th>Action</th>
          </tr>
        </thead>

        <tbody>
          {issues.map(i => (
            <tr key={i.id}>
              <td>{getUserName(i.userId)}</td>
              <td>{getBookName(i.bookId)}</td>

              {/* 🔥 ISSUE DATE */}
              <td>{i.issueDate}</td>

              {/* 🔥 RETURN DATE */}
              <td>
                {i.returnDate ? i.returnDate : "--"}
              </td>

              <td>{i.returned ? "Returned" : "Active"}</td>

              <td>
                {!i.returned && (
                  <button onClick={() => returnBook(i.id)}>
                    Return
                  </button>
                )}
              </td>
            </tr>
          ))}
        </tbody>

      </table>
    </div>
  );
}

export default IssuedList;