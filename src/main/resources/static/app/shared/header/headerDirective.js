
mixedApp.directive('mixedappHeader', function() {
    return {
        restrict: 'E',
        replace: true,
        templateUrl: '/app/shared/header/headerTemplate.html',
        controller: 'headerController'
    }
})