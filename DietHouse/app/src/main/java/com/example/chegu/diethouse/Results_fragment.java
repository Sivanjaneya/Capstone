package com.example.chegu.diethouse;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chegu.diethouse.network.DataBMI;
import com.example.chegu.diethouse.network.RestClient;
import com.example.chegu.diethouse.network.coloricount;
import com.google.gson.JsonElement;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class Results_fragment extends Fragment {
    TextView textView;
    TextView back;
    private ListView gr;
    private ArrayList<String> al;
    private ArrayList<Home_page_Model> mydata;
    private Context mContext;


    private DataBMI mDataBMI;
    private FragmentManager fragmentManager;
    private Animation shakeAnimation;

    public Results_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_results_fragment, container, false);

        // Inflate the layout for this fragment
        mDataBMI = DataBMI.getInstance();
        gr = (ListView) rootView.findViewById(R.id.list_view);
        mydata = new ArrayList<>();
        mydata.add(new Home_page_Model("Maximize Your Muscle", R.mipmap.image,"Muscles are fat-burning furnaces, so be sure to do enough resistance training to build and maintain them (these fast workouts tone your whole body in 30 minutes)."));
        mydata.add(new Home_page_Model("Don't Forget Cardio", R.mipmap.download,"Cardio improves definition and burns the fat that covers your muscles, especially belly fat. Combining regular aerobic exercise with strength."));
        mydata.add(new Home_page_Model("Never Skip Meals", R.mipmap.meal,"Eat six small meals a day to avoid blood-sugar spikes and minimize urges to binge. Try to schedule meals at the same time each day."));
        mydata.add(new Home_page_Model("Get Real", R.mipmap.download1,"Fuel your body with wholesome, nutritious foods, and limit your intake of refined carbs (anything sugary or white-flour based).  "));
        mydata.add(new Home_page_Model("Sleep Tight", R.mipmap.sleep,"Try to get 7-8 hours of sleep every night. A recent study from Case Western Reserve University found that, on average, women who sleep for 5 hours."));
        Home_page_Adapter Adapter = new Home_page_Adapter(mContext, mydata);
        gr.setAdapter(Adapter);
        gr.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent in;
                switch (position) {
                    case 0:
                        Toast.makeText(getActivity().getApplicationContext(), "500 calories per day to burn for your targeted weight" +mDataBMI.getGoalWeight(), Toast.LENGTH_LONG).show();
//                        in = new Intent(mContext, Main2Activity.class);
//                        startActivity(in);
                        break;
                    case 1:
                        Toast.makeText(getActivity().getApplicationContext(), "You Should Burn At Least 500 Calories During Your Cardio Sessions based on your age"+mDataBMI.getAge(), Toast.LENGTH_LONG).show();
                        break;
                    case 2:
                        Toast.makeText(getActivity().getApplicationContext(), "To lose 1kg of fat in a week, you have to eat 3,500 fewer calories "+mDataBMI.getWeight(), Toast.LENGTH_LONG).show();

                        break;
                    case 3:
                        Toast.makeText(getActivity().getApplicationContext(), "To gain 1kg of in a week, you have to eat 6,500 fewer calories  "+mDataBMI.getWeight(), Toast.LENGTH_LONG).show();

                        break;
                    case 4:
                        Toast.makeText(getActivity().getApplicationContext(), "You burn more calories when you are in a deep sleep "+mDataBMI.getGoalWeight(), Toast.LENGTH_LONG).show();

                        break;
                }
            }
        });




        fragmentManager = getActivity().getSupportFragmentManager();
        shakeAnimation = AnimationUtils.loadAnimation(getActivity(),
                R.anim.shake);
        textView = (TextView)  rootView.findViewById(R.id.calorie_results);
        back = (TextView) rootView.findViewById(R.id.back_button6);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager
                        .beginTransaction()
                        .setCustomAnimations(R.anim.left_enter, R.anim.right_out)
                        .replace(R.id.main_container,
                                new Details()).commit();

            }
        });
//        mDataBMI.setUsername("complanboy2");
//        mDataBMI.setSex("male");
//        mDataBMI.setGoalWeight(30.5);
//        mDataBMI.setCalorieCount(0);
//        mDataBMI.setWeeklyGoal(130.5);
//        mDataBMI.setBmr(200);
        Call<JsonElement> data  =RestClient.getApiService().updateBmr(mDataBMI);
        data.enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                if(response.isSuccessful()) {
                   JsonElement data = response.body();
                    textView.setText(data.getAsJsonObject().get("message").getAsJsonObject().get("calorieCount").getAsString());
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

    public void onAttach(Activity activity)
    {
        mContext = ((Context) activity);
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }





}
