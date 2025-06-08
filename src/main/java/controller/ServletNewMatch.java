package controller;


import dto.MatchDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Match;
import service.MatchesService;
import service.PlayersService;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@WebServlet("/new-match")
public class ServletNewMatch extends HttpServlet {


    private PlayersService playersService = new PlayersService();
    private MatchesService matchesService = new MatchesService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/newMatch.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("usernameOne");
        String name2 = req.getParameter("usernameTwo");

        try {
            playersService.findPlayer(name, name2);
            UUID id = matchesService.createCurrentMatch(name, name2);

            req.setAttribute("uuid", id);
            resp.sendRedirect(req.getContextPath()+"/match-score?uuid=" + id);
//            getServletContext().getRequestDispatcher("/match-score.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
