<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="pl.jdomanski.util.Mappings" %>
<%@ page import="pl.jdomanski.util.AttributeNames" %>
<!DOCTYPE html>
<html>
<head>
    <title>Todo items</title>
</head>
<body>
    <div align="center">
        <table border="1" cellpadding="5">
    	       <tr>
    	           <td><label>ID</label></td>
    	           <td>${todoItem.id}</td>
    	       </tr>
    	       <tr>
    	           <td><label>Title</label></td>
    	           <td>${todoItem.title}</td>
    	       </tr>
    	       <tr>
    	           <td><label>Date</label></td>
    	           <td>${todoItem.deadline}</td>
    	       </tr>
    	       <tr>
    	           <td><label>Details</label></td>
    	           <td>${todoItem.details}</td>
    	       </tr>
    	   </table>
    	   <c:url var="itemsUrl" value="${Mappings.ITEMS}"/>
    	   <h2><a href="${itemsUrl}">Items list</a></h2>
    </div>    
</body>
</html>