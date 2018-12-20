<%@ page import="java.util.Iterator" %>
<%@ page import="ug.znapierala.javaee.shop.domain.Flat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kup produkt</title>
    </head>
    <body>
        <jsp:useBean id="storage" class="ug.znapierala.javaee.shop.service.StorageService" scope="application" />
        <h2>Produkty:</h2>
        <table style='border-collapse: collapse;'>
            <%
                Iterator it = storage.getAllFlats().values().iterator();
                Flat f;
                while (it.hasNext()) {
                    f = (Flat) it.next();
                    out.println("<tr style='border: 1px solid black'>" +
                            "<td>" + f.showDetails() + "</td>");
                    out.println("<td>");
                    out.println("<form action='addToCart.jsp' method='POST'>");
                    out.println("<input name='id' hidden value='" + f.getId() + "'/>");
                    out.println("<input type='submit' value='Do koszyka'/>");
                    out.println("</form>");
                    out.println("</td>");
                    out.println("</tr>");
                }
            %>
        </table>
        <a href='summary.jsp'>Podsumowanie</a><br>
        <a href='index.jsp'>Powrót</a>
    </body>
</html>
