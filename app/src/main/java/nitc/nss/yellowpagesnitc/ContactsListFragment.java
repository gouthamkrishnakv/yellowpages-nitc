package nitc.nss.yellowpagesnitc;

import android.content.Intent;
import android.net.Uri;
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
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.Serializable;
import java.util.List;

import nitc.nss.yellowpagesnitc.lib.Contact;


public class ContactsListFragment extends Fragment {
    private List<Contact> contacts;

    private RecyclerView recyclerView;

    public ContactsListFragment() {
        // Required empty public constructor
    }

    public static ContactsListFragment newInstance(List<Contact> contacts) {
        ContactsListFragment fragment = new ContactsListFragment();
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
        private LinearLayout vPhonesList;
        private TextView vNotes;


        public ContactViewHolder(View itemView) {
            super(itemView);
            vName = itemView.findViewById(R.id.name);
            vPhonesList = itemView.findViewById(R.id.phonesList);
            vNotes = itemView.findViewById(R.id.notes);
        }

        public void loadContact(Contact contact) {
            vName.setText(contact.name);
            vPhonesList.removeAllViews();
            for(final String number: contact.numbers) {
                View phonesListEntry = LayoutInflater.from(getContext())
                        .inflate(R.layout.phones_list_item, null);
                TextView phone = phonesListEntry.findViewById(R.id.phone);
                phone.setText(number);
                Button dialBtn = phonesListEntry.findViewById(R.id.dialBtn);
                dialBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent callIntent = new Intent(Intent.ACTION_DIAL);
                        callIntent.setData(Uri.parse("tel:"+number));
                        startActivity(callIntent);
                    }
                });
                vPhonesList.addView(phonesListEntry);
            }
            vNotes.setText(contact.notes);
        }
    }

}
