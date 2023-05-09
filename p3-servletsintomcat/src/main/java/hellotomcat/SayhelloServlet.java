package hellotomcat;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/sayhello")
public class SayhelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String username = req.getParameter("name");
        if (username != null) {
            resp.getWriter().println("Hello %s!".formatted(username));
        } else {
            resp.getWriter().println("Hello user!");
        }
    }

}
