
var module = angular.module("adminApp");
module.controller("GetCompaniesCtrl", GetCompaniesCtrlCtor);

function GetCompaniesCtrlCtor($http, ErrorLogServ) {
	this.logError = {
		"error" : false,
		"msg" : ""
	};
	this.companies = []
	var self = this

	this.getCompanies = function() {
		$http.get('http://localhost:8080/web/webapi/admin/getcompanies')
			.then(function(resp) {
				console.log(resp.data);
				self.companies = resp.data;
				self.logError = {
					"error" : false,
					"msg" : ""
				};
				self.companies = resp.data;

			}),
		function(err) {
			console.log(err)
			self.logError = ErrorLogServ.logError(err);
		}
	}

	this.getCompanies();
	this.deleteCompany = function(compName) {
		this.success = false;
		this.failure = false;
		this.logError = {
			"error" : false,
			"msg" : ""
		};
		//var index = this.companies.indexOf(this.c);
		//	this.companies.splice(index, 1);

		$http.delete('http://localhost:8080/web/webapi/admin/deletecompany/' + compName)
			.then(function(resp) {
				console.log(resp.data);
				self.success = true;
				self.failure = false;
				console.log(res.data);
				self.logError = {
					"error" : false,
					"msg" : ""
				};
			},
				function(err) {
					console.log(err)
					self.logError = ErrorLogServ.logError(err);
					self.success = false;
					self.failure = true;
				}
		)
	}
}
