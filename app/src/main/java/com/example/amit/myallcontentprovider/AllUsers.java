package com.example.amit.myallcontentprovider;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AllUsers extends AppCompatActivity {


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_all_users);

            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvAllUsers);
            //in

            AllUsersAdapter allUsersAdapter = new AllUsersAdapter(getUserInformation(), this);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(allUsersAdapter);
        }

        private List<User> getUserInformation() {

            List<User> userList = new ArrayList<>();
            userList.add(new User(R.mipmap.ic_launcher,
                    "Amit", "9988776655",
                    "amit@sonevalley.com"));
            userList.add(new User(R.mipmap.ic_launcher,
                    "John", "9988776655",
                    "john@sonevalley.com"));
            userList.add(new User(R.mipmap.ic_launcher,
                    "rakesh", "9988776655",
                    "rakesh@sonevalley.com"));
            userList.add(new User(R.mipmap.ic_launcher,
                    "akash", "9988776655",
                    "akash@sonevalley.com"));
            userList.add(new User(R.mipmap.ic_launcher,
                    "Tanu", "9988776655",
                    "tanu@sonevalley.com"));
            userList.add(new User(R.mipmap.ic_launcher,
                    "Manu", "9988776655",
                    "manu@sonevalley.com"));
            userList.add(new User(R.mipmap.ic_launcher,
                    "Prakash", "9988776655",
                    "prak@sonevalley.com"));
            userList.add(new User(R.mipmap.ic_launcher,
                    "Jyoti", "9988776655",
                    "jyoti@sonevalley.com"));
            userList.add(new User(R.mipmap.ic_launcher,
                    "Puja", "9988776655",
                    "puja@sonevalley.com"));
            userList.add(new User(R.mipmap.ic_launcher,
                    "Aarti", "9988776655",
                    "aarti@sonevalley.com"));

            return userList;
        }

        public class User {
            private int imageResourceId;
            private String profileName;
            private String phoneNumber;
            private String emailId;

            public int getImageResourceId() {
                return imageResourceId;
            }

            public String getProfileName() {
                return profileName;
            }

            public String getPhoneNumber() {
                return phoneNumber;
            }

            public String getEmailId() {
                return emailId;
            }

            public User(int imageResourceId, String profileName, String phoneNumber, String emailId) {
                this.imageResourceId = imageResourceId;
                this.profileName = profileName;
                this.phoneNumber = phoneNumber;
                this.emailId = emailId;
            }
        }
    }

