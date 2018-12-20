package pl.ug.javaee.znapierala.sklep.web;
import pl.ug.javaee.znapierala.sklep.domain.Flat;
import pl.ug.javaee.znapierala.sklep.service.FlatService;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addFlat")
public class AddFlat extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html><body><h1>Dodaj mieszkanie</h1>" +
                "<form action=\"addFlat\" method=\"post\">" +
                "Nazwa: <input type=\"text\" name=\"name\" value=\"\">" + "<p></p>" +
                        "Data wybudowania: <input type=\"date\" name=\"date\" value=\"\">" + "<p></p>" +
                "Cena: <input type=\"text\" name=\"price\" value=\"\">" + "<p></p>" +
                "Czy dostêpne od zaraz: <input type=\"checkbox\" name=\"isAviliable\" value=\"\">"
                + "<input type=\"submit\" value=\"Dodaj do Koszyka\"></form></body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //ServletContext servletContext = getServletContext();
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        FlatService flatService = (FlatService) getServletContext().getAttribute("flat_service");
        boolean isAviliable = request.getParameter("isAviliable")!=null;
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(request.getParameter("date"), format);
        Date date2 = java.sql.Date.valueOf(date);
        flatService.addFlat(new Flat(request.getParameter("name"), isAviliable, (java.sql.Date) date2, Double.valueOf(request.getParameter("price"))));
        getServletContext().setAttribute("flat_service",flatService);
        out.println("<html><body>Dodano mieszkanie "  +
                "<p><a href=\"http://localhost:8080/servletjspdemo/shop\">Wróæ do sklepu</a></p>" +
                "<p><a href=\"http://localhost:8080/servletjspdemo/addFlat\">Wystaw mieszkanie</a></p>" +
                "</body></html>");

    }
}
