package br.com.bdccompany.services

import br.com.bdccompany.helpers.ServiceHelper
import groovyx.net.http.RESTClient

import static groovyx.net.http.ContentType.JSON

class PokemonServices {

    RESTClient restClient = new RESTClient("https://pokeapi.co/api/v2/pokemon/")

    def getPokemonName(name){
        def resource = "${name}"

        def response = restClient.get(path: resource, requestContentType: JSON)

        ServiceHelper.printJsonResponse(restClient, resource, response)

        return response

    }
}
