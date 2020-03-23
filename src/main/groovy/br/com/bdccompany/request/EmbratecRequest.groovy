package br.com.bdccompany.request

class EmbratecRequest {

    def static validaTelefoneRequest(telefone){
        [
            "codigoArea": "51",
            "numeroTelefone": telefone
        ]

    }
}
