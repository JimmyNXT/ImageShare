import React, { SyntheticEvent, useState } from "react";
import { Navigate } from "react-router-dom";

const Register = () => {
  const [username, setUsername] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [redirect, setRedirect] = useState(false);

  const submit = async (e: SyntheticEvent) => {
    e.preventDefault();

    let rootUrl = process.env.PUBLIC_URL;

    console.log("Root Url : " + rootUrl);

    await fetch(rootUrl + "/auth/register", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        Accept: "application/json",
      },
      body: JSON.stringify({ username, email, password }),
    });

    setRedirect(true);
  };

  if (redirect) {
    return <Navigate to={"/login"} />;
  }

  return (
    <form onSubmit={submit}>
      <h1 className="h3 mb-3 fw-normal">Please Register Here</h1>

      <input
        type="username"
        className="form-control"
        placeholder="Username"
        required
        onChange={(e) => setUsername(e.target.value)}
      />

      <input
        type="email"
        className="form-control"
        placeholder="name@example.com"
        required
        onChange={(e) => setEmail(e.target.value)}
      />
      <input
        type="password"
        className="form-control"
        placeholder="Password"
        required
        onChange={(e) => setPassword(e.target.value)}
      />

      <button className="w-100 btn btn-lg btn-primary" type="submit">
        Register
      </button>
    </form>
  );
};

export default Register;
