/*
  *this is a course project
  * You can feel free to use this code, but remember plagrism.
  *
 */

package com.acme.a3csci3130;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends Activity {


    private ListView contactListView;
    private FirebaseListAdapter<Business> firebaseAdapter;

    /**
     * main method, create the layout
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get the app wide shared variables
        MyApplicationData appData = (MyApplicationData)getApplication();

        //Set-up Firebase
        appData.firebaseDBInstance = FirebaseDatabase.getInstance();
        appData.firebaseReference = appData.firebaseDBInstance.getReference("contacts");

        //Get the reference to the UI contents
        contactListView = (ListView) findViewById(R.id.listView);

        //Set up the List View
       firebaseAdapter = new FirebaseListAdapter<Business>(this, Business.class,
                R.layout.view_list_show, appData.firebaseReference) {
            @Override
            protected void populateView(View v, Business model, int position) {
                TextView contactName = (TextView)v.findViewById(R.id.bus_name);
                TextView primaryBusi = (TextView)v.findViewById(R.id.primary_bus);

                contactName.setText(model.businessName);
                primaryBusi.setText("Primary business: " + model.getPrimaryBusiness());
            }
        };


        contactListView.setAdapter(firebaseAdapter);
        contactListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            // onItemClick method is called everytime a user clicks an item on the list
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Business business = (Business) firebaseAdapter.getItem(position);
                showDetailView(business);
            }
        });
    }

    /**
     * start a new activity, for user to input data
     * @param v the button view
     */
    public void createContactButton(View v)
    {
        Intent intent=new Intent(this, CreateBusinessAcitivity.class);
        startActivity(intent);
    }

    /**
     * show detail of a business
     * @param person the business which you clicked
     */
    private void showDetailView(Business person)
    {
        Intent intent = new Intent(this, DetailViewActivity.class);
        intent.putExtra("Business", person);
        startActivity(intent);
    }



}
