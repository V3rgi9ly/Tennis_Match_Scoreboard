<%--
  Created by IntelliJ IDEA.
  User: Sergey
  Date: 28.04.2025
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Tennis Scoreboard | New Match</title>
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
          String a="1";
          request.setAttribute("page",a);
        %>
        <a class="nav-link" href="${pageContext.request.contextPath}/matches?page=${page}">Matches</a>
      </nav>
    </div>
  </section>
</header>
<main>
  <div class="container">
    <div>
      <h1>Start new match</h1>
      <div class="new-match-image"></div>
      <div class="form-container center">
        <form method="post" action="${pageContext.request.contextPath}/new-match">
          <p style="color: red;">Sample error message</p>
          <label class="label-player" for="playerOne">Player one</label>
          <input class="input-player" placeholder="Name" type="text" required title="Enter a name" name="usernameOne">
          <label class="label-player" for="playerTwo">Player two</label>
          <input class="input-player" placeholder="Name" type="text" required title="Enter a name" name="usernameTwo" >
          <input class="form-button" type="submit" value="Start">
        </form>
      </div>
    </div>
  </div>
</main>
<footer>
  <div class="footer">
    <p>&copy; Tennis Scoreboard, project from <a href="https://zhukovsd.github.io/java-backend-learning-course/">zhukovsd/java-backend-learning-course</a> roadmap.</p>
  </div>
</footer>
</body>
</html>
