<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
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
    <form action="/admin/delete/${id}}">
        <div class="form gp">
            <div class="col-sm-4">
                <label for="id" class="col-form-label-sm">Delete by id:</label>
                <input type="text" class="form-control col-form-label-sm" id="id"
                       name="id"
                       placeholder="id">
                <div class="actions">
                    <input class=" btn btn-primary" type="submit"
                           value="Delete">
                </div>
            </div>
        </div>
    </form>
</div>
</br>

<div class="container">
    <div class="col-sm-4">
        <table class="table table-sm table-bordered">
            <thead>
            <tr align="center" class="table-active">
                <th>id</th>
                <th>email</th>
                <th>more info</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${userList}" var="user">
                <tr align="center">
                    <td>${user.id}</td>
                    <td>${user.username}</td>
                    <td><a href="/admin/show/${user.username}">${"+"}</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<div class="container">
    <h1>${user}</h1>
    <table class="table table-sm table-bordered">
        <thead>
        <tr align="center" class="table-active">
            <th>link</th>
            <th>tags</th>
            <th>description</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${linkList}" var="link">
            <tr>
                <td><a href="${link.linkName}">${link.linkName}</a></td>
                <td>*${link.tag1}*${link.tag2}*${link.tag3}*</td>
                <td>${link.description}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<footer class="modal-footer" id="footer1">
    <div text-align="center">
        <p>#LinksSaver 2018</p>
    </div>
</footer>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
