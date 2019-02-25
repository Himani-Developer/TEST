<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>OnlineShop</title>
<meta name="viewport" content="width=device-width, initial-scale=1">


</head>

<%@include file="templates/navbar.jsp"%>
<h1>Category</h1>
<hr />
<c:if test="${userclickededit==true}">
	<c:set var="url" value="UpdateCategory" />
</c:if>

<c:if test="${userclickededit!=true}">
	<c:set var="url" value="SaveCategory" />
</c:if>
<center>
	<form:form modelAttribute="category"
		action="${pageContext.request.contextPath}/${url}" method="post">
		<c:if test="${userclickededit==true}">
			<form:hidden path="categoryid"/>
		</c:if>
		<form:input path="categoryname" placeholder="categoryname" />
		<form:input path="categorydesc" placeholder="categorydesc" />
		<c:if test="${userclickededit==true}">
			<input type="submit" value="Update Category" />
		</c:if>
		<c:if test="${userclickededit!=true}">
			<input type="submit" value="Save Category" />
		</c:if>
	</form:form>

	<table align="center" width="300">
		<thead>
			<tr bgcolor="pink">
				<th>ID</th>
				<th>NAME</th>
				<th>DISCRIPTION</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${catlist}" var="cat">
				<tr bgcolor="yellow">
					<td>${cat.categoryid}</td>
					<td>${cat.categoryname}</td>
					<td>${cat.categorydesc}</td>
					<td><a
						href="${pageContext.request.contextPath}/editcat/${cat.categoryid}">Edit</a>
						<a
						href="${pageContext.request.contextPath}/deletecat/${cat.categoryid}">Delete</a>
						</td>
				
				</tr>
			</c:forEach>
		</tbody>

	</table>

</center>