<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <c:set var="contextPath" value="${pageContext.request.contextPath}" />

<title>Insert title here</title>
</head>
<style>
.dropbtn {
    background-color: #4CAF50;
    color: white;
    padding: 16px;
    font-size: 16px;
    border: none;
    cursor: pointer;
}

.dropdown {
    position: relative;
    display: inline-block;
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}

.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
}

.dropdown-content a:hover {background-color: #f1f1f1}

.dropdown:hover .dropdown-content {
    display: block;
}

.dropdown:hover .dropbtn {
    background-color: #3e8e41;
}

table {
    border-collapse: collapse;
    width: 100%;
}

th, td {
    text-align: left;
    padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}

th {
    background-color: #4CAF50;
    color: white;
}
</style>
<body>
<h2>Welcome to the search Page admin..</h2>
<br>
<br>
 <c:choose>     
<c:when test="${!empty advertList}">
           <table style="width:100%">            
            <thead>
                <tr>
                    <th>Ad Id</th>
                    <th>Ad Title</th>
                    <th>Date posted</th>
                    
                    <th></th>
                     </tr>                
            </thead>
            <tbody>
           <c:forEach items="${advertList}" var="ad"> 
            <tr>
                    <td>${ad.id}</td>
                    <td>${ad.title}</td>
                     <td>${ad.postedOn}</td>
                    
                   <td><form action="${contextPath}/admin/delete" method="post">
    <button class="button button3" type="submit"><font color="red">DELETE..</font></button>
    <input type="hidden" value="${ad.id}" name="id">
     </form></td>
     </tr>
</c:forEach> 

             </tbody>
            
                </table><br>
                </c:when>
                <c:otherwise>
                <form  method="post" action="${contextPath}/admin/AdminSearch"> 
CHOOSE CATEGORY &nbsp&nbsp&nbsp
<select name="category">
    
       <c:forEach items="${catList}" var="cat">
     
           <option>${cat.categoryDescription}</option>
           </c:forEach>
       </select>
 <br> 
 <br>
 <br> 
    
CHOOSE CITY  &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
<select name="city">
    
       <c:forEach items="${cityList}" var="city">
     
           <option>${city.city}</option>
           </c:forEach>
       </select>
       
      
         <button class="button button3" type="submit"><font color="red">VIEW RESULTS</font></button>
      <input type="hidden" name="action" value="view" />
    </form>
                
                </c:otherwise>
                
</c:choose>
</body>
</html>