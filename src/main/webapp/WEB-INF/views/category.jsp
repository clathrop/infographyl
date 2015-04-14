<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>infographyl</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

        <link href="/infographyl/css/mystyles.css" rel="stylesheet" type="text/css" />

        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

    </head>
    <body>
        <nav class="navbar navbar-inverse">
          <div class="container">
            <div class="navbar-header">
              <a class="navbar-brand" href="/">infographyl</a>
            </div>
            <div>
              <ul class="nav navbar-nav">
                <li class="active"><a href="/">home</a></li>
              </ul>
            </div>
            <div>
              <ul class="nav navbar-nav">
                <li class="active"><a href="/category/technology">technology</a></li>
              </ul>
            </div>
          </div>
        </nav>

        <div class="container mycontainer">
                <h1 class="title">infographyl</h1>
                <h2 class="subtitle">feed the mind</h2>
                <div class="row">

                  <div class="col-sm-3">
                    <a href="#" class="thumbnail">
                      <div class="caption">
                            ${igList[0].name}
                      </div>
                        <div class="image">
                          <img src=${igList[0].url} class="img img-responsive full-width" alt=${igList[0].name} width="300" height="300"/>
                        </div>
                    </a>
                  </div>
                  <div class="col-sm-3">
                      <a href="#" class="thumbnail">
                          <div class="caption">
                              ${igList[1].name}
                          </div>
                          <div class="image">
                              <img src=${igList[1].url} class="img img-responsive full-width" alt=${igList[1].name} width="300" height="300"/>
                          </div>
                      </a>
                  </div>

                </div>
        </div>

    </body>
</html>
