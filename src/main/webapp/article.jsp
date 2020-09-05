<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <jsp:include page="include/meta.jsp"/>
    <title>SDA Twitter artykół</title>
    <meta name="description" content="artykułół">
    <meta name="keyword" content="artykuł, sda, twitter">
</head>
<body>
<jsp:include page="include/header.jsp"/>
<main role="main" ng-app="articleApp">
    <div ng-controller="articleController" ng-init="articleById(<%= request.getParameter("id")%>)">
        <div class="jumbotron">
            <div class="container">
                <p>Użytkownik <b>{{article.user.login}}</b> napisał:</p>
                <p>{{article.content}}</p>
            </div>
        </div>
    </div>
</main>
<jsp:include page="include/footer.jsp"/>
</body>
<script src="${pageContext.request.contextPath}/js/angular.js"></script>
<script src="${pageContext.request.contextPath}/js/controller.js"></script>
</html>
