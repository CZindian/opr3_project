<%@ page import="cz.osu.opr3.project.notepadofexcursionist.service.LoggedInUserManager" %>
<%@ page import="java.util.List" %>
<%@ page import="cz.osu.opr3.project.notepadofexcursionist.repository.entity.TripEntity" %>
<%@ page import="java.util.Collections" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:if test="<%=LoggedInUserManager.hasTrips()%>">
    <%
        List<TripEntity> trips = LoggedInUserManager.getTripData();
        Collections.sort(trips);
        for (int i = 0; i < trips.size(); i++) {%>
    <div class="trip_form mb-3">
        <form>
            <div class="form-group row align-items-center my-3">
                <label for="heading" class="col-sm-4 col-form-label">Výlet</label>
                <div class="col-sm-8">
                    <div class="input-group">
                        <div class="input-group-prepend my-2 mx-1">
                    <span class="input-group-text" id="inputGroupPrepend1">
                        <i class="fas fa-heading"></i>
                    </span>
                        </div>
                        <input class="form-control" id="heading"
                               placeholder="<%=trips.get(i).getTripTitle()%>" disabled>
                    </div>
                </div>
            </div>
            <div class="form-group row align-items-center my-3">
                <label for="type" class="col-sm-4 col-form-label">Tag výletu</label>
                <div class="col-sm-8">
                    <div class="input-group">
                        <div class="input-group-prepend my-2 mx-1">
                    <span class="input-group-text" id="inputGroupPrepend2">
                        <i class="fas fa-tag"></i>
                    </span>
                        </div>
                        <input class="form-control" id="type"
                               placeholder="<%=trips.get(i).getTripCategory()%>" disabled>
                    </div>
                </div>
            </div>
            <div class="form-group row align-items-center my-3">
                <label class="col-sm-4 col-form-label">Navštívená místa</label>
                <div class="col-sm-8">
                    <div class="input-group">
                        <div class="input-group-prepend my-2 mx-1">
                            <span class="input-group-text" id="inputGroupPrepend3">
                                <i class="fas fa-map-marked-alt"></i>
                            </span>
                        </div>
                        <div>
                            <ul class="list-group">
                                <%
                                    List<String> visitedPlaces = LoggedInUserManager.getListOfTripPlaces(i);
                                    for (String visitedPlace : visitedPlaces) {
                                %>
                                <li class="list-group-item"><%=visitedPlace%>
                                </li>
                                <%
                                    }%>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="form-group row align-items-center my-3">
                    <label class="col-sm-4 col-form-label">Moje nejlepší fotka</label>
                    <div class="col-sm-8">
                        <div class="input-group">
                            <div class="input-group-prepend my-1">
                    <span class="input-group-text" id="inputGroupPrepend4">
                        <i class="fas fa-heading"></i>
                    </span>
                            </div>
                            <%
                                String base64 = LoggedInUserManager.getTripPicture(i);
                                if (!base64.trim().isEmpty()) {
                            %>
                            <div id="img_div">
                                <img id="trip_img" src="<%=base64%>"
                                     alt="výlet <%=trips.get(i).getTripTitle()%>, <%=trips.get(i).getTripCategory()%>, <%=trips.get(i).getTripDate()%>">
                            </div>
                            <%
                                }
                            %>
                        </div>
                    </div>
                </div>
                <div class="form-group row align-items-center my-3">
                    <label for="date" class="col-sm-4 col-form-label">Den výletu</label>
                    <div class="col-sm-8">
                        <div class="input-group">
                            <div class="input-group-prepend my-2 mx-1">
                    <span class="input-group-text" id="inputGroupPrepend5">
                        <i class="fas fa-calendar-alt"></i>
                    </span>
                            </div>
                            <input class="form-control" id="date" value="<%=trips.get(i).getTripDate()%>" disabled>
                        </div>
                    </div>
                </div>
                <div class="form-group row align-items-center my-3">
                    <label for="distance" class="col-sm-4 col-form-label">Délka výletu</label>
                    <div class="col-sm-8">
                        <div class="input-group">
                            <div class="input-group-prepend my-2 mx-1">
                    <span class="input-group-text" id="inputGroupPrepend6">
                        <i class="fas fa-ruler"></i>
                    </span>
                            </div>
                            <input class="form-control" id="distance" value="<%=trips.get(i).getTripDistance()%> Km"
                                   disabled>
                        </div>
                    </div>
                </div>
                <div class="form-group row align-items-center my-3">
                    <label for="time" class="col-sm-4 col-form-label">Čas výletu</label>
                    <div class="col-sm-8">
                        <div class="input-group">
                            <div class="input-group-prepend my-2 mx-1">
                    <span class="input-group-text" id="inputGroupPrepend7">
                        <i class="fas fa-stopwatch"></i>
                    </span>
                            </div>
                            <input class="form-control" id="time" value="<%=trips.get(i).getTripTime()%> h." disabled>
                        </div>
                    </div>
                </div>
                <div class="form-group row align-items-center my-3">
                    <label for="notes" class="col-sm-4 col-form-label">Poznámky k výletu</label>
                    <div class="col-sm-8">
                        <div class="input-group">
                            <div class="input-group-prepend my-2 mx-1">
                    <span class="input-group-text" id="inputGroupPrepend8">
                        <i class="fas fa-stopwatch"></i>
                    </span>
                            </div>
                            <textarea class="form-control text-left" id="notes" disabled>
                        <%=trips.get(i).getTripNotes()%>
                    </textarea>
                        </div>
                    </div>
                </div>
            </div>
        </form>
        <div class="form-group row">
            <div class="col-md-6 text-center">
                <form action="DeleteNoteServlet" method="post">
                    <input type="hidden" value="<%=trips.get(i).getTripId()%>" name="tripIdDelete">
                    <button type="submit" class="btn btn-warning"><i class="far fa-trash-alt"></i> Smazat</button>
                </form>
            </div>
            <div class="col-md-6 text-center">
                <form action="UpdateNoteServlet" method="post">
                    <input type="hidden" value="<%=trips.get(i).getTripId()%>" name="tripIdUpdate">
                    <button type="submit" class="btn btn-info"><i class="far fa-edit"></i> Upravit</button>
                </form>
            </div>
        </div>
    </div>
    <%
        }%>
</c:if>

<c:if test="<%=!LoggedInUserManager.hasTrips()%>">
    <div class="alert alert-warning" role="alert">
        <h2 class="alert-heading">Ups!</h2>
        <p>Zatím tady žádné tvoje výlety nevidím.</p>
        <hr>
        <p class="mb-0">Běž si hned jeden přidat :)</p>
    </div>
</c:if>
