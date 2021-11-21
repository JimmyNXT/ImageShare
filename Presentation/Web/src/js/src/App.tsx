import React, { useEffect, useState } from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";

import "./App.css";
import Nav from "./components/Nav";
import { getCookie } from "./functions/cookieManager";
import Home from "./pages/Home";
import Login from "./pages/Login";
import Register from "./pages/Register";

function App() {
  const [username, setUsername] = useState("");
  const [hasJWT, setHasJWT] = useState(false);

  useEffect(() => {
    console.log("Test");
    if (getCookie("jwt")) {
      (async () => {
        const response = await fetch(process.env.PUBLIC_URL + "/api/user", {
          headers: {
            "Content-Type": "application/json",
            Accept: "application/json",
            Authorisation: getCookie("jwt"),
          },
        });

        let data = await response.json();
        console.log(data);
        setUsername(data.username);
      })();
    }
  });

  return (
    <BrowserRouter>
      <div className="App">
        <Nav username={username} setHasJWT={setHasJWT} />
        <main className="form-signin">
          <Routes>
            <Route path="/" element={<Home username={username} />} />
            <Route
              path="/login"
              element={<Login propUsername={username} setHasJWT={setHasJWT} />}
            />
            <Route path="/register" element={<Register />} />
          </Routes>
        </main>
      </div>
    </BrowserRouter>
  );
}

export default App;
