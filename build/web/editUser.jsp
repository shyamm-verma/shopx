<%-- 
    Document   : editUer
    Created on : 06-Jun-2023, 7:03:19 pm
    Author     : raj94
--%>

<%@page import="javaClasses.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
User user = new User();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit User</title>
    <!-- Tailwind CSS -->
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mx-auto">
        <h1 class="text-3xl font-bold my-4">Edit User</h1>

        <div class="w-full max-w-sm mx-auto">
            <form action="updateUser" method="POST">
                <input type="hidden" name="id" value="<%= request.getParameter("id") %>">

                <div class="flex flex-wrap -mx-3 mb-6">
                    <div class="w-full px-3">
                        <label for="name" class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2">Name:</label>
                        <input type="text" id="name" name="name" value="<%= user.getName() %>" required
                            class="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500">
                    </div>
                </div>

<!--                <div class="flex flex-wrap -mx-3 mb-6">
                    <div class="w-full px-3">
                        <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2">Gender:</label>
                        <div class="mt-2">
                            <label class="inline-flex items-center">
                                                        <input type="radio" class="form-radio" name="gender" value="Male" required>
                                <span class="ml-2">Male</span>
                            </label>
                            <label class="inline-flex items-center ml-6">
                                <input type="radio" class="form-radio" name="gender" value="Female"  required>
                                <span class="ml-2">Female</span>
                            </label>
                            <label class="inline-flex items-center ml-6">
                                <input type="radio" class="form-radio" name="gender" value="Other"  required>
                                <span class="ml-2">Other</span>
                            </label>
                        </div>
                    </div>
                </div>-->

                <div class="flex flex-wrap -mx-3 mb-6">
                    <div class="w-full px-3">
                        <label for="address" class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2">Address:</label>
                        <input type="text" id="address" name="address" value="<%= user.getAddress() %>" required
                            class="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500">
                    </div>
                </div>

                <div class="flex flex-wrap -mx-3 mb-6">
                    <div class="w-full px-3">
                        <label for="contact" class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2">Contact:</label>
                        <input type="text" id="contact" name="contact" value="<%= user.getContactNum() %>" required
                            class="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500">
                    </div>
                </div>

                <div class="flex flex-wrap -mx-3 mb-6">
                    <div class="w-full px-3">
                        <label for="email" class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2">Email:</label>
                        <input type="email" id="email" name="email" value="<%= user.getEmail() %>" required readonly
                            class="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500">
                    </div>
                </div>

                <button type="submit"
                    class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline mx-auto block">
                    Update User
                </button>
            </form>
        </div>
    </div>

    <!-- Tailwind CSS -->
    <script src="https://cdn.tailwindcss.com/2.2.19/tailwind.min.js"></script>
</body>
</html>



