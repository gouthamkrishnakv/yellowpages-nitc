package nitc.nss.yellowpagesnitc.lib;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ContactsListParser {

    public static List<ContactCategory> parse(InputStream inputStream) throws IOException, ParsingException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        List<ContactCategory> categories = new ArrayList<>();
        ContactCategory cur_category = null;
        Contact cur_contact = null;
        String line = null;
        while( (line = reader.readLine()) != null) {
            line = line.trim();
            if(line.isEmpty()) continue;

            if(line.startsWith("#")) {
                cur_category = new ContactCategory(line.substring(1));
                categories.add(cur_category);
                continue;
            }

            if(cur_category == null) {
                throw new ParsingException("No category specified before specifying contacts");
            }

            if(line.endsWith(":")) {
                cur_contact = new Contact(line.substring(0, line.length()-1));
                cur_category.contacts.add(cur_contact);
            }

            if(cur_contact == null) {
                throw new ParsingException("No contact name specified before specifying contact details");
            }

            if(line.matches("[0-9,+ ]+")) {
                cur_contact.numbers.add(line);
            } else {
                cur_contact.notes = cur_contact.notes.concat(line);
            }

        }
        return categories;
    }

    public static class ParsingException extends Exception {

        public ParsingException(String message) {
            super(message);
        }
    }

}
