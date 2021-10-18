package hw10.family.Animals;

public class Fish extends Pet {

    {
        species = Species.FISH;
    }

    Fish() {
    }

    public Fish(String nickname) {
        super(nickname);
    }

    Fish(String nickname, int age, int trickLevel) {
        super(nickname, age, trickLevel);
    }

        public void respond() {
        System.out.println("Привет, я твоя рыба " + this.nickname + ". Рыбы только рот открывают, сорян братан!!!  Пообщайся с RoboCat");
    }

}
