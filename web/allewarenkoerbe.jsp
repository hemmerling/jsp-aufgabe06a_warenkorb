<%-- 
    Document   : cart
    Created on : 04.08.2017, 11:01:29
    Author     : rhemmerling
--%>

<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.hemmerling.aufgabe06a_warenkorb.model.persistence.*"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alle Warenkörbe</title>
    </head>
    <body>
        <jsp:include page = "header.jsp"/>
        <h1>Alle Warenkörbe</h1>
        <table style="width:100%" border="1">
            <tr>
                <th>Artikel</th>
                <th>Preis</th>
            </tr>
            <%
                ServletContext context2 = session.getServletContext();
                SessionListe sessionListe = (SessionListe) context2.getAttribute("sessions");
                List<HttpSession> sl = sessionListe.get();
                for (HttpSession aSession : sl) {
                    Warenkorb warenkorb = (Warenkorb) aSession.getAttribute("warenkorb");
                    List<Artikel> warenkorbListe = warenkorb.get();
                    double summe = 0d;
                    DecimalFormat f = new DecimalFormat("#0.00");
            %>
            <tr>
                <th  colspan="2">
                    <%= "Warenkorb '" + aSession.getId() + "':" %>
                </th>
            </tr>
            <%
                    for (Artikel artikel : warenkorbListe) {
                        double price = artikel.getPrice();
                        summe += price;
            %>
            <tr>
                <td>
                    <%= artikel.getName()%>
                </td>
                <td>
                    <%= f.format(price)%> EUR
                </td>
            </tr>
            <% }%>
            <tr>
                <th colspan="2">
                    Gesamtpreis: <%= f.format(summe)%> EUR
                </th>
            </tr>
            <% }%>
        </table>
    </body>
</html>
