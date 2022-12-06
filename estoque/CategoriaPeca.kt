package LetsCodeSecondModule.desafiosrefatorados.estoque

import LetsCodeSecondModule.desafiosrefatorados.ItemInvalidoException

enum class CategoriaPeca(val categoria : Int, val nome : String) {
    MOTOR( 1,"Motor"),
    CARROCERIA(2,"carroceria"),
    SUSPENSAO(3,"suspensão");

    override fun toString(): String {
        return nome
    }

    companion object {

        fun mostraCategoria() : String {
            val stringBuilder = StringBuilder()
            CategoriaPeca.values().forEach {
                stringBuilder.append("Nome da categoria: ${it.nome} | numero da categoria: ${it.categoria}\n")
            }
            return stringBuilder.toString()
        }

        fun getCategoria(categoria: Int): CategoriaPeca{
           return CategoriaPeca.values().find {
                it.categoria == categoria
            } ?: throw ItemInvalidoException()
        }
    }
}
