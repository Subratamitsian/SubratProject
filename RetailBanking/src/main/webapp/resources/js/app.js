var App = angular.module('myApp',['ngRoute']);
App.config(['$routeProvider',function($routeProvider){
	$routProvider
	.when('/users/:id/:accType',{
			templateURL:'/users',
			controller: "userController as userCtrl",
			resolve:{
				async:['userService','$route',function(userService,$route){
					return userService.fetchSpecificUserDetails($route.current.params.id,$route.current.params.accType);
				}]
			}
	})
	.when('/users',{
		template:'Welcome User!!!!'
	})
}
]);