import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import axios from "axios";



function User() {

    const [users, setUsers] = useState([])

    useEffect(() => {
        loadUsers();
    }, [])

    const loadUsers = async () => {
        const results = await axios.get("http://localhost:8080/api/users/all")
        // console.log(results.data);
        setUsers(results.data);
    }

    const deleteUser = async (id) => {
        await axios.delete(`http://localhost:8080/api/users/delete/${id}`);
        loadUsers();
    };

    return (

        <div classNameName='container'>
            {/* margin top */}
            <div classNameName='py-20'>
                <table className="table border shadow" >
                    <thead>
                        <tr>
                            <th scope="col">No.</th>
                            <th scope="col">Name</th>
                            <th scope="col">Email</th>
                            <th scope="col">User Role</th>
                            <th scope='col'>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            users.map((users, index) => (
                                <tr>
                                    <th scope="row" key={index}>{index + 1}</th>
                                    <td>{users.name}</td>
                                    <td>{users.email}</td>
                                    <td>{users.userRole}</td>
                                    <td>
                                        <Link
                                            className="btn btn-primary mx-2" to={`/viewuser/${users.id}`}>
                                            View
                                        </Link>
                                        <Link
                                            className="btn btn-outline-primary mx-2"
                                            to={`/edituser/${users.id}`}
                                        >
                                            Edit
                                        </Link>
                                        <button
                                            className="btn btn-danger mx-2"
                                            onClick={() => deleteUser(users.id)}
                                        >
                                            Delete
                                        </button>
                                    </td>
                                </tr>
                            ))

                        }
                    </tbody>
                </table>
                <Link className="btn btn-success" to="/adduser">Add User</Link>
            </div>
        </div>

    )
}

export default User