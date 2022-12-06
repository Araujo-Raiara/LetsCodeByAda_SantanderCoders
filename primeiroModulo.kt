package kotlinLetsCodeFirstModule.desafio

private const val PAES = 1
private const val SALGADOS = 2
private const val DOCES = 3
private const val FINALIZAR = 0

private const val LINHA = ".........."
private const val LINHACOMANDAFINAL = "..................."

const val valorPaoFrances = 0.60
const val valorPaoDeLeite = 0.40
const val valorPaoDeMilho = 0.50

const val valorCoxinha = 5.0
const val valorEsfiha = 6.0
const val valorPaoQueijo = 3.0

const val valorCarolina = 1.50
const val valorPudim = 4.0
const val valorBrigadeiro = 2.0

const val prodPaoFrances = "Pão Francês"
const val prodPaoLeite = "Pão de Leite"
const val prodPaoMilho = "Pão de Milho"

const val prodCoxinha = "Coxinha"
const val prodEsfiha = "Esfiha"
const val prodPaoQueijo = "Pão de Queijo"

const val prodCarolina = "Carolina"
const val prodPudim = "Pudim"
const val prodBrigadeiro = "Brigadeiro"

var cupomEhValido = false


val paes: List<Pair<String, Double>> = listOf(
    Pair(prodPaoFrances, valorPaoFrances), // index 0
    Pair(prodPaoLeite, valorPaoDeLeite), // index 1
    Pair(first = prodPaoMilho, second = valorPaoDeMilho), // index 2
)
val salgados: List<Pair<String, Double>> = listOf(
    Pair(prodCoxinha, valorCoxinha), // index 0
    Pair(prodEsfiha, valorEsfiha), // index 1
    Pair(first = prodPaoQueijo, second = valorPaoQueijo), // index 2
)
val doces: List<Pair<String, Double>> = listOf(
    Pair(prodCarolina, valorCarolina), // index 0
    Pair(prodPudim, valorPudim), // index 1
    Pair(first = prodBrigadeiro, second = valorBrigadeiro), // index 2
)

val categorias = """
    Digite a opção desejada no Menu:
    1${LINHA}Pães
    2${LINHA}Salgados
    3${LINHA}Doces
    0-> Finalizar compra
""".trimIndent()

val menuPaes = """
        1-> $prodPaoFrances${LINHA}R$${String.format("%.2f", valorPaoFrances)}
        2-> $prodPaoLeite${LINHA}R$${String.format("%.2f", valorPaoDeLeite)}
        3-> $prodPaoMilho${LINHA}R$${String.format("%.2f", valorPaoDeMilho)}
        0-> Voltar
    """.trimIndent()



val menuSalgados = """
        1-> $prodCoxinha${LINHA}R$${String.format("%.2f", valorCoxinha)}
        2-> $prodEsfiha${LINHA}R$${String.format("%.2f", valorEsfiha)}
        3-> $prodPaoQueijo${LINHA}R$${String.format("%.2f", valorPaoQueijo)}
        0-> Voltar
    """.trimIndent()

val menuDoces = """
        1-> $prodCarolina${LINHA}R$${String.format("%.2f", valorCarolina)}
        2-> $prodPudim${LINHA}R$${String.format("%.2f", valorPudim)}
        3-> $prodBrigadeiro${LINHA}R$${String.format("%.2f", valorBrigadeiro)}
        0-> Voltar
    """.trimIndent()

val itensComanda: MutableList<String> = mutableListOf()
var total: Double = 0.0

fun main() {
    do {
        var finalizarCompra = "S"
        ePadoca()
        if (itensComanda.isEmpty()) {
            println("Deseja mesmo finalizar a compra? (S/N)")
            finalizarCompra = readln().uppercase()
        } else {
            if (total >= 20){
                while (!cupomEhValido) {
                    println("Deseja aplicar cupom de desconto? [S/N]")
                    val cupom = readln().uppercase()
                    if (cupom == "S"){
                        aplicaCupom()
                    }
            }

            }else {
                println("O valor da compra não antingiu o valor suficiente para aplicar cupom de desconto. :(\nRESUMO DO PEDIDO:")
            }

            println("====================Comanda E-padoca=======================\n${LINHA}PRODUTO${LINHA}QUANTIDADE${LINHA}VALOR UNITARIO${LINHACOMANDAFINAL}TOTAL")
            itensComanda.forEach { item -> // funcao
                println(item)
            }
            println("Valor total R$${String.format("%.2f", total)}\nAgradecemos a visita! Volte sempre!! :D")

        }
    } while (finalizarCompra != "S")
}

fun ePadoca() {
    println("Bem Vindo à padaria E-Padoca!")
    do {
        println(categorias)

        val categoria = readln().toInt()

        when (categoria) {
            PAES -> selectProd(menuSelecionado = menuPaes, produtos = paes)
            SALGADOS -> selectProd(menuSelecionado = menuSalgados, produtos = salgados)
            DOCES -> selectProd(menuSelecionado = menuDoces, produtos = doces)

            else -> Unit
        }
    } while (categoria != FINALIZAR)
}

fun selectProd(
    menuSelecionado: String, produtos: List<Pair<String, Double>>
) {
    do {
        println(menuSelecionado)
        val produtoSelecionado = readln().toInt()

        for ((i, produto) in produtos.withIndex()) {
            if (i.inc() == produtoSelecionado) {
                selecionaQuantidadeDoProduto(produto)
                break
            }
        }


    } while (produtoSelecionado != 0)
}

fun selecionaQuantidadeDoProduto(prod: Pair<String, Double>) {
    println("Digite a quantidade:")
    val qtdProd = readln().toInt()
    val valortotalItem = qtdProd * prod.second
    val item =
        itemComanda(produto = prod.first, quantidade = qtdProd, valorUnitario = prod.second, total = valortotalItem)
    itensComanda.add(item)
    total += valortotalItem
}

fun itemComanda(
    produto: String,
    quantidade: Int,
    valorUnitario: Double,
    total: Double,
): String = "${itensComanda.size.inc()}${LINHA}$produto${LINHA}$quantidade${LINHACOMANDAFINAL}R$${String.format("%.2f", valorUnitario)}${LINHACOMANDAFINAL}R$${String.format("%.2f", total)}"

fun aplicaCupom() {
       println("Digite o código do cupom:")
       val codCupom = readln().uppercase()
       when (codCupom) {
            "5PADOCA" -> {
                total = total.times(100-5).div(100)
                cupomEhValido = true
            }
            "10PADOCA" -> {
                total.times(100-10).div(100)
                cupomEhValido = true
            }
            "5OFF" ->{
                total= total.minus(5)
                cupomEhValido = true
            }
           else -> {
               total
               cupomEhValido = false
           }
        }

    }


