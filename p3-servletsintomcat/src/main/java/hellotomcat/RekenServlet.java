package hellotomcat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/rekenmachine")
public class RekenServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double eersteGetal = Double.parseDouble(req.getParameter("getalX"));
        double tweedeGetal = Double.parseDouble(req.getParameter("getalY"));

        boolean afronden = false;
        if (req.getParameter("afronden") != null && req.getParameter("afronden").equals("ja")) {
            afronden = true;
        }

        String bewerking = req.getParameter("operator");
        double uitkomst = 0;

        switch(bewerking) {
            case "+": uitkomst = eersteGetal + tweedeGetal; break;
            case "-": uitkomst = eersteGetal - tweedeGetal; break;
        }

        if (afronden) {
            uitkomst = Math.round(uitkomst);
        }

        resp.getWriter().println(eersteGetal + " " + bewerking + " " + tweedeGetal + " = " + uitkomst);
    }
}
