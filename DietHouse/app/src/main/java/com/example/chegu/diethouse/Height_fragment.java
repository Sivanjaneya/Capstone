package com.example.chegu.diethouse;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.chegu.diethouse.network.DataBMI;


/**
 * A simple {@link Fragment} subclass.
 */
public class Height_fragment extends Fragment {
    TextView textView;


    private static Animation shakeAnimation;
    private static FragmentManager fragmentManager;
    private DataBMI mDataBMI;
    EditText editText_height,edittext_weight;
    private Context mContext;


    public Height_fragment() {
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
        View rootView = inflater.inflate(R.layout.height_fragment, container, false);
        fragmentManager = getActivity().getSupportFragmentManager();
        shakeAnimation = AnimationUtils.loadAnimation(getActivity(),
                R.anim.shake);
        editText_height = (EditText)rootView.findViewById(R.id.height);
        edittext_weight = (EditText)rootView.findViewById(R.id.weight);
        textView = (TextView) rootView.findViewById(R.id.back_button1);
        mDataBMI = DataBMI.getInstance();

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager
                        .beginTransaction()
                        .setCustomAnimations(R.anim.left_enter, R.anim.right_out)
                        .replace(R.id.main_container,
                                new Sex_Fragment()).commit();
            }
        });
        return rootView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.men_items, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Next:
                if(validate()){
                    mDataBMI.setHeight(Double.parseDouble(editText_height.getText().toString()));
                    mDataBMI.setWeight(Double.parseDouble(edittext_weight.getText().toString()));
                    fragmentManager
                            .beginTransaction()
                            .setCustomAnimations(R.anim.right_enter, R.anim.left_out)
                            .replace(R.id.main_container,
                                    new Goal_Fragment()).commit();
                }

                break;

        }
        return super.onOptionsItemSelected(item);
    }

    private boolean validate() {
        if(editText_height.getText().toString().equalsIgnoreCase("") ){
            editText_height.setError("Please enter height");
            return false;
        }else if(edittext_weight.getText().toString().equalsIgnoreCase("")){
            edittext_weight.setError("Please enter Weight");
            return false;
        }else{
            return true;
        }
    }

}
