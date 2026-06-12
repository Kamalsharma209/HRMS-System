import MainLayout from "../layouts/MainLayout";

function Employees() {
    return (
        <MainLayout>
            <h1>Employees</h1>

            <table border="1" cellPadding="10">
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Department</th>
                </tr>
                </thead>

                <tbody>
                <tr>
                    <td>Kamal</td>
                    <td>IT</td>
                </tr>

                <tr>
                    <td>Rahul</td>
                    <td>HR</td>
                </tr>
                </tbody>
            </table>
        </MainLayout>
    );
}

export default Employees;