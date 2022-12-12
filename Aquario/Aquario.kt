package LetsCodeSecondModule.aula4.Aquario

import kotlin.random.Random
import kotlin.random.nextInt

class Aquario {
    private val listaPeixes = mutableListOf<Peixe>()
    private var limitePeixe = 3
    private var porcentagemDeLimpezaDoAquario = 100

    fun addPeixe(peixe: Peixe) {
        if (porcentagemDeLimpezaDoAquario > 50) {
            listaPeixes.add(peixe)
        } else {
            println("Você não pode adicionar peixes porque seu aquario está sujo demais...\uD83E\uDD22")
        }
    }

    fun alimentaPeixe() {
        listaPeixes.ifEmpty {
            println("O Aquário não possui peixes para alimentar. \uD83E\uDD14")
        }
        println("Alimentando os seus peixes!")
        repeat(3) {
            Thread.sleep(500)
            print("\uD83C\uDF7D\n")
        }
        Thread.sleep(500)

        val novaLista = mutableListOf<Peixe>()

        listaPeixes.forEach { peixe ->
            val peixeAposTentarSerAlimentado = peixe.tentarAlimentar()
            novaLista.add(peixeAposTentarSerAlimentado)
        }

        listaPeixes.clear()
        listaPeixes.addAll(novaLista)

        if (listaPeixes.all { !it.alimentado }) {
            println("Nenhum peixe foi alimentado \uD83D\uDC94")
        } else if (listaPeixes.any { !it.alimentado }) {
            println("Alguns peixes não foram alimentados \uD83D\uDE22 ")
        } else {
            println("Todos os peixes foram alimentados \uD83D\uDC96")
        }
    }

    private fun Peixe.tentarAlimentar(): Peixe {
        val numero = Random.nextInt(0..100)
        return this.copy(alimentado = numero < this.especie.porcentagemDeSerAlimentado)
    }

    fun limpaAquario() {
        if (listaPeixes.size % limitePeixe == 0) {
            println("Limpando o aquário...\uD83E\uDDFD")
            repeat(3) {
                Thread.sleep(500)
                print("\uD83E\uDEE7")
            }
            Thread.sleep(500)
            println("\nAquario limpo!✨")
        } else {
            println("O Aquário ainda não está apto para limpeza")
        }

    }

//    fun defineLimitePeixe(limite: Int) {
//        limitePeixe = limite
//    }


    override fun toString(): String {
        return "Lista de Peixes:\n${listaPeixes.joinToString("\n")}"

    }
}