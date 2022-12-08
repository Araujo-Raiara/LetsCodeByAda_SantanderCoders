package LetsCodeSecondModule.desafiosrefatorados.padaria

abstract class ProdutoPadaria {
    abstract val id : Int
    abstract val nome : String
    abstract val descricao : String
    abstract val precoUnitario: Double?
    abstract val precoKg : Double?
    abstract val categoria : CategoriaPadaria

    override fun toString(): String {
        //alguns produtos não estão disponíveis por kg, por isso essa validação
        return if (precoKg == null) "\n$id-Produto: $nome\nDescrição: $descricao\nPreço Unitário\uD83D\uDCB5: R$ ${String.format("%.2f", precoUnitario)}"
        else
            "\n$id- Produto: $nome\nDescrição: $descricao\nPreço Unitário\uD83D\uDCB5: R$ ${String.format("%.2f", precoUnitario)}\nPreço kg\uD83D\uDCB5: ${String.format("%.2f", precoKg)}"
    }
}