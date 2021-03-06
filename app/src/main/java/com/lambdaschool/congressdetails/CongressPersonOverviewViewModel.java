package com.lambdaschool.congressdetails;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.lambdaschool.congressdataapiaccess.CongresspersonOverview;

import java.util.ArrayList;

public class CongressPersonOverviewViewModel extends ViewModel {
    private MutableLiveData<ArrayList<CongresspersonOverview>> overviewList;

    public LiveData<ArrayList<CongresspersonOverview>> getOverViewList() {
        if(overviewList == null) {
            loadList();
        }
        return overviewList;
    }
    private void loadList() {
        overviewList = CongressPersonOverviewRepo.getOverviewList();
    }
}
