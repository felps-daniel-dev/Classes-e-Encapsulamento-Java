import java.util.Scanner;

/*
* Autor.....: Felipe Daniel da Silva
* Data......:26/06/2025
* Objetivo..:
* Escreva um código onde temos uma conta bancaria que possa realizar as seguintes operações:
Consultar saldo
consultar cheque especial
Depositar dinheiro;
Sacar dinheiro;
Pagar um boleto.
Verificar se a conta está usando cheque especial.
Siga as seguintes regras para implementar

A conta bancária deve ter um limite de cheque especial somado ao saldo da conta;
O o valor do cheque especial é definido no momento da criação da conta, de acordo com o valor depositado na conta em sua criação;
Se o valor depositado na criação da conta for de R$500,00 ou menos o cheque especial deve ser de R$50,00
Para valores acima de R$500,00 o cheque especial deve ser de 50% do valor depositado;
Caso o limite de cheque especial seja usado, assim que possível a conta deve cobrar uma taxa de 20% do valor usado do cheque especial.
*/
public class Main {
    public static void main(String[] args) {

        //leitura do teclado
        Scanner sc = new Scanner(System.in);

        //inicio
        System.out.println("| ============Início=========== |");
        System.out.print("Digite o depósito inicial.....R$ ");
        double depInic = sc.nextDouble();
        ContaBancaria conta = new ContaBancaria(depInic);


        //limpa tela
        conta.limpaTela();
        int opcao;
        do {
            System.out.println("| ================Menu Inicial================ |");
            System.out.println("| [1] - Consultar Saldo.                       |");
            System.out.println("| [2] - Consultar cheque especial disponível.  |");
            System.out.println("| [3] - Depositar dinheiro.                    |");
            System.out.println("| [4] - Sacar dinheiro.                        |");
            System.out.println("| [5] - Pagar Boleto.                          |");
            System.out.println("| [6] - Verificar uso do cheque especial.      |");
            System.out.println("| [7] - Cobrar taxa do cheque especial.        |");
            System.out.println("| [0] - Sair.                                  |");
            System.out.print("| ==> ");
            opcao = sc.nextInt();

            switch (opcao) {

                case 1:
                    //limpar tela
                    conta.limpaTela();
                    conta.consutarSaldo();
                    break;

                case 2:
                    conta.limpaTela();
                    conta.consultarChequeEspecialDisponivel();
                    break;
                case 3:
                    conta.limpaTela();
                    System.out.print("Qual o valor do depósito.....: ");
                    var valor = sc.nextDouble();
                    conta.depositar(valor);
                    break;
                case 4:
                    conta.limpaTela();
                    System.out.print("Qual o valor do saque.......: ");
                    var valSa = sc.nextDouble();
                    conta.sacar(valSa);
                    break;
                case 5:
                    conta.limpaTela();
                    System.out.print("Qual o valor do boleto......: ");
                    var valBol = sc.nextDouble();
                    conta.pagarBoleto(valBol);
                    break;
                case 6:
                    conta.limpaTela();
                    conta.consultarChequeEspecialDisponivel();
                    break;
                case 7:
                    conta.limpaTela();
                    conta.cobrarTaxaChequeEspecial();
                    break;
                case 0:
                    conta.limpaTela();
                    break;
                default:
                    System.out.println("Número inválido.");
                    break;

            }

        } while (opcao != 0);
    }
}
