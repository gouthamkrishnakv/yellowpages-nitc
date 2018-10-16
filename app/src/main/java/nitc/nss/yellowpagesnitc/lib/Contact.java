package nitc.nss.yellowpagesnitc.lib;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Contact implements Serializable {
    public String name;
    public List<String> numbers;
    public String notes;

    public Contact(String name) {
        this.name = name;
        this.numbers = new ArrayList<>();
        this.notes = "";
    }
}
