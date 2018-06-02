<%@page import="java.util.List"%>
<%@page import="data.Employee"%>
<%@page import="data.Dataoperation"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*" %> 
<%@ page import="java.io.*" %> 
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
    Dataoperation dop=new Dataoperation();
   
    List<Employee> list=dop.getAllEmployees();
String id = request.getParameter("id");
String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String database = "company";
String userid = "root";
String password = "root";
try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>

<head>
<title>INFORMATION SYSTEM -- EMPLOYEES</title> 
    <link rel="stylesheet" type="text/css" href="style.css">
</head>

<body>

<h1>Table salary_history</h1>
<table border="1">
<tr>
<th>id</td>
  <th>Firstname</th>
  <th>Januar</th>
<th>Lastname</th>
<th>Januar</th>
<th>Februar</th>
<th>March</th>
<th>April</th>
<th>May</th>
</tr>
<%
try{
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement=connection.createStatement();
String sql ="select * from  salary_history";
resultSet = statement.executeQuery(sql);
int i=-1;
while(resultSet.next()){i++;
%>
<tr>
    <td><%=list.get(i).getfirstname()%></td>
   <td><%=list.get(i).getlastname()%></td>
<td><%=resultSet.getString("salary1") %></td> 
    
<td><%=resultSet.getString("id") %></td>
<td><%=resultSet.getString("salary1") %></td>
<td><%=resultSet.getString("salary2") %></td>
<td><%=resultSet.getString("salary3") %></td>
<td><%=resultSet.getString("salary4") %></td>
<td><%=resultSet.getString("salary5") %></td>

<td><a href="Updates.jsp?id=<%=resultSet.getString("id")%>">update</a></td>
</tr>
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</table>
</body>
</html>