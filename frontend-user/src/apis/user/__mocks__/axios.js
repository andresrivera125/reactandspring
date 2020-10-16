const get = (url) => {
    return Promise.resolve({
            data: [
                {
                    id: 1,
                    firstName: "Jhon",
                    lastName: "Ramírez",
                    email: "jramirez@gmail.com",
                },
                {
                    id: 2,
                    firstName: "Pedro",
                    lastName: "Pérez",
                    email: "pperez@gmail.com",
                },
            ]
    });
}

const axios = {
    get
};

export default axios;