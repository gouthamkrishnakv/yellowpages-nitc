package nitc.nss.yellowpagesnitc.lib;

import java.util.ArrayList;
import java.util.List;

public class ContactCategory {
    public String name;
    public List<Contact> contacts;

    public ContactCategory(String name) {
        this.name = name;
        this.contacts = new ArrayList<>();
    }
}
