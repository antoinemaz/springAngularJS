// app.js
// create angular app


// TODO
//- voir entityManagerFactory

//Toutes les opérations que l'on peut faire sur des entités JPA passent directement ou indirectement par l' entity manager 
//
//EntityManagerFactory : 
//
//    An entity manager factory provides entity manager instances, all instances are configured to connect to the same database, 
//    to use the same default settings as defined by the particular implementation, etc. You can prepare several entity manager factories to 
//    access several data stores. This interface is similar to the SessionFactory in native Hibernate.
//    
//EntityManager : 
//
//    The EntityManager API is used to access a database in a particular unit of work. It is used to create and remove persistent entity instances, 
//    to find entities by their primary key identity, and to query over all entities. This interface is similar to the Session in Hibernate.

//Session et Session factory sont propres à Hibernate (pas d'implémentation de la spec JPA) Mais Hibernate exploite aussi JPA

//- voir jpaVendorAdapter

//On spécifie ici l'adaptateur Spring pour l'implémentation JPA utilisée --> 


//- difference entre this et $scope : que utiliser ?

//ils font la même chose... ils sont interchangeables


//- gerer differents cas de retour : dans le controller 

//TODO :)

'use strict';

var personneApp = angular.module('personneApp', ['modulePersonne']);

var modulePersonne = angular.module('modulePersonne',[]);

// create angular controller
modulePersonne.controller('mainController', ['$scope', 'PersonneService', function($scope, PersonneService) {

   $scope.submitted = false;
    
    var self = this;
	self.users = [];
	self.user={id:null,nom:'',prenom:'',age:'',produits:[]};
	$scope.message = '';
	
  self.getPersonne = function(){
	  
	  PersonneService.getPersonne()
          .then(
	           function(d) {
	        	   self.users = d;
	           },
	            function(errResponse){
	                console.error('Error while fetching Currencies');
	            }
           );
  };
  
  self.creerPersonne = function(user){
	  
	  PersonneService.creerPersonne(user)
          .then(
        		function(){
        			$scope.message = 'Personne enregistrée';
        			self.getPersonne();
        		},
	            function(errResponse){
        			$scope.message = errResponse.data;
	            }
           );
  };
  
  // function to submit the form after all validation has occurred            
  self.submit = function() {
	  
	$scope.submitted = true;
	$scope.message = '';

    // check to make sure the form is completely valid
      self.creerPersonne(self.user);
    
    self.user={id:null,nom:'',prenom:'',age:'',produits:[]};
    $scope.myForm.$setPristine(); //reset Form
  };
  
  self.getPersonne();
  
}]);

modulePersonne.factory('PersonneService', ['$http', '$q', function($http, $q){
	 
    return {
	    getPersonne: function(){
	    	
	            return $http.get('http://localhost:8080/personne-rest/personnes')
	                .then(
	                        function(response){
	                            return response.data;
	                        }, 
	                        function(errResponse){
	                            console.error('Error while get personnes');
	                            return $q.reject(errResponse);
	                        }
	                );
	    },
        creerPersonne: function(user){
            return $http.post('http://localhost:8080/personne-rest/personnes/add', user)
                    .then(
                            function(response){
                                return response.data;
                            }, 
                            function(errResponse){
                                console.error('Error while creating user');
                                return $q.reject(errResponse);
                            }
                    );
    },
         
    };
 
}]);

