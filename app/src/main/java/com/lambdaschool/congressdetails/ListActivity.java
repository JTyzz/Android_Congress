package com.lambdaschool.congressdetails;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lambdaschool.congressdataapiaccess.CongresspersonOverview;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    LinearLayout    parentLayout;
    CongressPersonOverviewViewModel viewModel;
    Context         context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        parentLayout = findViewById(R.id.parent_layout);
        context = this;

        viewModel = ViewModelProviders.of(this).get(CongressPersonOverviewViewModel.class);
        viewModel.getOverViewList().observe(this, new Observer<ArrayList<CongresspersonOverview>>() {
            @Override
            public void onChanged(@Nullable ArrayList<CongresspersonOverview> congresspersonOverviews) {
                if(congresspersonOverviews != null){
                    for(CongresspersonOverview congressperson: congresspersonOverviews) {
//                        parentLayout.addView(getDefaultTextView(congressperson.getFirstName()+" "+ congressperson.getLastName()));
                        parentLayout.addView(getDefaultTextView(congressperson));
                    }
                }
            }
        });
    }
    TextView getDefaultTextView(final CongresspersonOverview congressperson) {
        TextView view = new TextView(context);
        String displayText = congressperson.getFirstName()+" "+congressperson.getLastName();
        view.setText(displayText);
        view.setTextSize(24);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = congressperson.getId();
                Intent intent = new Intent(context, DetailsView.class);
                intent.putExtra("CongressId", id);
                startActivity(intent);
            }
        });
        return view;
    }
}
