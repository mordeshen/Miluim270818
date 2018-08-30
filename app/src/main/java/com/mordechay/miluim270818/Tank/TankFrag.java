package com.mordechay.miluim270818.Tank;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.mordechay.miluim270818.R;

import java.util.ArrayList;
import java.util.List;

public class  TankFrag extends Fragment {


    private int[] itemTitle = {(R.string.tank_num_title),(R.string.tank_job_title),
            (R.string.tank_place_title),(R.string.tank_equipment_title),(R.string.tank_faults_title),
            (R.string.tank_updates_title)};
    private int[] itemDetail = {(R.string.tank_num),(R.string.tank_job),(R.string.tank_place),
            (R.string.tank_equipment),(R.string.tank_faults),(R.string.tank_updates)};
    private int[] itemImg ={R.drawable.id, R.drawable.job, R.drawable.current_location,
            R.drawable.equipment,R.drawable.faults,R.drawable.updates};

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.my_tank, container, false);

        RecyclerView recyclerView =  (RecyclerView) v.findViewById(R.id.recyclerViewTank);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        TankMyRecyclerViewAdapter adapter = new TankMyRecyclerViewAdapter(getDataSet());
        recyclerView.setAdapter(adapter);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        return v;
    }


    private List<TankDataObject> getDataSet() {
        List<TankDataObject> returnList = new ArrayList<>();
        for (int counter = 0; counter < itemTitle.length; counter += 1) {
            returnList.add(new TankDataObject(itemTitle[counter],itemDetail[counter],itemImg[counter]));
        }
        return returnList;
    }


}
