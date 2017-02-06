<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<t:layout>
	<jsp:attribute name="title">Delete Contact</jsp:attribute>
    <jsp:body>
    	<form:form method="POST" modelAttribute="contact" action="${pageContext.request.contextPath}/delete/${contact.id}">
		
			<p>You are about to delete the person: ${contact.firstName} ${contact.lastName}, are you sure?</p>
    	
    		<input type="submit" value="Delete" /> <a href="${pageContext.request.contextPath}/">Cancel</a>
    	
    	</form:form>
    </jsp:body>
</t:layout>