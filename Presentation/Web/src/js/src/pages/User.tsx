import React, { SyntheticEvent, useState } from "react";
import { Navigate } from "react-router";
import { getCookie } from "../functions/cookieManager";

const User = (props: {
  propUsername: string;
  propEmail: string;
  forceUpdate: Function;
}) => {
  const [username, setUsername] = useState(props.propUsername);
  const [email, setEmail] = useState(props.propEmail);
  const [password, setPassword] = useState("");
  const [redirect, setRedirect] = useState(false);

  const submit = async (e: SyntheticEvent) => {
    e.preventDefault();

    const response = await fetch(process.env.PUBLIC_URL + "/api/user/update", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        Accept: "application/json",
        Authorisation: getCookie("jwt"),
      },
      body: JSON.stringify({ username, email, password }),
    });
  };

  if (redirect) {
    props.forceUpdate();
    return <Navigate to={"/"} />;
  }

  let formContent = (
    <form onSubmit={submit}>
      <label className="form-label">Username</label>
      <input
        type="username"
        className="form-control"
        placeholder="Username"
        required
        value={username}
        onChange={(e) => setUsername(e.target.value)}
      />

      <label className="form-label">Email</label>
      <input
        type="email"
        className="form-control"
        placeholder="name@example.com"
        required
        value={email}
        onChange={(e) => setEmail(e.target.value)}
      />
      <label className="form-label">Password</label>
      <input
        type="password"
        className="form-control"
        placeholder="Password"
        required
        onChange={(e) => setPassword(e.target.value)}
      />

      <button className="w-100 btn btn-lg btn-primary" type="submit">
        Update
      </button>
    </form>
  );
  return <div>{formContent}</div>;
};

export default User;
