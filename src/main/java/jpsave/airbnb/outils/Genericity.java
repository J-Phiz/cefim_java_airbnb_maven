package jpsave.airbnb.outils;

public class Genericity <T extends Comparable> {
    private T obj1;
    private T obj2;

    public Genericity(T obj1, T obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    public T getHigher() {
        if (obj1.compareTo(obj2) > 0) {
            return obj1;
        } else {
            return obj2;
        }
    }

    public T getLower() {
        if (obj1.compareTo(obj2) > 0) {
            return obj2;
        } else {
            return obj1;
        }
    }
}
