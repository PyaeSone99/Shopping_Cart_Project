<%@ page import="com.example.listener.entity.Voucher" %>
<%@ page import="java.util.List" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %><%--
  Created by IntelliJ IDEA.
  User: pyaes
  Date: 5/3/2023
  Time: 8:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sale History</title>
</head>
<style>
    table, th, td {
        border: 1px solid black;
    }

    td {
        padding: 10px;
        text-align: center;
    }
</style>
<body>
    <%!List<Voucher> list; %>
    <%!
        String formatDateTime(LocalDateTime date){
            return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        }
    %>
    <%
        List<Voucher> list = (List<Voucher>) request.getAttribute("data");
    %>
    <h1>Sale List</h1>
    <p>
        <a href="index.jsp">back</a>
    </p>
<table  style="width:60%">
    <tr>
        <th>Voucher Id</th>
        <th>Sale Date Time</th>
        <th>Customer Name</th>
        <th>Item Count</th>
        <th>Sale Total</th>
    </tr>
    
    <%
        for (Voucher v : list){
    %>
    <tr>
        <td>
            <a href="sale-details?id=<%=v.getId()%>"><%=v.getId() %></a>
        </td>
        <td><%=formatDateTime(v.getSaleTime()) %></td>
        <td><%=v.getCustomer() %></td>
        <td><%=v.itemCount() %></td>
        <td><%=v.total() %></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
