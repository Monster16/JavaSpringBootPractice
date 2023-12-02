import axios from "axios";
import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";

export default function AddCourse() {
    let navigate = useNavigate();

    const [courses, setCourses] = useState({
        courseId: "",
        courseName: "",
        courseTime: "",
    });

    const { courseId, courseName, courseTime } = courses;

    const onInputChange = (e) => {
        setCourses({ ...courses, [e.target.name]: e.target.value });
    };

    const onSubmit = async (e) => {
        e.preventDefault();
        await axios.post(`http://localhost:8082/api/courses/add`, courses);
        navigate("/courses");
    };

    return (

        <div className="container">
            <div className="row">
                <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
                    <h2 className="text-center m-4">Add Course</h2>

                    <form onSubmit={(e) => onSubmit(e)}>
                        <div className="mb-3">
                            {/* <label htmlFor="CourseId" className="form-label">
                Course Id
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter Course Id"
                name="courseId"
                value={courseId}
                onChange={(e) => onInputChange(e)}
              /> */}
                        </div>
                        <div className="mb-3">
                            <label htmlFor="CourseName" className="form-label">
                                Course Name
                            </label>
                            <input
                                type={"text"}
                                className="form-control"
                                placeholder="Enter Course Name"
                                name="courseName"
                                value={courseName}
                                onChange={(e) => onInputChange(e)}
                            />
                        </div>
                        <div className="mb-3">
                            <label htmlFor="CourseTime" className="form-label">
                                Course Time
                            </label>
                            <input
                                type={"text"}
                                className="form-control"
                                placeholder="Enter Course Time"
                                name="courseTime"
                                value={courseTime}
                                onChange={(e) => onInputChange(e)}
                            />
                        </div>
                        <button type="submit" className="btn btn-outline-primary">
                            Submit
                        </button>
                        <Link className="btn btn-outline-danger mx-2" to="/">
                            Cancel
                        </Link>
                    </form>
                </div>
            </div>
        </div>
    );
}