<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LinksSaver</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <style>
        <%@include file='../kautube/hi.css' %>
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
                        <form class="well form-search" action="/linksSaver/search">
                            <input type="text" class="input-medium search-query" name="tagName">
                            <button type="submit" class="btn">Search by tag</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <%--<div class="row">--%>
            <%--<div class="span12">--%>
            <%--<div class="container">--%>
            <div class="row">
                <%--<div class="span3">--%>
                <form action="/linksSaver/add" modelAttribute="linkFormDto">
                    <div class="form gp">
                        <div class="col-md-4 margin-bottom-30">
                            <%--<div class="col-4">--%>
                            <label for="linkName"
                                   class="col-form-label-sm">Link:</label>
                            <input type="text" class="form-control col-form-label-sm"
                                   id="linkName"
                                   name="linkName">

                            <label for="tagEntity"
                                   class="col-form-label-sm">Tag:</label>
                            <div class="input-append">
                                <input type="text"
                                       class="form-control col-form-label-sm"
                                       id="tagEntity"
                                       name="tagName">
                            </div>
                            <div class="form-group">
                                <label for="description">Description:</label>
                                <textarea class="form-control" rows="5" id="description"
                                          name="description"></textarea>
                            </div>
                            <br>
                            <input class=" btn btn-primary btn-sm" type="submit"
                                   value="    Add    ">
                        </div>
                    </div>
                </form>
                <div class="row">
                    <div class="container">
                        <c:forEach items="${allLinksList}" var="links">
                            <div class="card">
                                <div class="col-md-offset-4 margin-bottom-30">
                                    <div class="portlet portlet-bordered">
                                        <div class="portlet-title">
                                            <div class="caption caption-red">
                                                <i class="glyphicon glyphicon-cog"></i>
                                                <span class="caption-subject text-uppercase">${links.tagName}</span>
                                            </div>
                                            <br>
                                            <div class="card-body">
                                                <h4 class="card-title"><a href="${links.linkName}">${links.linkName}</a>
                                                </h4>
                                                <p class="card-text">${links.description}</p>
                                                <div class="actions">
                                                    <a href="/linksSaver/delete" class="btn btn-primary">Delete</a>
                                                    <a href="#" class="btn btn-primary">Edit</a>
                                                </div>
                                            </div>
                                        </div>
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
<%--</div>--%>
<%--</div>--%>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
        crossorigin="anonymous"></script>
</body>
</html>
