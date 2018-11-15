package com.lambdaschool.congressdetails;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lambdaschool.congressdataapiaccess.CongresspersonOverview;

import java.util.ArrayList;

public class CongressListAdapter extends RecyclerView.Adapter<CongressListAdapter.ViewHolder> {
    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView congressName, congressTwitter;
        ViewGroup parentView;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            congressName = itemView.findViewById(R.id.congress_name);
            congressTwitter = itemView.findViewById(R.id.congress_twitter);
            parentView = itemView.findViewById(R.id.congress_parent_layout);
        }
    }

    private ArrayList<CongresspersonOverview> dataList;
    private Context context;
    private Activity activity;

    CongressListAdapter(ArrayList<CongresspersonOverview> dataList, Activity activity) {
        this.dataList = dataList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i){
        context = viewGroup.getContext();
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.congress_element_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final CongresspersonOverview data = dataList.get(i);

        viewHolder.congressName.setText(data.getFirstName()+" "+data.getLastName());
        viewHolder.congressTwitter.setText(data.getState()+"-"+data.getParty());
//        Intent intent = new Intent(context, DetailsView.class);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
