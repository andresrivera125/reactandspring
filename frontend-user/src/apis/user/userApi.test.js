import userApi from "./userApi";

test("should return an array of users", async () => {
        const response = await userApi.get();
        const users = response.data;

        if (expect(users) != null) {
            expect(users.length).toEqual(2);
            expect(users[0].id).toEqual(1);
            expect(users[0].firstName).toEqual("Jhon");
        }
    }
);