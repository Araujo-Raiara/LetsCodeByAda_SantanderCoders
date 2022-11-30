package LetsCodeSecondModule.desafiosrefatorados

data class ItemMecanica(val id: Int, var nome: String, var quantidade: Int){
    override fun toString(): String {
        return "ID: $id | PEÇA: $nome | QUANTIDADE: $quantidade"
    }

    fun atualizarCampos(nome: String, quantidade: Int) {
        this.nome = nome
        this.quantidade = quantidade
    }
}

