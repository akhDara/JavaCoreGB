package HomeworkForth;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class PhoneNumbers {
    private HashMap<String, HashSet<String>> phoneNumbers = new HashMap<>();

    public void addElementPhoneBook(String name, String phone) {
        HashSet<String> phones;
        if (phoneNumbers.containsKey(name)) {
            phones = phoneNumbers.get(name);
        }
        else {
            phones = new HashSet<>();
        }
        phones.add(phone.replaceAll(" ",""));
        phoneNumbers.put(name,phones);
    }

    public Set<String> getPhonesByName (String name){
        return phoneNumbers.get(name);
    }
}
