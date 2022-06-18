package Subject02;

import java.util.Comparator;

public class Phone implements Comparator<String> {

    //이름 정렬
    @Override
    public int compare(String o1, String o2) {
        return o2.compareTo(o1);
    }

    @Override
    public Comparator<String> reversed() {
        return Comparator.super.reversed();
    }

    String name;
    String phoneNumber;

    public Phone() {
    }

    public Phone(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
}