package com.mordechay.miluim270818.Chat;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mordechay.miluim270818.AppBarActivity;
import com.mordechay.miluim270818.Friend.FriendDataObject;
import com.mordechay.miluim270818.Friend.FriendFrag;
import com.mordechay.miluim270818.Friend.FriendRecyclerViewAdapter;
import com.mordechay.miluim270818.LoginRegister.LoginActivity;
import com.mordechay.miluim270818.MainActivity;
import com.mordechay.miluim270818.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChatFragRec extends Fragment {
/* TO DO: connect recycler and chat stuff
which men:
get text from xml
to realTime data element and then insert that into the recycler
so:
setPointer(findView)
uploadData
    onDataChanged(from here into the recycler)
    how to insert data into tje recycler?
    get the text from the cloud into the arrays that combine the list that show as recycler in getDataSet
    which mean:
    1. set pointer to the xml editText
    2. from this pointer to  sendMassage
    3. then adapt the setMessageListener to the recycler by the list that

  */
    List<ChatDataObject> returnList;
    EditText myMsg,txtUser;
    final String REF_ID="message";
    private int itemImg = R.drawable.soldier;
    private int itemName =R.id.txtUserNameChat;
    private int itemContent = (R.string.friend_duty_commander_title);
    private Date txtChatItemDate;
    RecyclerView recyclerView;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.chat_main, container, false);
        RecyclerView recyclerView =  (RecyclerView) v.findViewById(R.id.recyclerViewChat);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        ChatRecyclerViewAdapter adapter = new ChatRecyclerViewAdapter(getDataSet());
        recyclerView.setAdapter(adapter);

        recyclerView.setItemAnimator(new DefaultItemAnimator());


        myMsg=v.findViewById(R.id.txtMsg);
        v.findViewById(R.id.btnSend).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getActivity(),"send pressed", Toast.LENGTH_LONG).show();
                Log.e("err", "onClick: send btn" );
                sendMessage();

            }
        });

        setMessageListener();
        return v;
    }


    private List<ChatDataObject> getDataSet() {
     returnList = new ArrayList<>();
        for (int counter = 0; counter < 1; counter += 1) {
            returnList.add(new ChatDataObject(itemImg,itemName,txtChatItemDate));
        }
        return returnList;
    }


//    private void getUserList() {
//        //creating instance to the database
//        FirebaseDatabase database=FirebaseDatabase.getInstance();
//        //creating a reference to the database
//        DatabaseReference userRef = database.getReference("Users");
//        //adding an event listener for getting the information back
//        userRef.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                //moving on entire data that we recived from the database
//                String allUsers="";
//                for (DataSnapshot item:dataSnapshot.getChildren())
//                {
//                    //get a single value, and add to our string.
//                    Users reciviedUser = item.getValue(Users.class);
//                    allUsers+=reciviedUser.userName+" ";
//                }
//                Toast.makeText(context, allUsers, Toast.LENGTH_LONG).show();
//                Log.e("Immanual", "onDataChange: "+allUsers );
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//    }
    private void sendMessage() {
        String msg = myMsg.getText().toString();
        Toast.makeText(getActivity(),msg,Toast.LENGTH_LONG).show();
        myMsg.setText("");
        //fire base will give us singleton of his instance

        //creating an instance to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        //creating a referance to message object
        DatabaseReference msgRef = database.getReference(REF_ID);
        //set value to the database
        msgRef.setValue(msg);
    }
    private void setMessageListener() {
        //create an instance to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        //create a referance to the database
        DatabaseReference msgRef = database.getReference(REF_ID);
        //create an event listner with callback to our Reference
        msgRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //this method is called once with the initial value and again
                //whenever data at this location is updated
                String value=dataSnapshot.getValue(String.class);
                ChatDataObject chatDataObject = null;
                chatDataObject.setTxtChatContent(value);
                ChatRecyclerViewAdapter adapter = new ChatRecyclerViewAdapter(getDataSet());
                recyclerView.setAdapter(adapter);
                }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
