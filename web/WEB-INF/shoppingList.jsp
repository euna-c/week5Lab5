<%-- 
    Document   : shoppingList
    Created on : Oct 6, 2019, 5:08:08 AM
    Author     : 784564
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List Page</title>
    </head>

            
    <body>
        <h1>Shopping List</h1>

        <form action="" method="post">
            
            <h1>Hello ${username}</h1>
            <a href="shoppinglist?action=logout">Logout</a>
        </form>
        
        <br>
        <h3>List</h3>
        <br>
        <form action="shoppinglist" method="post">
            
            Add item: <input type="text" name="item">
            <input type="submit" name="action" value="add">

        <br>

       
            <%--${list} is the setAttribute of the itemlist == session attribute of arraylist--%>
                <c:forEach var="item" items="${list}"  varStatus="display">
                    
                <input type="radio" name="items" value="${display.count}"> 
                <%-- c:forEch variable named "item" will be printed out--%>
                ${item}<br>
                  
                </c:forEach>
           
            <input type="submit" name="action" value="delete">
        </form>
    </body>

    
</html>
