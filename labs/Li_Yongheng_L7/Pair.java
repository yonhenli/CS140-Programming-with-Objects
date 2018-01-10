package lab07;

public class Pair<K, V> {
    public final K first; // allow direct access since final
    public final V second; // allow direct access since final

    public Pair(K first, V second) {
        this.first = first;
        this.second = second;
    }

    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}