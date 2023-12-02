import React, { Component } from "react";
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
import AddCourse from "./Components/Courses/AddCourse";
import ViewCourse from "./Components/Courses/ViewCourse";
import EditCourse from "./Components/Courses/EditCourse";
import Courses from "./Components/Courses/Courses";
import Tasks from "./Components/Tasks/Tasks";
import ViewTask from "./Components/Tasks/ViewTask";


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
        <Route exact path="/courses" element={<Courses />} />
        <Route exact path="/addcourse" element={<AddCourse />} />
        <Route exact path="/editcourse/:courseId" element={<EditCourse />} />
        <Route exact path="/viewcourse/:courseId" element={<ViewCourse />} />
        <Route exact path="/tasks" element={<Tasks />} />
        <Route exact path="/viewtasks/:userId" element={<ViewTask />} />
        {/* <Route exact path="/addtask" element={<AddTask />} /> */}
      </Routes>

      <Footer />




    </div>
  );
}

export default App;