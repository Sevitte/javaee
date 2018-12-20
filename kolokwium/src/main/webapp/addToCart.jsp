<%@ page import="ug.znapierala.javaee.shop.domain.Perfume" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Dodano do koszyka</title>
</head>
<body>

    <jsp:useBean id="storage" class="ug.znapierala.javaee.shop.service.StorageService" scope="application" />
    <jsp:useBean id="cart" class="ug.znapierala.javaee.shop.service.StorageService" scope="session" />

    <%
        Map<Long, Perfume> perfumes = storage.getAllPerfumes();
        Perfume perfume = perfumes.get(Long.valueOf(request.getParameter("id")));
        cart.add(perfume);
    %>

    <h2>Dodano do koszyka</h2>
    <p>
        <a href="summary.jsp">Podsumowanie</a><br>
        <a href="buyFlat.jsp">Powrót do zakupów</a>
    </p>

</body>
</html>
