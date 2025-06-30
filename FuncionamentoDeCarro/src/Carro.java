public class Carro {

    private String meuCarro;//pode ser "Gol,Civic,Opala"

    //criando as variaveis
    private boolean ligado;
    public int marcha;
    public int velocidade;
    public String modelo;
    private double combustivel;
    private final double maxCombustivel = 80;

    public Carro(String modelo) {
        this.modelo = modelo;
        this.ligado = false;
        this.velocidade = 0;
        this.marcha = 0;
        this.combustivel = 40;
    }

    //exibir o modelo do carro sempre que necessrio
    //defino o modeloDigitado para o modelo
    public String getModelo() {
        return modelo;
    }


    public void ligar() {
        if (ligado) {
            System.out.println("O carro já esta ligado");
            return;
        } else {

            ligado = true;
            System.out.println("O carro foi ligado");
            return;
        }
    }

    public boolean estaLigado() {
        return ligado;
    }

    public void desligado(){
        if (!ligado){
            System.out.println("O carro já está desligado.");
            return;
        }

        if (velocidade == 0 && marcha == 0) {
            ligado = false;
            System.out.println("Carro foi desligado.");
        } else {
            System.out.println("Não é possível desligar o carro em movimento ou engatado.");
        }
    }

    public void acelerar() {
        //verificar se o carro esta ligado
        if (!ligado) {
            System.out.println("O carro esta desligado. Ligue para acelerar");

        }

        //verificando se o carro esta com combustive para conseguir acelerar
        double consumoPorKm = 0.2;

        if (velocidade % 5 == 0 && combustivel > 0) {
            combustivel -= 1;
        }

        if (combustivel < consumoPorKm) {
            System.out.println("Combustível insuficiente para acelerar. Abasteça.");
            return;
        }
        //verificar se a marcha é 0
        if (marcha == 0) {
            System.out.println("O carro precisa estar engatado para acelerar");
            return;
        }

        //fazendo a verificação de limite
        int limiteMax = -1;
        switch (marcha) {
            case 0: {
                System.out.println("Ponto morto não pode acelerar");
            }
            case 1:
                limiteMax = 20;
                break;
            case 2:
                limiteMax = 40;
                break;
            case 3:
                limiteMax = 60;
                break;
            case 4:
                limiteMax = 80;
                break;
            case 5:
                limiteMax = 100;
                break;
            case 6:
                limiteMax = 120;
                break;
            default:
                System.out.println("Marcha invalida");
                return;
        }
        //verificar se a velocidade atual limite pode acelerar
        if (velocidade < limiteMax) {
            velocidade += 1;
            combustivel -= consumoPorKm;

            System.out.println("Velocidade atual " + velocidade + "km/h");
        } else {
            System.out.println("Velocidade atual " + velocidade + "km/h. Chegou no limite da marcha aumente a marcha");
        }
    }

    public void reduzirVelo() {
        //verificar se o carro está desligado
        if (!ligado) {
            System.out.println("O carro prescisa estar ligado.");
            return;
        }
        //verificar se a velocidade jã esta no minimo
        if (velocidade > 0) {
            velocidade -= 1;
            System.out.println("Velocidade reduzida para " + velocidade + " km/h");
        } else {
            System.out.println("O carro já está parado");
        }
    }

    public void trocaMarcha(int novaMarcha) {
        //verificar se o carro esta desligado
        if (!ligado) {
            System.out.println("O carro prescisa estar ligado.");
            return;
        }

        //verificar se a nova marcha é valida
        if (novaMarcha < 0 || novaMarcha > 6) {
            System.out.println("Não é permitido pular marchar");
            return;
        }
        if (Math.abs(novaMarcha - marcha) > 1) {
            System.out.println("Não é possivel pular marcha");
            return;
        }

        //verificr se  velocidade é compativel  com a nova marcha
        boolean velocidadeIncompativel = false;

        switch (novaMarcha) {
            case 0:
                if (velocidade != 0) velocidadeIncompativel = true;
                break;
            case 1:
                if (velocidade > 20) velocidadeIncompativel = true;
                break;
            case 2:
                if (velocidade < 21 || velocidade > 40) velocidadeIncompativel = true;
                break;
            case 3:
                if (velocidade < 41 || velocidade > 60) velocidadeIncompativel = true;
                break;
            case 4:
                if (velocidade < 61 || velocidade > 80) velocidadeIncompativel = true;
                break;
            case 5:
                if (velocidade < 81 || velocidade > 101) velocidadeIncompativel = true;
                break;
            case 6:
                if (velocidade < 101 || velocidade > 120) velocidadeIncompativel = true;
                break;
        }

        //nao deixa trocar marcha
        if (velocidadeIncompativel) {
            System.out.println("Velocidade atual (" + velocidade + " km/h) não é compatível com a marcha " + novaMarcha + ".");
            return;
        }
        marcha = novaMarcha;
        System.out.println("Marcha alterada para: " + marcha);
    }

    public void virar(String direcao) {
        //verificar sde o carro esta ligado
        if (!ligado) {
            System.out.println("O carro está desligado. Não pode virar.");
            return;
        }

        if (!direcao.equalsIgnoreCase("esquerda") && !direcao.equalsIgnoreCase("direita")) {
            System.out.println("Direção invalida. So pode ir para a direita ou esquerda");
            return;
        }

        if (velocidade >= 1 && velocidade <= 40) {
            System.out.println("Virando para " + direcao);
        } else {
            System.out.println("Velecidade " + velocidade + "km/h não pode fazer essa curva");
        }

    }

    public void verificarCombustivel() {
        //verificar se o carro esta ligado
        if (!ligado) {
            System.out.println("O carro está desligado. Prescisa ligar para acender o combustivel no painel..");
            return;
        }
        //mostrar o maximo e o minimo de combustivel do tanque
        System.out.println("Minimo[0]   Máximo[80]");
        System.out.println("Tanque esta com " + combustivel);

        if (combustivel <= 0) {
            System.out.println("O carro esta sem combustivel. prescisa reabastecer");
            return;
        }

        //apontar a reserva do carro
        if (combustivel <= 20) {
            System.out.println("O Carro está na reserva.");
            return;
        }

        if (combustivel == 80) {
            System.out.println("O carro esta com o tanque cheio.");
            return;
        }


    }

    //nao posso usar a variavel combustivel porque se eu adicinar um valor, a quantidade que ja tinha no tanque passa a ser a quantidade adicionada
    //“Esse método precisa de uma informação vinda de fora pra funcionar?"
    //Se sim → põe nos parênteses como parâmetro.
    //Se não → deixa os parênteses vazios.
    public void reabastecer(double litros) {
        //verificando se o carro esta ligado
        if (ligado) {
            System.out.println("O carro está ligado. Precisa desligar para reabastecer");
            return;
        }
        if (litros <= 0) {
            System.out.println("Quantidade inválida para abastecimento.");
            return;
        }


        //litrosPossiveis seria a quantidade maxima menos o que ja tem no tanque ex:80 - 60 = so pode  abastecer ate 20 litros
        double litrosPossiveis = maxCombustivel - combustivel;
        if (litros > litrosPossiveis) {
            System.out.println("O tanque está cheio. Não pode abastecer mais que " + litrosPossiveis + " isso");
            return;
        }
        // reabastece
        this.combustivel += litros;
        System.out.println("Reabastecido com " + litros + " litros.");
        System.out.println("Combustível atual: " + combustivel + "L");
    }

    //limpar tela dentro da classe carro pq nao vou criar outra nao
    public static void limparTela() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }


}
