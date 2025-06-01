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
                <a class="nav-link" href="${pageContext.request.contextPath}/matches">Matches</a>
            </nav>
        </div>
    </section>
</header>
<main>
    <div class="container">
        <h1>Result-match</h1>

        <section class="score">
            <table class="table-matches">
                <table class="table">
                    <thead class="result">
                    <tr>
                        <th class="table-text">PlayerOne</th>
                        <th class="table-text">PlayerTwo</th>
                        <th class="table-text">PlayerWinner</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td class="table-text">${playerOne}</td>
                        <td class="table-text">${playerTwo}</td>
                        <td class="table-text">${playerWinner}</td>
                    </tr>
                    </tbody>
                </table>
            </table>
        </section>
    </div>
</main>
</body>
</html>
