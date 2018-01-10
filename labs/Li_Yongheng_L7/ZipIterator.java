package lab07;

import java.util.Iterator;

public class ZipIterator<K, V> implements Iterator<Pair<K, V>>{
	private K[] karr;
	private V[] varr;
	private int pos = 0;
	
	public ZipIterator(K[] karr, V[] varr) {
		this.karr = karr;
		this.varr = varr;
	}
	
	public boolean hasNext() {
		if (pos < karr.length && pos < varr.length) {
			return true;
		}
		return false;
	}

	public Pair<K, V> next() {
		Pair<K, V> pair = new Pair<>(karr[pos], varr[pos]);
		pos ++;
		return pair;
	}
	
    public Iterable<Pair<K, V>> toIterable() {
        return () -> this;
    }

}
