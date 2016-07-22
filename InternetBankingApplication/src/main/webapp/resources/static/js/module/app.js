var app = angular.module('myApp', ['ngRoute','ngResource']);
app.config(function($routeProvider){
    $routeProvider
    			.when("/", {
    			controller : "defaultcontroller",
    			template : "<h1> {{ title }} </h1>"
    			})
        .when('/userDetail',{
            templateUrl: 'resources/static/views/userData.html',
            controller: 'userDetailController'
        })
        .when('/contactus',{
            templateUrl: 'resources/static/views/contactus.html',
            controller: 'contactusController'
        })
        .otherwise(
            { redirectTo: '/'}
        );
});