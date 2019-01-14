
mixedApp.controller('pedidosController', function($scope, pedidosService) {

    $scope.pedidos = [];

    $scope.pedido = {
        editable: 0    
    }

    pedidosService
        .getAllPedidos()
        .then(function(pedidos) {
            $scope.pedidos = pedidos.data

        })

    $scope.editPedido = function(pedido) {
        pedido.editable = 1;
    }

    $scope.confirmEdit = function(pedido) {
        pedido.editable = false;
    }

    $scope.savePedido = function(pedido) {

        let isAnUpdate = pedido.editable

        if (isAnUpdate) pedido.editable = 0;

        pedidosService
            .savePedido(pedido)
            .then(function(response) {

                if (isAnUpdate) return;

                pedido.id = response.data.id;

                $scope.pedidos.push(Object.assign({}, pedido));
                $scope.pedido = {
                    editable: 0,
                    title: '',
                    description: ''
                };
            })

    }

    $scope.deletePedido = function(pedido) {

        pedidosService
            .deletePedido(pedido)
            .then(function() {

                let pedidoIndex = $scope.pedidos.indexOf(pedido)

                $scope.pedidos.splice(pedidoIndex, 1)

            })

    }

})