package LetsCodeSecondModule.desafiosrefatorados

import LetsCodeSecondModule.desafiosrefatorados.estoque.CategoriaPeca

data class ItemMecanica(private val id: Int, private var nome: String, private var quantidade: Int,private var descricaoPeca : String, private var fornecedor : String, private var categoria : CategoriaPeca){
    override fun toString(): String {
        return "ID: $id | PEÇA: $nome | QUANTIDADE: $quantidade | DESCRIÇÃO: $descricaoPeca | FORNECEDOR: $fornecedor | CATEGORIA: $categoria"
    }



    fun atualizarCampos(nome: String, quantidade: Int, descricaoPeca: String) {
        this.nome = nome
        this.quantidade = quantidade
        this.descricaoPeca = descricaoPeca
    }

    fun getId() = id
    fun getQtd() = quantidade


}



