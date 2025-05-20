package controller;


import dto.MatchDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.MatchScoreCalculationService;
import service.MatchesService;
import service.StorageIdMatchService;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@WebServlet("/match-score")
public class ServletMatchScore extends HttpServlet {


    private MatchesService matchesService = new MatchesService();
    private StorageIdMatchService storageIdMatchService = new StorageIdMatchService();
    private MatchScoreCalculationService matchScoreCalculationService = new MatchScoreCalculationService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UUID uuid = UUID.fromString(req.getParameter("uuid"));
        MatchDTO matchDTO = matchesService.getCurrentMatch(uuid);

        HttpSession session = req.getSession();
        session.setAttribute("UUID", uuid);


        req.setAttribute("playerOne", matchDTO.getPlayersOne().getName());
        req.setAttribute("playerTwo", matchDTO.getPlayersTwo().getName());
        req.setAttribute("sets", matchDTO.getSetScorePlayerOne());
        req.setAttribute("sets", matchDTO.getSetScorePlayerTwo());
        req.setAttribute("games", matchDTO.getGamesScorePlayerOne());
        req.setAttribute("games", matchDTO.getGamesScorePlayerTwo());
        req.setAttribute("points", matchDTO.getPointScorePlayerOne());
        req.setAttribute("points", matchDTO.getPointScorePlayerTwo());
        getServletContext().getRequestDispatcher("/match-score.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nameOne = req.getParameter("usernameOne");
        String nameTwo = req.getParameter("usernameTwo");
        HttpSession session = req.getSession();
        UUID uuid = (UUID) session.getAttribute("UUID");
        MatchDTO matchDTO = storageIdMatchService.getMathes(uuid);

        if (nameOne != null) {
            matchScoreCalculationService.calculateMatchScore(matchDTO, nameOne);
        } else if (nameTwo != null) {
            matchScoreCalculationService.calculateMatchScore(matchDTO, nameTwo);
        }

        resp.sendRedirect("/match-score?uuid=" + uuid);
    }
}
