package hw10.family.DAO;

import hw10.family.People.Family;

import java.util.LinkedList;
import java.util.List;

public class CollectionFamilyDao<T> implements FamilyDAO<T> {

    private final List<T> memoryStore;

    {
        memoryStore = new LinkedList<T>();
    }

    public List<T> getAllFamilies() {
        return memoryStore;
    }

    public T getFamilyByIndex(int i) {
        try {
            return memoryStore.get(i);
        } catch (NullPointerException e) {
            return null;
        }
    }

    public boolean deleteFamily(int i) {
        System.out.println("deleting family: " + memoryStore.get(i));
        try {
            memoryStore.remove(i);
            System.out.println("delete operation successful, updated family list: ");
            System.out.println(memoryStore);
            return true;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public boolean deleteFamily(T o) { //TODO дописать
        Family testFam = null;
        try {
            memoryStore.remove(o);
            return true;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public boolean saveFamily(T o) {
        if (memoryStore.contains(o)) {
            memoryStore.set(memoryStore.indexOf(o), o);
        } else {
            memoryStore.add(o);
        }
//        System.out.println("an object's been stored to: memoryStore");
        return true;
    }

    public boolean deleteChild(int famIndex, int childIndex) {
        Family current = (Family)memoryStore.get(famIndex);
        current.getChildren().remove(childIndex);
        saveFamily( (T)current );
        return true;
    }

    ;
}



