package controller;


import dto.MatchDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MatchesService;

import java.io.IOException;
import java.util.UUID;

@WebServlet("/result-match")
public class ServletResultMatch extends HttpServlet {

    private MatchesService matchesService = new MatchesService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UUID uuid= UUID.fromString(req.getParameter("uuid"));

        MatchDTO matchDTO = matchesService.getCurrentMatch(uuid);

        req.setAttribute("playerOne", matchDTO.getPlayersOne());
        req.setAttribute("playerTwo", matchDTO.getPlayersOne());
        req.setAttribute("playerWinner", matchDTO.getWinner());

        getServletContext().getRequestDispatcher("/result-match.jsp").forward(req, resp);
    }
}
