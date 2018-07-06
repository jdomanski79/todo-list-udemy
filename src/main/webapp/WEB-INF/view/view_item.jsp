<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="pl.jdomanski.util.Mappings" %>

<!DOCTYPE html>
<html>
<head>
    <title>View item</title>
</head>
<body>
    <div align="center">
    <h2>Item details</h2>
        <table border="1" cellpadding="5">
	       <tr>
	           <td><label>ID</label></td>
	           <td>
	               <c:out value= "${todoItem.id}"/>
	           </td>
	       </tr>
	       <tr>
	           <td><label>Title</label></td>
	           <td>
	               <c:out value = "${todoItem.title}"/>
	           </td>
	       </tr>
	       <tr>
	           <td><label>Date</label></td>
	           <td>
	               <c:out value="${todoItem.deadline}"/>
	           </td>
	       </tr>
	       <tr>
	           <td><label>Details</label></td>
	           <td>
	               <c:out value="${todoItem.details}"/>
	           </td>
	       </tr>
	   </table>
	   <c:url var="itemsUrl" value="${Mappings.ITEMS}"/>
	   <h2><a href="${itemsUrl}">Show item list</a></h2>
    </div>    
</body>
</html>