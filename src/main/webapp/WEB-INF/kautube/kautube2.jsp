<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LinksSaver</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/2.3.2/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/3.2.1/css/font-awesome.min.css" rel="stylesheet"
          media="screen">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <link href="../nestednav.css" rel="stylesheet">
    <style>
        <%@include file='hi.css' %>
    </style>
</head>
<body>

<div class="container">
        <div class="row">
        <div class="span12">
            <div class="container">
                <div class="row">
                    <div class="span9">
                        <div class="alert alert-info" role="alert">
                            <h1>LinksSaver</h1></div>
                    </div>
                    <div class="span3">
                        <form class="well form-search" action="/search">
                            <input type="text" class="input-medium search-query" name="themeName">
                            <button type="submit" class="btn">Search by theme</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="span12">
                    <div class="container">
                        <div class="row">
                            <div class="span3">
                                <form action="/linksSaver/add" modelAttribute="linkFormDto">
                                    <div class="form gp">
                                        <div class="col-4">
                                            <label for="linkName"
                                                   class="col-form-label-sm">Link:</label>
                                            <input type="text" class="form-control col-form-label-sm"
                                                   id="linkName"
                                                   name="linkName">

                                            <label for="tagEntity"
                                                   class="col-form-label-sm">Theme:</label>
                                            <div class="input-append">
                                                <input type="text"
                                                       class="form-control col-form-label-sm"
                                                       id="tagEntity"
                                                       name="themeName">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="description">Description:</label>
                                            <textarea class="form-control" rows="5" id="description"
                                                      name="description"></textarea>
                                        </div>
                                        <br>
                                        <input class=" btn btn-outline-primary btn-sm" type="submit"
                                               value="Add">
                                    </div>
                                </form>
                                <div class="dropdown">
                                    <button class="btn btn-default dropdown-toggle" type="button"
                                            data-toggle="dropdown">
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
                        </div>
                            <div class="row">
                                <%--<div class="span9">--%>
                                <c:forEach items="${allLinksList}" var="links">
                                    <div class="col-md-9 margin-bottom-30">
                                        <div class="portlet portlet-bordered">
                                            <div class="portlet-title">
                                                <div class="caption caption-red">
                                                    <i class="glyphicon glyphicon-cog"></i>
                                                    <span class="caption-subject text-uppercase">${links.themeName}</span>
                                                </div>
                                                <div class="actions">
                                                    <a href="javascript:;" class="btn btn-red btn-circle">
                                                        <i class="glyphicon glyphicon-trash"></i>
                                                    </a>
                                                </div>
                                            </div>
                                            <div class="portlet-body">
                                                <h4><a href="http://${links.linkName}">${links.linkName}</a></h4>
                                                <p>${links.description}</p>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
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
