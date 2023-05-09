package servlets;

import bank.Bank;
import bank.Rekening;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/rekeninginfo")
public class RekeningServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Bank bank = Bank.getBank();

        String nummer = req.getParameter("nummer");
        String logs = req.getParameter("logs");

        if ("true".equals(logs)) {

        } else {
            Rekening gezochteRekening = bank.getRekening(nummer);
            String rekeningNr = gezochteRekening.getNummer();
            String klant = gezochteRekening.getKlant();
            double saldo = gezochteRekening.getSaldo();

            resp.getWriter().println(rekeningNr);
            resp.getWriter().println(klant);
            resp.getWriter().println(saldo);
        }
    }
}
