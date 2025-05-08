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

@WebServlet("/new-match")
public class ServletNewMatch extends HttpServlet {


    private PlayersService playersService;
    private MatchesService matchesService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/newMatch.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("usernameOne");
        String name2 = req.getParameter("usernameTwo");

        playersService.findPlayer(name, name2);
        matchesService.createCurrentMatch(name, name2);




    }
}
