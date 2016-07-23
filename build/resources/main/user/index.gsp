<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>
<table >
    <tr>
        <th>ID</th>
        <th>FULL NAME</th>
        <th>FIRST AMOUNT</th>
        <th>SECOND AMOUNT</th>
        <th>TOTAL AMOUNT</th>

    </tr>
    <g:each in="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.firstAmount}</td>
            <td>${user.secondAmount}</td>
            <td>${user.totalAmount}</td>

        </tr>
    </g:each>
</table>

<br>
USER INFO : ${user?.dump()}
</body>
</html>