package br.com.bdccompany.services

import br.com.bdccompany.helpers.ServiceHelper
import br.com.bdccompany.request.EmbratecRequest
import groovyx.net.http.RESTClient

import static groovyx.net.http.ContentType.JSON

class EmbratecServices {

    EmbratecRequest embratecRequest = new EmbratecRequest()

    RESTClient restClient = new RESTClient("https://servicoFake/rest/v2/")

    def validaTelefone(telefone){
        def resource = "recargacelular/validarTelefone"
        def body = embratecRequest.validaTelefoneRequest(telefone)
        restClient.headers.put('Authorization', 'Basic c3J2X2VzcHBfd3NfY2FydGFvOmRlc2Vudg==')

        def response = restClient.post(path: resource, body: body, requestContentType: JSON)

        //servico que loga os dados do teste quando é rodado pelo JUnit
        ServiceHelper.printJsonResponse(restClient, resource, response)

        return response
    }

    def getOperadoras(){
        def resource = "mobile/operadoras"

        restClient.headers.put('Authorization', 'Basic c3Jfd897f8s9d798f7d8Rlc2Vudg==')

        def response = restClient.get(path: resource, requestContentType: JSON)

        //servico que loga os dados do teste quando é rodado pelo JUnit
        ServiceHelper.printJsonResponse(restClient, resource, response)

        return response
    }
}
