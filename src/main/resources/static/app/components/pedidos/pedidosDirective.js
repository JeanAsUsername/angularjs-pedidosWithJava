
mixedApp.directive('mixedappPedidos', function() {
    return {
        restrict: 'E',
        templateUrl: '/app/components/pedidos/pedidosTemplate.html',
        replace: true,
        controller: 'pedidosController'
    }
})