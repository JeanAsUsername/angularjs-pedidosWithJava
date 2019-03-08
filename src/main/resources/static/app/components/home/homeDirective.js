
mixedApp.directive('mixedappHome', function() {
    return {
        restrict: 'E',
        templateUrl: '/app/components/home/homeTemplate.html',
        replace: true,
        controller: 'homeController'
    }
})
