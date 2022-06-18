package d0615;

import java.util.*;

public class CollectionStudy {

    public void studyMap(){

        Map<String, Integer> map = new HashMap<String, Integer>();

        map.put("대한민국독립", 1945);
        map.put("임진왜란", 1592);
        map.put("조선건국", 1392);
        map.put("프랑스대혁명", 1789);
        map.put("서로마멸망", 476);

        map.put("대한민국독립",2025);

        Set<String> keys = map.keySet(); //List랑 비슷


        Integer year = 0;
        year = map.get("임진왜란");
        System.out.println(year);

        year = map.get("신대륙발견");
        System.out.println(year);

        year = map.get("대한민국독립");
        System.out.println(year);

    }

    public void studyQueue(){
        Queue<String> queue = new LinkedList<String>();
        List<String> list = new LinkedList<String>();

        queue.add("Korea");
        queue.add("Japan");
        queue.add("China");
        queue.add("USA");

        queue.poll();
        queue.poll();
        queue.poll();
        queue.poll();

        queue.add("Korea");
        queue.add("Japan");
        queue.add("China");
        queue.add("USA");

        list.get(0);
        list.get(1);
        list.get(2);
        list.get(3);

    }

    public void studySet(){
        Set<String> set = new HashSet<String>();
        set.add("Korea");
        set.add("Japan");
        set.add("China");
        set.add("USA");
        set.add("Korea");
        set.add("USA");

        for(String item : set){
            System.out.println(item);
        }

    }

    public static void main(String[] args) {
//        new CollectionStudy().studyMap();
        new CollectionStudy().studySet();

    }

}
