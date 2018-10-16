package nitc.nss.yellowpagesnitc;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import nitc.nss.yellowpagesnitc.lib.Contact;
import nitc.nss.yellowpagesnitc.lib.ContactCategory;

public class ContactCategoriesPagerAdapter extends FragmentPagerAdapter {

    List<ContactCategory> contactCategories;
    List<Fragment> contactCategoryFragments;

    public ContactCategoriesPagerAdapter(FragmentManager fm, List<ContactCategory> contactCategories) {
        super(fm);
        this.contactCategories = contactCategories;
        this.contactCategoryFragments = new ArrayList<>();
        for(int i =0; i<contactCategories.size(); i++) {
            contactCategoryFragments.add(null);
        }
    }

    @Override
    public Fragment getItem(int position) {
        if(contactCategoryFragments.get(position) == null) {
            List<Contact> contacts = contactCategories.get(position).contacts;
            Fragment f = ContactsList.newInstance(contacts);
            contactCategoryFragments.set(position, f);
        }

        return contactCategoryFragments.get(position);
    }

    @Override
    public int getCount() {
        return contactCategories.size();
    }
}
