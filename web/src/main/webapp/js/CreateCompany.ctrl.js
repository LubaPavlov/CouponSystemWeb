
(function() {

	var module = angular.module("adminApp");

	module.controller("CreateCompanyCtrl", CreateCompanyCtrlCtor);

	function CreateCompanyCtrlCtor($http, ErrorLogServ) {
		this.logError = {
			"error" : false,
			"msg" : ""
		};
		this.newCompany = {};
		this.compObj = {};
	    this.success = false;
	    this.failure = false;
		var self = this;
		this.createCompany = function() {
			$http.put('http://localhost:8080/web/webapi/admin/createcompany', this.newCompany)
				.then(
					function(res) {
						console.log(res.data);
						self.logError = {
							"error" : false,
							"msg" : ""
						};
						self.compObj = res.data;
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