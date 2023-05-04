<%@ page import="com.example.listener.entity.Voucher" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="com.example.listener.entity.SaleItem" %><%--
  Created by IntelliJ IDEA.
  User: pyaes
  Date: 5/3/2023
  Time: 8:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sale Details</title>
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
    <%
        Voucher voucher = (Voucher)request.getAttribute("data");
    %>
    <%!
        String formatDateTime(LocalDateTime date){
            return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        }
    %>
    <h1>Sale Details</h1>
    <p>
        <a href="index.jsp">back</a>
    </p>

    <table>
        <tr>
            <th>Voucher Id</th>
            <td> <%=voucher.getId()%> </td>
        </tr>
        <tr>
            <th>Customer Name</th>
            <td> <%=voucher.getCustomer()%> </td>
        </tr>
        <tr>
            <th>Sale Date Time</th>
            <td> <%=formatDateTime(voucher.getSaleTime())%> </td>
        </tr>
    </table>

    <h3>Sale Items</h3>
    <table style="width:60%">
        <tr>
            <th>Product</th>
            <th>Category</th>
            <th>Unit Price</th>
            <th>Qty</th>
            <th>Total</th>
        </tr>
        <%
            for (SaleItem item : voucher.getSales()){
        %>
        <tr>

            <td> <%=item.getProduct().getName() %> </td>
            <td> <%=item.getProduct().getCategory() %> </td>
            <td> <%=item.getProduct().getPrice() %> </td>
            <td> <%=item.getCount() %> </td>
            <td> <%=item.getTotal() %> </td>
            <%
                }
            %>
        </tr>
    </table>
</body>
</html>





















