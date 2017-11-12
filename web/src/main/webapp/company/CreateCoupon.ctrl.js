
(function() {

	var module = angular.module("compApp");

	module.controller("CreateCouponCtrl", CreateCouponCtrlCtor);

	function CreateCouponCtrlCtor($http, ErrorLogServ) {
		this.logError = {
			"error" : false,
			"msg" : ""
		};
		this.newCoupon = {};
		this.coupObj = {};
	    this.success = false;
	    this.failure = false;
		var self = this;
		this.createCoupon = function() {
			$http.put('http://localhost:8080/web/webapi/company/createcoupon', this.newCoupon)
				.then(
					function(res) {
						console.log(res.data);
						self.logError = {
							"error" : false,
							"msg" : ""
						};
						self.coupObj = res.data;
						  self.success = true;
			                self.failure = false;

					},

					function(err) {
						console.log(err)
						self.logError = ErrorLogServ.logError(err);
		                   self.success = false;
		                   self.failure = true;
					})
		}
	}
})();