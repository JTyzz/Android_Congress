package com.lambdaschool.congressdetails;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.lambdaschool.congressdataapiaccess.CongresspersonDetails;

public class DetailsView extends AppCompatActivity {

    public static final String CONGRESS_ID = "CongressId";
    TextView                        twitterHandle;
        CongressPersonDetailsViewModel  viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_view);

        twitterHandle = findViewById(R.id.twitter_view);

        String id = getIntent().getStringExtra(CONGRESS_ID);

        viewModel = ViewModelProviders.of(this).get(CongressPersonDetailsViewModel.class);
        viewModel.getDetails(id).observe(this, new Observer<CongresspersonDetails>() {
            @Override
            public void onChanged(@Nullable CongresspersonDetails congresspersonDetails) {
                if (congresspersonDetails != null) {
                    twitterHandle.setText(congresspersonDetails.getTwitterAccount());
                }
            }
        });


    }
}
