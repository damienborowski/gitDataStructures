package dsaii.map;

public interface Entry<K extends Comparable, V> extends Comparable<Entry<K, V>> {
    K getKey();
    V getValue();
}
