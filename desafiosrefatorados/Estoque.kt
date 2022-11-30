package LetsCodeSecondModule.desafiosrefatorados



fun main() {
    val estoque = Estoque()
    estoque.exibirMenu()
}
class Estoque {
    private var id = 0
    private val listaItens : MutableList<ItemMecanica> = mutableListOf()

    private fun gerarId() : Int {
        id++
        return id
    }

    fun exibirMenu() {
       do {
           println(
               "==========   Auto Center Mecânica   ===========\n" +
                       ">>>> Digite a opção desejada no menu: >>>\n" +
                       "1-> Adicionar item\n" +
                       "2-> Editar item\n" +
                       "3-> Exibir itens em estoque\n" +
                       "4-> Exibir todos os itens\n" +
                       "0-> Fechar sistema")
           val opcaoMenu = readln().toInt()

           when (opcaoMenu){
               1 -> adionarItem()
               2 -> editarItem()
               3 -> println(exibirItensEstoque())
               4 -> println(exibirTodosItens())
           }
       }while (opcaoMenu!= 0)

    }
    private fun adionarItem() {
        println("Digite o nome da peça: ")
        val nomeDaPeca = readln()
        println("Digite a quantidade: ")
        val quantidade = readln().toInt()

       if (quantidade <= 0 || quantidade >999) throw LimiteEstoqueException()

        val item = ItemMecanica(gerarId(), nomeDaPeca, quantidade)
        listaItens.add(item)
    }

    private fun editarItem() {
        println("Digite o id da peça que deseja modificar:")
        val id = readln().toInt()
        println("Digite o novo nome da peça: ")
        val nomeDaPeca = readln()
        println("Digite a nova quantidade: ")
        val quantidade = readln().toInt()

        if (quantidade < 0 || quantidade >999) throw LimiteEstoqueException()

        val itemEncontrado = listaItens.find { it.id == id } ?: throw ItemInvalidoException()
        itemEncontrado.atualizarCampos(nomeDaPeca, quantidade)

        listaItens[id - 1] = itemEncontrado
    }
    fun exibirItensEstoque() : String {
        return "Lista de itens em estoque: " + listaItens.filter {
            it.quantidade > 0
        }
    }
    fun exibirTodosItens() : String {
    return "Lista de itens: $listaItens\n"
    }

}

class LimiteEstoqueException : Exception()
class ItemInvalidoException : Exception()

