package nitc.nss.yellowpagesnitc;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.Serializable;
import java.util.List;

import nitc.nss.yellowpagesnitc.lib.Contact;


public class ContactsList extends Fragment {
    private List<Contact> contacts;

    private RecyclerView recyclerView;

    public ContactsList() {
        // Required empty public constructor
    }

    public static ContactsList newInstance(List<Contact> contacts) {
        ContactsList fragment = new ContactsList();
        Bundle args = new Bundle();
        args.putSerializable("contacts", (Serializable) contacts);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            contacts = (List<Contact>) getArguments().get("contacts");
            Log.d("NITC_YP_ContactsList", new Integer(contacts.size()).toString());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contacts_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = getView().findViewById(R.id.recyclerView);
        recyclerView.setAdapter(new ContactsListAdapter(contacts));
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
    }

    private class ContactsListAdapter extends RecyclerView.Adapter<ContactViewHolder> {

        private List<Contact> contacts;

        private ContactsListAdapter(List<Contact> contacts) {
            this.contacts = contacts;
        }

        @NonNull
        @Override
        public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                            .inflate(R.layout.recycler_view_item, parent, false);
            return new ContactViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
            Contact c = contacts.get(position);
            holder.loadContact(c);
        }

        @Override
        public int getItemCount() {
            return contacts.size();
        }
    }

    private class ContactViewHolder extends RecyclerView.ViewHolder {

        private TextView vName;
        private TextView vPhones;
        private TextView vNotes;


        public ContactViewHolder(View itemView) {
            super(itemView);
            vName = itemView.findViewById(R.id.name);
            vPhones = itemView.findViewById(R.id.phones);
            vNotes = itemView.findViewById(R.id.notes);
        }

        public void loadContact(Contact contact) {
            vName.setText(contact.name);
            StringBuilder phones = new StringBuilder();
            for(String number: contact.numbers) {
                phones.append(number);
                phones.append("\n");
            }
            vPhones.setText(phones);
            vNotes.setText(contact.notes);
            Log.d("NITC_YP_ContactViewHolder", contact.toString());
        }
    }

}
