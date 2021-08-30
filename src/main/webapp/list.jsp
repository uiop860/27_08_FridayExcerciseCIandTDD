<%-- 
    Document   : liste
    Created on : 30-Aug-2021, 14:23:13
    Author     : olive
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Page</title>
    </head>
    <body>
        <h1>This is the list page!</h1>
        <c:forEach var="account" items="${accounts}">
            <p>${account.firstName}</p>
        </c:forEach>
    </body>
</html>
