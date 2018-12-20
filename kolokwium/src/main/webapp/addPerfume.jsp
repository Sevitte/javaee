<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Dodano produkt</title>
  </head>
  <body>
  <jsp:useBean id="perfume" class="ug.znapierala.javaee.shop.domain.Perfume" scope="session" />

  <jsp:setProperty name="perfume" property="id" param="id" />
  <jsp:setProperty name="perfume" property="name" param="name" />
  <jsp:setProperty name="perfume" property="price" param="price" />


  <jsp:useBean id="storage" class="ug.znapierala.javaee.shop.service.StorageService" scope="application" />

  <%
    String myCheckBoxValue = request.getParameter("isAviliable");

    boolean isAviliable;
    String Aviliable;
    if (myCheckBoxValue == null) {
      isAviliable = false;
      Aviliable = "Nie";
    }
    else {
      isAviliable = true;
      Aviliable = "Tak";
    }

    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    Date date = format.parse(request.getParameter("date"));
    perfume.setDate(date);
    perfume.setIsAviliable(isAviliable);
    storage.add(perfume);

  %>

    <h2>Dodano produkt:</h2>
    <p>Id: ${perfume.id} </p>
    <p>Nazwa: ${perfume.name} </p>
    <p>Dostepny:
      <%
        out.println(Aviliable);
      %>
    </p>
    <p>Cena: ${perfume.price} </p>
    <p>Data wystawienia ogloszenia:
    <%
      out.println(request.getParameter("date"));
    %>
    </p>
    <p>
      <a href="index.jsp">Wróć do menu</a>
    </p>
  </body>
</html>