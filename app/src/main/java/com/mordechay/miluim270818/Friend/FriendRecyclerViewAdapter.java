package com.mordechay.miluim270818.Friend;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.mordechay.miluim270818.R;

import java.util.List;

public class FriendRecyclerViewAdapter extends RecyclerView.Adapter<FriendRecyclerViewAdapter.DataObjectHolder> {

    //set title for our tag
    private final String TAG="RecyclerView Adapter";
    //our data set list
    private List<FriendDataObject>lstDataSet;
    //create interface for click listener
    public interface MyClickListener{
        void onItemClick(int position, View v);
    }
    //our click listener that will be sent by method (interface)
    private MyClickListener myClickListener;

    //our c'tor to our class :)
    public FriendRecyclerViewAdapter(List<FriendDataObject> lstDataSet) {
        this.lstDataSet = lstDataSet;
    }

    public class DataObjectHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        ImageView imgFriendPerson;
        TextView txtFriendDuty;
        TextView txtFriendName;
        TextView txtFriendTel;



        //c'tor for our internal class which work as:
        //1. set pointer
        //2. set on click listener to our entire item.
        public DataObjectHolder(View itemView)
        {
            super(itemView);
            imgFriendPerson=itemView.findViewById(R.id.imgFriendPerson);
            txtFriendDuty=itemView.findViewById(R.id.txtFriendDuty);
            txtFriendName=itemView.findViewById(R.id.txtFriendName);
            txtFriendTel=itemView.findViewById(R.id.txtFriendTel);


            itemView.setOnClickListener(this);
        }

        //because we declare interface as implementation of on click listener, we can add some extra
        //information to our onclick.
        //since we using the method getAdapterPosition(), which give us the index of the position
        //now we hold the position and the view, instead of holding only the view without the position
        @Override
        public void onClick(View v) {
            myClickListener.onItemClick(getAdapterPosition(),v);
        }
    }

    //using the interface we set on click listener but for single item
    public void setOnItemClickListener(MyClickListener myClickListener)
    {
        this.myClickListener=myClickListener;
    }

    //create a view holder, which will be created upon using it
    @NonNull
    @Override
    public DataObjectHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate our card view row layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_friend_item,parent,false);
        //set the inflated view to our holder
        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        //return the data object holder
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DataObjectHolder holder, final int position) {
        holder.imgFriendPerson.setImageResource(lstDataSet.get(position).getImgFriendPerson());
        holder.txtFriendDuty.setText(lstDataSet.get(position).getTxtFriendDuty());
        holder.txtFriendName.setText(lstDataSet.get(position).getTxtFriendName());
        holder.txtFriendTel.setText(lstDataSet.get(position).getTxtFriendTel());


//        //set delete button inside the card view
//        holder.btnDel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                lstDataSet.remove(position);
//                notifyItemRemoved(position);
//            }
//        });
        Log.e(TAG, "onBindViewHolder: "+lstDataSet.get(position).getTxtFriendName());
    }

    @Override
    public int getItemCount() {
        return lstDataSet.size();
    }


    //CRUD
    public void addItem(FriendDataObject friendDataObject, int index)
    {
        lstDataSet.add(index, friendDataObject);
        notifyItemInserted(index);
    }

    public void deleteItem(int index)
    {
        lstDataSet.remove(index);
        notifyItemRemoved(index);
    }


}

