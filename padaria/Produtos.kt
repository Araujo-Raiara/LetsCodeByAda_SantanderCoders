package LetsCodeSecondModule.desafiosrefatorados.padaria

class PaoFrances : ProdutoPadaria() {
    override val id: Int
        get() = 1
    override val nome: String
        get() = "Pao Frances \uD83C\uDF5E"
    override val descricao: String
        get() = "Tabela nutricional:\n" +
                "Calorias- 186\n" +
                "Gorduras Totais- 15g"
    override val precoUnitario: Double?
        get() = 0.8
    override val precoKg: Double?
        get() = 15.2
    override val categoria: CategoriaPadaria
        get() = CategoriaPadaria.PAES
}
class Baguette : ProdutoPadaria() {
    override val id: Int
        get() = 2
    override val nome: String
        get() = "Baguette \uD83E\uDD56"
    override val descricao: String
        get() = "Tabela nutricional:\n" +
                "Calorias- 246\n" +
                "Gorduras Totais- 19g"
    override val precoUnitario: Double?
        get() = 0.5
    override val precoKg: Double?
        get() = 14.5
    override val categoria: CategoriaPadaria
        get() = CategoriaPadaria.PAES
}

class Croissant : ProdutoPadaria() {
    override val id: Int
        get() = 3
    override val nome: String
        get() = "Croissant \uD83E\uDD50"
    override val descricao: String
        get() = "Tabela nutricional:\n" +
                "Calorias- 286\n" +
                "Gorduras Totais- 14g"
    override val precoUnitario: Double?
        get() = 0.4
    override val precoKg: Double?
        get() = 13.0
    override val categoria: CategoriaPadaria
        get() = CategoriaPadaria.PAES
}

class Coxinha : ProdutoPadaria() {
    override val id: Int
        get() = 4
    override val nome: String
        get() = "Coxinha  \uD83C\uDF57"
    override val descricao: String
        get() = "Tabela nutricional:\n" +
                "Calorias- 156\n" +
                "Gorduras Totais- 18g"
    override val precoUnitario: Double?
        get() = 1.50
    override val precoKg: Double?
        get() = null
    override val categoria: CategoriaPadaria
        get() = CategoriaPadaria.SALGADOS
}

class Sandwich : ProdutoPadaria() {
    override val id: Int
        get() = 5
    override val nome: String
        get() = "Sandwich \uD83E\uDD6A "
    override val descricao: String
        get() = "Tabela nutricional:\n" +
                "Calorias- 114\n" +
                "Gorduras Totais- 14g"
    override val precoUnitario: Double?
        get() = 5.0
    override val precoKg: Double?
        get() = null
    override val categoria: CategoriaPadaria
        get() = CategoriaPadaria.SALGADOS
}

class Taco : ProdutoPadaria() {
    override val id: Int
        get() = 6
    override val nome: String
        get() = "Taco \uD83C\uDF2E"
    override val descricao: String
        get() = "Tabela nutricional:\n" +
                "Calorias- 226\n" +
                "Gorduras Totais- 13g"
    override val precoUnitario: Double?
        get() = 0.5
    override val precoKg: Double?
        get() = 12.0
    override val categoria: CategoriaPadaria
        get() = CategoriaPadaria.SALGADOS
}

class Shortcake : ProdutoPadaria() {
    override val id: Int
        get() = 7
    override val nome: String
        get() = "Shortcake \uD83C\uDF70"
    override val descricao: String
        get() = "Tabela nutricional:\n" +
                "Calorias- 220\n" +
                "Gorduras Totais- 16g"
    override val precoUnitario: Double?
        get() = 25.0
    override val precoKg: Double?
        get() = 100.0
    override val categoria: CategoriaPadaria
        get() = CategoriaPadaria.DOCES
}

class Cookie : ProdutoPadaria() {
    override val id: Int
        get() = 8
    override val nome: String
        get() = "Cookie  \uD83C\uDF6A"
    override val descricao: String
        get() = "Tabela nutricional:\n" +
                "Calorias- 166\n" +
                "Gorduras Totais- 12g"
    override val precoUnitario: Double?
        get() = 6.0
    override val precoKg: Double?
        get() = 50.0
    override val categoria: CategoriaPadaria
        get() = CategoriaPadaria.DOCES
}

class Cupcake : ProdutoPadaria() {
    override val id: Int
        get() = 9
    override val nome: String
        get() = "Cupcake \uD83E\uDDC1"
    override val descricao: String
        get() = "Tabela nutricional:\n" +
                "Calorias- 156\n" +
                "Gorduras Totais- 15g"
    override val precoUnitario: Double?
        get() = 5.0
    override val precoKg: Double?
        get() = 20.0
    override val categoria: CategoriaPadaria
        get() = CategoriaPadaria.DOCES
}

class CafeP : ProdutoPadaria() {
    override val id: Int
        get() = 10
    override val nome: String
        get() = "Café Pequeno ☕"
    override val descricao: String
        get() = "Tabela nutricional:\n" +
                "Calorias- 0\n" +
                "Gorduras Totais- 0g"
    override val precoUnitario: Double?
        get() = 1.5
    override val precoKg: Double?
        get() = null
    override val categoria: CategoriaPadaria
        get() = CategoriaPadaria.BEBIDAS
}

class CafeM : ProdutoPadaria() {
    override val id: Int
        get() = 11
    override val nome: String
        get() = "Café Médio ☕"
    override val descricao: String
        get() = "Tabela nutricional:\n" +
                "Calorias- 0\n" +
                "Gorduras Totais- 0g"
    override val precoUnitario: Double?
        get() = 3.5
    override val precoKg: Double?
        get() = null
    override val categoria: CategoriaPadaria
        get() = CategoriaPadaria.BEBIDAS
}

class CafeG : ProdutoPadaria() {
    override val id: Int
        get() = 12
    override val nome: String
        get() = "Café Grande ☕"
    override val descricao: String
        get() = "Tabela nutricional:\n" +
                "Calorias- 0\n" +
                "Gorduras Totais- 0g"
    override val precoUnitario: Double?
        get() = 5.0
    override val precoKg: Double?
        get() = null
    override val categoria: CategoriaPadaria
        get() = CategoriaPadaria.BEBIDAS
}



