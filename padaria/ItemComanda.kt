package LetsCodeSecondModule.desafiosrefatorados.padaria

data class ItemComanda(val produto: ProdutoPadaria, val quantidade : Int){
    override fun toString(): String {
        return "$produto \nquantidade: $quantidade"
    }
}
