package Exe5;

public class Animal {
    private String nomeAnimal;
    
    public Animal(String nomeAnimal){
        this.nomeAnimal = nomeAnimal;
    }

    public String getNomeAnimal() {
        return nomeAnimal;
    }

    public void setNomeAnimal(String nomeAnimal) {
        this.nomeAnimal = nomeAnimal;
    }

    public String toString(){
        return "Nome do animal: " + nomeAnimal;
    }
}
