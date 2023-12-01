import React from "react";
import { Link } from "react-router-dom";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Users from "../Users/Users";
import './Navbar.css';


const Navbar = () => {
    return (
        <div className="navbar">
            <div className="logo">Mentor Tracker</div>
            <div className="nav-items">
                <Link className="btn btn-secondary" to="/">Home</Link>
                <Link className="btn btn-secondary" to="/users" component={Users}>Users</Link>
                <Link className="btn btn-secondary" to="/courses">Courses</Link>
                <Link className="btn btn-secondary" to="/tasks">Tasks</Link>

                {/* <Routes>
          <Route>
          <Route  exact path="/" component={Home}/>
          <Route  path="/users" component={Users}/>
          <Route  path="/courses" component={Courses}/>
          <Route  path="/tasks" component={Task}/>
         </Route>
        </Routes> */}
            </div>
        </div>
    );
};

export default Navbar;