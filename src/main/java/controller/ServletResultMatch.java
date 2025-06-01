package controller;


import dto.MatchDTO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MatchesService;

import java.util.UUID;

@WebServlet("/result-match")
public class ServletResultMatch extends HttpServlet {

    private MatchesService matchesService = new MatchesService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

        UUID uuid= UUID.fromString(req.getParameter("uuid"));
        try {
            MatchDTO matchDTO = matchesService.getCurrentMatch(uuid);

            req.setAttribute("playerOne", matchDTO.getPlayer1());
            req.setAttribute("playerTwo", matchDTO.getPlayer2());
            req.setAttribute("playerWinner", matchDTO.getWinner());

            getServletContext().getRequestDispatcher("/result-match.jsp").forward(req, resp);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
