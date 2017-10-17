<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to My Adds Page</title>
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
  <a href="${contextPath}/logout">LOGOUT</a>
</div>
<h2>MY ADDS...</h2>
<c:choose>
<c:when test="${!empty adList}">
 <input type="hidden" name="size" value="${size}"/>
  <table>            
            <thead>
                <tr>
                <th>Title</th>
                    <th>Message</th>
                    <th>Category</th>
                    <th></th>
                </tr>                
            </thead>
            <tbody>
    <c:forEach items="${adList}" var="ad">   
        <tr>
                    
                    <td>${ad.title}</td>
                    <td>${ad.message}</td>
                    <td>${ad.categoryDescription}</td>
                    
                    <td><form action="${contextPath}/delete" method="post">
    <input type="submit" value="SOLD / DELETE"/>
    <input type="hidden" value="${ad.id}" name="id"> 
</form></td>
                    
                    <!--<input type="submit" value="Remove Ad"/></form></td>-->
    </c:forEach> 

</tbody>
            
                </table><br>
                </c:when>
                    
<c:otherwise>
<h3>There are no Ads posted by you...</h3>
</c:otherwise>
</c:choose> 
</body>
</html>