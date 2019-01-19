package cryptenet.thanatos.smart_tour_guide.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import cryptenet.thanatos.smart_tour_guide.R;
import cryptenet.thanatos.smart_tour_guide.models.Result;

public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.MyViewHolder>{
    private ArrayList<Result> resultList;

    public ResultAdapter(ArrayList<Result> resultList) {
        this.resultList = resultList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lay_recy_result_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Result result = resultList.get(position);
        holder.tvTourPath.setText(result.getPath());
        holder.tvExpenditure.setText("  " + Integer.toString(result.getExpenditure()));
        holder.tvDuration.setText("  " + Integer.toString(result.getDuration()));
    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvTourPath, tvExpenditure, tvDuration;

        MyViewHolder(View view) {
            super(view);
            tvTourPath = view.findViewById(R.id.tv_tour_path);
            tvExpenditure = view.findViewById(R.id.tv_expenditure);
            tvDuration = view.findViewById(R.id.tv_duration);
        }
    }
}
