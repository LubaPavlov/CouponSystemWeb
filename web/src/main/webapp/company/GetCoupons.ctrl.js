
var module = angular.module("compApp");
module.controller("GetCouponsCtrl", GetCouponsCtrlCtor);

function GetCouponsCtrlCtor($http, ErrorLogServ) {
	this.logError = {
		"error" : false,
		"msg" : ""
	};
	this.coupons = [];
	var self = this;

	this.getCoupons = function() {
		$http.get('http://localhost:8080/web/webapi/company/getcoupons')
			.then(function(resp) {
				console.log(resp.data);
				self.coupons = resp.data;
				self.logError = {
					"error" : false,
					"msg" : ""
				};
				self.coupons = resp.data;

			}),
		function(err) {
			console.log(err)
			self.logError = ErrorLogServ.logError(err);
		}
	}

	this.getCoupons();
	this.deleteCoupon = function(couponId) {
		this.success = false;
		this.failure = false;
		this.logError = {
			"error" : false,
			"msg" : ""
		};
		//var index = this.companies.indexOf(this.c);
		//	this.companies.splice(index, 1);

		$http.delete('http://localhost:8080/web/webapi/company/deletecoupon/' + couponId)
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
