<%-- 
    Document   : index
    Created on : Aug 29, 2021, 11:32:08 PM
    Author     : olive
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home page</title>
    </head>
    <body>
        <h1>Hello there bro!</h1>
        <a href="${pageContext.request.contextPath}/list">Se alle navne</a>
    </body>
</html>
