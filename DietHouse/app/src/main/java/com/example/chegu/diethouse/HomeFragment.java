package com.example.chegu.diethouse;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private ListView gr;
    private ArrayList<String> al;
    private ArrayList<Home_page_Model> mydata;
    private Context mContext;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
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
                        in = new Intent(mContext, Results_fragment.class);
                        startActivity(in);
                        break;
                    case 1:
                        in = new Intent(mContext, Results_fragment.class);
                        startActivity(in);
                        break;
                    case 2:
                        in = new Intent(mContext, Results_fragment.class);
                        startActivity(in);
                        break;
                    case 3:
                        in = new Intent(mContext, Results_fragment.class);
                        startActivity(in);
                        break;
                    case 4:
                        in = new Intent(mContext, Results_fragment.class);
                        startActivity(in);
                        break;
                }
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
