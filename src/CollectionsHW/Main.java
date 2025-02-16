//        1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
//        Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
//        Посчитать сколько раз встречается каждое слово.
//        2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
//        В этот телефонный справочник с помощью метода add() можно добавлять записи.
//        С помощью метода get() искать номер телефона по фамилии. С
//        ледует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
//        тогда при запросе такой фамилии должны выводиться все телефоны.
//        Желательно как можно меньше добавлять своего,
//        чего нет в задании (т.е. не надо в телефонную запись добавлять еще дополнительные поля (имя, отчество, адрес),
//        делать взаимодействие с пользователем через консоль и т.д.).
//        Консоль желательно не использовать (в том числе Scanner), тестировать просто из метода main() прописывая add() и get().

package CollectionsHW;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;


public class Main {

    public static HashSet<String> makeUniqueList(ArrayList list){
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < list.size(); i++){
            set.add(list.get(i).toString());
        }
        return set;
    }

    public static HashMap countListValues(ArrayList list){
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < list.size(); i++){
            if (map.containsKey(list.get(i).toString())){
                map.put(list.get(i).toString(), map.get(list.get(i).toString()) + 1);
            }
            else {
                map.put(list.get(i).toString(), 1);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        ArrayList<String> list = new ArrayList<>();
        HashSet<String> set1 = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, String> map2 = new HashMap<>();
        list.add("Beer");
        list.add("Tea");
        list.add("Beer");
        list.add("Coffee");
        list.add("Vine");
        list.add("Vodka");
        list.add("Juice");
        list.add("Juice");
        list.add("Beer");
        list.add("Tea");
        list.add("Tea");
        list.add("Tea");
        list.add("Beer");
        list.add("Coffee");
        list.add("Coffee");
        list.add("Vodka");
        set1 = makeUniqueList(list);
        System.out.println(set1);
        map = countListValues(list);
        for (String s : map.keySet()) {
            System.out.println(s + "=" + map.get(s));
        }

        phoneBook.add("90978", "Petrov");
        phoneBook.add("90979", "Petrov");
        phoneBook.add("90977", "Ivanov");
        phoneBook.add("90950", "Ivanov");
        phoneBook.add("90948", "Ivanov");
        phoneBook.add("90998", "Sokolov");
        map2 = phoneBook.get("Ivanov");
        for (String s : map2.keySet()) {
            System.out.println(map2.get(s) + " - " + s);
        }
        map2 = phoneBook.get("Petrov");
        for (String s : map2.keySet()) {
            System.out.println(map2.get(s) + " - " + s);
        }
        map2 = phoneBook.get("Sokolov");
        for (String s : map2.keySet()) {
            System.out.println(map2.get(s) + " - " + s);
        }
    }
}
