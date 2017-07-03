<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-route.js"></script>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body ng-app="myapp">
        <div>
            <p><a href="#/">Main</a></p>
            <a href="#london">City1</a>
            <a href="#paris">City2</a>
            <p>Click the links to read about london and Paris</p>
        </div>
        <div ng-view></div>
    </body>
    <script>
                var app = angular.module("myapp", ["ngRoute"])
                app.config(function ($routeProvider) {
                    $routeProvider
                            .when("/", {
                                templateUrl: "main.html"
                            })
                            .when("/london", {
                                templateUrl: "/WEB-INF/views/London.html",
                                controller: "londonCtrl"
                            })
                            .when("/paris", {
                                templateUrl: "paris.html",
                                controller: "parisCtrl"
                            });
                });
                app.controller("londonCtrl", function ($scope) {
                    $scope.msg = "I love London";
                });
                app.controller("parisCtrl", function ($scope) {
                    $scope.msg = "I love paris";
                });
    </script>
</html>
