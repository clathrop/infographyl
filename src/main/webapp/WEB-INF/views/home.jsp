<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>infographyl</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

    <link href="/css/mystyles.css" rel="stylesheet" type="text/css" />

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

</head>
<body>
    <nav class="navbar navbar-inverse navbar-static-top">
    <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand" href="/">infographyl</a>
            </div>
            <!-- <div>
                <ul class="nav navbar-nav">
                    <li class="active"><a href="/">home</a></li>
                </ul>
            </div> -->
            <div>
                <ul class="nav navbar-nav">
                    <li class="active"><a href="/category/technology">technology</a></li>
                </ul>
            </div>
            <div>
                <ul class="nav navbar-nav">
                    <li class="active"><a href="/category/food">food</a></li>
                </ul>
            </div>
            <div>
                <ul class="nav navbar-nav">
                    <li class="active"><a href="/category/health">health</a></li>
                </ul>
            </div>
            <div>
                <ul class="nav navbar-nav">
                    <li class="active"><a href="/category/travel">travel</a></li>
                </ul>
            </div>
            <div>
                <ul class="nav navbar-nav">
                    <li class="active"><a href="/category/history">history</a></li>
                </ul>
            </div>
            <div>
                <ul class="nav navbar-nav">
                    <li class="active"><a href="/category/lifehack">lifehack</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="container mycontainer">
        <h1 class="title">infographyl</h1>
        <h2 class="subtitle">feed the mind</h2>
        <div class="row">
            <div class="col-md-8">
                <img src=${url} class="img-rounded" alt=${name} width="750">
            </div>
            <div class="col-md-4">
                <br><br>
                <p class="text-muted topp"><small>Description: </small></p>
                <p class="bottomp">${description}</p>
                <p class="text-muted topp"><small>Category: </small></p>
                <p class="bottomp">${category}</p>
                <p class="text-muted topp"><small>Tags: </small></p>
                <p class="bottomp">${tags}</p>
                <a href="/" class="btn btn-info" role="button">New Infographic</a>
            </div>
        </div>
    </div>

</body>
</html>
