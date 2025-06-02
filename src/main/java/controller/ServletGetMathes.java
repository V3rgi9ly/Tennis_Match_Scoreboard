package controller;


import dto.MathesDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.GetListMathesService;
import service.SearchMathesByNameService;

import java.io.IOException;
import java.util.List;

@WebServlet("/matches")
public class ServletGetMathes extends HttpServlet {

    private GetListMathesService service = new GetListMathesService();
    private SearchMathesByNameService searchService = new SearchMathesByNameService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        int a = Integer.parseInt(req.getParameter("page"));
        String name = req.getParameter("name");


        List<MathesDTO> mathesDTO = null;
        List<Integer> pages = service.getListPages();

        try {
            if (name != null && !name.equals("")) {
               mathesDTO = searchService.searchMathesByName(name);
                pages = service.getListPages(name);
            } else {
                mathesDTO = service.getListMathes(a);
                pages = service.getListPages();
            }

            req.setAttribute("mathesDTO", mathesDTO);
            req.setAttribute("page", a);
            req.setAttribute("pages", pages);

            getServletContext().getRequestDispatcher("/matches.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
