package com.example.chegu.diethouse;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chegu.diethouse.network.DataBMI;
import com.example.chegu.diethouse.network.RestClient;
import com.google.gson.JsonElement;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.chegu.diethouse.R.id.textView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Details extends Fragment {



    private static Animation shakeAnimation;
    private static FragmentManager fragmentManager;
    private Context mContext;
    private TextView d_name,d_sex,d_age,d_height,d_weight,d_status,d_target,d_weekely,d_back;




    private DataBMI mDataBMI;


    public Details() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_details, container, false);

        fragmentManager = getActivity().getSupportFragmentManager();
        shakeAnimation = AnimationUtils.loadAnimation(getActivity(),
                R.anim.shake);
        mDataBMI = DataBMI.getInstance();
        d_name = (TextView) rootView.findViewById(R.id.details_username_view);
        d_sex = (TextView) rootView.findViewById(R.id.details_sex_view);
        d_age = (TextView) rootView.findViewById(R.id.details_age_view);
        d_height = (TextView) rootView.findViewById(R.id.details_height_view);
        d_weight = (TextView)rootView.findViewById(R.id.details_weight_view);
        d_status = (TextView) rootView.findViewById(R.id.details_status_view);
        d_target = (TextView)rootView.findViewById(R.id.details_target_view);
        d_weekely = (TextView)rootView.findViewById(R.id.details_weekely_view);
        d_back = (TextView)rootView.findViewById(R.id.back_details);
        d_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager
                        .beginTransaction()
                        .setCustomAnimations(R.anim.left_enter, R.anim.right_out)
                        .replace(R.id.main_container,
                                new Goal_Fragment()).commit();
            }
        });

//
        Call<JsonElement> data  = RestClient.getApiService().updateBmr(mDataBMI);
        data.enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                if(response.isSuccessful()) {
                    JsonElement data = response.body();
                    d_name.setText(data.getAsJsonObject().get("message").getAsJsonObject().get("username").getAsString());
                    d_sex.setText(data.getAsJsonObject().get("message").getAsJsonObject().get("sex").getAsString());
                    d_age.setText(data.getAsJsonObject().get("message").getAsJsonObject().get("age").getAsString());
                    d_height.setText(data.getAsJsonObject().get("message").getAsJsonObject().get("height").getAsString());
                    d_weight.setText(data.getAsJsonObject().get("message").getAsJsonObject().get("weight").getAsString());
                    d_status.setText(data.getAsJsonObject().get("message").getAsJsonObject().get("activeStatus").getAsString());
                    d_target.setText(data.getAsJsonObject().get("message").getAsJsonObject().get("goalWeight").getAsString());
                    d_weekely.setText(data.getAsJsonObject().get("message").getAsJsonObject().get("weeklyGoal").getAsString());

//                    Toast.makeText(getActivity().getApplicationContext(), "done", Toast.LENGTH_LONG).show();
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

    @Override
    public void onAttach(Activity activity) {
        mContext = ((Context) activity);
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.men_items, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.Next) {
            fragmentManager
                    .beginTransaction()
                    .setCustomAnimations(R.anim.right_enter, R.anim.left_out)
                    .replace(R.id.main_container,
                            new Results_fragment()).commit();
        }

        return super.onOptionsItemSelected(item);
    }


}
