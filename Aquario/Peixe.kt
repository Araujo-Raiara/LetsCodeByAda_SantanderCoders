package LetsCodeSecondModule.aula4.Aquario

 data class Peixe(val nome: String, val especie: TiposPeixe, val tamanho: TamanhoPeixe, var alimentado: Boolean = true){
  override fun toString(): String {
   val foiAlimentado = if (alimentado) "Está alimentado" else "Com fome"
   return "Nome: $nome | Foto: ${especie.imagem} | Espécie: ${especie.name.lowercase().replaceFirstChar { it.uppercase() }} | Tamanho: ${tamanho.name} | $foiAlimentado\n"
  }
 }

enum class TiposPeixe(val porcentagemDeSerAlimentado: Int, val imagem: String) {
 BETTA(95,"\uD83D\uDC1F"),
 COLISA(84,"\uD83D\uDC20"),
 CORIDORA(50,"\uD83D\uDC21")
}

enum class TamanhoPeixe {
 PEQUENO, MEDIO, GRANDE
}