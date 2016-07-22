(function(){
	
	angular.module("myApp").controller("userDetailController", function($scope){
		
		$scope.data= {
			fname:'Subrat', lName:'Panda', Email:'subrat@gmail.com', city:'Bangalore'	
		};
	});
	
}())