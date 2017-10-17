<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<title>ADD CATEGORY</title>
</head>
<body>

	<c:set var="contextPath" value="${pageContext.request.contextPath}" />

	
	<h2>Add a New Category</h2>


	<form:form action="${contextPath}/admin/addCategory" method="post" commandName="category">

		<table>
			<tr>
				<td>Category Title:</td>
				<td><form:input path="categoryDescription" size="30" required="required" />
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Create Category" /></td>
			</tr>
		</table>

	</form:form>

</body>
</html>