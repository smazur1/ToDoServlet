<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>To Do List</title>
</head>


<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

th, td {
	padding: 15px;
}

th {
	text-align: left;
}
</style>
</head>
<body>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<table style="width: 100%">
		<tr>
			<th>User ID</th>
			<th>To Do ID</th>
			<th>Type</th>
			<th>Description</th>
			<th>Status ID</th>
			<th>Status Date</th>
			<th>Due Date</th>
			<th>Priority</th>
		</tr>
		<c:forEach var="item" items="${todolist}">
			<tr>
				<td><c:out value="${item.todouser.userid }" /></td>
				<td><c:out value="${item.todoid }" /></td>
				<td><c:out value="${item.todotype }" /></td>
				<td><c:out value="${item.tododesc }" /></td>
				<td><c:out value="${item.todostatus.statusid }" /></td>
				<td><c:out value="${item.statusdate }" /></td>
				<td><c:out value="${item.duedate }" /></td>
				<td><c:out value="${item.priority }" /></td>
				

			</tr>
		</c:forEach>
	</table>


<form action="ToDoServlet" method="post">
		<p>
		<br/><h3>Update List</h3>
		To update a To Do Status, enter the To Do ID and the Status ID. 
			<br/><br/>
			
			<input type="hidden" id="userid" name="userid" value="${userid}">
			
			<label for="todoid">Enter To Do ID:</label> 
			<input id="todoid" name="todoid" value="${todoid}">
						
			<label for="statusid">Enter Status ID:</label> 
			<input id="statusid" name="statusid" value="${statusid}">
			
			<input type="hidden" name="option" value="2">
			
			<input type="submit">
		</p>
	</form>

<form action="ToDoServlet" method="post">
		<p>
		<br/><h3>Insert Item</h3>
		To insert an To Do Item, enter the following information. 
			<br/><br/>
			
				<input type="hidden" id="userid" name="userid" value="${userid}">
				
						
			<label for="todotype">Enter Type:</label> 
			<input id="todotype" name="todotype" value="${todotype}">
			
			<label for="tododesc">Enter Description:</label> 
			<input id="tododesc" name="tododesc" value="${tododesc}">
				
			<label for="priority">Enter Priority:</label> 
			<input id="priority" name="priority" value="${priority}">
			
			<label for="year">Year: </label> 
			<input id="year" name="year" value="${year}">
			
			<label for="month">Month: </label> 
			<input id="month" name="month" value="${month}">
			
			<label for="day">Day: </label> 
			<input id="day" name="day" value="${day}">
			
			
			<label for="statusid">Enter Status ID:</label> 
			<input id="statusid" name="statusid" value="${statusid}">
			
			<input type="hidden" name="option" value="3">
				
			<input type="submit">
		</p>
	</form>
<form action="ToDoServlet" method="post">
		<p>
		<br/><h3>Display Completed Items</h3>
		Display completed items for all users
			<br/><br/>
			
			<input type="hidden" id="userid" name="userid" value="${userid}">
			

			
			<input type="hidden" name="option" value="4">
			
			<input type="submit">
		</p>
	</form>


</body>
</html>