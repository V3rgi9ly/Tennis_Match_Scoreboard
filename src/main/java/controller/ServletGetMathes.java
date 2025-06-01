package controller;


import dto.MathesDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.GetListMathesService;

import java.io.IOException;
import java.util.List;

@WebServlet("/matches")
public class ServletGetMathes extends HttpServlet {

    private GetListMathesService service = new GetListMathesService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int a=Integer.parseInt(req.getParameter("page"));


        List<MathesDTO> mathesDTO=service.getListMathes(a);
        List<Integer> pages=service.getListPages();

        req.setAttribute("mathesDTO",mathesDTO);
        req.setAttribute("page",a);
        req.setAttribute("pages",pages);
        getServletContext().getRequestDispatcher("/matches.jsp").forward(req, resp);
    }
}
