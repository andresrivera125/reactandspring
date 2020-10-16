const API_ROOT = "localhost:8000/backend-users/users";

const get = () => {
    return fetch(API_ROOT);
}

const userFetchApi = {
    get
}

export default userFetchApi;