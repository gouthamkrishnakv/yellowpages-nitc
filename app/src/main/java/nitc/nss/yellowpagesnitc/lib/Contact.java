package nitc.nss.yellowpagesnitc.lib;

import java.util.ArrayList;
import java.util.List;

public class Contact {
    public String name;
    public List<String> numbers;
    public String notes;

    public Contact(String name) {
        this.name = name;
        this.numbers = new ArrayList<>();
        this.notes = "";
    }
}
