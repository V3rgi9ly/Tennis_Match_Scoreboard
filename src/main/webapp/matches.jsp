<%--
  Created by IntelliJ IDEA.
  User: Sergey
  Date: 28.04.2025
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tennis Scoreboard | Finished Matches</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/style.css">

    <script src="js/app.js"></script>
</head>

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
            </nav>
        </div>
    </section>
</header>
<main>
    <div class="container">
        <h1>Matches</h1>
        <div class="input-container">


            <form action="${pageContext.request.contextPath}/matches" method="get">
                <input class="input-filter" placeholder="Filter by name" type="text" name="name"/>
                <input type="hidden" name="page" value="1"/>
                <button class="btn-filter" type="submit">Apply Filter</button>
            </form>
        </div>

        <table class="table-matches">
            <tr>
                <th>Player One</th>
                <th>Player Two</th>
                <th>Winner</th>
            </tr>
        </table>

        <table class="table-matches">

            <c:forEach var="player" items="${mathesDTO}">
                <tr>
                    <td>${player.player1}</td>
                    <td>${player.player2}</td>
                    <td><span class="winner-name-td">${player.winner}</span></td>
                </tr>
            </c:forEach>

        </table>
        <div class="pagination">

            <c:choose>
                <c:when test="${pages.size() == 1}">
                    <a class="prev" href="${pageContext.request.contextPath}/matches?page=${page+0}&name=${name}">
                        < </a>
                    <a class="num-page current"
                       href="${pageContext.request.contextPath}/matches?page=${page}&name=${name}">${page}</a>
                    <a class="next" href="${pageContext.request.contextPath}/matches?page=${page+0}&name=${name}">
                        > </a>

                </c:when>
                <c:when test="${pages.size() == 2}">
                    <c:forEach var="i" items="${pages}" varStatus="loop">
                        <c:choose>
                            <c:when test="${i eq page}">
                                <c:if test="${loop.first}">
                                    <a class="prev"
                                       href="${pageContext.request.contextPath}/matches?page=${page+0}&name=${name}">
                                        < </a>
                                    <a class="num-page current"
                                       href="${pageContext.request.contextPath}/matches?page=${page}&name=${name}">${page}</a>
                                    <a class="num-page"
                                       href="${pageContext.request.contextPath}/matches?page=${page+1}&name=${name}">${page+1}</a>
                                    <a class="next"
                                       href="${pageContext.request.contextPath}/matches?page=${page+1}&name=${name}">
                                        > </a>
                                </c:if>
                                <c:if test="${loop.last}">
                                    <a class="prev"
                                       href="${pageContext.request.contextPath}/matches?page=${page-1}&name=${name}">
                                        < </a>
                                    <a class="num-page"
                                       href="${pageContext.request.contextPath}/matches?page=${page-1}&name=${name}">${page-1}</a>
                                    <a class="num-page current"
                                       href="${pageContext.request.contextPath}/matches?page=${page}&name=${name}">${page}</a>
                                    <a class="next"
                                       href="${pageContext.request.contextPath}/matches?page=${page+0}&name=${name}">
                                        > </a>
                                </c:if>
                            </c:when>
                        </c:choose>
                    </c:forEach>
                </c:when>

                <c:when test="${pages.size() > 2}">
                    <c:forEach var="i" items="${pages}" varStatus="loop">
                        <c:choose>
                            <c:when test="${i eq page}">
                                <c:choose>
                                    <c:when test="${loop.first}">
                                        <a class="prev"
                                           href="${pageContext.request.contextPath}/matches?page=${page+0}&name=${name}">
                                            < </a>
                                        <a class="num-page current"
                                           href="${pageContext.request.contextPath}/matches?page=${page}&name=${name}">${page}</a>
                                        <a class="num-page"
                                           href="${pageContext.request.contextPath}/matches?page=${page+1}&name=${name}">${page+1}</a>
                                        <a class="num-page"
                                           href="${pageContext.request.contextPath}/matches?page=${page+2}&name=${name}">${page+2}</a>
                                        <a class="next"
                                           href="${pageContext.request.contextPath}/matches?page=${page+1}&name=${name}">
                                            > </a>
                                    </c:when>
                                    <c:when test="${loop.last}">
                                        <a class="prev"
                                           href="${pageContext.request.contextPath}/matches?page=${page-1}&name=${name}">
                                            < </a>
                                        <a class="num-page"
                                           href="${pageContext.request.contextPath}/matches?page=${page-2}&name=${name}">${page-2}</a>

                                        <a class="num-page"
                                           href="${pageContext.request.contextPath}/matches?page=${page-1}&name=${name}">${page-1}</a>

                                        <a class="num-page current"
                                           href="${pageContext.request.contextPath}/matches?page=${page}&name=${name}">${page}</a>
                                        <a class="next"
                                           href="${pageContext.request.contextPath}/matches?page=${page+0}&name=${name}">
                                            > </a>
                                    </c:when>
                                    <c:otherwise>
                                        <a class="prev" href="${pageContext.request.contextPath}/matches?page=${page-1}&name=${name}">
                                            < </a>
                                        <c:if test="${page>1}">
                                        <a class="num-page"
                                           href="${pageContext.request.contextPath}/matches?page=${page-1}&name=${name}">${page-1}</a>
                                        </c:if>
                                        <a class="num-page current"
                                           href="${pageContext.request.contextPath}/matches?page=${page}&name=${name}">${page}</a>

                                        <c:if test="${page+1<=pages.size()}">
                                        <a class="num-page"
                                           href="${pageContext.request.contextPath}/matches?page=${page+1}&name=${name}">${page+1}</a>
                                        </c:if>
                                        <a class="next" href="${pageContext.request.contextPath}/matches?page=${page+1}&name=${name}">
                                            > </a>
                                    </c:otherwise>
                                </c:choose>
                            </c:when>
                        </c:choose>
                    </c:forEach>
                </c:when>
            </c:choose>
        </div>
    </div>
</main>


<footer>
    <div class="footer">
        <p>&copy; Tennis Scoreboard, project from <a href="https://zhukovsd.github.io/java-backend-learning-course/">zhukovsd/java-backend-learning-course</a>
            roadmap.</p>
    </div>
</footer>
</body>
</html>
