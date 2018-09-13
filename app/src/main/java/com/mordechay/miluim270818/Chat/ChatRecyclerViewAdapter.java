package com.mordechay.miluim270818.Chat;

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

public class ChatRecyclerViewAdapter extends RecyclerView.Adapter<ChatRecyclerViewAdapter.DataObjectHolder> {

    private List<ChatDataObject>lstDataSet;
    private final String TAG="RecyclerView Adapter";
    public interface MyClickListener{
        void onItemClick(int position, View v);
    }
    private MyClickListener myClickListener;

    public ChatRecyclerViewAdapter(List<ChatDataObject> lstDataSet) {
        this.lstDataSet = lstDataSet;
    }

    public class DataObjectHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        ImageView imgChatPerson;
        TextView txtChatUserName;
        TextView txtChatContent;
//        TextView txtChatItemDate;



        //c'tor for our internal class which work as:
        //1. set pointer
        //2. set on click listener to our entire item.
        public DataObjectHolder(View itemView)
        {
            super(itemView);
            imgChatPerson=itemView.findViewById(R.id.imgChatPerson);
            txtChatUserName=itemView.findViewById(R.id.txtUserNameChat);
            txtChatContent=itemView.findViewById(R.id.txtMsgChat);
//            txtChatItemDate=itemView.findViewById(R.id.date_chat);


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
    public void setOnItemClickListener(ChatRecyclerViewAdapter.MyClickListener myClickListener)
    {
        this.myClickListener=myClickListener;
    }

    //create a view holder, which will be created upon using it
    @NonNull
    @Override
    public ChatRecyclerViewAdapter.DataObjectHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate our card view row layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_item,parent,false);
        //set the inflated view to our holder
        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        //return the data object holder
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DataObjectHolder holder, int position) {
        holder.imgChatPerson.setImageResource(lstDataSet.get(position).getImgChatPerson());
        holder.txtChatUserName.setText(lstDataSet.get(position).getTxtChatUserName());
        holder.txtChatContent.setText(lstDataSet.get(position).getTxtChatContent());
//        holder.txtChatItemDate.setText((CharSequence) lstDataSet.get(position).getTxtChatItemDate());

        Log.e(TAG, "onBindViewHolder: "+lstDataSet.get(position).getTxtChatUserName());

    }

    @Override
    public int getItemCount() {
        return lstDataSet==null? 0 :lstDataSet.size();
    }


}
