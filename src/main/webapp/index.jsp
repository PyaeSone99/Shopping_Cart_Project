<%@ page import="com.example.listener.model.ProductModel" %>
<%@ page import="com.example.listener.entity.Product" %>
<%@ page import="com.example.listener.model.ShoppingCart" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
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

<h1>Product List</h1>

<p>
    Shopping Cart : <a href="cart-show">
    <% ShoppingCart cart = (ShoppingCart) session.getAttribute("cart"); %>
    <%=null == cart ? 0 : cart.itemCount() %>
</a>
    <p>
        <%
            if (null != cart && cart.itemCount() > 0 ){
        %>
            <a href="cart-clear">Cart Clear</a>
        <%
            }
        %>
    </p>
</p>

<%
    ProductModel model = (ProductModel) application.getAttribute("products");
%>
<table style="width:100%">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Category</th>
        <th>Price</th>
        <th><% model.getList(); %></th>
    </tr>
    <%
        for (int i = 0; i < model.getList().size(); i++) {
            Product p = model.getList().get(i);
    %>
    <tr>
        <td>
            <%=p.getId()%>
        </td>
        <td>
            <%=p.getName()%>
        </td>
        <td>
            <%=p.getCategory()%>
        </td>
        <td>
            <%=p.getPrice()%>
        </td>
        <td>
            <a href="cart-add?product=<%=p.getId()%>">Add To Card</a>
        </td>
    </tr>
    <%
        }
    %>
</table>
    <p>
        <a href="sale-history">Sale History</a>
    </p>
</body>
</html>