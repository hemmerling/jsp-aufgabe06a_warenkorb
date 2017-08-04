<%-- 
    Document   : articles
    Created on : 04.08.2017, 11:01:53
    Author     : rhemmerling
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.hemmerling.aufgabe06a_warenkorb.model.persistence.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Artikelliste</title>
    </head>
    <body>
        <jsp:include page = "header.jsp"/>
        <h1>Artikelliste</h1>
        <table style="width:100%" border="1">
            <tr>
                <th>Bestellnummer</th>
                <th>Artikel</th>
                <th>Preis</th>
                <th>Aktion</th>
            </tr>
            <%
                ArrayList<Artikel> artikelListe = new ArtikelListe().get();
                double summe = 0d;
                DecimalFormat f = new DecimalFormat("#0.00");
                for (int ii = 0; ii < artikelListe.size(); ii++) {
                    double price = artikelListe.get(ii).getPrice();
                    summe += price;
                ;%>
            <tr>
                <td>
                    <%= ii%>
                </td>
                <td>
                    <%= artikelListe.get(ii).getName()%>
                </td>
                <td>
                    <%= f.format(price)%> EUR
                </td>
                <td>
                    <a href="FrontController?action=add_artikel&amp;id=<%= ii%>">Zum Warenkorb hinzufügen</a>
                </td>
        </td>
    </tr>
    <% }%>
</table>
</body>
</html>
