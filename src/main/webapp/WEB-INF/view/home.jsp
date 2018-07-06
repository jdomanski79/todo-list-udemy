<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="pl.jdomanski.util.Mappings" %>

<!DOCTYPE html>
<html>
<head>
    <title>Todo List Application</title>
</head>
<body>
    <div align="center">
        <c:url var="itemsLink" value="${Mappings.ITEMS}"/>        
        <h2><a href="${itemsLink}">Show items list</a></h2>
    </div>    
</body>
</html>