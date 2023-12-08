<%-- 
    Document   : userOperations
    Created on : 06-Jun-2023, 6:44:42 pm
    Author     : raj94
--%>

<%@page import="DataObj.UserObj"%>
<%@page import="java.util.List"%>
<%@page import="javaClasses.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Page</title>
    <!-- Tailwind CSS -->
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mx-auto">
        <h1 class="text-3xl font-bold my-4">Admin Page</h1>

        <table class="table-auto w-full">
            <thead>
                <tr>
                    <th class="px-4 py-2">ID</th>
                    <th class="px-4 py-2">Name</th>
                    <th class="px-4 py-2">Gender</th>
                    <th class="px-4 py-2">Address</th>
                    <th class="px-4 py-2">Contact</th>
                    <th class="px-4 py-2">Email</th>
                    <th class="px-4 py-2">Actions</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<User> userList = (List<User>) UserObj.selectAllUsers();

                    for (User user : userList) {
                %>
                <tr>
                    <td class="border px-4 py-2"><%= user.getUid() %></td>
                    <td class="border px-4 py-2"><%= user.getName() %></td>
                    <td class="border px-4 py-2"><%= user.getGender() %></td>
                    <td class="border px-4 py-2"><%= user.getAddress() %></td>
                    <td class="border px-4 py-2"><%= user.getContactNum() %></td>
                    <td class="border px-4 py-2"><%= user.getEmail() %></td>
                    <td class="border px-4 py-2">
                        <a class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded" href="editUser.jsp?id=<%= user.getUid() %>">Edit</a>
                        <a class="bg-red-500 hover:bg-red-700 text-white font-bold py-2 px-4 rounded" href="deleteUser?id=<%= user.getUid() %>">Delete</a>
                    </td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>

        <div class="w-full max-w-sm mx-auto">
            <h2 class="text-2xl font-bold my-4">Add User</h2>
            <form action="addUser" method="POST">
                <div class="flex flex-wrap -mx-3 mb-6">
                    <div class="w-full px-3">
                        <label for="id" class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2">ID:</label>
                        <input type="text" id="id" name="id" required
                            class="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500">
                    </div>
                </div>

                <div class="flex flex-wrap -mx-3 mb-6">
                    <div class="w-full px-3">
                        <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2">Gender:</label>
                        <div class="mt-2">
                            <label class="inline-flex items-center">
                                <input type="radio" class="form-radio" name="gender" value="Male" required>
                                <span class="ml-2">Male</span>
                            </label>
                            <label class="inline-flex items-center ml-6">
                                <input type="radio" class="form-radio" name="gender" value="Female" required>
                                <span class="ml-2">Female</span>
                            </label>
                            <label class="inline-flex items-center ml-6">
                                <input type="radio" class="form-radio" name="gender" value="Other" required>
                                <span class="ml-2">Other</span>
                            </label>
                        </div>
                    </div>
                </div>

                <div class="flex flex-wrap -mx-3 mb-6">
                    <div class="w-full px-3">
                        <label for="address" class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2">Address:</label>
                        <input type="text" id="address" name="address" required
                            class="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500">
                    </div>
                </div>

                <div class="flex flex-wrap -mx-3 mb-6">
                    <div class="w-full px-3">
                        <label for="contact" class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2">Contact:</label>
                        <input type="text" id="contact" name="contact" required
                            class="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500">
                    </div>
                </div>

                <div class="flex flex-wrap -mx-3 mb-6">
                    <div class="w-full px-3">
                        <label for="email" class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2">Email:</label>
                        <input type="email" id="email" name="email" required
                            class="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500">
                    </div>
                </div>

                <button type="submit"
                    class="bg-green-500 hover:bg-green-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline mx-auto block">
                    Add User
                </button>
            </form>
        </div>
    </div>

    <!-- Tailwind CSS -->
    <script src="https://cdn.tailwindcss.com/2.2.19/tailwind.min.js"></script>
</body>
</html>