import axios from "axios";
import React, { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";

export default function ViewTask() {
    const [tasks, setTasks] = useState({
        userId: "",
        courseId: "",
        taskId: "",
        startDate: "",
        endDate: "",
        hoursPerDay: "",
    });

    const { userId } = useParams();

    useEffect(() => {
        loadTask();
    }, [userId]);

    const loadTask = async () => {
        const result = await axios.get(`http://localhost:8083/api/tasks/all/${userId}`);
        console.log(result);
        setTasks(result.data);
    };

    return (
        <div className="container">
            <div className="row">
                <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
                    <h2 className="text-center m-4">Task Details</h2>
                    {/* {tasks.map((task) => ( */}
                    <div className="card" key={tasks.taskId}>
                        <div className="card-header">
                            Details of Task with Id : {tasks.userId}
                            <ul className="list-group list-group-flush">
                                <li className="list-group-item">
                                    <b>User Id:</b>
                                    {tasks.userId}
                                </li>
                                <li className="list-group-item">
                                    <b>Course Id:</b>
                                    {tasks.courseId}
                                </li>
                                <li className="list-group-item">
                                    <b>Task Id:</b>
                                    {tasks.taskId}
                                </li>
                                <li className="list-group-item">
                                    <b>Start Date:</b>
                                    {tasks.startDate}
                                </li>
                                <li className="list-group-item">
                                    <b>End Date:</b>
                                    {tasks.endDate}
                                </li>
                                <li className="list-group-item">
                                    <b>Hour per Day:</b>
                                    {tasks.hoursPerDay}
                                </li>
                            </ul>
                        </div>
                    </div>
                    {/* ))} */}
                    <Link className="btn btn-primary my-2" to={"/Tasks"}>
                        Back to Tasks
                    </Link>
                </div>
            </div>
        </div>
    );
}