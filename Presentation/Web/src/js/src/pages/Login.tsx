import React, { SyntheticEvent, useState } from "react";
import { Navigate } from "react-router";
import { setCookie } from "../functions/cookieManager";

const Login = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [redirect, setRedirect] = useState(false);

  const submit = async (e: SyntheticEvent) => {
    e.preventDefault();

    const response = await fetch(
      process.env.PUBLIC_URL + "/auth/authenticate",
      {
        method: "POST",
        credentials: "include",
        headers: {
          "Content-Type": "application/json",
          Accept: "application/json",
        },
        body: JSON.stringify({ username, password }),
      }
    );

    let data = await response.json();
    setCookie("jwt", "Bearer " + data.jwt);
    // document.cookie =
    //   "jwt=Bearer " +
    //   data.jwt +
    //   +";max-age=" +
    //   1000 * 60 * 60 * 10 +
    //   +";domail=" +
    //   process.env.PUBLIC_URL +
    //   ";path=/" +
    //   ";samesite=lax";

    setRedirect(true);
  };

  if (redirect) {
    return <Navigate to={"/"} />;
  }

  return (
    <form onSubmit={submit}>
      <h1 className="h3 mb-3 fw-normal">Please sign in</h1>

      <input
        type="username"
        className="form-control"
        placeholder="Username"
        required
        onChange={(e) => setUsername(e.target.value)}
      />
      <input
        type="password"
        className="form-control"
        placeholder="Password"
        required
        onChange={(e) => setPassword(e.target.value)}
      />

      <button className="w-100 btn btn-lg btn-primary" type="submit">
        Sign in
      </button>
    </form>
  );
};

export default Login;
