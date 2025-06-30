public class PetMachine {

    private boolean clean = true;

    private int water = 30;

    private int shampoo =10;

    private Pet pet;


    public void takeAShouwer(){

        if(this.pet == null){
            System.out.println("Coloque o pet na máquina para iniciar o banho");
            return;
        }

        this.water =- 10;
        this.shampoo -=2;

        pet.setClean(true);
        System.out.println("O pet " + pet.getName() + " está limpo");

    }

    public void addWater(){

        if (water == 30){
            System.out.println("A capacidade de água na máquina esta no maximo!");
            return;
        }

        water += 2;
    }

    public void addShampoo(){

        if (shampoo == 10){
            System.out.println("A capacidade de shampoo na máquina esta no maximo!\n");
            return;
        }

        shampoo += 2;
    }

    public int getWater() {
        return water;
    }

    public int getShampoo() {
        return shampoo;
    }

    public boolean hasPet(){
        return pet != null;
    }

    public void setPet(Pet pet) {
        if (!this.clean){
            System.out.println("A máquina esta suja, para colocar o pet é necessario limpar\n");
            return;
        }
        if(hasPet()){
            System.out.println("O pet " + this.pet.getName() + " está na maquina neste momento\n");
            return;
        }
        this.pet = pet;
        System.out.println("O pet " + pet.getName() + " foi colocado na maquina\n");
    }

    public void removePet(){

        this.clean = this.pet.isClean();
        System.out.println("O pet " + this.pet.getName()+ " foi retirado da máquina\n");
        this.pet = null;
    }

    public void wash (){
        this.water -= 10;
        this.shampoo -= 2;
        this.clean = true;
        System.out.println("Amáquina esta foi limpa!\n");
    }


}
