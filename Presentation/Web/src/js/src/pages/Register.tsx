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

    // const response =
    await fetch(rootUrl + "/auth/register", {
      method: "POST",
      // mode: "no-cors",
      headers: {
        "Content-Type": "application/json",
        Accept: "application/json",
        // "Access-Control-Allow-Origin": "*",
      },
      body: JSON.stringify({ username, email, password }),
    });

    // const data = await response.json();

    // console.log("data");
    // console.log(JSON.stringify({ username, email, password }));
    // console.log(data);

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
