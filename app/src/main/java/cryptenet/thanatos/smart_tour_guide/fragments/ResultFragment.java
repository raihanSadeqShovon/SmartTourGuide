package cryptenet.thanatos.smart_tour_guide.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import cryptenet.thanatos.smart_tour_guide.PlanMaker;
import cryptenet.thanatos.smart_tour_guide.R;
import cryptenet.thanatos.smart_tour_guide.adapters.ResultAdapter;
import cryptenet.thanatos.smart_tour_guide.models.Result;

public class ResultFragment extends Fragment {
    private ArrayList<Result> results;
    private RecyclerView recyResults;

    private ResultAdapter resultAdapter;

    public ResultFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null){
            results = new PlanMaker(getArguments()).gerenatePlan();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View convertView = inflater.inflate(R.layout.fragment_result, container, false);

        init(convertView);
        return convertView;
    }

    private void init(View convertView) {
        viewBinder(convertView);

        resultAdapter = new ResultAdapter(results);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyResults.setLayoutManager(layoutManager);
        recyResults.setItemAnimator(new DefaultItemAnimator());
        recyResults.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));

        recyResults.setAdapter(resultAdapter);
    }

    private void viewBinder(View convertView) {
        recyResults = convertView.findViewById(R.id.recy_results);
    }

    public interface onListItemSelectedListener {
        void onListItemSelected();
    }
}
