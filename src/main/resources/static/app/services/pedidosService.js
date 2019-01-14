
mixedApp.factory('pedidosService', function($http, $q) {
    return {
        getAllPedidos: function() {

            let deferred = $q.defer();

            $http
                .get('rest/pedidos')
                .then(function(response) {
                    deferred.resolve(response)
                })
                .catch(function(e) {
                    deferred.reject('Something go wrong...')
                })

                return deferred.promise;
        },

        savePedido: function(pedido) {
            
            let deferred = $q.defer(),
                data = JSON.stringify(pedido)
                config = {
                    headers: {
                        'Content-Type': 'application/json'
                    }
                };

            $http
                .post('rest/pedidos', data)
                .then(function(response) {
                    deferred.resolve(response)
                })
                .catch(function(e) {
                    deferred.reject("Something go wrong and i'ts not possible to save the Pedido")
                })

                return deferred.promise;
        },

        deletePedido: function(pedido) {

            let deferred = $q.defer();
                url = 'rest/pedidos/' + pedido.id

            $http({method: 'DELETE', url})
                .then(function(response) {
                    console.log('the pedido was deleted from the database successfully. !')
                    deferred.resolve(response);
                })
                .catch(function(e) {
                    console.error(e);
                })

            return deferred.promise;
        }
    }
})