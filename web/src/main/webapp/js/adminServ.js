(function () {

var module = angular.module("adminApp");

module.service("adminServ", adminServCtor);

function adminServCtor($http) {
	/*
	this.getCompanies = function() {
		return $http.get('http://localhost:8080/web/webapi/admin/getcompanies');
	}	
	*/


	this.deleteCompany = function(compName) {
		return $http.delete('http://localhost:8080/web/webapi/admin/getcompanies'+ compName);
	}
}
})();
