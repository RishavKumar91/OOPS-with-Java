import React, { useEffect, useState } from "react";
import axios from "axios";

function BookList() {
  const [books, setBooks] = useState([]);

  useEffect(() => {
    axios.get("http://localhost:8080/books")
      .then(res => setBooks(res.data));
  }, []);

  return (
    <div className="card">
      <h2>Books</h2>

      <table>
        <thead>
          <tr>
            <th>Title</th>
            <th>Author</th>
            <th>Qty</th>
          </tr>
        </thead>
        <tbody>
          {books.map(b => (
            <tr key={b.id}>
              <td>{b.title}</td>
              <td>{b.author}</td>
              <td>{b.quantity}</td>
            </tr>
          ))}
        </tbody>
      </table>

    </div>
  );
}

export default BookList;