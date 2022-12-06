package kotlinLetsCodeFirstModule.desafio

val estoque: MutableList<String> = mutableListOf()
var id = 0

fun main() {
    var opcaoMenu = 1
    while (opcaoMenu != 0) {
        try {
            println(
                "==========   Auto Center Mecânica   ===========\n" +
                        ">>>> Digite a opção desejada no menu: >>>\n" +
                        "1-> Adicionar item\n" +
                        "2-> Editar item\n" +
                        "3-> Exibir itens em estoque\n" +
                        "4-> Exibir todos os itens\n" +
                        "0-> Fechar sistema"
            )
            opcaoMenu = readln().toInt()

            when (opcaoMenu) {
                1 -> addItem()
                2 -> editarItem()
                3 -> println(listaEstoque())
                4 -> println(listaCompleta())
            }
        } catch (e: Exception) {
            when (e) {
                is LimiteEstoqueMaxException -> println("Voce excedeu o limite de itens")

                is ItemNaoEncontradoException -> println("ID não encontrado")

                is CaractereInvalidoException -> println("Você não pode usar esse caractere | ")

                is LimiteEstoqueMinException -> println("Quantidade de peças precisa ser maior que 0")

                is NumberFormatException -> println(" você digitou um número inválido")

                else -> {
                    println("Ocorreu um erro desconhecido")
                }
            }
        }
    }
}
//exception caracter invalido |

fun addItem() {
    id++
    println("Digite o nome da peça: ")
    val nomeDaPeca = readln()
    println("Digite a quantidade: ")
    val quantidade = readln().toInt()
    if(quantidade > 999) {
        throw LimiteEstoqueMaxException()
    }else if (quantidade <= 0) {
        throw LimiteEstoqueMinException()
    }
    if (nomeDaPeca.contains("|")){
        throw CaractereInvalidoException()
    }

    val item = "$id|$nomeDaPeca|$quantidade"
    estoque.add(item)
}

fun editarItem() {
    println("Digite o id da peça que deseja modificar:")
    val id = readln().toInt()
    println("Digite o novo nome da peça: ")
    val nomeDaPeca = readln()
    println("Digite a nova quantidade: ")
    val quantidade = readln().toInt()

    val itemEncontrado = estoque.find { item ->
        item.split("|")[0].toInt() == id
    }

    if(itemEncontrado == null) {
        throw ItemNaoEncontradoException()
    }
    if (nomeDaPeca.contains("|")){
        throw CaractereInvalidoException()
    }
    if (quantidade < 0){
        throw LimiteEstoqueMinException()
    }

    val itemAtualizado = itemEncontrado.split("|")[0] + "|" + nomeDaPeca + "|" + quantidade
    estoque[id - 1] = itemAtualizado
}

fun listaCompleta(): String {
    return "Lista de itens completa: $estoque\n"
}

fun listaEstoque(): String {
    return "Lista de itens em estoque: " + estoque.filter { item ->
        item.split("|")[2].toInt() > 0
    }.toString() + "\n"
}

class LimiteEstoqueMaxException : Exception()
class ItemNaoEncontradoException : Exception()
class CaractereInvalidoException : Exception()
class LimiteEstoqueMinException : Exception()
