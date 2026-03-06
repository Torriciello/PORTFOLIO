import "./index.css";
import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import { BrowserRouter } from "react-router-dom";
import Login from "./pages/Login/Login.jsx";
import Register from "./pages/Register/Register.jsx";

createRoot(document.getElementById("root")).render(
  <StrictMode>
    <BrowserRouter>
      {/* {<Login />} */}
      {<Register />}
      {/* <Feed /> */}
      {/* {<BlogPost />} */}
    </BrowserRouter>
  </StrictMode>, 
);
