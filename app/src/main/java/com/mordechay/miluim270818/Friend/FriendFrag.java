package com.mordechay.miluim270818.Friend;

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

public class FriendFrag extends Fragment {

    private int[] itemImg = {(R.drawable.soldier),(R.drawable.soldier),(R.drawable.soldier),(R.drawable.soldier)};

    private int[] itemDuty = {(R.string.friend_duty_commander_title),(R.string.friend_duty_hunter_title),
            (R.string.friend_duty_provider_title),(R.string.friend_duty_driver_title)};

    private int[] itemName = {(R.string.friend_name_commander),(R.string.friend_name_hunter),
            (R.string.friend_name_provider),(R.string.friend_name_driver)};

    private int[] itemTel = {(R.string.friend_num_commander),(R.string.friend_num_hunter),
            (R.string.friend_num_provider),(R.string.friend_num_driver)};


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.my_friend, container, false);

        RecyclerView recyclerView =  (RecyclerView) v.findViewById(R.id.recyclerViewFriend);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        FriendRecyclerViewAdapter adapter = new FriendRecyclerViewAdapter(getDataSet());
        recyclerView.setAdapter(adapter);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        return v;
    }


    private List<FriendDataObject> getDataSet() {
        List<FriendDataObject> returnList = new ArrayList<>();
        for (int counter = 0; counter < itemDuty.length; counter += 1) {
            returnList.add(new FriendDataObject(itemImg[counter],itemDuty[counter],itemName[counter],itemTel[counter]));
        }
        return returnList;
    }


}
