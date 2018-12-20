<%@ page import="java.util.Iterator" %>
<%@ page import="ug.znapierala.javaee.shop.domain.Perfume" %>
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
            Map<Long, Perfume> perfumes = cart.getAllPerfumes();
            if(perfumes.size() > 0) {
                Iterator it = perfumes.values().iterator();
                Perfume p;
                while (it.hasNext()) {
                    p = (Perfume) it.next();
                    total += p.getPrice();
                    out.println("<tr style='border: 1px solid black'>" +
                            "<td>" + p.showDetails() + "</td>");
                    out.println("<td>");
                    out.println("</tr>");
                }
            } else {
                out.println("<h2>Koszyk jest pusty</h2>");
            }
        %>
    </table>
    <%
        if(perfumes.size() > 0) {
            out.println("<p>Łączna kwota: "+ total + "</p><br>");
        }
    %>
    <a href='index.jsp'>Powrót</a>

</body>
</html>
