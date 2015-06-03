angular.module('organizaciones', [ 'ui.bootstrap', 'ngResource', 'ngRoute', 'infinite-scroll' ]).config(function($routeProvider, $httpProvider) {
	
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

function($rootScope, $scope, $http, $location, $route, $window) {

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
			$window.location.href =  "http://localhost:9999/uaa/logout" ;
		}).error(function(data) {
			console.log("Logout failed")
			$rootScope.authenticated = false;
		});
	}

}).controller('home', function($scope, $http, $location) {
	
	$http.get('public/organizacion/cuantas').success(function(data) {
		$scope.cuantas = data;
	})
	
	$scope.buscar = function() {
		$location.path('/organizaciones/buscar/'+$scope.q);
	}
	
}).controller('contacto', function($scope, $http, $location) {

}).controller('organizacion', function($scope, $location, $routeParams, OrganizacionResource) {
	$scope.id = $routeParams.organizacionId;
	OrganizacionResource.get({organizacionId:$scope.id}).$promise.then(
			function(organizacion){
				$scope.organizacion = organizacion
			});
}).controller('organizaciones', function($scope, $http, $location, $routeParams, Organizaciones) {

	$scope.q = $routeParams.que;
	
	$scope.pageChanged = function() {
	  $scope.organizaciones.traerDesde(pageNo);
	  $log.log('Page changed to: ' + $scope.currentPage);
	};

	$scope.maxSize = 10;
	$scope.organizaciones = new Organizaciones($scope.q);
	
}).factory('OrganizacionResource', function($resource, $http) {
	var resource = $resource('/public/organizacion/:organizacionId',{organizacionId:'@id'});
	
	resource.relacionadas = function(organizacionId, start, rows) {
		if (!start) start = 0;
		if (!rows) rows = 5;

		var url = '/public/organizacion/relacionadasCon/'+organizacionId+'?start='+start+'&rows='+rows;
		return $http.get(url);
	}
	
	resource.seRelacionaCon = function(organizacionId, start, rows) {
		if (!start) start = 0;
		if (!rows) rows = 5;
		
		var url = '/public/organizacion/seRelacionaCon/'+organizacionId+'?start='+start+'&rows='+rows;
		return $http.get(url);
	}
	
	resource.ancestros = function(relacion, organizacionId) {
		return $http.get('/public/organizacion/'+organizacionId+'/ancestros/'+relacion.replace(/ /g, '_'));
	}
	
	return resource;
}).factory('Organizaciones', function($http) {
	var Organizaciones = function(q) {
		this.items = [];
		this.busy = false;
		this.start = 0; // para scroll infinito
		this.rows = 10;
		this.page = 1;
		this.q = q;
		this.traerDesde();
		this.mostrandoBusqueda = false;
	}
	
	
	Organizaciones.prototype.traerDesde = function() {
		var start = (this.page - 1) || 0;
		this.mostrandoBusqueda = false;
		this.buscado = '';
		
		var url = 'public/organizacion/?start=' + start + '&rows=' + this.rows;
		if (this.q && '' != this.q) {
			this.mostrandoBusqueda = true;
			this.buscado = this.q;
			url = 'public/organizacion/buscar?q=' + this.q + '&start=' + start + '&rows=' + this.rows;
		}
		
		var that = this;
		$http.get(url).
			success(function(data) {
				that.items = data.content;
				that.total = data.totalElements;			
		});
	}
	
	Organizaciones.prototype.nextPage = function() {
		if (this.busy) return;
		
		this.busy = true;
		var that = this;
		
		var url = 'organizacion/public?start='+this.start+'&rows='+this.rows;
		$http.get(url).
			success(function(data) {
		      var items = data.content;
		      for (var i = 0; i < items.length; i++) {
		        that.items.push(items[i]);
		      }
		      that.start += items.length;
		      that.busy = false;
		}.bind(this));
	}
	return Organizaciones;
}).directive('nombresDeOrganizacion', function() {
	  return {
		    restrict: "E",
		    scope: {
		    	'nombres' : '=',
		    	'editable' : '='
		    },
		    controller: function($scope) {

		    },
		    transclude: true,
		    templateUrl:"view/nombres-de-organizacion.html",
//		    require:["^solr", "solrFacetGroup"],
		    link: function(scope, element, attrs, ctrls){

		    }
		  }
}).directive('ancestros', function(OrganizacionResource) {
	  return {
		    restrict: "E",
		    scope: {
		    	'relacion': '@',
		    	'organizacionId' : '='
		    },
		    controller: function($scope) {
		    },
		    templateUrl:"view/ancestros.html",
		    compile: function(scope, element, attrs, ctrls){
		    	return {
		    		pre : function(scope, iElement, iAttrs, controller)  {
		    		      scope.$watch('organizacionId',
		    		        function ( newVal, oldVal){
		    		    	  if (newVal) {
		    		    		  OrganizacionResource.ancestros(scope.relacion, newVal)
		    		    		  	.success(function(data) { 
		    		    		  		scope.ancestros = data 
		    		    		  	});
		    		    	  }
		    		      });
		    		}
		    	}
		    }
		  }
}).directive('relaciones', function(OrganizacionResource) {
	  return {
		    restrict: "E",
		    scope: {
		    	'organizacionId' : '='
		    },
		    controller: function($scope) {
		    	var ctrl = {};
		    	
		    	$scope.page = 0;
		    	
		    	$scope.cambiarPagina = function(organizacionId, page) {
		          var start = (page - 1) || 0;
		          console.log($scope.organizacionId);
	    		  OrganizacionResource.seRelacionaCon(organizacionId, start)
	    		  	.success(function(data) { 
	    		  		$scope.seRelacionaCon = data;
	    		  	});
		    	}
		    	return ctrl;
		    },
		    templateUrl:"view/relaciones.html",
		    compile: function(scope, element, attrs, ctrls){
		    	return {
		    		pre : function(scope, iElement, iAttrs, controller)  {
		    		      scope.$watch('organizacionId',
				    		        function ( newVal, oldVal){
				    		    	  if (newVal) {
				    		    		  OrganizacionResource.relacionadas(newVal)
				    		    		  	.success(function(data) { 
				    		    		  		scope.relacionadas = data;
				    		    		  	});
				    		    		  OrganizacionResource.seRelacionaCon(newVal)
				    		    		  	.success(function(data) { 
				    		    		  		scope.seRelacionaCon = data;
				    		    		  	});
				    		    		  
				    		    	  }
				    		      });		    			
		    		}
		    	}
		    }
		  }
});
