import React, { useEffect, useState } from "react";
import { getCookie } from "../../functions/cookieManager";

const Gallary = (props: { setAlbum: Function; forceUpdate: Function }) => {
  interface albumData {
    name: string;
    owner: string;
  }

  const [albums, setAlbums] = useState<[albumData]>();
  const [albumName, setAlbumName] = useState("");
  const [shouldUpdate, setShouldUpdate] = useState(false);

  let handleClick = (newAlbumName: string) => {
    props.setAlbum(newAlbumName);
  };

  let forceUpdate = () => {
    setShouldUpdate(!shouldUpdate);
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
      })();
    } else {
    }
  }, []);

  let handleAddItem = () => {
    (async () => {
      const response = await fetch(process.env.PUBLIC_URL + "/api/album", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
          Accept: "application/json",
          Authorisation: getCookie("jwt"),
        },
        body: JSON.stringify(albumName),
      });

      //   let data = await response.json();
      //   console.log(data);
      //   setAlbums(data);
      //   console.log(albums);
      props.forceUpdate();
    })();
  };

  let formData;
  if (albums) {
    formData = (
      <div>
        <div className="card">
          <div className="card-body">
            <input
              type="albumname"
              className="form-control"
              placeholder="Album Name"
              required
              onChange={(e) => setAlbumName(e.target.value)}
            />
            <button
              type="button"
              className="btn btn-primary"
              style={{ marginLeft: "auto", marginRight: "auto" }}
              onClick={handleAddItem}
            >
              Add Album
            </button>
          </div>
        </div>
        <div>
          {albums.map((a, index) => {
            console.log(index);
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
          })}
        </div>
      </div>
    );
  }

  return <div className="col">{formData}</div>;
};

export default Gallary;
