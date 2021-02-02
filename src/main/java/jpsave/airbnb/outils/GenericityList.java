package jpsave.airbnb.outils;

import java.util.ArrayList;

public class GenericityList<T extends Comparable> extends ArrayList<T> {

    public T getHigher() {
        T higher = this.get(0);
        for (int i = 1; i < this.size(); i++) {
            Genericity<T> genericity = new Genericity<T>(higher, this.get(i));
            higher = genericity.getHigher();
        }
        return higher;
    }

    public T getLower() {
        T lower = this.get(0);
        for (int i = 1; i < this.size(); i++) {
            Genericity<T> genericity = new Genericity<T>(lower, this.get(i));
            lower = genericity.getLower();
        }
        return lower;
    }
}
