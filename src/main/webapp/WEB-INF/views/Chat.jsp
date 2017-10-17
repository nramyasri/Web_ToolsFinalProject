<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <c:set var="contextPath" value="${pageContext.request.contextPath}" />
<title>Insert title here</title>
</head>
<style>
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

table {
    border-collapse: collapse;
    width: 100%;
}

th, td {
    padding: 8px;
    text-align: left;
    border-bottom: 1px solid #ddd;
}

tr:hover{background-color:#f5f5f5}

input[type=submit] {
    width: 40%;
    background-color: red;
    color: white;
    padding: 7px 10px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

</style>
<body>
<div class="topnav" id="myTopnav">
  <a href="${contextPath}/veiwMyAdds">VIEW MY ADDS</a>
  <a href="${contextPath}/myMessages">VIEW MY MESSAGES</a>
  <a href="${contextPath}/addItem">SELL AN ITEM</a>
  <a href="${contextPath}/HomePage">SEARCH PAGE</a>
  <a href="${contextPath}/logout">LOGOUT</a>
</div>

<form action="${contextPath}/chat" method="post">
            <p><b> From : </b> <c:out value='${sessionScope.user.firstName}' /></p>
            
            <p>Message : </p>
            <textarea name='message' rows='6' cols="40"></textarea><br/>
            <input type='submit' value='send' />
            
        </form>


</body>
</html>