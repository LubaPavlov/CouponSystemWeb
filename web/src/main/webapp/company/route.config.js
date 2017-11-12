
(function() {

	var module = angular.module("compApp");

	module.config([ '$locationProvider', function($locationProvider) {
		$locationProvider.hashPrefix('');
	} ]);

	// router config
	module.config(function($stateProvider, $urlRouterProvider) {

		$stateProvider
			.state("getCupons", {
				url : "/getcoupons",
				templateUrl : "getcoupons.html",
				controller : "GetCouponsCtrl as g"
			})
			.state("createCoupon", {
				url : "/createcoupon",
				templateUrl : "createcoupon.html",
				controller : "CreateCouponCtrl as c"
			});
		
		$urlRouterProvider.when("", "/getcoupons");

	});

})();