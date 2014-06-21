<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesextras" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<tilesextras:useAttribute name="body" classname="String"/>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>cards app</title>
    <link rel="stylesheet" href="../css/bootstrap.css"/>
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-9">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Cards demo</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-9">
            <ul class="nav nav-pills">
                <li class="${newCard or updateCard ? "active":""}"><a href="/">${updateCard? "Úprava karty":"Nová karta"}</a></li>
                <li class="${not (newCard or updateCard) ? "active":""}"><a href="/cards">Všetky karty</a></li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
<div class="container">
    <tiles:insertAttribute name="body"/>
</div>
</body>
</html>