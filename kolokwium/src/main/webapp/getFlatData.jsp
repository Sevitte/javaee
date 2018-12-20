<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dodaj produkt</title>
    </head>
    <body>
    <jsp:useBean id="storage" class="ug.znapierala.javaee.shop.service.StorageService" scope="application" />
    <jsp:useBean id="flat" class="ug.znapierala.javaee.shop.domain.Flat" scope="session" />

        <h2>Dodaj produkt</h2>
        <form action='addFlat.jsp' method='POST'>
            Id: <input type='number' name='id' required value="${flat.id}" /><br>
            Nazwa: <input type='text' name='name' required value="${flat.name}" /> <br>
            Dostepny: <input type='checkbox' name='isAviliable'
            <%
                if(flat.isAviliable()) {
                    out.println("checked");
                }
            %>/><br>
            Cena: <input type='number' name='price' step='any' required value="${flat.price}" /><br>
            Data wystawienia: <input type='date' name='date' required
            <%
                SimpleDateFormat df = new SimpleDateFormat ("yyyy-MM-dd");
                out.println("value = '" + df.format(flat.getDate()) + "'");
            %> /><br>
            <input type='submit' value='Dodaj'/>
        </form>
        <a href='index.jsp'>Powrót</a>
    </body>
</html>
