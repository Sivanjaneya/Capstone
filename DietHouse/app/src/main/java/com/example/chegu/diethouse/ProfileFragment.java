package com.example.chegu.diethouse;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.chegu.diethouse.network.DataBMI;
import com.example.chegu.diethouse.network.GetAccount;
import com.example.chegu.diethouse.network.RestClient;
import com.google.gson.JsonElement;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.RequestBody;

import java.io.IOException;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.chegu.diethouse.R.id.textView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {
    EditText username,emailid;
    private GetAccount myaccount;




    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);

        username = (EditText)rootView.findViewById(R.id.etname1);
        emailid = (EditText)rootView.findViewById(R.id.email);
        myaccount = GetAccount.getInstance();
        Call<JsonElement> data  = RestClient.getApiService().getAccount(myaccount);
        data.enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                if(response.isSuccessful()) {
                    JsonElement data = response.body();
                    username.setText(data.getAsJsonObject().get("message").getAsJsonObject().get("username").getAsString());
                    emailid.setText(data.getAsJsonObject().get("message").getAsJsonObject().get("email").getAsString());

                    Toast.makeText(getActivity().getApplicationContext(), "done", Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(getActivity().getApplicationContext(),"fail",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {
                Toast.makeText(getActivity().getApplicationContext(),"fail 2",Toast.LENGTH_LONG).show();
            }
        });
        return rootView;
    }



}
