var saldo = 1000.0
var nome = ""

fun main() {
    print("Digite seu nome: ")
    nome = readln()

    println("Olá $nome é um prazer ter você por aqui!")

    inicio()
}

fun inicio() {
    var opcao: Int

    do {
        println()
        println("===== MENU PRINCIPAL =====")
        println("1 - Saldo")
        println("2 - Extrato")
        println("3 - Saque")
        println("4 - Depósito")
        println("5 - Transferência")
        println("6 - Sair")
        print("Escolha uma opção: ")

        opcao = readln().toInt()

        when (opcao) {
            1 -> consultarSaldo()
            2 -> consultarExtrato()
            3 -> realizarSaque()
            4 -> realizarDeposito()
            5 -> realizarTransferencia()
            6 -> {
                println()
                println("$nome, foi um prazer ter você por aqui!")
            }
            else -> erro()
        }

    } while (opcao != 6)
}

fun validarSenha(): Boolean {
    print("Digite sua senha: ")
    val senha = readln().toInt()

    if (senha == 3589) {
        return true
    } else {
        println("Senha incorreta.")
        return false
    }
}

fun consultarSaldo() {

    if (!validarSenha()) {
        consultarSaldo()
        return
    }

    println()
    println("Saldo atual: R$ %.2f".format(saldo))
}

fun consultarExtrato() {

    if (!validarSenha()) {
        consultarExtrato()
        return
    }

    println()
    println("===== EXTRATO =====")
    println("Depósito: + R$ 500,00")
    println("Compra: - R$ 100,00")
    println("Compra: - R$ 50,00")
    println("Depósito: + R$ 650,00")
    println("-------------------")
    println("Saldo atual: R$ %.2f".format(saldo))
}

fun realizarSaque() {

    if (!validarSenha()) {
        realizarSaque()
        return
    }

    print("Digite o valor do saque: ")
    val valor = readln().toDouble()

    if (valor <= 0) {
        println("Operação não autorizada.")
        return
    }

    if (valor > saldo) {
        println("Operação não autorizada.")
        return
    }

    saldo -= valor

    println("Saque realizado com sucesso.")
    println("Saldo atual: R$ %.2f".format(saldo))
}

fun realizarDeposito() {

    print("Digite o valor do depósito: ")
    val valor = readln().toDouble()

    if (valor <= 0) {
        println("Operação não autorizada.")
        return
    }

    saldo += valor

    println("Depósito realizado com sucesso.")
    println("Saldo atual: R$ %.2f".format(saldo))
}

fun realizarTransferencia() {

    if (!validarSenha()) {
        realizarTransferencia()
        return
    }

    var conta: String

    while (true) {
        print("Digite o número da conta: ")
        conta = readln()

        if (conta.matches(Regex("\\d+"))) {
            break
        }

        println("Número da conta inválido. Digite apenas números.")
    }

    print("Digite o valor da transferência: ")
    val valor = readln().toDouble()

    if (valor <= 0) {
        println("Operação não autorizada.")
        return
    }

    if (valor > saldo) {
        println("Operação não autorizada.")
        return
    }

    saldo -= valor

    println("Transferência realizada com sucesso.")
    println("Conta de destino: $conta")
    println("Saldo atual: R$ %.2f".format(saldo))
}

fun erro() {
    println("Por favor, informe um número entre 1 a 6.")
}