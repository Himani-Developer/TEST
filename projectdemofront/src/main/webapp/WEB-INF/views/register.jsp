<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>OnlineShop</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- <link rel="stylesheet" href="resources/css/bootstrap.css">
<script src="resources/js/jquery-3.3.1.js"></script>
<script src="resources/js/popper.js"></script>
<script src="resources/js/bootstrap.js"></script>
<link rel="stylesheet" href="resources/css/fontawsome.css">
 -->
 
 
 <style>
 table {
  border-collapse: collapse;
  border-spacing: 0;
  width: 100%;
  
} 

input[type=submit] {
  width: 20%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

 /* tr:nth-child(even) {
  background-color: #f2f2f2
}
  */
 </style>
</head>
<body>

	

	<!-- ------------navbar--------------- -->
	<%@include file="templates/navbar.jsp"%>

	<div class="container">
		
		<img alt="registration" src="resources/images/REGISTRATIONFORM.gif" width="100%">
		</br></br>
		
		<center>
		<form:form modelAttribute="user"
			action="${pageContext.request.contextPath}/${url}" method="post">

			<form:hidden path="u_id"/>
			<table>
			<tr>
			<td>Name</td>  <td><form:input path="name" placeholder="name" /></td>
			</tr>
			<tr>
			<td>Email</td>  <td><form:input path="email" placeholder="email" /></td>
			</tr>
			<tr>
			<td>Password</td>  <td><form:input type="password" path="password" placeholder="password" /></td>
			</tr>
			<tr>
			<td>Phone</td>  <td><form:input path="phone" placeholder="phone" /></td>
			</tr>
			<tr>
			<td>Address</td>  <td><form:input path="address" placeholder="address" /></td>
			</tr>
			<tr>
			<td>Role</td>  <td><form:input path="role" placeholder="role" /></td>
			</tr>
			<tr>
			<td>Enabled</td>  <td><form:input path="enabled" placeholder="True/False" /></td>
			</tr>
			<tr>
			<td></td>
			<td><c:if test="${UserClickedEdit==true}">
				<input type="submit" value="Update user" />
			</c:if>
			<c:if test="${UserClickedEdit!=true}">
				<input type="submit" value="Save user" />
			</c:if></td>
			</tr>
			
			
</table>

			

		</form:form>
		</center>

		<table align="center" width="300" cellpadding="50" cellspacing="70" style="border-collapse: collapse;
  border-spacing: 0;
  width: 100%;
  border: 1px solid #ddd;">
			<thead>
				<tr bgcolor="yellow">

					<th>ID</th>
					<th>NAME</th>
					<th>Address</th>
					<th>Phone</th>
					<th>Email</th>
					<th>Password</th>
					<th>Role</th>
					<th>Enabled</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody >
				<c:forEach items="${userlist}" var="user">
					<tr style="background-color: #f2f2f2;">
						
						<td>${user.u_id}</td>
						<td>${user.name}</td>
						<td>${user.address}</td>
						<td>${user.phone}</td>
						<td>${user.email}</td>
						<td>${user.password}</td>
						<td>${user.role}</td>
						<td>${user.enabled}</td>

						<td><a
							href="${pageContext.request.contextPath}/edituser/${user.u_id}"> <i class="fas fa-user-edit"></i> </a>

							<a
							href="${pageContext.request.contextPath}/deleteuser/${user.u_id}"><i class="fas fa-trash"></i></a>

						</td>
					</tr>
				</c:forEach>
			</tbody>

		</table>

	</div>


</body>
</html>