<html>
<body>
	<h3>Multiplication Table</h3>
	<%
		for(int i = 2; i <10; i++){
			for(int j = 2; j <10; j++){%>
			
				<%=(i + " x " + j + " = " + (j*i) + "\r\n") %></br>
			<%}%>
			</br>
			<% 
		}
	%>
</body>
</html>