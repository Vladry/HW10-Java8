package hw10.family.Animals;

public class Dog extends Pet {

    {
        species = Species.DOG;
    }

    Dog() {
    }

    public Dog(String nickname) {
        super(nickname);
    }

    Dog(String nickname, int age, int trickLevel) {
        super(nickname, age, trickLevel);
    }

    public void respond(){
        System.out.println("Привет, я твоя собака " + this.nickname);
    }

    public void foul() {
        System.out.println("ты меня не выгулял, делаем вид, что это не я нагадила");
    }

}
