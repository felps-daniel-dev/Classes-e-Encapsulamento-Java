public class ContaBancaria {
    private double saldo;
    private double limiteChequeEspecial;
    private double chequeEspecialUsado;

    public ContaBancaria(double depositoInicial) {
        this.saldo = depositoInicial;


        if (depositoInicial <= 500) {
            this.limiteChequeEspecial = 50;
        } else {
            this.limiteChequeEspecial = depositoInicial * 0.5;
        }

        this.chequeEspecialUsado = 0;
    }

    //verificar saldo
    public void consutarSaldo() {
        System.out.println("Saldo: " + saldo);
        return;
    }

    //consultar cheque especial Disponivel
    public void consultarChequeEspecialDisponivel() {
        double disponivel = limiteChequeEspecial - chequeEspecialUsado;
        System.out.println("Cheque especial disponível: R$" + disponivel);
    }

    //Fazer deposito
    public void depositar(double valor) {

        //verificar se o valor nao é menor ou igual a zero
        if (valor <= 0){
            System.out.println("O valor é invalido.");
            return;
        }

        // verificar se está devendo o cheque especial
        if(chequeEspecialUsado > 0){
            if(valor >= chequeEspecialUsado) {
                valor -= chequeEspecialUsado;
                System.out.printf("R$%.2f foram descontados para pagar outros cheques especiais usados.",chequeEspecialUsado);
                chequeEspecialUsado = 0;
            }else{
                chequeEspecialUsado -= valor;
                System.out.printf("R$%.2f pagos no cheque especial. Ainda restam:R$%.2f",valor,chequeEspecialUsado);
                valor = 0;
            }
        }
        // o que sobrou vai para o saldo
        saldo += valor;
        System.out.printf("Depósito realizado. Saldo: R$%.2f\n",saldo);
    }

    //sacar um valor
    public void sacar(double valor){
        //verificar se o valor nao é menor ou igual a zero
        if (valor <= 0){
            System.out.println("O valor é invalido.");
            return;
        }
        double saldoDisponivel = saldo + (limiteChequeEspecial - chequeEspecialUsado);
        if (valor > saldoDisponivel) {
            System.out.println("Saldo insuficiente, mesmo com cheque especial.");
            return;
        }
        if (valor <= saldo) {
            saldo -= valor;
        } else {
            // Usar o saldo inteiro e o restante do cheque especial
            double restante = valor - saldo;
            saldo = 0;
            chequeEspecialUsado += restante;
        }

        System.out.printf("Saque de R$%.2f realizado com sucesso.%n", valor);
        System.out.printf("Saldo atual: R$%.2f | Cheque especial usado: R$%.2f%n", saldo, chequeEspecialUsado);

    }

    //pagamento de boleto
    public void pagarBoleto(double valorBoleto){
            System.out.println("Pagamento de boleto no valor de R$" + valorBoleto);
            sacar(valorBoleto);

    }

    //verificar se esta usando o cheque
    public boolean estaUsandoChequeEspecial() {
        return chequeEspecialUsado > 0;
    }

    //taxa do cheque
    public void cobrarTaxaChequeEspecial() {
        if (chequeEspecialUsado > 0) {
            double taxa = chequeEspecialUsado * 0.2;

            if (saldo >= taxa) {
                saldo -= taxa;
                System.out.printf("Taxa de R$%.2f cobrada do saldo.%n", taxa);
            } else {
                chequeEspecialUsado += taxa;
                System.out.printf("Saldo insuficiente. Taxa de R$%.2f adicionada ao cheque especial usado.%n", taxa);
            }
        } else {
            System.out.println("Nenhuma taxa cobrada. Cheque especial não foi utilizado.");
        }
    }

    //limpador de tela
    public void limpaTela(){
        for(int i =0; i < 50; i++){
            System.out.println("        ");
        }
    }

}


