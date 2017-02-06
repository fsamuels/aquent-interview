<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:layout>
	<jsp:attribute name="title">Contact Manager</jsp:attribute>
    <jsp:body>
    	<h1>Contact Manager</h1>
    	<c:choose>
    		<c:when test="${empty contacts}">
    			<p>No results found</p>
    		</c:when>
    		<c:otherwise>
		    	<table>
		    		<tr>
			    		<th>First Name</th>
			    		<th>Last Name</th>
			    		<th>Email Address</th>
			    		<th>Actions</th>
			    	</tr>
			    	<c:forEach var="contact" items="${contacts}">
			    	<tr>
			    		<td>${contact.firstName}</td>
			    		<td>${contact.lastName}</td>
			    		<td>${contact.email}</td>
			    		<td>[<a href="edit/${contact.id}">Edit</a>]  [<a href="delete/${contact.id}">Delete</a>]</td>
			    	</tr>
			    	</c:forEach>
		    	</table>
    		</c:otherwise>
    	</c:choose>
    	<a href="create">Create Contact</a>
    </jsp:body>
</t:layout>