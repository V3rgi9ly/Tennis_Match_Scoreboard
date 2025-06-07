<%--
  Created by IntelliJ IDEA.
  User: Sergey
  Date: 24.05.2025
  Time: 22:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tennis Scoreboard | ResultMathes</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/style.css">

    <script src="js/app.js"></script>
</head>
<body>
<header class="header">
    <section class="nav-header">
        <div class="brand">
            <div class="nav-toggle">
                <img src="images/menu.png" alt="Logo" class="logo">
            </div>
            <span class="logo-text">TennisScoreboard</span>
        </div>
        <div>
            <nav class="nav-links">
                <a class="nav-link" href="${pageContext.request.contextPath}/main">Home</a>
                <%
                    String a = "1";
                    request.setAttribute("page", a);
                %>
                <a class="nav-link" href="${pageContext.request.contextPath}/matches?page=${page}">Matches</a>
            </nav>
        </div>
    </section>
</header>
<main>
    <div class="container">
        <h1>Result-match</h1>
        <table class="table-matches">
            <tr>
                <th>PlayerOne</th>
                <th>PlayerTwo</th>
                <th>Winner</th>
            </tr>
        </table>

        <table class="table-matches">
            <tr>
                <td>${playerOne}</td>
                <td>${playerTwo}</td>
                <td><span class="winner-name-td">${playerWinner}</span></td>
            </tr>
        </table>
    </div>
</main>
</body>
</html>
