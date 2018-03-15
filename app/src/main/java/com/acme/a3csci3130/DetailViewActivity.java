package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

public class DetailViewActivity extends Activity {

    private EditText nameField, emailField;
    Business receivedPersonInfo;
    private MyApplicationData appState;
    private EditText bsNumber, bsName, bsPrimary, bsAddress, bsProvince;
    private  TextView checkResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedPersonInfo = (Business)getIntent().getSerializableExtra("Business");

        //Get the app wide shared variables
        appState = ((MyApplicationData) getApplicationContext());

        bsNumber = (EditText) findViewById(R.id.dv_number);
        bsName = (EditText) findViewById(R.id.dv_name);
        bsPrimary = (EditText) findViewById(R.id.dv_primary);
        bsAddress = (EditText) findViewById(R.id.dv_address);
        bsProvince = (EditText) findViewById(R.id.dv_province);
        checkResult = (TextView) findViewById(R.id.check_result);


        if(receivedPersonInfo != null){

            bsNumber.setText(receivedPersonInfo.getBusinessNumber());
            bsName.setText(receivedPersonInfo.getBusinessName());
            bsPrimary.setText(receivedPersonInfo.getPrimaryBusiness());
            bsAddress.setText(receivedPersonInfo.getAddress());
            bsProvince.setText(receivedPersonInfo.getProvince());

        }
    }

    /**
     * update the contact, to firebase
     * @param v the button you clicked
     */
    public void updateContact(View v){
        //TODO: Update contact funcionality

        String bsID = receivedPersonInfo.getBusinessId();

        String number =bsNumber.getText() + "";
        String name = bsName.getText().toString();
        String primary_busin = bsPrimary.getText().toString();
        String address = bsAddress.getText().toString();
        String province = bsProvince.getText().toString();

        Business business = new Business(number, name, primary_busin, address, province, bsID);


        Task task =  appState.firebaseReference.child(bsID).setValue(business);



        task.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
               checkResult.setText("Update is not success. Check entered data");
                return;
            }
        });
        task.addOnSuccessListener(new OnSuccessListener() {
            @Override
            public void onSuccess(Object o) {
                checkResult.setText("Update is successful");

                finish();
            }
        });




    }
    /**
     * delete the contact, from firebase
     * @param v the button you clicked
     */
    public void eraseContact(View v)
    {
        //TODO: Erase contact functionality
        if(receivedPersonInfo !=null){

            Task task = appState.firebaseReference.child(receivedPersonInfo.getBusinessId()).removeValue();

            task.addOnSuccessListener(new OnSuccessListener() {
                @Override
                public void onSuccess(Object o) {
                    checkResult.setText("remove data successful");
                    finish();
                }
            });




        }

    }
}
