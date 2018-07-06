<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="pl.jdomanski.util.Mappings" %>
<!DOCTYPE html>
<html>
<head>
    <title>Todo items</title>
</head>
<body>
    <div align="center">
    <c:url var="addUrl" value="${Mappings.ADD_ITEM}"/>
    <h2><a href="${addUrl}">Add new item</a></h2>
        <table border="1" cellpadding="5">
            <caption><h2>Todo items </h2></caption>
            
            <tr>
                <th>Title</th>
                <th>Deadline</th>
                <th>Delete</th>
            </tr>
            
            <c:forEach var="item" items="${todoData.items}">
            
                <c:url var="deleteUrl" value="${Mappings.DELETE_ITEM}">
                    <c:param name="id" value = "${item.id}"/>
                </c:url>
                <tr>
                    <td><c:out value="${item.title}"/></td>
                    <td><c:out value="${item.deadline}"/></td>
                    <td><a href="${deleteUrl}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>    
</body>
</html>