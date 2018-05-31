<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
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
<%
try{
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement=connection.createStatement();
String sql ="select * from salary_history where id="+id;
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<!DOCTYPE html>
<html>
<head>
<title>INFORMATION SYSTEM -- EMPLOYEES</title> 
<link rel="stylesheet" type="text/css" href="style.css">
</head>

<body>
    
    
<h1>Update data </h1>
<form method="post" action="update-process2.jsp">
<input type="hidden" name="id" value="<%=resultSet.getString("id") %>">
<br>
id<br>

<input type="text" name="id2" value="<%=resultSet.getString("id") %>">
<br>
Salary in januar:<br>
<input type="text" name="first_name" value="<%=resultSet.getString("salary1") %>">
<br>
Salary in februar:<br>
<input type="text" name="last_name" value="<%=resultSet.getString("salary2") %>">
<br>
Salary in march:<br>
<input type="text" name="city_name" value="<%=resultSet.getString("salary3") %>">
<br>
<br>
Salary in april:<br>
<input type="text" name="email" value="<%=resultSet.getString("salary4") %>">
<br><br>
<br>
Salary in may:<br>
<input type="text" name="email2" value="<%=resultSet.getString("salary5") %>">
<br><br>

<input type="submit" value="submit">
</form>
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</body>
</html>