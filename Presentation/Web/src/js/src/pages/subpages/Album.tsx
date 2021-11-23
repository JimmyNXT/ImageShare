import React, { useEffect, useState } from "react";
import { getCookie } from "../../functions/cookieManager";

const Album = (props: { albumName: string; setAlbum: Function }) => {
  const [images, setImages] = useState("");

  useEffect(() => {
    if (getCookie("jwt")) {
      (async () => {
        const response = await fetch(
          process.env.PUBLIC_URL + "/api/album/" + props.albumName,
          {
            method: "GET",
            headers: {
              "Content-Type": "application/json",
              Accept: "application/json",
              Authorisation: getCookie("jwt"),
            },
          }
        );

        let data = await response.json();
        console.log(data);
        setImages(data);
        console.log(images);
      })();
    } else {
    }
  }, []);
  return <div>test</div>;
};

export default Album;
