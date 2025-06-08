package controller;


import dto.MathesDTO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.GetListMathesService;
import service.SearchMathesByNameService;
import java.util.List;

@WebServlet("/matches")
public class ServletGetMathes extends HttpServlet {

    private GetListMathesService service = new GetListMathesService();
    private SearchMathesByNameService searchService = new SearchMathesByNameService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        int a = Integer.parseInt(req.getParameter("page"));
        String name = req.getParameter("name");


        List<MathesDTO> mathesDTO;
        List<Integer> pages;

        try {
            if ((name != null && !name.equals("")) || (name != null && !name.equals("") && a==1)  ) {
                mathesDTO = searchService.searchMathesByName(name);
                pages = service.getListPages(name);
            } else {
                mathesDTO = service.getListMathes(a);
                pages = service.getListPages();
            }

            req.setAttribute("mathesDTO", mathesDTO);
            req.setAttribute("page", a);
            req.setAttribute("pages", pages);
            req.setAttribute("name", name);

            getServletContext().getRequestDispatcher("/matches.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
