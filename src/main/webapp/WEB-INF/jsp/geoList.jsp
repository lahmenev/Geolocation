<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Geolocation List</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"/>
    <script defer src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="/geolocation">Geolocation</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav">
            <a class="nav-item nav-link active" href="/geolocation">Geolocation log<span class="sr-only">(current)</span></a>
            <a class="nav-item nav-link btn btn-dark" href="/geolocation/addform">Add location</a>
        </div>
    </div>
</nav>

<div class="container">
    <h2 style="margin-bottom: 20px; margin-top: 20px"; align="center">Geolocation log</h2>
    <table border="1" cellpadding="5" class="table table-striped">
        <thead class="thead-dark">
        <th scope="row">Id</th>
        <th scope="row">Country</th>
        <th scope="row">Display name</th>
        <th scope="row">Latitute</th>
        <th scope="row">Lon</th>
        <th scope="row">Osm id</th>
        <th scope="row">Osm type</th>
        </thead>
        <tbody>
        <c:forEach items="${geoList}" var="geo">
            <tr>
                <td>${geo.id}</td>
                <td>${geo.addressEntity.country}</td>
                <td>${geo.displayName}</td>
                <td>${geo.latitute}</td>
                <td>${geo.lon}</td>
                <td>${geo.osmId}</td>
                <td>${geo.osmType}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
