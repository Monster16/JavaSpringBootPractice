import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import axios from "axios";


function Tasks() {

    const [tasks, setTasks] = useState([])

    useEffect(() => {
        loadTasks();
    }, [])

    const loadTasks = async () => {
        const results = await axios.get(`http://localhost:8083/api/tasks/all`);
        console.log(results.data);
        setTasks(results.data);
    }

    const deleteTask = async (taskId) => {
        await axios.delete(`http://localhost:8083/api/tasks/delete/${taskId}`);
        loadTasks();
    };

    return (

        <div classNameName='container'>
            {/* margin top */}
            <div classNameName='py-20'>
                <table className="table border shadow" >
                    <thead>
                        <tr>
                            <th scope="col">Sr. No.</th>
                            <th scope="col">User Id</th>
                            <th scope="col">Course Id</th>
                            <th scope="col">Task Id</th>
                            <th scope="col">Start Date</th>
                            <th scope='col'>End Date</th>
                            <th scope='col'>Hours Per Day</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            tasks.map((tasks, index) => (
                                <tr>
                                    <th scope="row" key={index}>{index + 1}</th>
                                    <td>{tasks.userId}</td>
                                    <td>{tasks.courseId}</td>
                                    <td>{tasks.taskId}</td>
                                    <td>{tasks.startDate}</td>
                                    <td>{tasks.endDate}</td>
                                    <td>{tasks.hoursPerDay}</td>
                                    <td>
                                        <Link
                                            className="btn btn-primary mx-2" to={`/viewtask/${tasks.taskId}`}>
                                            View
                                        </Link>
                                        <Link
                                            className="btn btn-outline-primary mx-2"
                                            to={`/edittask/${tasks.taskId}`}
                                        >
                                            Edit
                                        </Link>
                                        <button
                                            className="btn btn-danger mx-2"
                                            onClick={() => deleteTask(tasks.taskId)}
                                        >
                                            Delete
                                        </button>
                                    </td>
                                </tr>
                            ))

                        }
                    </tbody>
                </table>
                <Link className="btn btn-warning" to="/addtask">Add Task</Link>
            </div>
        </div>

    )
}

export default Tasks