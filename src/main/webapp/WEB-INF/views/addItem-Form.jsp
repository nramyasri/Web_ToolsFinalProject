<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SELL AN ITEM</title>
</head>
<style>
input[type=text], select {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}

input[type=submit] {
    width: 100%;
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

input[type=submit]:hover {
    background-color: red;
}

div {
    border-radius: 5px;
    background-color: #f2f2f2;
    padding: 20px;
}

body {margin:0;}

.topnav {
  overflow: hidden;
  background-color: red;
}

.topnav a {
  float: left;
  display: block;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.topnav a:hover {
  background-color: white;
  color: red;
}

.topnav a.active {
    background-color: white;
    color: white;
    
}
</style>


<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<div class="topnav" id="myTopnav">
 <a href="${contextPath}/veiwMyAdds">VIEW MY ADDS</a>
  <a href="${contextPath}/myMessages">VIEW MY MESSAGES</a>
  <a href="${contextPath}/addItem">SELL AN ITEM</a>
  <a href="${contextPath}/HomePage">SEARCH PAGE</a>
  <a href="${contextPath}/logout">LOGOUT</a>
</div>


<h3><font color="red">Add a new Item...</font></h3>
<br>


<form:form action="${contextPath}/addItem" method="post" commandName="advert" enctype="multipart/form-data">
		
		<table>
			  <tr>
				<td>Posted By</td>
				<td>${sessionScope.user.username}</td>
				<td><form:hidden path="postedBy"
						value="${sessionScope.user.userAccountId}"/></td>
			</tr>

			<tr>
				<td>Category:</td>
				<td><form:select path="categoryDescription" items="${sessionScope.catlist}"
						multiple="true" required="required" /></td>
				       
			</tr>

			<tr>
				<td>Advert Title:</td>
				<td><form:input type="text" path="title" size="30" required="required"/></td>
				<td><form:hidden path="filename"/></td>
				
				
			</tr>

			<tr>
				<td>Message:</td>
				<td><form:input type="text" path="message" size="30" required="required"/></td>
				
			</tr>
			
			<tr>
				<td>Price:</td>
				<td><form:input type="text" path="price" size="30" required="required"/></td>
				
			</tr>
			
			
			<tr>
				<td>City:</td>
				<td><form:input type="text" path="city" size="30" required="required"/></td>
			</tr>
            
            
			<tr>
			<td>Select photo: <input type="file" name="photo"/><br/></td>
			
             </tr>			
			    <tr>
			    <td></td>
			    </tr>
			     <tr>
			    <td></td>
			    </tr>
			     <tr>
				<td colspan="2"><input type="Submit" value="Post Item for Sale" /></td>
			</tr>
		</table>
		
		</form:form>
</body>
</html>