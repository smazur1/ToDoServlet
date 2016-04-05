<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>To Do Lists</h2>
	<form action="ToDoServlet" method="post">
		<p>
			<label for="username">Enter username:</label> 
				<input id="username" name="username" value="${param.username}">
				<input type="hidden" name="option" value="1">
				
				<input type="submit">
		</p>
	</form>


</body>
</html>