import React, { useEffect, useState } from "react";
import Sidebar from "../components/Sidebar";
import { getCookie } from "../functions/cookieManager";
import Album from "./subpages/Album";
import Gallary from "./subpages/Gallary";

const Home = (props: { username: string }) => {
  const [album, setAlbum] = useState("");

  if (!props.username) return <div>You are not loged in</div>;

  let formData = (
    <div>
      <Gallary setAlbum={setAlbum} />
    </div>
  );

  if (album) {
    formData = (
      <div>
        <Album albumName={album} setAlbum={setAlbum} />
      </div>
    );
  }

  return <div>{formData}</div>;
};
export default Home;
