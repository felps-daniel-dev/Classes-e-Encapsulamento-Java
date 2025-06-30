import java.util.Scanner;

/*
* Autor......:Felipe Daniel da Silva
* Data.......:26/06/2025
* Objetivo...:
* Escreva um código onde controlamos as funções de um carro, ele deve ter as seguintes funções:
Ligar o carro;
Desligar o carro;
Acelerar;
diminuir velocidade;
virar para esquerda/direita
verificar velocidade;
trocar a marcha
Siga as seguintes regras na implementação

Quando o carro for criado ele deve começar desligado, em ponto morto e com sua velocidade em 0
O carro desligado não pode realizar nenhuma função;
Quando o carro for acelerado ele deve incrementar 1km em sua velocidade (pode chegar no máximo a 120km);
Quando diminuir a velocidade do carro ele deve decrementar 1 km de sua velocidade (pode chegar no minimo a 0km);
o carro deve possuir 6 marchas, não deve ser permitido pular uma marcha no carro;
A velocidade do carro deve respeitar os seguintes limites para cada velocidade
se o carro estiver na marcha 0 (ponto morto) ele não pode acelerar
se estiver na 1ª marcha sua velocidade pode estar entre 0km e 20km
se estiver na 2ª marcha sua velocidade pode estar entre 21km e 40km
se estiver na 3ª marcha sua velocidade pode estar entre 41km e 60km
se estiver na 4ª marcha sua velocidade pode estar entre 61km e 80km
se estiver na 5ª marcha sua velocidade pode estar entre 81km e 100km
se estiver na 6ª marcha sua velocidade pode estar entre 101km e 120km
O carro podera ser desligado se estiver em ponto morto (marcha 0) e sua velocidade em 0 km
O carro só pode virar para esquerda/direita se sua velocidade for de no mínimo 1km e no máximo 40km;*/
public class Main {

    public static void main(String[] args) {

        //objeto para ler o teclado
        Scanner sc = new Scanner(System.in);

        //indentificando o modelo
        System.out.print("Digite o modelo do carro...: ");
        var modeloDigitado = sc.nextLine();
        //ojeto com os atributos e métodos da Classe Carro
        Carro meuCarro = new Carro(modeloDigitado);
        meuCarro.limparTela();

        //loop para o menu
        int opcao;

        do {
            System.out.println("| ======Menu do meu carro====== |");
            System.out.println("| Modelo...: " + meuCarro.getModelo() + "                |");
            System.out.println("| [1] -> Ligar o Carro          |");
            System.out.println("| [2] -> Reabastecer            |");
            System.out.println("| [0] -> EXIT.                  |");
            System.out.print("|==> ");
            opcao = sc.nextInt();
            meuCarro.limparTela();

            if (opcao == 1) {
                meuCarro.ligar();

                int opLigado;
                do {
                    System.out.println("| =====Painel do carro [--> LIGADO <--]===== |");
                    System.out.println("| [1] => Acelerar. [" + meuCarro.velocidade + "km/h]                     |");
                    System.out.println("| [2] -> Reduzir Velocidade.                 |");
                    System.out.println("| [3] -> Engatar marcha. [" + meuCarro.marcha + "]                 |");
                    System.out.println("| [4] -> Virar.                              |");
                    System.out.println("| [5] -> Verificar Gasolina.                 |");
                    System.out.println("| [6] -> Desligar.                           |");
                    System.out.println("| [0] -> EXIT.                               |");
                    System.out.print("==> ");
                    opLigado = sc.nextInt();
                    meuCarro.limparTela();

                    switch (opLigado) {
                        case 1:
                            meuCarro.acelerar();
                            break;
                        case 2:
                            meuCarro.reduzirVelo();
                            break;
                        case 3:
                            System.out.print("Digite a nova marcha...: ");
                            int nova = sc.nextInt();
                            sc.nextLine();
                            meuCarro.trocaMarcha(nova);
                            break;
                        case 4:
                            meuCarro.limparTela();
                            sc.nextLine(); // Consome o ENTER que ficou pendente no buffer
                            System.out.println("Qual direção quer seguir? [direita/esquerda]");
                            String newdirecao = sc.nextLine();
                            meuCarro.virar(newdirecao);
                            break;
                        case 5:
                            meuCarro.verificarCombustivel();
                            break;
                        case 6:
                            meuCarro.desligado();
                            break;
                        case 0:
                            System.out.println("Encerrando...");
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Opção inválida.");
                            break;
                    }
                } while (meuCarro.estaLigado());

            } else if (opcao == 2) {
                if (meuCarro.estaLigado()) {
                    System.out.println("Desligue o carro para reabastecer.");
                } else {
                    System.out.print("Quantos litros vai reabastecer...: ");
                    double litros = sc.nextDouble();
                    meuCarro.reabastecer(litros);
                }
            } else if (opcao == 0) {
                System.out.println("Encerrando...");
                System.exit(0);
            } else {
                System.out.println("Número inválido.");
            }

        } while (true);
    }
}