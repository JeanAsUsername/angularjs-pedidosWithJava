
mixedApp.directive('mixedappFooter', function() {
    return {
        restrict: 'E',
        replace: true,
        templateUrl: '/app/shared/footer/footerTemplate.html',
        controller: 'footerController'
    }
})