<%@page import="java.util.Date"%>
<html>
<body>
<h2>Hello World! + <%= new Date().toString() %></h2>

<% 
System.out.println("Hello on server");
for (int i = 0; i < 10; i++) {%>
	<h4>Hello again <%=i %></h4>
<%} %>
</body>
</html>
