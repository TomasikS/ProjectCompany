<%@page import="java.util.ArrayList"%>
<%@page import="data.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*" %> 
<%@ page import="java.io.*" %> 
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
 <%@ page import="data.Dataoperation" %>
<%
    
 


    Dataoperation dop=new Dataoperation();
   
    List<Employee> list=dop.getAllEmployees();
    List<Employee> list2=dop.compute();
 
 
 
%>

<head>
<title>INFORMATION SYSTEM -- EMPLOYEES</title> 
    <link rel="stylesheet" type="text/css" href="style.css">
</head>

<body>

<h1>Updating amount</h1>
<table border="1">

<tr>
<th>id</th>
<th>amount</th>
<th>lastname</th>
<th>firstname</th>

</tr>
 
<%

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
<%
try{
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement=connection.createStatement();
String sql ="select * from employee_details";
resultSet = statement.executeQuery(sql);
int i=-1;
while(resultSet.next()){
    i++;
%>

 <tr>


<td><%=resultSet.getString("id") %></td>
<td><%=list2.get(i).getAmount() %></td>
 <td><%=list.get(i).getlastname() %></td>
  <td><%=list.get(i).getfirstname() %></td>





<td><a href="Updatea.jsp?id=<%=resultSet.getString("id")%>">update</a></td>
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