package cycle_01

import br.com.bdccompany.services.PokemonServices
import spock.lang.Specification

class pokemonTest extends Specification {

    PokemonServices pokemonServices = new PokemonServices()

    def "Primeiro teste nome do pokemon"(){
        given: 'Dado que eu tenha um pokemon'
        def response = pokemonServices.getPokemonName("pikachu")

        when: 'então eu vejo'
        println "foi aqui"

        then: 'eu valido'
        println response
    }
}
