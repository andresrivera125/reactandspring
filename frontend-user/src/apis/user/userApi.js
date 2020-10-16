import axios from "axios";

const API_ROOT = "localhost:8000/backend-users/users";

const get = () => {
    return axios.get(API_ROOT);
};

const userApi = {
    get
};

export default userApi;