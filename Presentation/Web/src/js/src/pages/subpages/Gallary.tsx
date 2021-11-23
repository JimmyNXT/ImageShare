import React, { useEffect, useState } from "react";
import { getCookie } from "../../functions/cookieManager";

const Gallary = (props: { setAlbum: Function }) => {
  interface albumData {
    name: string;
    owner: string;
  }

  const [albums, setAlbums] = useState<[albumData]>();

  let handleClick = (newAlbumName: string) => {
    props.setAlbum(newAlbumName);
  };

  useEffect(() => {
    if (getCookie("jwt")) {
      (async () => {
        const response = await fetch(process.env.PUBLIC_URL + "/api/album", {
          method: "GET",
          headers: {
            "Content-Type": "application/json",
            Accept: "application/json",
            Authorisation: getCookie("jwt"),
          },
        });

        let data = await response.json();
        console.log(data);
        setAlbums(data);
        console.log(albums);
      })();
    } else {
    }
  }, []);

  let formData;
  if (albums) {
    formData = albums.map((a, index) => {
      console.log(a.name);
      return (
        <div
          className={"row-sm-12 row-md-4"}
          onDoubleClick={() => handleClick(a.name)}
        >
          <div className="card">
            <div className="card-body">
              <h5 className="card-title">{a.name}</h5>
            </div>
          </div>
        </div>
      );
    });
  }

  return <div className="col">{formData}</div>;
};

export default Gallary;
