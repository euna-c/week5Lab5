<%-- 
    Document   : register
    Created on : Oct 6, 2019, 5:07:44 AM
    Author     : 784564
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        
        <form action="shoppinglist" method="post">
            
            Username: <input type="text" name="username">
            <input type="submit" value="register" name="action"><br>
        ${message}
        </form>
        
    </body>
</html>
