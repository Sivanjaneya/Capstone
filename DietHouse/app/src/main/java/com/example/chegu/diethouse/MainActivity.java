package com.example.chegu.diethouse;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chegu.diethouse.network.DataBMI;
import com.example.chegu.diethouse.network.RestClient;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.gson.JsonElement;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.RequestBody;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button login_button;
    TextView register_link;
    EditText et1, et2;
//    DbHelper dbhelper = new DbHelper(this);
    LoginButton loginButton;
    CallbackManager callbackManager;
    String login_name,login_pass;
    private DataBMI mDataBMI;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main);
        loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions(Arrays.asList("public_profile, email, user_birthday, user_friends"));
        callbackManager = CallbackManager.Factory.create();

        mDataBMI = DataBMI.getInstance();


        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                startActivity(new Intent(MainActivity.this, Navigation_drawer_side_menu.class));


            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });
        et1 = (EditText) findViewById(R.id.etname);
        et2 = (EditText) findViewById(R.id.etotp);
        register_link = (TextView) findViewById(R.id.Register_link);
        login_button = (Button) findViewById(R.id.Login_button1);
        login_button.setOnClickListener(this);
        register_link.setOnClickListener(this);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Login_button1:

                login_name = et1.getText().toString();
                login_pass = et2.getText().toString();
//                String method = "login";
//                BackgroundTask backgroundTask = new BackgroundTask(this);
//                backgroundTask.execute(method,login_name,login_pass);
                mDataBMI.setUsername(login_name);
                HashMap<String,String> params = new HashMap<String, String>();
                params.put("userName",login_name);
                params.put("password",login_pass);
                String request = "username="+ login_name+"&"+"password="+login_pass;
                Log.e("request****",request);
                RequestBody requestBody = RequestBody.create(MediaType.parse("text/plain"),request);
                Call<JsonElement> loginservercaall = RestClient.getApiService().doLogin(params);
                loginservercaall.enqueue(new Callback<JsonElement>() {
                    @Override
                    public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                        if(response.isSuccessful()){
                          JsonElement data = response.body();
//                            Toast.makeText(MainActivity.this, data.getAsJsonObject().get("message").getAsString(), Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(MainActivity.this, Navigation_drawer_side_menu.class));
                        }else{
                            try {
                                Toast.makeText(MainActivity.this, "Please enter valid details "+response.errorBody().string(), Toast.LENGTH_SHORT).show();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<JsonElement> call, Throwable t) {

                    }
                });
//                startActivity(new Intent(MainActivity.this, Navigation_drawer_side_menu.class));
                break;


            case R.id.Register_link:
                startActivity(new Intent(MainActivity.this, Registration_Page.class));
                break;
        }
    }

}




