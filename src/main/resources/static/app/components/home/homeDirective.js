
mixedApp.directive('mixedappHome', function() {
    return {
        restrict: 'E',
        template: '/app/components/home/homeTemplate.html',
        replace: true,
        controller: 'homeController'
    }
})