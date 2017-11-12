
var module = angular.module("adminApp");
module.controller("GetCustomersCtrl", GetCustomersCtrlCtor);

function GetCustomersCtrlCtor($http, ErrorLogServ) {
	this.logError = {
		"error" : false,
		"msg" : ""
	};
	this.customers = [];
	var self = this;

	this.getCustomers = function() {
		$http.get('http://localhost:8080/web/webapi/admin/getcustomers')
			.then(function(resp) {
				console.log(resp.data);
				self.customers = resp.data;
				self.logError = {
					"error" : false,
					"msg" : ""
				};
				self.customers = resp.data;

			}),
		function(err) {
			console.log(err)
			self.logError = ErrorLogServ.logError(err);
		}
	}

	this.getCustomers();
	this.deleteCustomer = function(custName) {
		this.success = false;
		this.failure = false;
		this.logError = {
			"error" : false,
			"msg" : ""
		};
		//var index = this.companies.indexOf(this.c);
		//	this.companies.splice(index, 1);

		$http.delete('http://localhost:8080/web/webapi/admin/deletecustomer/' + custName)
			.then(function(resp) {
				console.log(resp.data);
				self.success = true;
				self.failure = false;
				console.log(resp.data);
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
