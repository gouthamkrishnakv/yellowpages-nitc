package nitc.nss.yellowpagesnitc;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import nitc.nss.yellowpagesnitc.lib.ContactCategory;
import nitc.nss.yellowpagesnitc.lib.ContactsListParser;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;

    List<ContactCategory> contactCategories = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewPager);
        loadContacts(savedInstanceState);
        renderContacts();
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        ActionBar.TabListener tabListener = new ActionBar.TabListener() {

            @Override
            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
                tab.select();
            }

            @Override
            public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

            }
        };

        for(ContactCategory category: contactCategories) {
            actionBar.addTab(
                    actionBar.newTab()
                            .setText(category.name)
                            .setTabListener(tabListener)
            );
        }

        viewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                getSupportActionBar().setSelectedNavigationItem(position);
            }
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        saveContactsToInstanceState(outState);
        super.onSaveInstanceState(outState);
    }

    private void loadContacts(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            contactCategories = (List<ContactCategory>) savedInstanceState.get("contactCategories");
        }
        if(contactCategories == null) {
            try {
                contactCategories = ContactsListParser.parse(getResources().openRawResource(R.raw.contacts));
            } catch (IOException | ContactsListParser.ParsingException e) {
                e.printStackTrace();
            }
        }
    }

    private void renderContacts() {
        viewPager.setAdapter(new ContactCategoriesPagerAdapter(getSupportFragmentManager(), contactCategories));
    }

    private void saveContactsToInstanceState(Bundle outState) {
        outState.putSerializable("contactCategories", (Serializable) contactCategories);
    }




}
