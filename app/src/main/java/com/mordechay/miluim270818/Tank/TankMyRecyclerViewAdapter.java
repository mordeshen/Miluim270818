package com.mordechay.miluim270818.Tank;

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

public class TankMyRecyclerViewAdapter extends RecyclerView.Adapter<TankMyRecyclerViewAdapter.DataObjectHolder> {

    //set title for our tag
    private final String TAG="RecyclerView Adapter";
    //our data set list
    private List<TankDataObject>lstDataSet;
    //create interface for click listener
    public interface MyClickListener{
        void onItemClick(int position, View v);
    }
    //our click listener that will be sent by method (interface)
    private MyClickListener myClickListener;

    //our c'tor to our class :)
    public TankMyRecyclerViewAdapter(List<TankDataObject> lstDataSet) {
        this.lstDataSet = lstDataSet;
    }

    public class DataObjectHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView itemTitle;
        TextView itemDetail;
        ImageView itemImg;

        //c'tor for our internal class which work as:
        //1. set pointer
        //2. set on click listener to our entire item.
        public DataObjectHolder(View itemView)
        {
            super(itemView);
            itemTitle=itemView.findViewById(R.id.txt_item_title);
            itemDetail=itemView.findViewById(R.id.txt_item_detail);
            itemImg=itemView.findViewById(R.id.img_item);

//            itemView.setOnClickListener(this);
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_tank_item,parent,false);
        //set the inflated view to our holder
        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        //return the data object holder
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DataObjectHolder holder, final int position) {
        //set the label (our header which show index : XX)
        holder.itemTitle.setText(lstDataSet.get(position).getmText1());
        //set the slogan
        holder.itemDetail.setText(lstDataSet.get(position).getmText2());
        holder.itemImg.setImageResource(lstDataSet.get(position).getImg());

//        //set delete button inside the card view
//        holder.btnDel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                lstDataSet.remove(position);
//                notifyItemRemoved(position);
//            }
//        });
        Log.e(TAG, "onBindViewHolder: "+lstDataSet.get(position).getmText1());
    }

    @Override
    public int getItemCount() {
        return lstDataSet.size();
    }


    //CRUD
    public void addItem(TankDataObject tankDataObject, int index)
    {
        lstDataSet.add(index, tankDataObject);
        notifyItemInserted(index);
    }

    public void deleteItem(int index)
    {
        lstDataSet.remove(index);
        notifyItemRemoved(index);
    }


}

