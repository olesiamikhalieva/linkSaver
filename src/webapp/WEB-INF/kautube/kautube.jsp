<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/2.3.2/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/3.2.1/css/font-awesome.min.css" rel="stylesheet"
          media="screen">
    <link href="../nestednav.css" rel="stylesheet">
</head>
<body>

<div class="container">
    <div class="row">
        <div class="span12">
            <div class="container">
                <div class="row">
                    <div class="span12">
                        <div class="row">
                            <div class="span9">
                                <div class="alert alert-info" role="alert">
                                    <h1>LinksSaver</h1></div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="span3">
                                <form class="well form-search">
                                    <input type="text" class="input-medium search-query">
                                    <button type="submit" class="btn">Поиск</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="span3">
                    <div class="container">
                        <div class="container">
                            <form action="/linksSaver/add" modelAttribute="linkDto">
                                <div class="form gp">
                                    <div class="col-4">
                                        <label for="linkName" class="col-form-label-sm">Link:</label>
                                        <input type="text" class="form-control col-form-label-sm" id="linkName"
                                               name="linkName"
                                               placeholder="link">

                                        <label for="themeEntity" class="col-form-label-sm">Theme:</label>
                                            <div class="input-append">
                                        <input type="text" class="form-control col-form-label-sm" id="themeEntity"
                                               name="themeEntity"
                                               placeholder="themeEntity">

                                            <%--<input class="span2" id="appendedInputButton" size="16" type="text">--%>
                                                <button class="btn" type="submit" value="addInputForm">+</button>
                                        </div>
                                    </div>
                                </div>
                                <br>
                                <input class=" btn btn-outline-primary btn-sm" type="submit" value="Add">
                            </form>
                        </div>
                        <div class="container">
                            <div class="dropdown">
                                <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">
                                    Setting
                                    <span class="caret"></span></button>
                                <ul class="dropdown-menu">
                                    <li><a tabindex="-1" href="#">Create</a></li>
                                    <li><a tabindex="-1" href="#">Delete</a></li>
                                    <li><a tabindex="-1" href="#">Update</a></li>
                                </ul>
                                </li>
                            </div>
                        </div>
                        <div class="span9">
                            <ul class="nav nav-tabs">
                                <li class="nav-item">
                                    <a class="nav-link active" href="#">Active</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#">Link</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#">Link</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link disabled" href="#">Disabled</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
        <script type="text/javascript"
                src="//maxcdn.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
        <script src="jquery.nestednav.min.js"></script>
</body>
</html>
