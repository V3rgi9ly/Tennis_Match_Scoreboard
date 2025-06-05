package controller;


import dto.MatchDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.MatchScoreCalculationService;
import service.MatchesService;
import service.FinishedMatchesPersistenceService;

import java.util.UUID;

@WebServlet("/match-score")
public class ServletMatchScore extends HttpServlet {


    private MatchesService matchesService = new MatchesService();
    private FinishedMatchesPersistenceService finishedMatchesPersistenceService = new FinishedMatchesPersistenceService();
    private MatchScoreCalculationService matchScoreCalculationService = new MatchScoreCalculationService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){
        UUID uuid = UUID.fromString(req.getParameter("uuid"));



        try {
            MatchDTO matchDTO = matchesService.getCurrentMatch(uuid);
            HttpSession session = req.getSession();
            session.setAttribute("uuid", uuid);


            req.setAttribute("playerOne", matchDTO.getPlayer1().getName());
            req.setAttribute("playerTwo", matchDTO.getPlayer2().getName());
            req.setAttribute("setsOnePlayer", matchDTO.getSetScorePlayerOne());
            req.setAttribute("setsTwoPlayer", matchDTO.getSetScorePlayerTwo());
            req.setAttribute("gamesOnePlayer", matchDTO.getGamesScorePlayerOne());
            req.setAttribute("gamesTwoPlayer", matchDTO.getGamesScorePlayerTwo());
            req.setAttribute("pointsOnePlayer", matchDTO.getPointScorePlayerOne());
            req.setAttribute("pointsTwoPlayer", matchDTO.getPointScorePlayerTwo());

            getServletContext().getRequestDispatcher("/match-score.jsp").forward(req, resp);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)  {
        UUID uuid = UUID.fromString(req.getParameter("uuid"));
        String nameOne = req.getParameter("usernameOne");
        String nameTwo = req.getParameter("usernameTwo");

        MatchDTO matchDTO = null;
        try {
            if (nameOne != null) {
                matchDTO = matchScoreCalculationService.calculateMatchScore(nameOne + "One", uuid);
            } else if (nameTwo != null) {
                matchDTO = matchScoreCalculationService.calculateMatchScore( nameTwo + "Two", uuid);
            }

            if (matchDTO.isGameOver() == true) {
                finishedMatchesPersistenceService.saveMatch(matchDTO);
                resp.sendRedirect("/result-match" + "?uuid=" + uuid);

            } else {
                req.setAttribute("playerOne", matchDTO.getPlayer1().getName());
                req.setAttribute("playerTwo", matchDTO.getPlayer2().getName());
                req.setAttribute("setsOnePlayer", matchDTO.getSetScorePlayerOne());
                req.setAttribute("setsTwoPlayer", matchDTO.getSetScorePlayerTwo());
                req.setAttribute("gamesOnePlayer", matchDTO.getGamesScorePlayerOne());
                req.setAttribute("gamesTwoPlayer", matchDTO.getGamesScorePlayerTwo());
                req.setAttribute("pointsOnePlayer", matchDTO.getPointScorePlayerOne());
                req.setAttribute("pointsTwoPlayer", matchDTO.getPointScorePlayerTwo());

                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/match-score.jsp");
                requestDispatcher.forward(req, resp);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }


    }
}
