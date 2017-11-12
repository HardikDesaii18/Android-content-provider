package com.example.amit.myallcontentprovider;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PhoneContacts extends AppCompatActivity {
    RecyclerView rvContactsView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_contacts);
        rvContactsView= (RecyclerView) findViewById(R.id.rvContactsView);
        //add method
       /* PhoneContactsAdapter phoneContactsAdapter=new PhoneContactsAdapter(getAllContacts(), this);
        rvContactsView.setLayoutManager(new LinearLayoutManager(this));
        rvContactsView.setAdapter(phoneContactsAdapter);

*/
        getAllContacts();

    }
    private List<PhoneContactsView> getAllContacts()
    {
         List<PhoneContactsView> PhoneContactsList= new ArrayList<>();
        PhoneContactsView phoneContactsView;

        ContentResolver contentResolver = getContentResolver();
        String columns[] = {ContactsContract.Contacts._ID, ContactsContract.Contacts.DISPLAY_NAME, ContactsContract.Contacts.HAS_PHONE_NUMBER,ContactsContract.CommonDataKinds.Email.DATA};
        String query = ContactsContract.Contacts.DISPLAY_NAME + " LIKE 'F%' " ;
        Cursor cursor = contentResolver.query(ContactsContract.Contacts.CONTENT_URI, columns, query, null, null);

        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {

                int hasPhoneNumber = Integer.parseInt(cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER)));
                if (hasPhoneNumber > 0) {
                    String id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                    String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));

                    phoneContactsView = new PhoneContactsView();
                    phoneContactsView.setContactName(name);

                    Cursor phoneCursor = contentResolver.query(
                            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                            null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
                            new String[]{id},
                            null);
                    if (phoneCursor.moveToNext()) {
                        String phoneNumber = phoneCursor.getString(phoneCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        phoneContactsView.setContactPhoneNumber(phoneNumber);
                    }

                    phoneCursor.close();

                    Cursor emailCursor = contentResolver.query(
                            ContactsContract.CommonDataKinds.Email.CONTENT_URI,
                            null,
                            ContactsContract.CommonDataKinds.Email.CONTACT_ID + " = ?",
                            new String[]{id}, null);
                    while (emailCursor.moveToNext()) {
                        String emailId = emailCursor.getString(emailCursor.getColumnIndex(ContactsContract.CommonDataKinds.Email.DATA));
                        phoneContactsView.setContactPhoneNumber(emailId);
                    }
                    PhoneContactsList.add(phoneContactsView);
                }
            }
            cursor.close();

            PhoneContactsAdapter phoneContactsAdapter=new PhoneContactsAdapter(PhoneContactsList,getApplicationContext());
            rvContactsView.setLayoutManager(new LinearLayoutManager(this));
            rvContactsView.setAdapter(phoneContactsAdapter);

        }
    return PhoneContactsList;
    }
}
