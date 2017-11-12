
(function() {

	var module = angular.module("adminApp");

	module.config([ '$locationProvider', function($locationProvider) {
		$locationProvider.hashPrefix('');
	} ]);

	// router config
	module.config(function($stateProvider, $urlRouterProvider) {

		$stateProvider
			.state("getCompanies", {
				url : "/get",
				templateUrl : "getcompanies.html",
				controller : "GetCompaniesCtrl as g"
			})
			.state("createCompany", {
				url : "/create",
				templateUrl : "createcompany.html",
				controller : "CreateCompanyCtrl as c"
			})
				.state("getCustomers", {
				url : "/getcust",
				templateUrl : "getcustomers.html",
				controller : "GetCustomersCtrl as g"
			})
			.state("createCustomer", {
				url : "/createcust",
				templateUrl : "createcustomer.html",
				controller : "CreateCustomerCtrl as c"
			})
				.state("logout", {
				url : "/logout",
				templateUrl : "logout.html",
				controller : "LogoutCtrl as c"   //action="http://localhost:8080/web/logout"
			});
		
		$urlRouterProvider.when("", "/get");

	});

})();