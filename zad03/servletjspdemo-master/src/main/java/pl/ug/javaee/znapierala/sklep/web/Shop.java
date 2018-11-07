package pl.ug.javaee.znapierala.sklep.web;
import pl.ug.javaee.znapierala.sklep.domain.Flat;
import pl.ug.javaee.znapierala.sklep.service.FlatService;
import pl.ug.javaee.znapierala.sklep.service.StorageService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;


@WebServlet("/shop")
public class Shop extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        if(getServletContext().getAttribute("flat_service")!=null) {
            out.println("<h2>Mieszkania do kupienia</h2>");
            FlatService flatService = (FlatService) getServletContext().getAttribute("flat_service");
            for(Flat flat : flatService.getMap().values()) {
                out.println("<p>"+ " Mieszkanie pod adresem " + flat.getName() + " Wybudowane  "
                        + flat.getDate() +  " Kosztuje "+ flat.getPrice() + " z³oty i ");
                if(flat.getIsAviliable()) {
                    out.print(" jest dostêpne");
                } else {
                    out.print(" nie jest dostêpne");
                }
                out.print("\"<form action=\"shop\" method=\"post\">"
                +"<input type=\"hidden\" name=\"id\" value=\""+ flat.getId() +"\">" +
                "<input type=\"submit\" value=\"Dodaj\"></form></p>");
            }
        } else {
            getServletContext().setAttribute("flat_service",new FlatService());
            out.println("<h2>Brak mieszkañ!</h2>");
            out.println("<p><a href=\"http://localhost:8080/servletjspdemo/addFlat\"Wystaw mieszkanie</a></p>");
        }
        if(StorageService.getCart(request)!=null) {
            if (StorageService.getCart(request).size() > 0) {
            out.println("<h2>Twój koszyk</h2>");
            for(Flat flat : StorageService.getCart(request)) {
                out.println("<p>"+ " Mieszkanie pod adresem " + flat.getName() + " Wybudowane  "
                        + flat.getDate() +  " Kosztuje "+ flat.getPrice() + " z³oty i ");
                if(flat.getIsAviliable()) {
                    out.print(" jest dostêpne");
                } else {
                    out.print(" nie jest dostêpne");
                }
                out.print("</p>");
            }
        } else {
            out.println("<h2>Masz pusty koszyk</h2>");
        }
        }
    else {
        out.println("<h2>Masz pusty koszyk!</h2>");
        
        }
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("cart")!=null) {
            StorageService.addToCart(Integer.parseInt(request.getParameter("id")), request,getServletContext());
        } else {
            request.getSession().setAttribute("cart",new ArrayList<Flat>());
            StorageService.addToCart(Integer.parseInt(request.getParameter("id")), request,getServletContext());
        }
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Dodano mieszkanie do koszyka!");
        out.println("<p><a href=\"http://localhost:8080/servletjspdemo/shop\">Sklep</a></p>");
        out.println("</body></html>");
    }
}
