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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chegu.diethouse.network.DataBMI;


/**
 * A simple {@link Fragment} subclass.
 */
public class Goal_Fragment extends Fragment {

    private static Animation shakeAnimation;
    private static FragmentManager fragmentManager;
    Context mContext;
    TextView textView;
    RadioGroup radioGroup;
    RadioButton checkedRadioButton;
    private DataBMI mDataBMI;
    EditText editText;


    public Goal_Fragment() {
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
        View rootView = inflater.inflate(R.layout.fragment_goal_, container, false);
        fragmentManager = getActivity().getSupportFragmentManager();
        shakeAnimation = AnimationUtils.loadAnimation(getActivity(),
                R.anim.shake);
        mDataBMI = DataBMI.getInstance();
        textView = (TextView) rootView.findViewById(R.id.back_button2);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager
                        .beginTransaction()
                        .setCustomAnimations(R.anim.left_enter, R.anim.right_out)
                        .replace(R.id.main_container,
                                new Height_fragment()).commit();
            }
        });
        radioGroup = (RadioGroup) rootView.findViewById(R.id.rg1);
        editText = (EditText) rootView.findViewById(R.id.goalweight);



// This will get the radiobutton in the radiogroup that is checked
        checkedRadioButton = (RadioButton) radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());


//radioGroup = (RadioGroup)rootView.findViewById(R.id.rg);
//        rb1 = (RadioButton) rootView.findViewById(R.id.active);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // This will get the radiobutton that has changed in its check state
                checkedRadioButton = (RadioButton) group.findViewById(checkedId);
                // This puts the value (true/false) into the variable
                boolean isChecked = checkedRadioButton.isChecked();
                mDataBMI.setWeeklyGoal(Double.valueOf(checkedRadioButton.getText().toString().replace("kgs per week","")));
                mDataBMI.setGoalWeight(Double.valueOf(editText.getText().toString()));
                // If the radiobutton that has changed in check state is now checked...
                if (isChecked) {
                    fragmentManager
                            .beginTransaction()
                            .setCustomAnimations(R.anim.right_enter, R.anim.left_out)
                            .replace(R.id.main_container,
                                    new Details()).commit();

                }
            }
        });
        return rootView;
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.men_items, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.Next:
//                if(validate()){
//
//                    fragmentManager
//                            .beginTransaction()
//                            .setCustomAnimations(R.anim.right_enter, R.anim.left_out)
//                            .replace(R.id.main_container,
//                                    new Results_fragment()).commit();
//                }
//                break;
//        }
//        return super.onOptionsItemSelected(item);
//    }
//
//    private boolean validate() {
//        if(editText.getText().toString().equalsIgnoreCase("") ){
//            editText.setError("Please enter weekly goal");
//            return false;
//
//        }else if (radioGroup.getCheckedRadioButtonId() == -1){
//            Toast.makeText(getActivity(),"Please select weekely goal",Toast.LENGTH_LONG).show();
//
//            return false;
//
//        }
//        else{
//            return true;
//        }
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.Next) {

            fragmentManager
                    .beginTransaction()
                    .setCustomAnimations(R.anim.right_enter, R.anim.left_out)
                    .replace(R.id.main_container,
                            new Details()).commit();
        } else if (radioGroup.getCheckedRadioButtonId() == -1) {
            fragmentManager
                    .beginTransaction()
                    .setCustomAnimations(R.anim.right_enter, R.anim.left_out)
                    .replace(R.id.main_container,
                            new Details()).commit();


        }

        return super.onOptionsItemSelected(item);
    }




}
