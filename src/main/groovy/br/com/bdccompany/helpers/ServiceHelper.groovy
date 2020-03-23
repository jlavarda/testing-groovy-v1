package br.com.bdccompany.helpers

import groovy.json.JsonOutput
import groovy.util.logging.Slf4j

@Slf4j
class ServiceHelper {

    static printJsonResponse(client, resource, response) {
        println "URL: ${client.getUri()}${resource} "
        println "Resposta com status: ${response.getStatus()}: "
        println JsonOutput.prettyPrint(JsonOutput.toJson(response.getData()))

        return response
    }

}
