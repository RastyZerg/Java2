package CollectionsHW;

import java.util.HashMap;

public class PhoneBook {
    HashMap<String, String> map = new HashMap<>();

    PhoneBook() {
    }

    public void add(String number, String surName){
        map.put(number, surName);
    }

    public HashMap<String, String> get(String surName){
        HashMap<String, String> result = new HashMap<>();
        for (String s : map.keySet()) {
            if (map.get(s) == surName){
                result.put(s, surName);
            }
        }
        return result;
    }

}
