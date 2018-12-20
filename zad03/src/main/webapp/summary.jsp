<%@ page import="java.util.Iterator" %>
<%@ page import="ug.znapierala.javaee.shop.domain.Flat" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Podsumowanie</title>
</head>
<body>
    <jsp:useBean id="cart" class="ug.znapierala.javaee.shop.service.StorageService" scope="session" />
    <h2>Koszyk:</h2>
    <table style='border-collapse: collapse;'>
        <%
            double total = 0;
            Map<Long, Flat> flats = cart.getAllFlats();
            if(flats.size() > 0) {
                Iterator it = flats.values().iterator();
                Flat f;
                while (it.hasNext()) {
                    f = (Flat) it.next();
                    total += f.getPrice();
                    out.println("<tr style='border: 1px solid black'>" +
                            "<td>" + f.showDetails() + "</td>");
                    out.println("<td>");
                    out.println("</tr>");
                }
            } else {
                out.println("<h2>Koszyk jest pusty</h2>");
            }
        %>
    </table>
    <%
        if(flats.size() > 0) {
            out.println("<p>Łączna kwota: "+ total + "</p><br>");
        }
    %>
    <a href='index.jsp'>Powrót</a>

</body>
</html>
