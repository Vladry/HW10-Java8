package hw10.family.People;

import hw10.family.Animals.Pet;

import java.util.ArrayList;
//import java.util.LinkedList;
import java.util.List;

import static hw10.family.People.BabyFactory.deliverABaby;

public class Family implements HumanCreator {

    private Human mother;
    private Human father;
    private final List<Human> children;
    private Pet pet;



    private final List<Pet> pets;

    static {
//        System.out.println("загружается новый класс Family");
    }

    {
//        this.children = new LinkedList<>();
        this.children = new ArrayList<>();
//        System.out.println("создается новый объект Family");
        this.pets = new ArrayList<>();
    }

    public Family(Human father, Human mother) {
        this.father = father;
        this.mother = mother;
    }

    public Human bornChild() {
        return deliverABaby(this);
    }

    public void addChild(Human child) {
        children.add(child);
    }

    public boolean deleteChild(int index) {
        if (index < 0 || index >= children.size() || children.get(index) == null) {
            return false;
        }
        children.remove(index);
        return true;

    }

    public int countFamily(int numOfChildren) {
        return numOfChildren + 2;
    }

    public Human getMother() {
        return this.mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return this.father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public List<Human> getChildren() {
        return this.children;
    }

    public void setChildren(Human child) {
        child.setFamily(this);
        addChild(child);
    }

    public Pet getPet() {
        return this.pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(Pet pet) {
        pets.add(pet);
    }

    @Override
    public String toString() {
        return "\n\nFamily{\n mother= " + mother +
                "father= " + father +
                "children=\n" + children.toString() +
//                "pet= " + pet +
                "\nPets=" + pets +
                "}";
    }

    @Override
    protected void finalize() {
        System.out.println("Deleting an instance of Family");
    }
}

