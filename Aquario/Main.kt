package LetsCodeSecondModule.aula4.Aquario

fun main() {
    val aquario1 =  Aquario().also {
        it.addPeixe(Peixe("Dory", TiposPeixe.CORIDORA, TamanhoPeixe.MEDIO))
        it.addPeixe(Peixe("Nemo", TiposPeixe.BETTA, TamanhoPeixe.PEQUENO))
        it.addPeixe(Peixe("Bolha", TiposPeixe.COLISA, TamanhoPeixe.GRANDE))
        it.alimentaPeixe()
    }
    println(aquario1)
}