package hellotomcat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(urlPatterns = "/requestinfo")
public class InfoServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.getWriter().println("Method: " + req.getMethod());
        resp.getWriter().println("URL:    " + req.getRequestURL());
        resp.getWriter().println("Path:   " + req.getServletPath());
        resp.getWriter().println("Server: " + req.getServerName());
        resp.getWriter().println("Port:   " + req.getServerPort());

        resp.getWriter().println();
        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            String value = req.getParameter(name);

            resp.getWriter().println("%s : %s".formatted(name, value));
        }

        resp.getWriter().println();
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            String value = req.getHeader(name);

            resp.getWriter().println("%s : %s".formatted(name, value));
        }
    }
}
