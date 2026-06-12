import api from "./api";

export const getEmployees = () => {
    return api.get("/employees");
};