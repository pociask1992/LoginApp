var app = angular.module('theLogin', [ "ngRoute" ]);

app.config(function($routeProvider) {
	  $routeProvider.when("/", {
	    templateUrl : "index.html",
	    controller : "loginController"
	  })
	  
});
	  
	  