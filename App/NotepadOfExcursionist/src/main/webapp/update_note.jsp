<%@ page import="cz.osu.opr3.project.notepadofexcursionist.repository.entity.TripEntity" %>
<%@ page import="cz.osu.opr3.project.notepadofexcursionist.service.LoggedInUserManager" %>
<%@ page import="cz.osu.opr3.project.notepadofexcursionist.utils.Validator" %>
<%@ page import="static cz.osu.opr3.project.notepadofexcursionist.utils.Constants.DATE_FORMAT_PATTERN" %>
<%@ page import="static cz.osu.opr3.project.notepadofexcursionist.utils.Constants.DATE_FORMAT_PATTERN_DEFAULT" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    TripEntity trip = LoggedInUserManager.getTripEntityToUpdate();
    String tripTypeValue = Validator.reformatTripValue(
            trip.getTripCategory()
    );
    String tripDate = Validator.formatDate(
            trip.getTripDate(), DATE_FORMAT_PATTERN, DATE_FORMAT_PATTERN_DEFAULT
    );
%>
<form class="trip_form" action="ProcessUpdateServlet" method="post" id="new_note" enctype="multipart/form-data">
    <h2>Upravit výlet</h2>
    <div class="form-group row align-items-center my-3">
        <label for="heading" class="col-sm-4 col-form-label">Název pro výlet</label>
        <div class="col-sm-8">
            <div class="input-group">
                <div class="input-group-prepend my-2 mx-1">
                    <span class="input-group-text" id="inputGroupPrepend1">
                        <i class="fas fa-heading"></i>
                    </span>
                </div>
                <input type="text" class="form-control" id="heading" name="heading" minlength="1"
                       value="<%=trip.getTripTitle()%>" required>
            </div>
        </div>
    </div>
    <div class="form-group row align-items-center my-3">
        <label for="type" class="col-sm-4 col-form-label">Tag výletu</label>
        <div class="col-sm-8">
            <div class="input-group">
                <div class="input-group-prepend mx-1">
                    <span class="input-group-text" id="inputGroupPrepend2">
                        <i class="fas fa-tag"></i>
                    </span>
                </div>
                <select id="type" name="type">
                    <option value="<%=tripTypeValue%>" selected="selected">
                        <%=trip.getTripCategory()%>
                    </option>
                    <option value="road_trip_auto">Road trip - auto</option>
                    <option value="road_trip_motorka">Road trip - motorka</option>
                    <option value="kolo">Kolo</option>
                    <option value="turistika">Turistika</option>
                    <option value="procházka">Procházka</option>
                    <option value="cestování">Cestování</option>
                </select>
            </div>
        </div>
    </div>
    <div class="form-group row align-items-center my-3">
        <label for="places" class="col-sm-4 col-form-label">Moje navštívená místa</label>
        <div class="col-sm-8">
            <div class="input-group">
                <div class="input-group-prepend my-2 mx-1">
                    <span class="input-group-text" id="inputGroupPrepend3">
                        <i class="fas fa-map-marked-alt"></i>
                    </span>
                </div>
                <input type="text" class="form-control" id="places" name="places"
                       value="<%=trip.getTripPlaces()%>" required>
            </div>
        </div>
    </div>
    <div class="form-group row align-items-center my-3">
        <label for="picture" class="col-sm-4 col-form-label">Moje nejlepší fotka</label>
        <div class="col-sm-8">
            <div class="input-group">
                <div class="input-group-prepend my-1">
                    <span class="input-group-text" id="inputGroupPrepend4">
                        <i class="far fa-images"></i>
                    </span>
                </div>
                <input type="file" class="file" id="picture" name="picture" data-show-preview="true"
                       accept="image/x-png,image/gif,image/jpeg">
                <div id="img_div">
                    <%--Uploaded image--%>
                    <c:if test="<%=!trip.getTripPicture().isEmpty()%>">
                        "<img id="trip_img" src="<%=trip.getTripPicture()%>"
                        alt="výlet <%=trip.getTripTitle()%>, <%=trip.getTripCategory()%>, <%=trip.getTripDate()%>">
                    </c:if>
                </div>
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
                <%-- //TODO trip date in input --%>
                <input type="date" class="form-control" id="date" name="date" value="<%=tripDate%>" required>
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
                <input type="number" class="form-control" id="distance" name="distance" step=".01" min="0"
                       value="<%=trip.getTripDistance()%>" required>
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
                <%-- //TODO tripTime in input --%>
                <input type="time" class="form-control" id="time" name="time" value="<%=trip.getTripTime()%>">
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
                <c:if test="<%=!trip.getTripNotes().isEmpty()%>">
                    <textarea class="form-control" id="notes" name="notes"><%=trip.getTripNotes()%></textarea>
                </c:if>
                <c:if test="<%=trip.getTripNotes().isEmpty()%>">
                    <textarea class="form-control" id="notes" name="notes"></textarea>
                </c:if>
            </div>
        </div>
    </div>
    <button type="submit" class="btn btn-success">
        <i class="fas fa-cloud-upload-alt"></i> Uložit
    </button>
</form>
