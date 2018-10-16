package nitc.nss.yellowpagesnitc.lib;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ContactCategory implements Serializable {
    public String name;
    public List<Contact> contacts;

    public ContactCategory(String name) {
        this.name = name;
        this.contacts = new ArrayList<>();
    }
}
