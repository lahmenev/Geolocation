<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Geolocation</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"/>
    <script defer src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">

    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <a class="navbar-brand" href="/geolocation">Geolocation</a>
        <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
            <li class="nav-item active">
                <a class="nav-item nav-link btn" href="/geolocation">Geolocation log<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-item nav-link btn " href="/geolocation/putCoordinates">Put coordinates</a>
            </li>
            <li class="nav-item">
                <a class="nav-item nav-link btn " href="/geolocation/putQuery">Put query</a>
            </li>
            <li class="nav-item">
                <a class="nav-item nav-link btn " href="/geolocation/countrySearch">Search log by country</a>
            </li>
        </ul>
        <a class="nav-item nav-link btn" href="/logout">LogOut</a>

    </div>
</nav>

</body>
</html>
