<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form class="trip_form" action="NewNoteServlet" method="post" id="new_note" enctype="multipart/form-data">
    <h2>Můj nový výlet</h2>
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
                       placeholder="Road trip do Makedonie" required>
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
                       placeholder="Bratislava, Budapešť, Gráz, Kosovo" required>
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
                <div class="img_div">
                    <%--Uploaded image--%>
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
                <input type="date" class="form-control" id="date" name="date" required>
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
                <input type="number" class="form-control" id="distance" name="distance" step=".01" min="0" required>
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
                <input type="time" class="form-control" id="time" name="time">
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
                <textarea class="form-control" id="notes" name="notes"></textarea>
            </div>
        </div>
    </div>
    <button type="submit" class="btn btn-success">
        <i class="fas fa-cloud-upload-alt"></i> Uložit
    </button>
</form>
