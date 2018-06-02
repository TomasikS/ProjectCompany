<%@page import="java.util.List"%>
<%@page import="data.Employee"%>
<%@page import="data.Dataoperation"%>
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

Dataoperation dop=new Dataoperation();
   
    List<Employee> list=dop.getAllEmployees();
    
    
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
String sql ="select id, amount from employee_details where id="+id;
resultSet = statement.executeQuery(sql);
int i=-1;
while(resultSet.next()){
    i++;
%>
<!DOCTYPE html>
<html>
<head>
<title>INFORMATION SYSTEM -- EMPLOYEES</title> 
<link rel="stylesheet" type="text/css" href="style.css">
</head>

<body>
    
    
<h1>Update data </h1>
<form method="post" action="update-process3.jsp">
<input type="hidden" name="id" value="<%=resultSet.getString("id") %>">
<br>
id<br>

<input type="text" name="id2" value="<%=resultSet.getString("id") %>">
<br>
Salary  amount<br>
<input type="text" name="first_name" value="<%=resultSet.getString("amount") %>">
<br>

Firstname<br>
<input type="text" name="first_name" value="<%=list.get(i).getfirstname() %>">
<br>
 
Lastname<br>
<input type="text" name="first_name" value="<%=list.get(i).getlastname()%>">
<br>
 
<br>

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