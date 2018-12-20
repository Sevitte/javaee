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
  <jsp:useBean id="flat" class="main.ug.znapierala.javaee.shop.domain.Flat" scope="session" />

  <jsp:setProperty name="laptop" property="id" param="id" />
  <jsp:setProperty name="laptop" property="name" param="name" />
  <jsp:setProperty name="laptop" property="price" param="price" />


  <jsp:useBean id="storage" class="main.ug.znapierala.javaee.shop.service.StorageService" scope="application" />

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
    flat.setDate(date);
    flat.setIsAviliable(isAviliable);
    storage.add(flat);

  %>

    <h2>Dodano produkt:</h2>
    <p>Id: ${flat.id} </p>
    <p>Nazwa: ${flat.name} </p>
    <p>Dostepny:
      <%
        out.println(Aviliable);
      %>
    </p>
    <p>Cena: ${flat.price} </p>
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