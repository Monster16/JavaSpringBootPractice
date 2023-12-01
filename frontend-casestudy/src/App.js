import React from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import './App.css';
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import Navbar from './Components/Navbar/Navbar';
import Home from "./Components/Home/Home";
import Users from "./Components/Users/Users";
import AddUser from "./Components/Users/AddUser";
import EditUser from "./Components/Users/EditUser";
import ViewUser from "./Components/Users/ViewUser";
import Footer from "./Components/Footer/Footer";


function App() {
  return (
    <div className="App">
      <Navbar />
      <Routes>
        <Route exact path="/" element={<Home />} />
        <Route exact path="/users" element={<Users />} />
        <Route exact path="/adduser" element={<AddUser />} />
        <Route exact path="/edituser/:id" element={<EditUser />} />
        <Route exact path="/viewuser/:id" element={<ViewUser />} />
      </Routes>

      <Footer />




    </div>
  );
}

export default App;