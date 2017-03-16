package com.example.chegu.diethouse;


import android.app.Activity;
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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.chegu.diethouse.network.DataBMI;


/**
 * A simple {@link Fragment} subclass.
 */
public class Weight_Loss_Fragment extends Fragment {
    private static View view;

    private static Animation shakeAnimation;
    private static FragmentManager fragmentManager;

    private DataBMI mDataBMI;
    Spinner spinner, spinner1;
    ArrayAdapter<CharSequence> adapter;
    Context mContext;
    //    Button button;
    RadioGroup radioGroup;
    RadioButton checkedRadioButton;


    public Weight_Loss_Fragment() {
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

        View rootView = inflater.inflate(R.layout.fragment_weight__loss_, container, false);

        fragmentManager = getActivity().getSupportFragmentManager();
        shakeAnimation = AnimationUtils.loadAnimation(getActivity(),
                R.anim.shake);
        mDataBMI = DataBMI.getInstance();
        radioGroup = (RadioGroup) rootView.findViewById(R.id.rg);

        checkedRadioButton = (RadioButton) radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // This will get the radiobutton that has changed in its check state
                checkedRadioButton = (RadioButton) group.findViewById(checkedId);
                // This puts the value (true/false) into the variable
                boolean isChecked = checkedRadioButton.isChecked();
                mDataBMI.setActiveStatus(checkedRadioButton.getText().toString());
                // If the radiobutton that has changed in check state is now checked...
                if (isChecked) {
                    fragmentManager
                            .beginTransaction()
                            .setCustomAnimations(R.anim.right_enter, R.anim.left_out)
                            .replace(R.id.main_container,
                                    new Sex_Fragment()).commit();

                }
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

            Toast.makeText(getActivity().getApplicationContext(), "Please select one category ", Toast.LENGTH_LONG).show();

        }
//
//            fragmentManager
//                    .beginTransaction()
//                    .setCustomAnimations(R.anim.right_enter, R.anim.left_out)
//                    .replace(R.id.main_container,
//                            new Sex_Fragment()).commit();
//        } else if (radioGroup.getCheckedRadioButtonId() == -1) {
//            fragmentManager
//                    .beginTransaction()
//                    .setCustomAnimations(R.anim.right_enter, R.anim.left_out)
//                    .replace(R.id.main_container,
//                            new Sex_Fragment()).commit();
//
//
//        }

        return super.onOptionsItemSelected(item);
    }

}


