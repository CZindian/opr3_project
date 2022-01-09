<%@ page import="cz.osu.opr3.project.notepadofexcursionist.service.LoggedInUserManager" %>
<%@ page import="java.util.List" %>
<%@ page import="cz.osu.opr3.project.notepadofexcursionist.repository.entity.TripEntity" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="<%=LoggedInUserManager.hasTrips()%>">
    <%
        List<TripEntity> trips = LoggedInUserManager.getTripData();
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
                    List<String> visitedPlaces = LoggedInUserManager.getListOfTripPlaces(i);
                    for (String visitedPlace : visitedPlaces) {%>
                <li><%=visitedPlace%>
                </li>
                <%
                    }%>
            </ul>
        </div>
        <%
            String tripPicture = LoggedInUserManager.getTripPicture(i);
            %>
        <img src="<%=tripPicture%>" alt="výlet <%=trips.get(i).getTripTitle()%>, <%=trips.get(i).getTripCategory()%>, <%=trips.get(i).getTripDate()%>">
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
        <div class="trip_adjust_div">
            <button>Upravit (nepřipraveno)</button>
            <button>Smazat (nepřipraveno)</button>
        </div>
    </div>
    <%
        }%>
</c:if>

<c:if test="<%=!LoggedInUserManager.hasTrips()%>">
    <div class="trip_div">
        Hola amigo! Žádné uložoné výlety tady nevidím.
    </div>
</c:if>
