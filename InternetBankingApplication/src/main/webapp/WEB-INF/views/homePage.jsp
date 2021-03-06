<!DOCTYPE html>
<html lang="en" ng-app="myApp" class="no-js">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Spring and Angularjs</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../static/css/app.css">
</head>
<body>
<h2>Spring and Angularjs </h2>
<div class="home-section">
    <ul class="menu-list">
        <li><a href="#/userDetail">User Details</a></li>
        <li><a href="#/contactus">Contact</a></li>
    </ul>
</div>
<div ng-view></div>
<script src="./webjars/angularjs/1.4.8/angular.js"></script>
<script src="./webjars/angularjs/1.4.8/angular-resource.js"></script>
<script src="./webjars/angularjs/1.4.8/angular-route.js"></script>
<!-- <script src="../static/js/app.js"></script>
<script src="../resources/static/js/controller.js"></script> -->

<script src="../resources/static/js/module/app.js"></script>
<script src="../resources/static/js/controller/defaultController.js"></script>
<script src="../resources/static/js/controller/UserDetailController.js"></script>

<link rel="stylesheet" href="./webjars/bootstrap/3.3.6/css/bootstrap.css">
</body>
</html>