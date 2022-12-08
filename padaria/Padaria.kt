package LetsCodeSecondModule.desafiosrefatorados.padaria

import java.lang.Exception

class Menu() {

    val comanda: MutableList<ItemComanda> = mutableListOf()

    val listaItens: List<ProdutoPadaria> = listOf(
        PaoFrances(), Baguette(), Croissant(), Coxinha(), Sandwich(), Taco(), Shortcake(),
        Cookie(), Cupcake(), CafeP(), CafeM(), CafeG()
    )
    val listaDeCategorias: List<CategoriaPadaria> = listaItens.distinctBy { it.categoria }.map { it.categoria }

    var idCategoria = -1

    init {
        menuPadaria()
    }

    fun menuPadaria() {

        println("Bem Vindo à padaria E-Padoca!\uD83E\uDD56 ☕ \uD83D\uDE00")
        while (idCategoria != 0) {
            var idSubcategoria = -1
            try {
                print("Digite a opção desejada no Menu:\n")
                print(listaDeCategorias.joinToString("\n"))
                print("\n0- Finalizar compra \uD83D\uDD1A\n")
                val categoria = readln().toInt()
                val subcategoria = listaItens.filter { it.categoria.id == categoria }
                var finalizarCompra: String
                if (categoria == 0) {
                    println("Deseja mesmo finalizar a compra \uD83E\uDD7A? [S] [N]")
                    finalizarCompra = readln().uppercase()
                    if (finalizarCompra != "N") {

                        println(
                            "Obrigado pela visita, volte sempre! \uD83D\uDE0D \n" +
                                    "\nresumo da compra:\n" +
                                    "valor total: R$ ${String.format("%.2f", somaProdutos())}"
                        )
                        comanda.forEach {
                            println("Sacola:$it")
                        }
                        break
                    }
                } else if (subcategoria.isNotEmpty()) {
                    while (idSubcategoria != 0) {
                        println(subcategoria.joinToString("\n"))
                        println("0- Voltar ↩\n")
                        idSubcategoria = readln().toInt()
                        if (idSubcategoria != 0) {
                            val item = listaItens.find {
                                it.id == idSubcategoria
                            } ?: throw ItemInvalido()

                            print("Digite a quantidade:")
                            val qtd = readln().toInt()
                            comanda.add(ItemComanda(item, qtd))
                        }
                    }

                } else {
                    throw ItemInvalido()
                }


            } catch (e: Exception) {
                println(e.message)

            }

        }

    }

    fun somaProdutos(): Double {
        var valorItem: Double
        var total = 0.0
        for (i in comanda) {
            valorItem = i.quantidade * i.produto.precoUnitario!!
            total += valorItem
        }
        return total

    }
}

fun main() {
    Menu()
}

class ItemInvalido : Exception("Item não encontrado")
