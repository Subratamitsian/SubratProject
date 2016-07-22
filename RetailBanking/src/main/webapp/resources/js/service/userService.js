App.factory('userService',['$http','$q',function($http,$q){
	return{
		
		fetchSpecificUserDetails: function(id,accType){
			return $http.get('http://localhost:8080/RetailBanking/users/'+id+'/'+accType)
			.then(
					function(response){
						return response.data;
					},
					function(erroResponse){
						console.log('Error while fetching the users by Id');
						return $q.reject(errorResponse);
					});
			
		}
	}
	
}]
		
);