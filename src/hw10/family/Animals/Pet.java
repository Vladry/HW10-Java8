package hw10.family.Animals;

import java.util.List;

public abstract class Pet {

    protected Species species;
    protected String nickname;
    protected int age;
    protected int trickLevel; //from 0 to 100
    protected List<String> habits;

    static {
//        System.out.println("загружается новый класс Pet");
    }

    {
//        System.out.println("создается новый объект Pet");
    }


    Pet() {
    }

    Pet(String nickname) {
        this.nickname = nickname;
    }

    Pet(String nickname, int age, int trickLevel) {
        this.age = age;
        this.trickLevel = trickLevel;
    }

    public void eat() {
        System.out.println("Я кушаю!");
    }

    public abstract void respond();

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }


    public void setAge(int age) {
        this.age = age;
    }

    public int getTrickLevel() {
        return trickLevel;
    }

    public void setTrickLevel(int trickLevel) {
        this.trickLevel = trickLevel;
    }

    public List<String> getHabits() {
        return habits;
    }


    public void setHabits(List<String> habits) {
        this.habits = habits;
    }


    @Override
    public String toString() {
        return species + " {nickname=" + nickname +
                "}\n";
    }

    @Override
    protected void finalize() {
        System.out.println("Deleting an instance of Pet");
    }
}


