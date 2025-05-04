package controller;


import dto.PlayersCurrentMatchesDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.PlayersService;
import service.ServicesStoringCurrentMatches;

import java.io.IOException;

@WebServlet("/new-match")
public class ServletNewMatch extends HttpServlet {


    private PlayersService playersService=new PlayersService();
    private ServicesStoringCurrentMatches servicesStoringCurrentMatches=new ServicesStoringCurrentMatches();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/newMatch.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("usernameOne");
        String name2 = req.getParameter("usernameTwo");

        if (playersService.findPlayer(name, name2)) {
            resp.sendRedirect(req.getContextPath() + "/new-match");
        }else {
            PlayersCurrentMatchesDTO playersCurrentMatchesDTO=servicesStoringCurrentMatches.createCurrentMatch(name, name2);
        }

    }
}
