package cryptenet.thanatos.smart_tour_guide.fragments;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.adw.library.widgets.discreteseekbar.DiscreteSeekBar;

import cryptenet.thanatos.smart_tour_guide.R;
import cryptenet.thanatos.smart_tour_guide.activities.SplashActivity;

public class HomeFragment extends Fragment
        implements View.OnClickListener, DiscreteSeekBar.OnProgressChangeListener {
    private Activity activity;
    private Spinner spinStartPoint, spinInterest;
    private TextView tvBudgetSelected, tvDurationSelected;
    private DiscreteSeekBar seekBudget, seekDuration;
    private RadioGroup rgSeason, rgExpenditure, rgSpeed, rgTransportation;
    private Button btnMoreOptions, btnSearch;
    private LinearLayout layLinMoreOptions;

    private ArrayAdapter<CharSequence> startPointAdapter, interestAdapter;

    private Boolean isShown;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Activity)
            activity = (Activity) context;
    }

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View convertView = inflater.inflate(R.layout.fragment_home, container, false);

        init(convertView);
        return convertView;
    }

    private void init(View convertView) {
        isShown = false;
        viewBinder(convertView);

        startPointAdapter = ArrayAdapter.createFromResource(getContext(),
                R.array.start_point_list, android.R.layout.simple_spinner_item);
        startPointAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinStartPoint.setAdapter(startPointAdapter);

        interestAdapter = ArrayAdapter.createFromResource(getContext(),
                R.array.interest_list, android.R.layout.simple_spinner_item);
        interestAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinInterest.setAdapter(interestAdapter);

        seekBudget.setOnProgressChangeListener(this);
        seekDuration.setOnProgressChangeListener(this);

        btnMoreOptions.setOnClickListener(this);
        btnSearch.setOnClickListener(this);
    }

    private void viewBinder(View convertView) {
        spinStartPoint = convertView.findViewById(R.id.spin_start_point);
        spinInterest = convertView.findViewById(R.id.spin_interest);

        tvBudgetSelected = convertView.findViewById(R.id.tv_budget_selected);
        tvDurationSelected = convertView.findViewById(R.id.tv_duration_selected);

        seekBudget = convertView.findViewById(R.id.seek_budget);
        seekDuration = convertView.findViewById(R.id.seek_duration);

        rgSeason = convertView.findViewById(R.id.rg_season);
        rgExpenditure = convertView.findViewById(R.id.rg_expenditure);
        rgSpeed = convertView.findViewById(R.id.rg_speed);
        rgTransportation = convertView.findViewById(R.id.rg_transportation);

        btnMoreOptions = convertView.findViewById(R.id.btn_more_options);
        btnSearch = convertView.findViewById(R.id.btn_search);

        layLinMoreOptions = convertView.findViewById(R.id.lay_lin_more_options);
    }

    private boolean validate() {
        if (layLinMoreOptions.getVisibility() == View.GONE) {
            if (spinStartPoint != null && spinStartPoint.getSelectedItem() != null
                    && spinInterest != null && spinInterest.getSelectedItem() != null
                    && !tvBudgetSelected.getText().toString().equals("0")
                    && !tvDurationSelected.getText().toString().equals("0")
                    && rgSeason.getCheckedRadioButtonId() != -1) {

            return true;
            }else {
                Toast.makeText(getActivity(), "Please select from each options", Toast.LENGTH_SHORT).show();
//                Log.d("gone", "gone");
//                Log.d("tag", spinStartPoint.getSelectedItem().toString() + "\n" +
//                        spinInterest.getSelectedItem().toString() + "\n" +
//                        tvDurationSelected.getText().toString() + "\n" +
//                        tvBudgetSelected.getText().toString() + "\n" +
//                        rgSeason.getCheckedRadioButtonId());
                return false;
            }
        } else if (layLinMoreOptions.getVisibility() == View.VISIBLE) {
            if (spinStartPoint != null && spinStartPoint.getSelectedItem() != null
                    && spinInterest != null && spinInterest.getSelectedItem() != null
                    && !tvBudgetSelected.getText().toString().equals("0")
                    && !tvDurationSelected.getText().toString().equals("0")
                    && rgSeason.getCheckedRadioButtonId() != -1
                    && rgExpenditure.getCheckedRadioButtonId() != -1
                    && rgSpeed.getCheckedRadioButtonId() != -1
                    && rgTransportation.getCheckedRadioButtonId() != -1)
                return true;
            else {
                Toast.makeText(getActivity(), "Please select from each options", Toast.LENGTH_SHORT).show();
//                Log.d("ngone", "ngone");
                return false;
            }
        }
        else{
//            Log.d("lgone", "lgone");
            return false;
        }
    }

    private Bundle getParameters() {
        Bundle bundle = new Bundle();
        switch (layLinMoreOptions.getVisibility()){
            case View.GONE :
                getPrimaryData(bundle);
                break;
            case View.VISIBLE:
                getPrimaryData(bundle);
                getOptionalData(bundle);
                break;
        }
        return bundle;
    }

    private String getRadioInput(int groupId, int checkedButtonId) {
        switch (groupId){
            case R.id.rg_season:
                switch (checkedButtonId) {
                    case R.id.btn_season_summer:
                        return String.valueOf(R.string.btn_season_summer);
                    case R.id.btn_season_rainy:
                        return String.valueOf(R.string.btn_season_rainy);
                    case R.id.btn_season_winter:
                        return String.valueOf(R.string.btn_season_winter);
                }
            case R.id.rg_expenditure:
                switch (checkedButtonId) {
                    case R.id.btn_expenditure_luxury:
                        return String.valueOf(R.string.btn_expenditure_luxury);
                    case R.id.btn_expenditure_smart:
                        return String.valueOf(R.string.btn_expenditure_smart);
                    case R.id.btn_expenditure_saver:
                        return String.valueOf(R.string.btn_expenditure_saver);
                }
            case R.id.rg_speed:
                switch (checkedButtonId) {
                    case R.id.btn_speed_rush:
                        return String.valueOf(R.string.btn_speed_rush);
                    case R.id.btn_speed_moderate:
                        return String.valueOf(R.string.btn_speed_moderate);
                    case R.id.btn_speed_relaxing:
                        return String.valueOf(R.string.btn_speed_relaxing);
                }
            case R.id.rg_transportation:
                switch (checkedButtonId) {
                    case R.id.btn_transportation_air:
                        return String.valueOf(R.string.btn_transportation_air);
                    case R.id.btn_transportation_bus_luxury:
                        return String.valueOf(R.string.btn_transportation_bus_luxury);
                    case R.id.btn_transportation_bus_cheap:
                        return String.valueOf(R.string.btn_transportation_bus_cheap);
                    case R.id.btn_transportation_none:
                        return String.valueOf(R.string.btn_transportation_none);
                }
            default:
                return "";
        }
    }

    private void getPrimaryData(Bundle bundle) {
        bundle.putString(String.valueOf(R.string.bundle_start_point), spinStartPoint.getSelectedItem().toString());
        bundle.putString(String.valueOf(R.string.bundle_interest), spinInterest.getSelectedItem().toString());
        bundle.putString(String.valueOf(R.string.bundle_budget), tvBudgetSelected.getText().toString());
        bundle.putString(String.valueOf(R.string.bundle_duration), tvDurationSelected.getText().toString());
        bundle.putString(String.valueOf(R.string.bundle_season),
                getRadioInput(rgSeason.getId(), rgSeason.getCheckedRadioButtonId()));
    }

    private void getOptionalData(Bundle bundle) {
        bundle.putString(String.valueOf(R.string.bundle_expenditure_type),
                getRadioInput(rgExpenditure.getId(), rgExpenditure.getCheckedRadioButtonId()));
        bundle.putString(String.valueOf(R.string.bundle_speed),
                getRadioInput(rgSpeed.getId(), rgSpeed.getCheckedRadioButtonId()));
        bundle.putString(String.valueOf(R.string.bundle_transportation),
                getRadioInput(rgTransportation.getId(), rgTransportation.getCheckedRadioButtonId()));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_more_options:
                if (isShown) {
                    layLinMoreOptions.setVisibility(View.GONE);
                    isShown = false;
                }else {
                    layLinMoreOptions.setVisibility(View.VISIBLE);
                    isShown = true;
                }
                break;
            case R.id.btn_search:
                if (validate()) {
                    Bundle bundle = getParameters();

                    try {
                        ((onSearchButtonPressedListener) activity).onSearchButtonPressed(bundle);
                    } catch (ClassCastException e) {
                        e.printStackTrace();
                    }
                }
                break;
        }
    }

    @Override
    public void onProgressChanged(DiscreteSeekBar seekBar, int value, boolean fromUser) {
        switch (seekBar.getId()){
            case R.id.seek_budget:
                tvBudgetSelected.setText(String.valueOf(value));
                break;
            case R.id.seek_duration:
                tvDurationSelected.setText(value + " days");
                break;
        }
    }

    @Override
    public void onStartTrackingTouch(DiscreteSeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(DiscreteSeekBar seekBar) {

    }

    public interface onSearchButtonPressedListener {
        void onSearchButtonPressed(Bundle bundle);
    }
}
