<%@ page import="com.example.listener.model.ShoppingCart" %>
<%@ page import="com.example.listener.entity.SaleItem" %>
<%@ page import="java.text.DecimalFormat" %><%--
  Created by IntelliJ IDEA.
  User: pyaes
  Date: 5/2/2023
  Time: 9:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Cart</title>
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
        <h1>My Cart</h1>
        <p>
            <a href="index.jsp">back</a>
        </p>
        <p>
            Item Details in Shopping Cart
        </p>
        <%
            ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        %>
        <%!
            String format(int data) {
                return new DecimalFormat("#,##0").format(data);
            }
        %>
        <table style="width:60%">
            <tr>
                <th>Product</th>
                <th>Unit Price</th>
                <th></th>
                <th>Count</th>
                <th></th>
                <th>Total</th>
            </tr>
            <%
                for (SaleItem item : cart.items()) {
            %>

            <tr>
                <td><%= item.getProduct().getName() %>
                </td>
                <td><%= item.getProduct().getCategory() %>
                </td>
                <td><%= item.getProduct().getPrice() %>
                </td>
                <td></td>
                <td>
                    <a href="cart-minus?product=<%= item.getProduct().getId() %>" style="text-decoration: none">-</a>
                    <%= item.getCount() %>
                    <a href="cart-plus?product=<%= item.getProduct().getId() %>" style="text-decoration: none">+</a>
                </td>
                <td></td>
                <td><%= item.getTotal() %>
                </td>
            </tr>

            <%
                }
            %>

            <tr>
                <td colspan="5">Total</td>
                <td style="text-align: center"><%=cart.itemCount()%>
                </td>
                <td><%= format(cart.total())  %>
                </td>
            </tr>
        </table>
        <hr>
        <h3>Check Out</h3>
        <form action="checkout" method="post">
            <label for="name">Customer Name</label>
            <input type="text" placeholder="Enter customer name" name="customer" id="name"> <br>
            <button type="submit">Checkout</button>
        </form>
    </body>
</html>
























