package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

public class CreateBusinessAcitivity extends Activity {

    private Button submitButton;
    private EditText bsNumber, bsName, bsPrimary, bsAddress, bsProvince;
    private MyApplicationData appState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact_acitivity);
        //Get the app wide shared variables
        appState = ((MyApplicationData) getApplicationContext());

        submitButton = (Button) findViewById(R.id.submitButton);
        bsNumber = (EditText) findViewById(R.id.bs_number);
        bsName = (EditText) findViewById(R.id.bs_name);
        bsPrimary = (EditText) findViewById(R.id.bs_primary);
        bsAddress = (EditText) findViewById(R.id.bs_address);
        bsProvince = (EditText) findViewById(R.id.bs_province);


    }

    /**
     * submit data to firebase
     * @param v the buttion clicked
     */
    public void submitInfoButton(View v) {
        //each entry needs a unique ID
        String bsID = appState.firebaseReference.push().getKey();

        String number =bsNumber.getText() + "";
        String name = bsName.getText().toString();
        String primary_busin = bsPrimary.getText().toString();
        String address = bsAddress.getText().toString();
        String province = bsProvince.getText().toString();

        Business business = new Business(number, name, primary_busin, address, province, bsID);

       Task task =  appState.firebaseReference.child(bsID).setValue(business);

        task.addOnSuccessListener(new OnSuccessListener() {
            @Override
            public void onSuccess(Object o) {
                Toast.makeText(getApplicationContext(), "Create success", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        task.addOnFailureListener(new OnFailureListener() {
           @Override
           public void onFailure(@NonNull Exception e) {
               Toast.makeText(getApplicationContext(), "Failed. Entered data not correct", Toast.LENGTH_SHORT).show();
               return;
           }
       });

    }
}
