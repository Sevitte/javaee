<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ankieta</title>
</head>
<body>
    <jsp:useBean id="survey" class="ug.znapierala.javaee.shop.domain.Survey" scope="session" />

    <h2>Uzupełnij ankietę</h2>
    <form action='sendSurvey.jsp' method='POST'>
        Data użytkowanie (od): <input type='date' name='usedFrom' required value="<%
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                out.print(df.format(survey.getUsedFrom()));
            %>" /><br>
        Data użytkowanie (do): <input type='date' name='usedTo' required value="<%
                out.print(df.format(survey.getUsedTo()));
            %>" /><br>
        <p>Częstotliwość użytkowania:</p>
        <input type="radio" name="frequency" value="Codziennie" <%
            if(survey.getFrequency().equals("Codziennie")) {
                out.print("checked");
            }
        %>>Codzinnie<br>
        <input type="radio" name="frequency" value="Raz w tygodniu" <%
            if(survey.getFrequency().equals("Raz w tygodniu")) {
                out.print("checked");
            }
        %>>Raz w tygodniu<br>
        <input type="radio" name="frequency" value="Rzadziej"<%
            if(survey.getFrequency().equals("Rzadziej")) {
                out.print("checked");
            }
        %>>Rzadziej<br>
        <p>Dzielnice:</p>
        <input type="checkbox" name="comments" value="Orlowo" <%
            if(survey.ifCommentSelected("Orlowo")) {
                out.print("checked");
            }
        %>>Orlowo<br>
        <input type="checkbox" name="comments" value="Redlowo"<%
            if(survey.ifCommentSelected("Redlowo")) {
                out.print("checked");
            }
        %>>Redlowo<br>
        <input type="checkbox" name="comments" value="Wzgorze Swietego Maksymiliana" <%
            if(survey.ifCommentSelected("Wzgorze Swietego Maksymiliana")) {
                out.print("checked");
            }
        %>>Wzgorze Swietego Maksymiliana<br>
        <input type="checkbox" name="comments" value="Chylonia" <%
            if(survey.ifCommentSelected("Chylonia")) {
                out.print("Chylonia");
            }
        %>>Chylonia<br>
        <button type="submit">Prześlij</button>
    </form>
    <p>
        <a href="index.jsp">Wróć do menu</a>
    </p>
</body>
</html>
