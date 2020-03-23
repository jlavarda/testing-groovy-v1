package cycle_02

import br.com.bdccompany.database.NomeBaseDados
import br.com.bdccompany.services.EmbratecServices
import spock.lang.Specification

class EmbratecTest extends Specification  {

    EmbratecServices embratecServices = new EmbratecServices() //instancia a classe que será chamada nos testes
    NomeBaseDados nomeBaseDados = new NomeBaseDados()

    def "Nome do cenário de teste"(){
        given: 'Dado que eu tenha algum teste para realizar'
        //linha para teste

        when: 'Então eu faço uma ação'
        //linha para teste

        then: 'Então eu valido a ação que eu fiz'
        //linha para teste

        and:'E Então eu posso validar outra ação'
        //linha para teste
    }

    def "Validar numero de telefone"(){
        given: 'Dado que eu tenha um numero de telefone'
        def telefone = '85119710'  // def define uma variavel tanto faz se é string ou number
        // def codigoArea = 51      //se for numero retirar as aspas
        def cpf = 34805654686

        when: 'Então eu faço uma ação'
        def responseTelefone = embratecServices.validaTelefone(telefone).getData()

        then: 'Então eu valido se o serviço retornou corretatamente os dados'
        with(responseTelefone) {
            numeroCartao == 6035740037980767
            //outro exemplo diferente de null =>  numeroCartao != null
            codigoOperadoraRecarga == 6
        }

        and:'E Então eu posso validar outra ação'
        //caso houver outras validações fazer uma por "and"

        and:'E Então eu posso validar se o registro está no banco de dados'
        //caso houver outras validações fazer uma por "and"
        assert nomeBaseDados.getRegistroValue(cpf) == cpf  //exemplo de assert com algum registro no banco"

    }

    def "Validar a operador"(){
        given: 'Dado que eu quero validar as operadoras'
        println "----------------> Comando para printar no log"
        def codOperadora = 1234

        when: 'executo o serviço'
        def responseOperadoras = embratecServices.getOperadoras().getData()

        then: 'eu valido se o response está correto'
        with(responseOperadoras){
            codigoOperadora == codOperadora
            descricao == "CLARO 1324"
        }

    }
}
