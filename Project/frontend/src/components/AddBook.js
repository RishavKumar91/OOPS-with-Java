import React, { useState } from "react";
import axios from "axios";

function AddBook() {
  const [book, setBook] = useState({
    title: "",
    author: "",
    quantity: ""
  });

  const handleChange = (e) => {
    setBook({ ...book, [e.target.name]: e.target.value });
  };

  const handleSubmit = () => {
    const fixedBook = {
      ...book,
      quantity: Number(book.quantity)
    };

    axios.post("http://localhost:8080/books", fixedBook)
      .then(() => {
        alert("Book Added");
        window.location.reload();
      });
  };

  return (
    <div className="card">
      <h2>Add Book</h2>
      <input name="title" placeholder="Title" onChange={handleChange} />
      <input name="author" placeholder="Author" onChange={handleChange} />
      <input name="quantity" placeholder="Quantity" onChange={handleChange} />
      <button onClick={handleSubmit}>Add</button>
    </div>
  );
}

export default AddBook;