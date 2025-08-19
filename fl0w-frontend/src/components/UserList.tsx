import React, { useState, useEffect } from 'react';
import type { User } from '../types/User';
import { userService } from '../services/userService';


// Component to display a list of users
const UserList: React.FC = () => {

    const [users, setUsers] = useState<User[]>([]);
    const [loading, setLoading] = useState<boolean>(true);
    const [error, setError] = useState<string | null>(null);

    useEffect(() => {

        // Fetch users from the API when component mounts, then set with captured data
        userService.getAllUsers().then((fetchedUsers) => {
            setUsers(fetchedUsers);
            console.log("Users fetched successfully: ", fetchedUsers);
            setLoading(false);

        }).catch((err) => {
            setError("Failed to fetch users: " + err.message);
            console.error("Error fetching users: ", err);
        
        }).finally(() => {
            console.log("User fetching process completed.")
            setLoading(false);
        });
    }, [])



    return (
        <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8 py-6">
            <h2 className="text-2xl font-bold mb-4">User List</h2>
            {loading && <p>Loading users...</p>}
            {error && <p className="text-red-500">{error}</p>}
            {!loading && !error && (
                <ul className="space-y-4">
                    {users.map(user => (

                        <li key={user.id} className="bg-white shadow rounded-lg p-4">
                            <h3 className="text-lg font-semibold">{user.firstName} + {user.lastName}</h3>

                        </li>
                    ))}
                </ul>
            )}
        </div>
    )




}

export default UserList;