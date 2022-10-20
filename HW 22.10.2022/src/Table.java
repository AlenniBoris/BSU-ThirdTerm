import java.util.ArrayList;

public class Table<K, V> {
    private ArrayList<Entry<K,V>> arrayList;

    Table(){
        arrayList = new ArrayList<>();
    }

    public void push(Entry<K,V> value){
        arrayList.add(value);
    }

    public V getValue(K key){
        for(Entry<K, V> e : arrayList){
            if (e.getKey().equals(key)){
                return e.getValue();
            }
        }
        return null;
    }

    public void setValue(K key, V val){
        for (Entry<K,V> e : arrayList){
            if (e.getKey().equals(key)){
                e.setValue(val);
            }
        }
    }

    public ArrayList<Entry<K,V>> deleteKey(K key){
        arrayList.removeIf(e -> e.getKey().equals(key));
        return arrayList;
    }
}

class Entry<K, V>{
    private K key;
    private V value;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }
}