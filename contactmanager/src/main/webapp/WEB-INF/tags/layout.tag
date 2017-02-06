<%@tag description="Main Layout" pageEncoding="UTF-8"%>
<%@attribute name="title" fragment="true" %>
<!DOCTYPE html>
<html>
<head>
<title><jsp:invoke fragment="title"/></title>
<link rel="stylesheet" type="text/css" media="all" href="${pageContext.request.contextPath}/css/contactmanager.css" />
</head>

<body>
<jsp:doBody/>
</body>

</html>
