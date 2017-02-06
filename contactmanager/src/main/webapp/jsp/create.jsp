<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<t:layout>
	<jsp:attribute name="title">${contactActionDisplay} Contact</jsp:attribute>
    <jsp:body>
    	<h1>${contactActionDisplay} Contact</h1>
    	<form:form method="POST" modelAttribute="contact" action="${pageContext.request.contextPath}/${formAction}">
    	<table>
    		<tr>
	    		<th><form:label path="firstName">First Name</form:label></th>
	    		<td><form:input path="firstName" maxlength="30" /><form:errors path="firstName" cssClass="error" /></td>
	    	</tr>
    		<tr>
	    		<th><form:label path="lastName">Last Name</form:label></th>
	    		<td><form:input path="lastName" maxlength="30" /><form:errors path="lastName" cssClass="error" /></td>
	    	</tr>
    		<tr>
	    		<th><form:label path="email">Email Address</form:label></th>
	    		<td><form:input path="email" maxlength="30" /><form:errors path="email" cssClass="error" /></td>
	    	</tr>
    		<tr>
	    		<th><form:label path="address1">Street Address</form:label></th>
	    		<td><form:input path="address1" maxlength="60" /><form:errors path="address1" cssClass="error" /></td>
	    	</tr>
    		<tr>
	    		<th><form:label path="city">City</form:label></th>
	    		<td><form:input path="city" maxlength="30" /><form:errors path="city" cssClass="error" /></td>
	    	</tr>
    		<tr>
	    		<th><form:label path="state">State</form:label></th>
	    		<td><form:input path="state" maxlength="2" /><form:errors path="state" cssClass="error" /></td>
	    	</tr>
    		<tr>
	    		<th><form:label path="zipCode">Zip Code</form:label></th>
	    		<td><form:input path="zipCode" maxlength="5" /><form:errors path="zipCode" cssClass="error" /></td>
	    	</tr>	    		    			    		    	    	
    	</table>
    	<form:hidden path="id" />
    	<input type="submit" value="${contactActionDisplay}" /> <a href="${pageContext.request.contextPath}/">Cancel</a>
    	</form:form>
    </jsp:body>
</t:layout>