<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <jsp:include page="include/meta.jsp"/>
    <title>SDA Twitter lista artykułów</title>
    <meta name="description" content="lista artykułów">
    <meta name="keyword" content="lista, artykuł, sda, twitter">
</head>
<body>
<jsp:include page="include/header.jsp"/>
<main role="main" ng-app="articleApp">

    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
        <div class="container">
            <h1 class="display-3">Hello, world!</h1>
            <p>This is a template for a simple marketing or informational website. It includes a large callout called a
                jumbotron and three supporting pieces of content. Use it as a starting point to create something more
                unique.</p>
            <p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more &raquo;</a></p>
        </div>
    </div>
    <div ng-controller="articleController" ng-init="init()">
        <div ng-repeat="article in articles">
            <div class="jumbotron">
                <div class="container">
                    <h1 class="display-3">Hello world!</h1>
                    <p>{{article.content}}</p>
                    <p><a class="btn btn-secondary" href="${pageContext.request.contextPath}/article.jsp?id={{article.id}}" role="button">View details
                        &raquo;</a></p>
                </div>
            </div>
        </div>
    </div>
</main>
<jsp:include page="include/footer.jsp"/>
</body>
<script src="${pageContext.request.contextPath}/js/angular.js"></script>
<script src="${pageContext.request.contextPath}/js/controller.js"></script>
</html>
