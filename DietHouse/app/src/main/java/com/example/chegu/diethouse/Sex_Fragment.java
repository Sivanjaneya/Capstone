package com.example.chegu.diethouse;


import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
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
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chegu.diethouse.network.DataBMI;

import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class Sex_Fragment extends Fragment implements View.OnClickListener {

    private Context mContext;
    Calendar calendar = Calendar.getInstance();
    EditText display;
    private TextView t;
    TextView textView;

    private static Animation shakeAnimation;
    private static FragmentManager fragmentManager;

    RadioGroup radioGroup;
    RadioButton checkedRadioButton;
    private DataBMI mDataBMI;


    public Sex_Fragment() {
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
        View rootView = inflater.inflate(R.layout.sex_fragment, container, false);
        fragmentManager = getActivity().getSupportFragmentManager();
        shakeAnimation = AnimationUtils.loadAnimation(getActivity(),
                R.anim.shake);
        mDataBMI = DataBMI.getInstance();
        display = (EditText) rootView.findViewById(R.id.date);
        textView = (TextView) rootView.findViewById(R.id.back_button);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager
                        .beginTransaction()
                        .setCustomAnimations(R.anim.left_enter, R.anim.right_out)
                        .replace(R.id.main_container,
                                new Weight_Loss_Fragment()).commit();
            }
        });
//        t = (TextView) rootView.findViewById(R.id.calender);
//        t.setOnClickListener(this);

        radioGroup = (RadioGroup) rootView.findViewById(R.id.sex_rg);
        checkedRadioButton = (RadioButton) radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());

// This will get the radiobutton in the radiogroup that is checked

//radioGroup = (RadioGroup)rootView.findViewById(R.id.rg);
//        rb1 = (RadioButton) rootView.findViewById(R.id.active);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // This will get the radiobutton that has changed in its check state
                checkedRadioButton = (RadioButton) group.findViewById(checkedId);
                // This puts the value (true/false) into the variable
                boolean isChecked = checkedRadioButton.isChecked();
                mDataBMI.setSex(checkedRadioButton.getText().toString());
                // If the radiobutton that has changed in check state is now checked...
                if (isChecked) {
                    validate();
//                    fragmentManager
//                            .beginTransaction()
//                            .setCustomAnimations(R.anim.right_enter, R.anim.left_out)
//                            .replace(R.id.main_container,
//                                    new Height_fragment()).commit();

                }
            }
        });

        return rootView;
    }

    @Override
    public void onClick(View v) {
//        new DatePickerDialog(mContext,listener,calendar.get(calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(calendar.DAY_OF_MONTH)).show();

    }
//    DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
//        @Override
//        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//            display.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year);
//        }
//    };

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
        switch (item.getItemId()) {
            case R.id.Next:
                if(validate()){
                    mDataBMI.setAge(Double.valueOf(display.getText().toString().replace("", "")));
                    fragmentManager
                            .beginTransaction()
                            .setCustomAnimations(R.anim.right_enter, R.anim.left_out)
                            .replace(R.id.main_container,
                                    new Height_fragment()).commit();
                }
                break;


        }
        return super.onOptionsItemSelected(item);
    }

    private boolean validate() {


        if (radioGroup.getCheckedRadioButtonId() == -1){
            Toast.makeText(getActivity(),"Please select male or female",Toast.LENGTH_LONG).show();

            return false;

        }else if(display.getText().toString().equalsIgnoreCase("") ) {
            display.setError("Please enter Age");
            return false;
        }
        else{
            return true;
        }
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        if (item.getItemId() == R.id.Next) {
//
//            fragmentManager
//                    .beginTransaction()
//                    .setCustomAnimations(R.anim.right_enter, R.anim.left_out)
//                    .replace(R.id.main_container,
//                            new Height_fragment()).commit();
//        } else if (radioGroup.getCheckedRadioButtonId() == -1) {
//            fragmentManager
//                    .beginTransaction()
//                    .setCustomAnimations(R.anim.right_enter, R.anim.left_out)
//                    .replace(R.id.main_container,
//                            new Height_fragment()).commit();
//
//
//        }
//
//        return super.onOptionsItemSelected(item);
//    }


}
