package d0615;

public class Generic<T, ZZZ> {

    private T value;

    private ZZZ id;

    public T getValue(){
        return value;
    }

    public ZZZ getId() {
        return id;
    }

    public void setId(ZZZ id) {
        this.id = id;
    }

    public void setValue(T value){
        this.value = value;
    }

    public static void main(String[] args) {
        Generic<String, Integer> generic = new Generic<String, Integer>(); //T 대신 String 대체된다.
        generic.setValue("Korea");

//        Generic<Integer> generic1 = new Generic<Integer>(); //T 대신 String 대체된다.
//        generic1.setValue(123);


    }

}
