package LetsCodeSecondModule.aula2.cores_enum


enum class Cores(val corNome: String, val padrao: PadraoCor){
    VERMELHO("Vermelho",  padrao = PadraoCor(" #d61e18", " 214, 30, 24", " 0%, 86%, 89%, 16%", " 2°, 89%, 84%", " 2°, 80%, 47%")),
    AZUL("Azul",  padrao = PadraoCor(" #184bd8", " 24, 76, 217", " 89%, 65%, 0%, 15%", " 224°, 89%, 85%", " 224°, 80%, 47%")),
    VERDE("Verde",  padrao = PadraoCor(" #1ff507", " 31, 245, 7", " 87%, 0%, 97%, 4%", " 114°, 97%, 96%", " 114°, 94%, 49%")),
    AMARELO("Amarelo",  padrao = PadraoCor(" #ebe134", " 235, 225, 52", " 0%, 4%, 78%, 8%", " 57°, 78%, 92%", " 57°, 82%, 56%"));

    override fun toString(): String {
        return "Cores(nome= $corNome, padroes= $padrao)"
    }
}



