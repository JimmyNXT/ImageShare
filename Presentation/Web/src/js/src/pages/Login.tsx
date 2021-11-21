import { render } from "@testing-library/react";
import React, { SyntheticEvent, useState } from "react";
import { Navigate } from "react-router";
import { setCookie } from "../functions/cookieManager";

const Login = (props: { propUsername: string; setHasJWT: Function }) => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [redirect, setRedirect] = useState(false);

  const submit = async (e: SyntheticEvent) => {
    e.preventDefault();

    const response = await fetch(
      process.env.PUBLIC_URL + "/auth/authenticate",
      {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
          Accept: "application/json",
        },
        body: JSON.stringify({ username, password }),
      }
    );

    let data = await response.json();
    console.log(data);

    if (data.jwt) {
      setCookie("jwt", "Bearer " + data.jwt);
    }

    if (data.httpStatus === "BAD_REQUEST") {
      //TODO: Userfeedgack
      console.log("Title: " + data.title + ", Message: " + data.message);
    } else {
      props.setHasJWT(true);
      setRedirect(true);
    }
  };

  if (redirect) {
    return <Navigate to={"/"} />;
  }

  let formContent = (
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

  if (props.propUsername) {
    formContent = (
      <h1 className="h3 mb-3 fw-normal">
        You are currently logen in as {props.propUsername}
      </h1>
    );
  }

  return <div>{formContent}</div>;
};

export default Login;
