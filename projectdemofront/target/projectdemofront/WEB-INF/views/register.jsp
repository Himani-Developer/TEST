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
</head>
<body>

	

	<!-- ------------navbar--------------- -->
	<%@include file="templates/navbar.jsp"%>

	<div class="container">
		<h1 class="well">Registration Form</h1>
		<hr>
		<center>
		<form:form modelAttribute="user"
			action="${pageContext.request.contextPath}/${url}" method="post">

			<form:hidden path="u_id"/>
			Name<form:input path="name" placeholder="name" /></br>
			Email<form:input path="email" placeholder="email" /></br>
			Password<form:input path="password" placeholder="password" /></br>
			Phone<form:input path="phone" placeholder="phone" /></br>
			Address<form:input path="address" placeholder="address" /></br>
			Role<form:input path="role" placeholder="role" /></br>
			Enabled<form:input path="enabled" placeholder="True/False" /></br>


			<c:if test="${UserClickedEdit==true}">
				<input type="submit" value="Update user" />
			</c:if>
			<c:if test="${UserClickedEdit!=true}">
				<input type="submit" value="Save user" />
			</c:if>

		</form:form>
		</center>

		<table align="center" width="300">
			<thead>
				<tr bgcolor="aqua">

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
			<tbody>
				<c:forEach items="${userlist}" var="user">
					<tr>
						
						<td>${user.u_id}</td>
						<td>${user.name}</td>
						<td>${user.address}</td>
						<td>${user.phone}</td>
						<td>${user.email}</td>
						<td>${user.password}</td>
						<td>${user.role}</td>
						<td>${user.enabled}</td>

						<td><a
							href="${pageContext.request.contextPath}/edituser/${user.u_id}">Edit</a>

							<a
							href="${pageContext.request.contextPath}/deleteuser/${user.u_id}">Delete</a>

						</td>
					</tr>
				</c:forEach>
			</tbody>

		</table>

	</div>


</body>
</html>