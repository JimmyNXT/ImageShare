import React, { useEffect } from "react";
import { getCookie } from "../functions/cookieManager";

const Home = () => {
  useEffect(() => {
    (async () => {
      const response = await fetch(process.env.PUBLIC_URL + "/api/user", {
        credentials: "include",
        headers: {
          "Content-Type": "application/json",
          Accept: "application/json",
          Authorisation: getCookie("jwt"),
        },
      });
      getCookie("jwt");

      let data = await response.json();
      console.log(data);
    })();
  });

  return <div>Home</div>;
};
export default Home;
