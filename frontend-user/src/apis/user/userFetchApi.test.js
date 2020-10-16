import userFetchApi from "./userFetchApi";

global.fetch = jest.fn(() => Promise.resolve({
    json: () => Promise.resolve({
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
    })
}));

test("Should return an array of two users", async () => {
    const response = await userFetchApi.get();
    const users = await response.json();

    if (expect(users) != null) {
        expect(users.length).toEqual(2);
        expect(users[0].id).toEqual(1);
        expect(users[0].firstName).toEqual("Jhon");
    }
});

