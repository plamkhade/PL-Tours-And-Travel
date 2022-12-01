<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*" %>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql"  prefix="sql"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body{
background-image: url('./resources//images//lg.webp');
background-repeat: no-repeat;
background-size: cover;
}
#customers {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width:70%;
  margin-top:150px;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #04AA6D;
  color: white;
}
</style>
</head>
<body>




<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"
url="jdbc:mysql://localhost/pl" user="root" password=""/>

<sql:query dataSource="${db}" var="rs">
select * from booking;
</sql:query>

<div class="container" align="center">
<table id="customers" border="4" cellpadding="5">
<caption><h2></h2></caption>
<tr>
<th>name</th>
<th>adharNo</th>
<th>email</th>
<th>pass</th>
<th>packages</th>
</tr>
<c:forEach var="table" items="${rs.rows }">
<tr>
<td><c:out value="${table.name}"/></td>
<td><c:out value="${table.adharNo}"/></td>
<td><c:out value="${table.email}"/></td>
<td><c:out value="${table.pass}"/></td>
<td><c:out value="${table.packages}"/></td>
<tr>
</c:forEach>
</table>
</div>
</body>
</html>