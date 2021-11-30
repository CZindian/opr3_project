<%@ page import="cz.osu.opr3.project.notepadofexcursionist.service.CurrentUserManager" %>
<%@ page import="java.util.List" %>
<%@ page import="cz.osu.opr3.project.notepadofexcursionist.repository.entity.TripEntity" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="<%=CurrentUserManager.hasTrips()%>">
    <%
        List<TripEntity> trips = CurrentUserManager.getCurrentUserDada().getTrips();
        for (int i = 0; i < trips.size(); i++) {%>
    <div class="trip_div">
        <div class="trip_heading_div">
            <%=trips.get(i).getTripTitle()%>
        </div>
        <div>
            Typ výletu: <%=trips.get(i).getTripCategory()%>
        </div>
        <div class="trip_places_div">
            <span>
                Navštívená místa:
            </span>
            <ul>
                <%
                    List<String> visitedPlaces = CurrentUserManager.getListOfTripPlaces(i);
                    for (String visitedPlace : visitedPlaces) {%>
                <li><%=visitedPlace%>
                </li>
                <%
                    }%>
            </ul>
        </div>
        <%
            List<String> pictures = CurrentUserManager.getListOfTripPictures(i);
            for (String picture : pictures) {%>
        <img src="<%=picture%>"
             alt="výlet <%=trips.get(i).getTripTitle()%>, <%=trips.get(i).getTripCategory()%>, <%=trips.get(i).getTripDate()%>">
        <%
            }%>
        <div>
            Datum: <%=trips.get(i).getTripDate()%>
        </div>
        <div>
            Vzdálenost: <%=trips.get(i).getTripDistance()%>
        </div>
        <div>
            Čas: <%=trips.get(i).getTripTime()%> hodin
        </div>
        <div>
            Osobní poznámky: <%=trips.get(i).getTripNotes()%>
        </div>
        <div>
            <button>Zobrazit trasu v mapě (nepřipraveno)</button>
        </div>
        <div class="trip_adjust_div">
            <button>Upravit (nepřipraveno)</button>
            <button>Smazat (nepřipraveno)</button>
        </div>
    </div>
    <%
        }%>
</c:if>
<c:if test="<%=!CurrentUserManager.hasTrips()%>">
    <div class="trip_div">
        Hola amigo! Žádné uložoné výlety tady nevidím.
    </div>
</c:if>
