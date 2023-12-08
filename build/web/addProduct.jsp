<%-- 
    Document   : addProduct
    Created on : 06-Jun-2023, 1:05:38 am
    Author     : raj94
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Products</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.0/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h2>Admin Products</h2>

        <!-- Add Product Form -->
        <div class="card">
            <div class="card-header">Add Product</div>
            <div class="card-body">
                <form action="add-product" method="post">
                    <div class="mb-3">
                        <label for="productName" class="form-label">Product Name</label>
                        <input type="text" class="form-control" id="prodName" name="prodName" placeholder="Enter Product Name" required>
                    </div>
                    <div class="mb-3">
                        <label for="productDescription" class="form-label">Product Description</label>
                        <textarea class="form-control" id="descp" name="descp" placeholder="Enter Product Description" required></textarea>
                    </div>
                    <div class="mb-3">
                        <label for="productPrice" class="form-label">Product Price</label>
                        <input type="number" class="form-control" id="price" name="price" placeholder="Enter Product Price" required>
                    </div>
                    <div class="mb-3">
                        <label for="productImage" class="form-label">Product Image</label>
                        <input type="text" class="form-control" id="image" name="image" placeholder="Enter Product Image Path" required>
                    </div>
                    <div class="mb-3">
                        <label for="productImage" class="form-label">Product Category</label>
                        <input type="text" class="form-control" id="category" name="category" placeholder="Enter Product Category" required>
                    </div>
                    <button type="submit" class="btn btn-primary">Add Product</button>
                </form>
            </div>
        </div>
            <% 
            String message = request.getParameter("message");
            if (message != null && !message.isEmpty()) {
        %>
        <div class="alert alert-info mt-3">
            <%= message %>
        </div>
        <% } %>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
</body>
</html>


