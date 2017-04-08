var app = angular.module('theLogin');

app.controller("loginController", function($scope, $http, $window){
	console.log("load loginController");
	
	$scope.getLogins = function() {
		$http.get("login/getAll").then(function successCallback(response) {
			console.log("logins successfully get " + response);
			$scope.getData = response.data;
			console.log(response.data);
			$scope.logins = response.data;
		}, function errorCallback(response) {
			console.log("Error loginController !" + response);
		});
	}

	$scope.changeValueChB = {
			value: ""
	};
	
	$scope.aa = {
			login :{}
	}

	
	$scope.updateLogin = function(name, surname, login, password, email, login_id) {
		console.log("I'm in updateLogin ");
		$scope.changeLogin = {
				  "name" : name,
				  "surname" : surname,
				  "login" : login,
				  "password" : password,
				  "email" : email,
				  "login_id" : login_id
			}
		$scope.aaa(name, surname, login, password, email);
	};
	
	$scope.message = function(result) {
		$window.alert(result);
	};
	
	
	$scope.aaa = function(name, surname, login, password, email) {
	$scope.addLoginObject = {
			  "name" : name,
			  "surname" : surname,
			  "login" : login,
			  "password" : password,
			  "email" : email
		}
	};
	$scope.auxiliaryAddFunction = function() {
		$scope.auxiliaryAdd = {
				name : $scope.changeLogin.name,
				surname : $scope.changeLogin.surname,
				login : $scope.changeLogin.login,
				password : $scope.changeLogin.password,
				email : $scope.changeLogin.email
		}
	};
	
	$scope.addLoginFunction = function() {
		console.log("I'm in addLogin function.");
		$scope.auxiliaryAddFunction();
		$http.post("/login/addLogin", $scope.auxiliaryAdd ).then(function successCallback(response) {
			console.log("Successfully add login.");
			$scope.response = response.data;
			$scope.message("Data successfully added. \n" +
					"Name: " + $scope.response.name + "\n" +
					"Surname: " + $scope.response.surname + "\n" +
					"Login: " + $scope.response.login + "\n" + 
					"Email: " + $scope.response.email);
			$scope.changeValueChB ={ value : "" };
			$scope.getLogins();
			$scope.updateLogin("", "", "", "", "", "");
		}, function errorCallback(response) {
			console.log("Error during added login");
			$scope.response = response.data;
			$scope.message("Error during added login.\n" + 
			$scope.response );
		});
	};
	
	$scope.updateLoginFunction = function() {
		console.log("I'm in updateLoginFunction");
		$http.put('/login/update', $scope.changeLogin).then(function successCallback(response){
			console.log("Login successfully updated.");
			$scope.response = response.data;
			$scope.message("Data successfully updated. \n" +
					"Name: " + $scope.response.name + "\n" +
					"Surname: " + $scope.response.surname + "\n" +
					"Login: " + $scope.response.login + "\n" + 
					"Email: " + $scope.response.email);
			$scope.changeValueChB ={ value : "" };
			$scope.getLogins();
		}, function errorCallback(response) {
			console.log("Error during update login.");
			$scope.message("Error during update login");
		});
	};
	
	$scope.deleteLoginFunction = function($resource, value) {
		console.log("I'm in deleteLoginFunction");
		data = $scope.changeLogin.login_id;
		console.log("data prepare to remove " + value);
		$http.delete("/login/deleteLogin/" + $scope.changeLogin.login_id).then(function successCallback(response){
			console.log("Login successfully deleted.");
			$scope.response = response.data;
			$scope.message("Data successfully deleted. \n" +
							"Name: " + $scope.response.name + "\n" +
							"Surname: " + $scope.response.surname + "\n" +
							"Login: " + $scope.response.login + "\n" + 
							"Email: " + $scope.response.email);
			$scope.changeValueChB ={ value : "" };
			$scope.getLogins();
		}, function errorCallbac(response) {
			console.log("Error during delete login.");
			$scope.message("Error during delete login");
		});
	};
	
	$scope.getLogins();
});