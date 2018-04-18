<%--
  Created by IntelliJ IDEA.
  User: thomas
  Date: 16/04/18
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <link rel="stylesheet" href="style.css" />
  </head>

  <body>
    <form action="custom-hello" method="post">

      Name <input type="text" name="userName"/><br/><br/>
      Family Name <input type="text" name="userSurname"/><br/><br/>
      Time <input id="time" type="time" name="time">
      <br/><br/>
      <input type="submit" value="sendInfo"/>

    </form>
  </body>
</html>
