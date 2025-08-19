import apiService from "../services/apiService";

import type {User} from "../types/User";


/**
 * Service for communicating with the REST API for users
 */
export const userService = { 
    
    /**
     * Fetches all users from the API
     * @returns {Promise<User[]>} A promise that resolves to an array of User objects
     */
    getAllUsers: async () : Promise<User[]> => {

        console.log("Fetching all users from the API");
        const response = await apiService.get<User[]>("/users");
        console.log("Users fetched successfully:", response.data);
        return response.data;
    }

}