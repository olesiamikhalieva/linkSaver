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
        <%@include file='../resources/css/mainLink.css' %>
    </style>
</head>
<body>
<div class="container">
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
        <div class="col-md-offset-8"><h4>Welcome, ${pageContext.request.userPrincipal.name} | <a
                onclick="document.forms['logoutForm'].submit()">Logout</a></h4></div>
    </c:if>

</div>
<div class="alert alert-info" role="alert">
    <h1>LinksSaver</h1>
</div>
<div class="container">
    <div class="col-md-4">
        <form action="/linksSaver/add" modelAttribute="linkFormDto">
            <div class="form gp">

                <label for="linkName"
                       class="col-form-label-sm">Link:</label>
                <input type="text" class="form-control col-form-label-sm"
                       id="linkName"
                       name="linkName">
                <label for="tagEntity1"
                       class="col-form-label-sm">Tag_1:</label>
                <div class="input-append">
                    <input type="text"
                           class="form-control col-form-label-sm"
                           id="tagEntity1"
                           name="tag1">
                </div>
                <label for="tagEntity2"
                       class="col-form-label-sm">Tag_2:</label>
                <div class="input-append">
                    <input type="text"
                           class="form-control col-form-label-sm"
                           id="tagEntity2"
                           name="tag2">
                </div>
                <label for="tagEntity3"
                       class="col-form-label-sm">Tag_3:</label>
                <div class="input-append">
                    <input type="text"
                           class="form-control col-form-label-sm"
                           id="tagEntity3"
                           name="tag3">
                </div>
                <div class="form-group">
                    <label for="description">Description:</label>
                    <textarea class="form-control" rows="3" id="description"
                              name="description"></textarea>
                </div>
                <br>
                <input class=" btn btn-primary btn-sm" type="submit"
                       value="Add">
            </div>
        </form>
    </div>
    <div class="container">
        <div class="col-md-offset-8">
            <form action="/linksSaver/search">
                <input type="text" class="input-medium search-query" name="tagName">
                <button type="submit" class="btn btn-primary">Search by tag</button>
            </form>
            <form action="/linksSaver">
                <button type="submit" class="btn btn-primary">Show all</button>
            </form>
        </div>
        <c:forEach items="${allLinksList}" var="links">
            <div class="card">
                <form action="/linksSaver/delete/${links.linkName}">
                    <div class="col-md-offset-4 margin-bottom-30">
                        <div class="portlet portlet-bordered">
                            <div class="portlet-title">
                                <div class="caption caption-red">
                                    <i class="glyphicon glyphicon-cog"></i>
                                    <span class="caption-subject text-uppercase">${links.tag1}</span>
                                </div>
                                <div class="caption caption-red">
                                    <i class="glyphicon glyphicon-cog"></i>
                                    <span class="caption-subject text-uppercase">${links.tag2}</span>
                                </div>
                                <div class="caption caption-red">
                                    <i class="glyphicon glyphicon-cog"></i>
                                    <span class="caption-subject text-uppercase">${links.tag3}</span>
                                </div>
                                <br>
                                <div class="card-body">
                                    <h4 class="card-title"><a
                                            href="${links.linkName}">${links.linkName}</a>
                                    </h4>
                                    <p class="card-text">${links.description}</p>
                                    <div class="actions">
                                        <input class=" btn btn-primary" type="submit"
                                               value="Delete">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </c:forEach>
    </div>
</div>
<footer class="modal-footer" id="footer1">
    <div text-align="center">
    <p>#LinksSaver 2018</p>
    </div>
</footer>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
        crossorigin="anonymous"></script>
</body>
</html>
