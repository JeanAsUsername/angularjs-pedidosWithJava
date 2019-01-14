
mixedApp.config(function($routeProvider, $locationProvider) {
    $routeProvider
            .when('/home', {
                template: '<mixedapp-home></mixedapp-home>'
            })
            .when('/pedidos', {
                template: '<mixedapp-pedidos></mixedapp-pedidos>'
            })

})  