angular.module('organizaciones', [ 'ngRoute','infinite-scroll' ]).config(function($routeProvider, $httpProvider) {
	
	$routeProvider.when('/', {
		templateUrl : 'home.html',
		controller : 'home'
	})
	.when('/organizaciones', {
		templateUrl : 'organizaciones.html',
		controller : 'organizaciones'
	})
	.when('/organizaciones/buscar/:que', {
		templateUrl : 'organizaciones.html',
		controller : 'organizaciones'
	})
	.when('/organizacion/:organizacionId', {
		templateUrl : 'organizacion.html',
		controller : 'organizacion'
	})
	.when('/contacto', {
		templateUrl : 'contacto.html',
		controller : 'contacto'
	})
	.otherwise('/');

	  
	$httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';

}).controller('navigation',

function($rootScope, $scope, $http, $location, $route) {

	$scope.tab = function(route) {
		return $route.current && route === $route.current.controller;
	};

	$http.get('user').success(function(data) {
		if (data.name) {
			$rootScope.authenticated = true;
		} else {
			$rootScope.authenticated = false;
		}
	}).error(function() {
		$rootScope.authenticated = false;
	});

	$scope.credentials = {};

	$scope.logout = function() {
		$http.post('logout', {}).success(function() {
			$rootScope.authenticated = false;
			$location.path("/");
		}).error(function(data) {
			console.log("Logout failed")
			$rootScope.authenticated = false;
		});
	}

}).controller('home', function($scope, $http, $location) {
	
	$http.get('organizacion/public/cuantas').success(function(data) {
		$scope.cuantas = data;
	})
	
}).controller('contacto', function($scope, $http, $location) {

}).controller('organizacion', function($scope, $http, $location) {
	
}).controller('organizaciones', function($scope, $http, $location, $routeParams, Organizaciones) {
	$scope.q = $routeParams.que;
	
	$scope.organizaciones = new Organizaciones();
	
}).factory('Organizaciones', function($http) {
	var Organizaciones = function() {
		this.items = [];
		this.busy = false;
		this.after = '';
		this.pos = 0;
		this.cuantos = 20;
	}
	
	Organizaciones.prototype.nextPage = function() {
		if (this.busy) return;
		
		this.busy = true;
		var that = this;
		
		var url = 'organizacion/public/todas?start='+this.pos+'&rows='+this.cuantos;
		$http.get(url).
			success(function(data) {
		      var items = data.content;
		      for (var i = 0; i < items.length; i++) {
		        that.items.push(items[i]);
		      }
		      that.pos += items.length;
		      that.busy = false;
			}.bind(this));
		this.busy = false;
	}
	return Organizaciones;
});
