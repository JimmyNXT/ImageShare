import React from "react";
import { Link } from "react-router-dom";
import { removeCookie } from "../functions/cookieManager";
// import { i } from "bootstrap-icons";

const Nav = (props: { username: string; setHasJWT: Function }) => {
  let menu;

  if (!props.username) {
    menu = (
      <ul className="navbar-nav me-auto mb-2 mb-md-0">
        <li className="nav-item active">
          <Link className="nav-link" to="/login">
            Login
          </Link>
        </li>
        <li className="nav-item active">
          <Link className="nav-link" to="/register">
            Register
          </Link>
        </li>
      </ul>
    );
  } else {
    menu = (
      <ul className="navbar-nav me-auto mb-2 mb-md-0">
        <li className="nav-item active">
          <Link className="nav-link" to="/user">
            <svg
              xmlns="http://www.w3.org/2000/svg"
              width="26"
              height="16"
              fill="currentColor"
              className="bi bi-person-circle"
              viewBox="0 0 16 16"
            >
              <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z" />
              <path
                fill-rule="evenodd"
                d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"
              />
            </svg>
            {props.username}
          </Link>
        </li>
        <li className="nav-item active">
          <Link
            className="nav-link"
            to="/login"
            onClick={() => {
              props.setHasJWT(false);
              removeCookie("jwt");
            }}
          >
            Logout
          </Link>
        </li>
      </ul>
    );
  }

  return (
    <nav className="navbar navbar-expand-md navbar-dark bg-dark mb-4">
      <div className="container-fluid">
        <Link className="navbar-brand" to="/">
          Image Share
        </Link>

        <div>{menu}</div>
      </div>
    </nav>
  );
};

export default Nav;
