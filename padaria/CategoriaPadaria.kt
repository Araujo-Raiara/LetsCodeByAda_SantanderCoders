package LetsCodeSecondModule.desafiosrefatorados.padaria

enum class CategoriaPadaria (val descricao: String, val id: Int) {
    PAES("Pães \uD83C\uDF5E", 1),
    SALGADOS("Salgados \uD83C\uDF57",2),
    DOCES("Doces \uD83E\uDDC1",3),
    BEBIDAS("Bebidas ☕",4);

    override fun toString(): String {
        return "$id- $descricao"
    }
}