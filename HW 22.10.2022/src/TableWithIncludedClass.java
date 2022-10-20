import java.util.ArrayList;

public class TableWithIncludedClass<T, P> {

    private static class EntryS<T, P>{
        private T key;
        private P value;

        public EntryS(T key, P value) {
            this.key = key;
            this.value = value;
        }

        public T getKey() {
            return key;
        }

        public P getValue() {
            return value;
        }

        public void setKey(T key) {
            this.key = key;
        }

        public void setValue(P value) {
            this.value = value;
        }
    }

    private ArrayList<Entry<T,P>> arrayList;

    TableWithIncludedClass(){
        arrayList = new ArrayList<>();
    }

    public void push(EntryS<T,P> value){
        arrayList.add(value);
    }

    public P getValue(T key){
        for(EntryS<T, P> e : arrayList){
            if (e.getKey().equals(key)){
                return e.getValue();
            }
        }
        return null;
    }

    public void setValue(T key, P val){
        for (EntryS<T,P> e : arrayList){
            if (e.getKey().equals(key)){
                e.setValue(val);
            }
        }
    }

    public ArrayList<EntryS<T,P>> deleteKey(T key){
        arrayList.removeIf(e -> e.getKey().equals(key));
        return arrayList;
    }

}
