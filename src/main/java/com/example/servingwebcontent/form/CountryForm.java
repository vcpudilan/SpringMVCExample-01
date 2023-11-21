package com.example.servingwebcontent.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CountryForm {
    
//    @NotBlank(message = "ID should not be blank")
    private String mstcountrycd;
//    @NotBlank(message = "Name should not be blank")
    private String mstcountrynanme;
//    private String postCode;
//    @Email(message = "Email should be valid")
//    @NotBlank(message = "Email should not be blank")
//    private String email;
//    private String phoneNumber;
    
    public CountryForm() {
    }
    
    public CountryForm(String mstcountrycd,String mstcountrynanme) {
        this.mstcountrycd = mstcountrycd;
        this.mstcountrynanme = mstcountrynanme;
//        this.postCode = postcode;
//        this.email = email;
//        this.phoneNumber = phone;
    }
}
