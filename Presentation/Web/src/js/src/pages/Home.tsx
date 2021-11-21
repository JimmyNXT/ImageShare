import React from "react";

const Home = (props: { username: string }) => {
  return (
    <div>
      {props.username ? "Hey " + props.username : "You are not loged in"}
    </div>
  );
};
export default Home;
