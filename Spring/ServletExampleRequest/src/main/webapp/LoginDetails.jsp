<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${10+20}
<%
String userName=(String)session.getAttribute("userName");
out.println("wrong user: "+userName);
%>
</body>
</html>