package hw10.family.Animals;

public class DomesticCat extends Pet {

    {
        species = Species.DOMESTICCAT;
    }

    DomesticCat() {
    }

    public DomesticCat(String nickname) {
        super(nickname);
    }

    DomesticCat(String nickname, int age, int trickLevel) {
        super(nickname, age, trickLevel);
    }


    public void foul() {
        System.out.println("Я нагадил, я же кот, ужно хорошо замести следы...");
    }

        public void respond() {
        System.out.println("Привет, хозяин. Я - кот сырун " + this.nickname + " Мышей тоже не ловлю, как и Робокот, но сру регулярно");
    }

}
