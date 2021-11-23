import React, { useEffect, useState } from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";

import "./App.css";
import Nav from "./components/Nav";
import Sidebar from "./components/Sidebar";
import { getCookie } from "./functions/cookieManager";
import Home from "./pages/Home";
import Login from "./pages/Login";
import Register from "./pages/Register";
import User from "./pages/User";

function App() {
  const [username, setUsername] = useState("");
  const [email, setEmail] = useState("");
  const [hasJWT, setHasJWT] = useState(false);
  const [shouldUpdate, setShouldUpdate] = useState(true);

  let forceUpdate = () => {
    setShouldUpdate(!shouldUpdate);
  };

  useEffect(() => {
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
        setUsername(data.username);
        setEmail(data.email);
      })();
    } else {
      setUsername("");
      setEmail("");
    }
  });

  return (
    <BrowserRouter>
      <div className="App">
        <Nav
          username={username}
          setHasJWT={setHasJWT}
          forceUpdate={forceUpdate}
        />
        <div className="row py-3">
          <Sidebar />
          <main className="form-signin">
            <Routes>
              <Route path="/" element={<Home username={username} />} />
              <Route
                path="/login"
                element={
                  <Login propUsername={username} setHasJWT={setHasJWT} />
                }
              />
              <Route path="/register" element={<Register />} />
              <Route
                path="/user"
                element={
                  <User
                    propUsername={username}
                    propEmail={email}
                    forceUpdate={forceUpdate}
                  />
                }
              />
            </Routes>
          </main>
        </div>
      </div>
    </BrowserRouter>
  );
}

export default App;
