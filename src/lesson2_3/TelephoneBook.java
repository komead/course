package lesson2_3;

import java.util.HashMap;
import java.util.Map;

public class TelephoneBook {
    private HashMap<String,String> telephoneBook;

    public TelephoneBook() {
        telephoneBook = new HashMap<>();
    }

    public void add(String phone, String owner){
        telephoneBook.put(phone, owner);
    }

    public void get(String owner){
        for (Map.Entry<String, String> entry : telephoneBook.entrySet()) {

            if (owner.equals(entry.getValue())) {
                System.out.println(entry.getKey());
            }
        }
    }
}
