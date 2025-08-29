import "./App_dwitter.css";
import Dwitter from "./components/Dwitter.js";
import DwitterForm from "./components/DwitterForm.js";
import { useState, useEffect } from "react";
import axios from "axios";

export default function App_dwitter() {
  const [diwtters, setDwitters] = useState([]);
  const [count, setCount] = useState(0);

  useEffect(() => {
    axios
      .get("http://localhost:8080/api/dwitters")
      .then((response) => {
        console.log(response.data);
        setDwitters(response.data);
      })
      .catch();
  }, [count]);

  function handleRegisterSuccess() {
    setCount(count + 1);
  }

  function handleDeleteSuccess() {
    setCount(count - 1);
  }

  return (
    <div>
      <h1 className="top-title">Dwitter</h1>
      {diwtters.map((dwitter) => (
        <Dwitter
          image={dwitter.image}
          name={dwitter.name}
          id={dwitter.id}
          date={dwitter.sdate}
          message={dwitter.message}
          onSuccessDelete={handleDeleteSuccess}
        />
      ))}
      <DwitterForm onSuccess={handleRegisterSuccess} />
    </div>
  );
}
