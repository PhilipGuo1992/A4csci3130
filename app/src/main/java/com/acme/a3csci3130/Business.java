package com.acme.a3csci3130;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Class that defines how the data will be stored in the
 * Firebase databse. This is converted to a JSON format
 */

public class Business implements Serializable {

    public String businessNumber;
    public String businessName;
    public String primaryBusiness;
    public String address;
    public String province;
    public  String businessId;


    public Business() {
        // Default constructor required for calls to DataSnapshot.getValue
    }

    public Business(String businessNumber, String businessName, String primaryBusiness, String address, String province, String businessId) {
        this.businessNumber = businessNumber;
        this.businessName = businessName;
        this.primaryBusiness = primaryBusiness;
        this.address = address;
        this.province = province;
        this.businessId = businessId;
    }

    public String getBusinessNumber() {
        return businessNumber;
    }

    public void setBusinessNumber(String businessNumber) {
        this.businessNumber = businessNumber;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getPrimaryBusiness() {
        return primaryBusiness;
    }

    public void setPrimaryBusiness(String primaryBusiness) {
        this.primaryBusiness = primaryBusiness;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
//        result.put("uid", uid);
//        result.put("name", name);
//        result.put("email", email);

        return result;
    }
}
