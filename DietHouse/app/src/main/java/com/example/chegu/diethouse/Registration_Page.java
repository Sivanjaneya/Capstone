package com.example.chegu.diethouse;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chegu.diethouse.network.RestClient;
import com.google.gson.JsonElement;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.RequestBody;

import java.io.IOException;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Registration_Page extends AppCompatActivity implements View.OnClickListener {
    EditText name, email, phone, word, word1;
    String etname,etmail,etpass,etmobile;
    Button sign_up;
//    DbHelper dbhelper = new DbHelper(this);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration__page);
        name = (EditText) findViewById(R.id.etname1);
        email = (EditText) findViewById(R.id.email);
        phone = (EditText) findViewById(R.id.Mobile);
        word = (EditText) findViewById(R.id.password);
        word1 = (EditText) findViewById(R.id.confirmetotp);
        sign_up = (Button)findViewById(R.id.register1);
        sign_up.setOnClickListener(this);


    }



    @Override
    public void onClick(View v) {

        etname = name.getText().toString();
        etmail = email.getText().toString();
        etpass = word.getText().toString();
//        etmobile = phone.getText().toString();
        HashMap<String,String> params = new HashMap<String, String>();
        params.put("userName",etname);
        params.put("email",etmail);
        params.put("password",etpass);
//        params.put("mobile",etmobile);

        String request = "username="+ etname+"&"+"email="+etmail+"&"+"password="+etpass;
        Log.e("request****",request);
        RequestBody requestBody = RequestBody.create(MediaType.parse("text/plain"),request);
        Call<JsonElement> loginservercaall = RestClient.getApiService().doRegister(params);
        loginservercaall.enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                if(response.isSuccessful()){
                    JsonElement data = response.body();
//                    Toast.makeText(Registration_Page.this, data.getAsJsonObject().get("message").getAsString(), Toast.LENGTH_SHORT).show();
                    Toast.makeText(Registration_Page.this,"Registration is success"+response.toString(),Toast.LENGTH_LONG).show();
                }else{
                    try {
                        Toast.makeText(Registration_Page.this, "error "+response.errorBody().string(), Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {

            }
        });
//        startActivity(new Intent(Registration_Page.this, MainActivity.class));

        finish();

    }



}
