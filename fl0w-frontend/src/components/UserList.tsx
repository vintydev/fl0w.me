import React, { useState, useEffect } from 'react';
import type { User } from '../types/User';
import { userService } from '../services/userService';



const UserList: React.FC = () => {

    const [users, setUsers] = useState<User[]>([]);
    const [loading, setLoading] = useState<boolean>(true);
    const [error, setError] = useState<string | null>(null);

    // Fetch users when the component mounts
    useEffect(() => {

        
        userService.getAllUsers().then(() => {

            console.log("Users fetched successfully");
            setUsers(users);
            setLoading(false);

        }).catch((err) => {
            setError("Failed to fetch users: " + err.message);
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
                            <h3 className="text-lg font-semibold">{user.name}</h3>
                            <p>Email: {user.email}</p>
                            <p>Age: {user.age}</p>
                        </li>
                    ))}
                </ul>
            )}
        </div>
    )




}

export default UserList;