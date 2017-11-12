
(function() {

	var module = angular.module("adminApp");

	module.controller("UpdateCompanyCtrl", UpdateCompanyCtrlCtor);

	function UpdateCompanyCtrlCtor($http, ErrorLogServ) {
		this.logError = {
			"error" : false,
			"msg" : ""
		};
		this.updatedCompany = {};
		this.compObj = {};
	    this.success = false;
	    this.failure = false;
		var self = this;
		this.updateCompany = function() {
			$http.put('http://localhost:8080/web/webapi/admin/updatecompany', this.updatedCompany)
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