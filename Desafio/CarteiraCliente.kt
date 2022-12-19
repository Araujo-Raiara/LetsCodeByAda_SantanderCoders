package LetsCodeSecondModule.aula7.Desafio


fun main() {
    val clienteUm = Cliente(
        nome = "Maria",
        sobrenome = "Manu",
        cpf = "587.789.561/44",
        plano = ClienteNormal(),
        senha = "1245"
    )
    //Obs: Tive que fazer o cast porque não consegui pensar em outra forma, aceito criticas construtivas :,)
    val clienteNormal = clienteUm.plano as ClienteNormal
    clienteNormal.deposito(valorDepositado = 1200.00)
    clienteNormal.saque(200.0)
    clienteNormal.pagarBoleto(100.0)
    println("Valor de saldo: ${clienteNormal.carteira.saldo}")

    val clienteDois = Cliente("jose","da silva", "589.845.785.58", ClienteDigital(),  "1289")
    val clienteDigital = clienteDois.plano as ClienteDigital
    clienteDigital.guardar(200.00)
    println("Quantia disponível no cofrinho: ${clienteDigital.cofrinho}")
    clienteDigital.investir(100.00)
    println("Valor investido: ${clienteDigital.investimentos}")
    clienteDigital.transferenciaPix(200.00)
    println("Valor de saldo: ${clienteDigital.carteira.saldo}")

    val clienteTres = Cliente("Jonatas", "Moises", "458.589.748.22", ClientePremium(), "5894")
    val clientePremium = clienteTres.plano as ClientePremium
    clientePremium.deposito(200.0)
    clientePremium.saque(2.0)
    clientePremium.pagarBoleto(10.0)
    clientePremium.transferenciaPix(5.00)
    clientePremium.investir(50.0)
    clientePremium.guardar(80.0)
}

data class Cliente(
    val nome: String,
    val sobrenome: String,
    val cpf: String,
    var plano: Planos,
    private var senha: String
) {
    //Função para alteração de senha quando necessário
    fun adicionarSenha(senha: String, confirmacaoSenha: String) {
        if(validarSenha(senha,confirmacaoSenha)) {
            this.senha = senha
        } else {
            println("senha invalida")
        }
    }

    private fun validarSenha(senha1: String, senha2: String) : Boolean {
        return if(senha1 != senha2) {
            false
        } else {
            senha1.length >= 8
        }
    }
}

interface Planos

class ClienteNormal : Planos, CarteiraFisica() {
    override val carteira = Carteira()
}

class ClienteDigital : Planos, CarteiraDigital() {
    override val carteira: Carteira
        get() = Carteira()
}

class ClientePremium : Planos, ICarteiraBase, ICarteiraFisica, ICarteiraDigital {

    override val carteira: Carteira
        get() = Carteira()

    override var cofrinho: Double = 0.0

    override var investimentos: Double = 0.0

    override fun investir(valorInvestimento: Double) {
        investimentos+=valorInvestimento
        carteira.saldo -= valorInvestimento
    }

    override fun guardar(quantiaAGuardar: Double) {
        cofrinho+=quantiaAGuardar
        carteira.saldo -= quantiaAGuardar
    }

    override fun pagarBoleto(valorBoleto: Double)  {
        carteira.saldo -= valorBoleto
    }

    override fun deposito(valorDepositado: Double)  {
        if (valorDepositado <= 0){
            println("Tentativa de deposito inválida")
        }else carteira.saldo += valorDepositado

    }

    override fun saque(valorASacar: Double)  {
        carteira.saldo -= valorASacar
    }

    override fun transferenciaPix(valorPix: Double)  {
        carteira.saldo += valorPix
    }
}

interface ICarteiraFisica {
    fun deposito(valorDepositado: Double)

    fun saque(valorASacar: Double)
}

open class CarteiraFisica : ICarteiraFisica, ICarteiraBase {

    override val carteira: Carteira
        get() = Carteira()

    override fun pagarBoleto(valorBoleto: Double) {
        carteira.saldo -= valorBoleto
    }

    override fun deposito(valorDepositado: Double) {
        carteira.adicionarSaldo(valorDepositado)
    }

    override fun saque(valorASacar: Double) {
        carteira.saldo-= valorASacar
    }
}

interface ICarteiraDigital {
    var cofrinho: Double
    var investimentos: Double
    fun transferenciaPix(valorPix: Double)
    fun investir(valorInvestimento: Double)
    fun guardar(quantiaAGuardar: Double)
}

open class CarteiraDigital : ICarteiraDigital, ICarteiraBase {

    override val carteira: Carteira
        get() = Carteira()

    override fun pagarBoleto(valorBoleto: Double) {
        carteira.saldo-=valorBoleto
    }

    override var cofrinho: Double = 0.0

    override var investimentos: Double = 0.0

    override fun transferenciaPix(valorPix: Double) {
        carteira.saldo += valorPix
    }

    override fun investir(valorInvestimento: Double) {
        investimentos+=valorInvestimento
        carteira.saldo -= valorInvestimento
    }

    override fun guardar(quantiaAGuardar: Double) {
        cofrinho+=quantiaAGuardar
        carteira.saldo -= quantiaAGuardar
    }
}

interface ICarteiraBase {
    val carteira: Carteira
    fun pagarBoleto(valorBoleto: Double)
}

data class Carteira(
    var senha: String = String(),
    var saldo: Double = 0.0,
    val extrato: MutableList<String> = mutableListOf()
) {
    fun adicionarSaldo(quantia: Double) {
        saldo = saldo.plus(quantia)
    }
}