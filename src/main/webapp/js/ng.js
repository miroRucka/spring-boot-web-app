var app = angular.module('newgen', []);
app.controller("NewGenController", function($scope, $http){
    $scope.cards = [];
    var promise = $http({
        method: 'GET',
        url: "/api/cards"
    });
    promise.then(function(response){
        $scope.cards = response.data ;
    })
});