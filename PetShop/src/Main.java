import java.util.Scanner;

/*
* Autor......:Felipe Daniel da Silva
* Data.......:26/06/2025
* Objetivo...:
*Escreva um código onde temos o controle de banho de um petshop, a maquina de banhos dos pets deve ter as seguintes operações:
Dar banho no pet;
Abastecer com água;
Abastecer com shampoo;
verificar nivel de água;
verificar nivel de shampoo;
verificar se tem pet no banho;
colocar pet na maquina;
retirar pet da máquina;
limpar maquina.
Siga as seguintes regras para implementação

A maquina de banho deve permitir somente 1 pet por vez;
Cada banho realizado irá consumir 10 litros de água e 2 litros de shampoo;
A máquina tem capacidade máxima de 30 litros de água e 10 litros de shampoo;
Se o pet for retirado da maquina sem estar limpo será necessário limpar a máquina para permitir a entrada de outro pet;
A limpeza da máquina ira consumir 3 litros de água e 1 litro de shampoo;
O abastecimento de água e shampoo deve permitir 2 litros por vez que for acionado;
*/
public class Main {
    private final static Scanner scanner = new Scanner(System.in);

    private final static PetMachine petMachine  = new PetMachine();
    public static void main(String[] args) {

        scanner.useDelimiter("\\n");

        var option = -1;
        do {
            System.out.println("===Escolha uma das opções===");
            System.out.println("1 - Dar banho no Pet");
            System.out.println("2 - Abastecer maquina com água");
            System.out.println("3 - Abastecer maquina com shampoo");
            System.out.println("4 - Verificar água da máquina");
            System.out.println("5 - Verificar shampoo da máquina");
            System.out.println("6 - Verificar se tem pet no banho");
            System.out.println("7 - Colocar pet na máquina");
            System.out.println("8 - Retirar pet da maquina");
            System.out.println("9 - Limpar máquina");
            System.out.println("0 - Sair");
            option = scanner.nextInt();

            switch (option){
                case 1 -> petMachine.takeAShouwer();
                case 2 -> setWater();
                case 3 -> setShampoo();
                case 4 -> {
                    verifyWater();
                }
                case 5-> {
                    verifyShampoo();
                }
                case 6 -> checkIfHasInMachine();
                case 7 -> setPetInPetMachine();
                case 8 -> petMachine.removePet();
                case 9 -> petMachine.wash();
                case 0 -> System.exit(0);
                default -> System.out.print("Opção inválida");

            }
        }while (true);
    }

    private static void setWater(){
        System.out.println("Tentando colocar água na máquina");
        petMachine.addWater();
    }


    private static void verifyWater() {
        var amout = petMachine.getWater();
        System.out.println("A Maquina está no momento com" + amout + "Litros de water");
    }
    private static void setShampoo(){
        System.out.print("Tentando colocar shampoo na máquina\n");
        petMachine.addShampoo();
    }

    private static void verifyShampoo() {
        System.out.print("Tentando colocar shampoo na máquina\n ");
        var amout = petMachine.getShampoo();
        System.out.println("A Maquina está no momento com " + amout + " Litros de shampoo\n");
    }

    private static void checkIfHasInMachine() {
        var hasPet = petMachine.hasPet();
        System.out.println(hasPet ?"Tem pet na maquina\n" : "Não tem pet na máquina\n");
    }


    public static void setPetInPetMachine(){

        var name ="";
        while (name == null || name.isEmpty() ){
            System.out.println("Informe o nome do pet..: ");
            name = scanner.nextLine();
        }
        var pet = new Pet(name);
        petMachine.setPet(pet);

    }



}