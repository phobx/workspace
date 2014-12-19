<h1>Multiplication Table</h1>
<%
	Cookie c = new Cookie("ccc", "WWW");
	response.addCookie(c);

	for (int i = 2; i < 10; i++) {
		for (int j = 2; j < 10; j++) {
			%>
			<%=i + " * " + j + " = " + (i * j) %><br/>
			<%
		}
		%>
		<br/>
		<%
	}
%>