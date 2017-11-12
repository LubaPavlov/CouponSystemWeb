(function()
{

    var module = angular.module("adminApp");

    module.service("ErrorLogServ", ErrorLogServCtor);

   
        function ErrorLogServCtor()
            {

              this.result = {"error": false, "data":""};
              var self = this;
              this.emptyErr = function(value){

                if(value==""){
                   return false;
                }
                return true;
              }

              this.nullErr= function(value){
                  if(value == null || value == undefined){
                      return false;
                  }
                  return true;
              } 

                  this.logError = function(err){
                    var result = {"error": false, "msg":""};
                    if(err.status==500){
                        result.error = true;
                        result.msg = err.data;
                    }
                    if(err.status==404){
                        result.error = true;
                        result.msg = "An error occured";
                    }
                    return result;
                  }
              }
    })();
