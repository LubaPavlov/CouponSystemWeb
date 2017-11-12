
(function() {

	var module = angular.module("adminApp");

	module.controller("CreateCustomerCtrl", CreateCustomerCtrlCtor);

	function CreateCustomerCtrlCtor($http, ErrorLogServ) {
		this.logError = {
			"error" : false,
			"msg" : ""
		};
		this.newCustomer = {};
		this.custObj = {};
		this.success = false;
		this.failure = false;
		var self = this;
		this.createCustomer = function() {
			$http.put('http://localhost:8080/web/webapi/admin/createcustomer', this.newCustomer)
				.then(
					function(res) {
						console.log(res.data);
						self.logError = {
							"error" : false,
							"msg" : ""
						};
						self.custObj = res.data;
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