import React from "react";

const Sidebar = () => {
  return (
    <div>
      <div className="col-3 order-2 col" id="sticky-sidebar">
        <div className="sticky-top">Sidebar</div>
      </div>
      <div id="main">Main Area</div>
    </div>
  );
};

export default Sidebar;
