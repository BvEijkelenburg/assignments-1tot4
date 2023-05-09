package listeners;

import bank.Bank;
import bank.Rekening;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletContextListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Applicatie wordt gestart!");
        Rekening r1 = new Rekening("NLINGB02345678", "Bart", 10);
        Rekening r2 = new Rekening("NLINGB01234567", "Klant2", 0);

        Bank bankje = Bank.getBank();
        bankje.addRekening(r1);
        bankje.addRekening(r2);

        r1.boekOver(5, r2);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Applicatie wordt gestopt!");
    }
}
