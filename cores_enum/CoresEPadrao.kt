package LetsCodeSecondModule.aula2.cores_enum

const val ANSI_RESET = "\u001B[0m"
const val VERMELHO = "\u001B[31m"
const val AZUL = "\u001B[34m"
const val VERDE = "\u001B[32m"
const val AMARELO = "\u001B[33m"


fun main() {

    println(Cores.VERMELHO.toString() + VERMELHO + " :)"+ ANSI_RESET);
    println(Cores.AZUL.toString() + AZUL + " :)"+ ANSI_RESET);
    println(Cores.VERDE.toString() + VERDE + " :)"+ ANSI_RESET);
    println(Cores.AMARELO.toString() + AMARELO + " :)"+ ANSI_RESET);

}