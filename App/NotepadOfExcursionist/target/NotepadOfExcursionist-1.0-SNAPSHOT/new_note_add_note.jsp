<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="trip_div">
    <form action="NewNoteServlet" method="post" id="new_note">
    <span>
        <label for="heading">Nadpis</label>
        <input type="text" id="heading" name="heading">
    </span>
        <span>
        <label for="type">Typ</label>
        <select id="type" name="type">
            <option value="road_trip_auto">Road trip - auto</option>
            <option value="road_trip_motorka">Road trip - motorka</option>
            <option value="kolo">Kolo</option>
            <option value="turistika">Turistika</option>
            <option value="procházka">Procházka</option>
            <option value="cestování">Cestování</option>
        </select>
    </span>
        <span>
            <label for="places">Názvy míst</label>
            <input type="text" id="places" name="places">
        </span>
        <span>
        <label for="pictures">Obrázky</label>
        <input type="file" id="pictures" name="pictures" multiple>
        <div class="img_div"></div>
    </span>
        <span>
        <label for="date">Datum</label>
        <input type="date" id="date" name="date">
    </span>
        <span>
        <label for="distance">Vzdálenost</label>
        <input type="number" id="distance" name="distance">
    </span>
        <span>
        <label for="time">Čas</label>
        <input type="time" id="time" name="time">
    </span>
        <span>
        <label for="notes">Poznámky</label>
        <textarea id="notes" name="notes" form="new_note">
            Zde pište Vaše poznámky...
        </textarea>
    </span>
        <span>
        <label for="gpx_file">Přidejte soubor .gpx</label>
        <input type="file" id="gpx_file" name="gpx_file">
    </span>
        <input type="submit" value="Uložit">
    </form>
</div>

<script type="text/javascript" src="js/script.js"></script>