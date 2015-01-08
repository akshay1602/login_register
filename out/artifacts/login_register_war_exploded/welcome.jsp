
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1></h1>
<%
    String name = request.getParameter("username");
    out.println("<h1 >Welcome " + name +" </h1>");

%>
</body>
</html>
